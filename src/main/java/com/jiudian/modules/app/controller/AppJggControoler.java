package com.jiudian.modules.app.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jiudian.StartUpRunner;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.annotation.LoginUser;
import com.jiudian.modules.app.calculate.RewardCalcuTask;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberAccountService;
import com.jiudian.modules.promotion.entity.NsPromotionGameRuleEntity;
import com.jiudian.modules.promotion.entity.NsPromotionGamesWinningRecordsEntity;
import com.jiudian.modules.promotion.service.NsPromotionGameRuleService;
import com.jiudian.modules.promotion.service.NsPromotionGamesWinningRecordsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 九宫格控制器
 * @author KF-180419
 *
 */

@RestController
@RequestMapping("/app")
@Api("九宫格控制器")
public class AppJggControoler {
	@Autowired
	private NsPromotionGamesWinningRecordsService nsPromotionGamesWinningRecordsService;
	@Autowired
	private NsPromotionGameRuleService nsPromotionGameRuleService;
	@Autowired
	private MemberAccountService memberAccountService;
	@Autowired
	private MemberAccountRecordsService memberAccountRecordsService;
	
	
	@Login
	@GetMapping("sexBoxList")
    @ApiOperation("获取九宫格奖品信息列表和机会数量和获奖记录列表")
	public R sexBoxList(@RequestAttribute("userId") Integer userId) {
		Integer num = nsPromotionGamesWinningRecordsService.selectCount(new EntityWrapper<NsPromotionGamesWinningRecordsEntity>().eq("uid", userId).where("TO_DAYS(add_time) = TO_DAYS(NOW())", "").eq("game_id", 1));
		List<NsPromotionGameRuleEntity> ruleList = nsPromotionGameRuleService.selectList(new EntityWrapper<NsPromotionGameRuleEntity>().eq("game_id", 1));
//		List<NsPromotionGamesWinningRecordsEntity> recordList = nsPromotionGamesWinningRecordsService.selectList(new EntityWrapper<NsPromotionGamesWinningRecordsEntity>().eq("game_id", 1));
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(userId));
		int res = memberAccountRecordsService.queryTodayCount(params);
		if(res > 0) {
			num = 0;
		}else {
			num = 1;
		}
		map.put("num", num);
		map.put("ruleList", ruleList);
//		map.put("recordList", recordList);
		return R.ok(map);
	}
	
	@Login
	@PostMapping("startDraw")
	@ApiOperation("开始抽奖")
	@Transactional
	public R startDraw(@RequestAttribute("userId") Integer userId, @LoginUser UserEntity user) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", String.valueOf(userId));
		int res = memberAccountRecordsService.queryTodayCount(params);
		if (res > 0) {
			return R.error("今天已经抽过奖了，请勿重复抽取！");
		}
		Integer[] proArr = new Integer[8];
		List<NsPromotionGameRuleEntity> ruleList = nsPromotionGameRuleService
				.selectList(new EntityWrapper<NsPromotionGameRuleEntity>().eq("game_id", 1));
		for (int i = 0; i < ruleList.size(); i++) {
			proArr[i] = ruleList.get(i).getProb();
		}
		Integer index = this.getRand(proArr);
		try {
			NsPromotionGameRuleEntity info = nsPromotionGameRuleService.selectById(index);
			NsPromotionGamesWinningRecordsEntity objData = new NsPromotionGamesWinningRecordsEntity();
			objData.setUid(userId.toString());
			objData.setShopId(0);
			objData.setGameId(1);
			objData.setGameType(3);
			objData.setType(1);
			objData.setPoints(new BigDecimal(info.getPoints()));
			objData.setRemark("九宫格游戏");
			objData.setIsWinning(index != null ? 1 : 0);
			objData.setNickName(user.getNickName());
			objData.setAddTime((int) (System.currentTimeMillis() / 1000));
			// 保存中奖记录
			nsPromotionGamesWinningRecordsService.insert(objData);
			Wrapper<MemberAccountEntity> maeWrapper = new EntityWrapper<MemberAccountEntity>();
			maeWrapper.eq("uid", userId);
			MemberAccountEntity memberAccountEntity = memberAccountService.selectOne(maeWrapper);
			if (memberAccountEntity != null && memberAccountEntity.getPoint() != null) {
				Integer point = memberAccountEntity.getPoint();
				point += info.getPoints();
				memberAccountEntity.setPoint(point);
			} else {
				memberAccountEntity.setPoint(info.getPoints());
			}
			// 修改用户积分
			boolean flag = false;
//		memberAccountService.updateById(memberAccountEntity);
			Semaphore semaphore = new Semaphore(0);
			Vector<String> uidVector = new Vector<String>();
			double totalFee = info.getPoints().doubleValue();
//		MemberAccountEntity memberAccountEntity = memberAccountService
//				.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
			RewardCalcuTask rewardCalcuTask = new RewardCalcuTask(String.valueOf(userId), totalFee,
					memberAccountService, semaphore, uidVector);
			StartUpRunner.executor.getQueue().offer(rewardCalcuTask);
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (uidVector.size() > 0 && uidVector.get(0).equals(String.valueOf(userId))) {
				flag = true;
			} else {
				throw new Exception();
			}
			if (flag) {
				MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
				accountRecordsEntity.setUid(userId);
				accountRecordsEntity.setShopId(0);
				accountRecordsEntity.setAccountType(1);
				accountRecordsEntity.setSign(1);
				accountRecordsEntity.setNumber(new BigDecimal(info.getPoints()));
				accountRecordsEntity.setFromType(13);
				accountRecordsEntity.setDataId(0);
				accountRecordsEntity.setText("抽奖获得积分");
				accountRecordsEntity.setIsFreeze(0);
				Date date = Calendar.getInstance().getTime();
				accountRecordsEntity.setCreateTime(date);
				memberAccountRecordsService.insert(accountRecordsEntity);
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return R.error("抽奖失败");
		}
		return R.ok().put("index", index);
	}
	
	@Login
	@GetMapping("getPrizeRecord")
    @ApiOperation("获取九宫格中奖纪录")
	public R getPrizeRecord(@RequestAttribute("userId") Integer userId,@RequestParam Map<String, Object> params) {
		//todo...
		params.put("fromType", 13);
		int res = Integer.parseInt((String) params.get("isAll"));
		if(res == 0) {
			params.put("memberId", userId);
		}else {
			params.put("memberId", "");
		}
		PageUtils page = memberAccountRecordsService.queryDetailByUserList(params);
		return R.ok().put("res", page);	
	}
	
	/**
	 * 中奖概率计算
	 * @param proArr 概率
	 * @return
	 */
	private Integer getRand(Integer[] proArr) {
		int randomRes = (int) (Math.random() * 100 + 1);
		int sum = 0;
		int index = 0;
		for(int i = 1; i <= proArr.length; i++) {
			sum += proArr[i - 1];
			if(randomRes <= sum) {
				index = i;
				break;
			}
		}
		return index;
	}

}
