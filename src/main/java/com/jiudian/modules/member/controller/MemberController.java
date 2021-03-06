package com.jiudian.modules.member.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.Constant;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;
import com.jiudian.modules.configthree.service.SysConfigThreeService;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.entity.MemberBalanceWithdrawEntity;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberLevelEntity;
import com.jiudian.modules.member.form.AddMemberAccountForm;
import com.jiudian.modules.member.form.AddMemberLevel;
import com.jiudian.modules.member.form.IdForm;
import com.jiudian.modules.member.form.MemberAccountRecordsTypeNameList;
import com.jiudian.modules.member.form.UpdateMemberForm;
import com.jiudian.modules.member.form.UpdateMemberPasswordForm;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberAccountService;
import com.jiudian.modules.member.service.MemberBalanceWithdrawService;
import com.jiudian.modules.member.service.MemberLevelService;
import com.jiudian.modules.member.service.MemberService;

import io.swagger.annotations.ApiOperation;



/**
 * ???????????????
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberAccountService memberAccountService;
    
    @Autowired
    private MemberLevelService memberLevelService;
    
    @Autowired
    private SysConfigThreeService sysConfigThreeService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AlbumPictureService albumPictureService;
    
    @Autowired
    private MemberBalanceWithdrawService memberBalanceWithdrawService;
    
    @Autowired
    private MemberAccountRecordsService memberAccountRecordsService;
    
    /**
     * ????????????
     */
    @RequestMapping("/memberlist")
    @RequiresPermissions("member:member:memberlist")
    public R memberlist(@RequestParam Map<String, Object> params){
    	PageUtils page = memberService.queryByUserList(params);
        return R.ok().put("page", page);
    }
    
	@SuppressWarnings("unchecked")
	@RequestMapping("/partnerList")
	public R partnetList(@RequestParam Map<String, String> params) {
		PageUtils page = memberService.queryPartnerList(params);
		List<MemberEntity> memberEntities = (List<MemberEntity>) page.getList();
		memberEntities.forEach(me -> {
			AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
					(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", me.getUserHeadimg()));
			me.setUserHeadImgDetail(albumPictureEntity);
		});
		return R.ok().put("page", page);
	}

    
    /**
     * ????????????????????????
     * @param form
     * @return
     */
    @RequestMapping("/addMemberAccount")
    @RequiresPermissions("member:member:addMemberAccount")
    public R addMemberAccount(@RequestBody AddMemberAccountForm form) {
        //????????????
        ValidatorUtils.validateEntity(form);
        Integer retval = memberAccountService.addMemberAccountData(form.getShopId(), form.getType(), 
        		form.getId(), 1,form.getNum(), 10,0,StringUtils.isEmpty(form.getText()) ? "????????????" : form.getText());
        if(retval > 0) {
        	return R.ok();
        }else {
        	return R.error(retval, ErrorMsg.queryCodeByName(retval));
        }
    }
    
    /**
     * ??????????????????
     * @param form
     * @return
     */
    @RequestMapping("/addMemberLevel")
    @RequiresPermissions("member:member:addMemberLevel")
    public R addMemberLevel(@RequestBody AddMemberLevel form) {
    	//????????????
        ValidatorUtils.validateEntity(form);
        Integer retval = memberLevelService.addMemberLevel(form.getShopId(),form.getLevelName(),form.getMinIntegral(),form.getQuota(),form.getUpgrade(),form.getGoodsDiscount(),form.getDesc(),form.getRelation());
    	if(retval == 0 || retval > 0) {
        	return R.ok();
        }else {
        	return R.error(retval, ErrorMsg.queryCodeByName(retval));
        }
    }
    
    /**
	 * ??????????????????
	 */
	@GetMapping("/getMemberLevel/{levelId}")
	@RequiresPermissions("member:member:updateMemberLevel")
	public R getMemberLevel(@PathVariable("levelId") Long levelId){
		MemberLevelEntity memberLevel = memberLevelService.selectById(levelId);
        return R.ok().put("memberLevel", memberLevel);
	}
	

    /**
     * ??????????????????
     */
    @RequestMapping("/updateMemberLevel")
    @RequiresPermissions("member:member:updateMemberLevel")
    public R updateMemberLevel(@RequestBody MemberLevelEntity memberLevel){
			memberLevelService.updateById(memberLevel);
        return R.ok();
    }
    
    
    /**
     * ??????????????????
     * @param form
     * @return
     */
    @RequestMapping("/balanceMemberAccount")
    @RequiresPermissions("member:member:balanceMemberAccount")
    public R balanceMemberAccount(@RequestBody AddMemberAccountForm form) {
        //????????????
        ValidatorUtils.validateEntity(form);
        Integer retval = memberAccountService.addMemberAccountData(form.getShopId(), form.getType(), 
        		form.getId(), 1,form.getNum(), 10,0,StringUtils.isEmpty(form.getText()) ? "????????????" : form.getText());
        if(retval > 0) {
        	return R.ok();
        }else {
        	return R.error(retval, ErrorMsg.queryCodeByName(retval));
        }
    }
    
    /**
     * ????????????
     * @param form
     * @return
     */
    @RequestMapping("/memberLock")
    @RequiresPermissions("member:member:memberLock")
    public R memberLock(@RequestBody IdForm form) {
    	//????????????
        ValidatorUtils.validateEntity(form);
        Boolean retval = memberService.userLock(form.getId());
    	if(retval) {
        	return R.ok();
        }else {
        	return R.error("??????????????????!");
        }
    }
    
    
    /**
     * ????????????
     * @param form
     * @return
     */
    @RequestMapping("/memberUnLock")
    @RequiresPermissions("member:member:memberUnLock")
    public R memberUnLock(@RequestBody IdForm form) {
    	//????????????
        ValidatorUtils.validateEntity(form);
        Boolean retval = memberService.userUnlock(form.getId());
    	if(retval) {
        	return R.ok();
        }else {
        	return R.error("??????????????????!");
        }
    }
    
    /**
     * ??????uid????????????????????????
     * @param form
     * @return
     */
    @RequestMapping("/updateMemberPassword")
    @RequiresPermissions("member:member:updateMemberPassword")
    public R updateMemberPassword(@RequestBody UpdateMemberPasswordForm form) {
    	//????????????
        ValidatorUtils.validateEntity(form);
        Boolean retval = memberService.updateUserInfoByUserid(form.getId(),form.getPassword());
    	if(retval) {
        	return R.ok();
        }else {
        	return R.error("??????????????????!");
        }
    }
    
    
    /**
     * ??????????????????
     * @param form
     * @return
     */
    @RequestMapping("/updateMember")
    @RequiresPermissions("member:member:updateMember")
    public R updateMember(@RequestBody UpdateMemberForm form) {
    	//????????????
        ValidatorUtils.validateEntity(form);
        Integer retval = memberService.updateMemberByAdmin(form.getId(),form.getUsername(),form.getEmail(),form.getSex(),form.getStatus(),form.getMobile(),form.getNickname());
        
    	if(retval < 0) {
        	return R.error(retval, ErrorMsg.queryCodeByName(retval));
        }else {
//        	memberService.updateUserLevel(form.getId(),form.getLevelName());
        	return R.ok();
        }
    }
    
    /**
     * ????????????????????????
     */
    @RequestMapping("/accountdetail")
    @RequiresPermissions("member:member:accountdetail")
    public R accountdetail(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.getAccountList(params);
        List<MemberAccountRecordsTypeNameList> accountTypeList = memberAccountService.getMemberAccountRecordsTypeNameList();
        List<MemberAccountRecordsTypeNameList> fromTypeList = memberAccountService.getMemberAccountRecordsNameList();
        Map<String, Object> map = new HashMap<>();
        map.put("accountTypeList", accountTypeList);
        map.put("fromTypeList",fromTypeList);
        map.put("page", page);
        return R.ok(map);
    }
    
    /**
     * ??????????????????
     * @param params
     * @return
     */
    @RequestMapping("/memberLevelList")
    @RequiresPermissions("member:member:memberLevelList")
    public R memberLevelList(@RequestParam Map<String,Object> params) {
    	PageUtils page = memberLevelService.queryPage(params);
        return R.ok().put("page",page);
    }
    
    
    /**
     * ??????????????????
     * @param params
     * @return
     * @throws ParseException 
     */
    @RequestMapping("/userCommissionWithdrawList")
    @RequiresPermissions("member:member:userCommissionWithdrawList")
    public R userCommissionWithdrawList(@RequestParam Map<String,Object> params) throws ParseException {
    	if(params.containsKey("startDatetime")) {
    		String startDatetime = params.get("startDatetime").toString();
    		SimpleDateFormat startDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		long startDate = startDateformat.parse(startDatetime).getTime();
    		params.put("startDatetime", startDate);
    	}
    	if(params.containsKey("endDatetime")) {
    		String endDatetime = params.get("endDatetime").toString();
    		SimpleDateFormat endDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		long endDate = endDateformat.parse(endDatetime).getTime();
    		params.put("endDatetime", endDate);
    	}
    	PageUtils page = memberService.getMemberBalanceWithdraw(params);
    	Integer withdraw = memberBalanceWithdrawService.getWithdraw(params);
    	Integer waitWithdraw = memberBalanceWithdrawService.getWaitWithdraw(params);
        return R.ok().put("page", page.getList().isEmpty() ? new Page<String>() : page)
        		.put("withdraw", withdraw).put("waitWithdraw", waitWithdraw);
    }
    
	/**
	 * ??????????????????
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/cashReview")
//	@RequiresPermissions("member:member:userCommissionWithdrawList")
	@Transactional
	public R cashReview(@RequestParam Map<String, String> params) throws Exception {
		boolean res = false;
		String status = params.get("status");
		String id = params.get("id");
		res = memberBalanceWithdrawService.updateCashReview(params);
		if(!res) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RRException("????????????");
		}
		if("2".equals(status.trim())) {
			MemberBalanceWithdrawEntity balanceWithdrawEntity =  memberBalanceWithdrawService.selectOne
					(new EntityWrapper<MemberBalanceWithdrawEntity>().eq("id", id));
			int uid = balanceWithdrawEntity.getUid();
			MemberAccountEntity accountEntity = memberAccountService.selectOne
					(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
			BigDecimal bigDecimal = accountEntity.getBalance().add(balanceWithdrawEntity.getCash());
			accountEntity.setBalance(bigDecimal);
			res = memberAccountService.insertOrUpdate(accountEntity);
			MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
			accountRecordsEntity.setUid(uid);
			accountRecordsEntity.setAccountType(2);
			accountRecordsEntity.setNumber(balanceWithdrawEntity.getCash());
			accountRecordsEntity.setFromType(9);
			accountRecordsEntity.setText("??????????????????");
			accountRecordsEntity.setCreateTime(Calendar.getInstance().getTime());
			memberAccountRecordsService.insert(accountRecordsEntity);
		}
		if(!res) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw new RRException("????????????");
		}
		return res ? R.ok() : R.error("??????????????????");
	}

    
    /**
     * ??????????????????
     * @param params
     * @return
     * @throws ParseException 
     */
    @RequestMapping("/pointlist")
    @RequiresPermissions("member:member:pointlist")
    public R pointlist(@RequestParam Map<String,Object> params){
//    	if(params.containsKey("startDatetime")) {
//    		String startDatetime = params.get("startDatetime").toString();
//    		SimpleDateFormat startDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    		long startDate = startDateformat.parse(startDatetime).getTime();
//    		params.put("startDatetime", startDate/1000);
//    	}
//    	if(params.containsKey("endDatetime")) {
//    		String endDatetime = params.get("endDatetime").toString();
//    		SimpleDateFormat endDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    		long endDate = endDateformat.parse(endDatetime).getTime();
//    		params.put("endDatetime", endDate/1000);
//    	}
    	PageUtils page = memberService.getAccountList(params);
    	BigDecimal usePoint = memberAccountRecordsService.queryUse(params);
    	BigDecimal getPoint = memberAccountRecordsService.queryGet(params);
        return R.ok().put("page", page.getList().isEmpty() ? new Page<String>() : page)
        		.put("usePoint", usePoint).put("getPoint", getPoint);
    }
    
    
    /**
     * ??????????????????
     * @param params
     * @return
     */
    @RequestMapping("/accountlist")
    @RequiresPermissions("member:member:accountlist")
    public R accountlist(@RequestParam Map<String,Object> params) {
    	PageUtils page = memberService.getAccountList(params);
    	BigDecimal useBalance = memberAccountRecordsService.queryUse(params);
    	BigDecimal getBalance = memberAccountRecordsService.queryGet(params);
        return R.ok().put("page", page.getList().isEmpty() ? new Page<String>() : page)
        		.put("useBalance", useBalance).put("getBalance", getBalance);
    }
    
    /**
     * ????????????????????????
     */
    @GetMapping("getCustomerService")
    @ApiOperation("????????????????????????")
    public R getCustomerService() {
    	SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo("CUSTOMERSERVICE");   //?????????????????????
    	return R.ok().put("info", sysConfigThreeList);
    }
    
    /**
     * ????????????????????????
     */
    @PostMapping("updateCustomerService")
    @ApiOperation("????????????????????????")
    @RequiresPermissions("member:member:updateCustomerService")
    public R updateCustomerService(@RequestBody SysConfigThreeEntity form) {
    	String value = form.getValue();
    	SysConfigThreeEntity entity = new SysConfigThreeEntity();
    	entity.setValue(value);
    	sysConfigThreeService.update(entity, new EntityWrapper<SysConfigThreeEntity>().eq("key", "CUSTOMERSERVICE"));
    	return R.ok();
    }
    
    
    
    /**
     * ??????????????????
     * @param params
     * @return
     */
    @RequestMapping("/getMemberDetail/{uid}")
    public R getMemberDetail(@PathVariable("uid") Integer uid) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("uid",uid);
    	MemberEntity member = memberService.queryByUserDetail(map);
    	Map<String,Object> mapList = new HashMap<String,Object>();
    	List<MemberLevelEntity> levelList = new ArrayList<MemberLevelEntity>();
    	levelList = memberLevelService.selectList(new EntityWrapper<MemberLevelEntity>());
    	mapList.put("detail", member);
    	mapList.put("levelList",levelList);
    	return R.ok(mapList);
    }
    
    @GetMapping("/getChildList")
    public R getMemberDetail(@RequestParam Map<String,String> params) {
    	String uid = params.get("uid");
    	String levelName = params.get("levelName");
    	Map<Integer,List<MemberEntity>> teamMap = memberService.queryTeamList(Integer.parseInt(uid));
    	ArrayList<MemberEntity> childList = new ArrayList<MemberEntity>();
    	Iterator<Entry<Integer, List<MemberEntity>>> iterator = teamMap.entrySet().iterator();
    	while(iterator.hasNext()) {
    		Entry<Integer, List<MemberEntity>> t = iterator.next();
    		List<MemberEntity> tempList = t.getValue();
    		tempList.forEach(p ->{
    			UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", p.getUid()));
    			p.setNickName(userEntity.getNickName());
    			p.setMobile(userEntity.getMobile());
    			p.setLevelName(Constant.MemberLevel.valueOf(t.getKey() - 1).name());
    			p.setLastLoginTime(userEntity.getLastLoginTime());
    		});
    		childList.addAll(t.getValue());
    	}
    	int total = childList.size();
    	int level2 = (int)childList.stream().
				filter(cl -> Constant.MemberLevel.valueOf(1).name().equals(cl.getLevelName())).collect(Collectors.toList()).size();
    	if(!StringUtils.isEmpty(levelName)) {
    		childList = (ArrayList<MemberEntity>)childList.stream().
    				filter(cl -> levelName.equals(cl.getLevelName())).collect(Collectors.toList());
    	}
    	return R.ok().put("list", childList).put("total", total).put("level2", level2).put("level3", total - level2);
    }
    

}
