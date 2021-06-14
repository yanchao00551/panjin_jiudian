package com.jiudian.modules.promotion.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.promotion.entity.NsPromotionGameRuleEntity;
import com.jiudian.modules.promotion.service.NsPromotionGameRuleService;

import net.sf.json.JSONArray;

/**
 * 九宫格概率游戏
 * @author Mr.Yan
 *
 */

@RestController
@RequestMapping("promotion/games")
public class NsPromotionGamesController {
	@Autowired
	NsPromotionGameRuleService nsPromotionGameRuleService;
	@Autowired
	private MemberAccountRecordsService memberAccountRecordsService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private UserService userService;
	
	/**
     * 获取九宫格游戏规则
     */
    @RequestMapping("/getGameRule")
    @RequiresPermissions("promotion:games:list")
    public R getGameRule(@RequestParam Map<String, String> params){
    	Integer gameId = Integer.parseInt(params.get("gameId"));
    	List<NsPromotionGameRuleEntity> list = nsPromotionGameRuleService.selectList(new EntityWrapper<NsPromotionGameRuleEntity>().eq("game_id",gameId));
        return R.ok().put("rules", list);
    }
    
    /**
     * 获取单条九宫格游戏规则
     */
    @RequestMapping("/getSingleRule")
    @RequiresPermissions("promotion:games:info")
    public R getSingleRule(@RequestParam Map<String, String> params){
    	Integer gameId = Integer.parseInt(params.get("gameId"));
    	Integer ruleId = Integer.parseInt(params.get("ruleId"));
    	List<NsPromotionGameRuleEntity> list = nsPromotionGameRuleService.selectList(new EntityWrapper<NsPromotionGameRuleEntity>()
    			.eq("game_id",gameId).eq("rule_id", ruleId));
        return R.ok().put("rules", list);
    }
    
    /**
     * 更新或新增九宫格游戏规则
     */
    @RequestMapping("/saveGameRule")
    public R saveGameRule(@RequestBody NsPromotionGameRuleEntity form){
    	Integer gameId = form.getGameId();
    	String rules = form.getRules();   // 规格json数组
    	JSONArray jsonArray = JSONArray.fromObject(rules);
    	if(!jsonArray.isEmpty()) {
    		for(int i=0;i<jsonArray.size();i++) {
    			if(jsonArray.getJSONObject(i).getString("ruleId") == null) {
    				NsPromotionGameRuleEntity info = new NsPromotionGameRuleEntity();
    				info.setGameId(gameId);
    				info.setRuleNum(0);
    				info.setType(1);
    				info.setCouponTypeId(0);
    				info.setPoints(jsonArray.getJSONObject(i).getInt("points"));  //奖励积分数
    				info.setProb(jsonArray.getJSONObject(i).getInt("prob"));
    				info.setHongbao(new BigDecimal("0"));
    				info.setGiftId(0);
    				info.setRemark("");
    				info.setCreateTime((int)(System.currentTimeMillis() / 1000));
    				info.setRuleName("");
    				info.setTypeValue("");
    				nsPromotionGameRuleService.insert(info);
    			}else {
    				NsPromotionGameRuleEntity info = new NsPromotionGameRuleEntity();
    				info.setRuleId(jsonArray.getJSONObject(i).getInt("ruleId"));
    				info.setGameId(gameId);
    				info.setRuleNum(0);
    				info.setType(1);
    				info.setCouponTypeId(0);
    				info.setPoints(jsonArray.getJSONObject(i).getInt("points"));  //奖励积分数
    				info.setProb(jsonArray.getJSONObject(i).getInt("prob"));
    				info.setHongbao(new BigDecimal("0"));
    				info.setGiftId(0);
    				info.setRemark("");
    				info.setCreateTime((int)(System.currentTimeMillis() / 1000));
    				info.setRuleName("");
    				info.setTypeValue("");
    				nsPromotionGameRuleService.updateById(info);
    			}
    		}
    	}
        return R.ok();
    }
    
    /**
     * 更新九宫格游戏积分和概率
     */
    @RequestMapping("/updateGameRule")
    @RequiresPermissions("promotion:games:update")
    public R updateGameRule(@RequestBody String form){
    	JSONObject jObject = JSON.parseObject(form);
    	com.alibaba.fastjson.JSONArray array = jObject.getJSONArray("data");
    	for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = (JSONObject) array.get(i);
    		Integer gameId = jsonObject.getInteger("gameId");
        	Integer points = jsonObject.getInteger("points");
        	Integer prob = jsonObject.getInteger("prob");
        	Integer ruleId = jsonObject.getInteger("ruleId");
        	NsPromotionGameRuleEntity info = new NsPromotionGameRuleEntity();
        	info.setRuleId(ruleId);
    		info.setGameId(gameId);
    		info.setRuleNum(0);
    		info.setType(1);
    		info.setCouponTypeId(0);
    		info.setPoints(points);  //奖励积分数
    		info.setProb(prob);
    		info.setHongbao(new BigDecimal("0"));
    		info.setGiftId(0);
    		info.setRemark("");
    		info.setCreateTime((int)(System.currentTimeMillis() / 1000));
    		info.setRuleName("");
    		info.setTypeValue("");
    		nsPromotionGameRuleService.updateById(info);
		}
    	return R.ok();
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping("/getPrizeRecord")
    public R getPrizeRecord(@RequestParam Map<String, Object> params){
		params.put("fromType", 13);
		PageUtils page = memberAccountRecordsService.queryDetailByUserList(params);
		List<MemberAccountRecordsEntity> accountRecordsEntities = (List<MemberAccountRecordsEntity>) page.getList();
//		accountRecordsEntities.forEach(re -> {
//			MemberEntity memberEntity = memberService.selectOne
//    				(new EntityWrapper<MemberEntity>().eq("uid", re.getUid()));
//    		UserEntity userEntity = userService.selectOne
//    				(new EntityWrapper<UserEntity>().eq("user_id", re.getUid()));
//    		String nickName = userEntity.getNickName();
//    		String memberName = memberEntity.getMemberName();
//    		re.setUsername(memberName);
//    		re.setNickName(nickName);
//		});
		page.setList(accountRecordsEntities);
		return R.ok().put("page", page);	
    }
    
    
}
