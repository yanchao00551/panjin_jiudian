package com.jiudian.modules.app.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.*;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.annotation.LoginUser;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.form.*;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.balance.entity.BalanceCofigEntity;
import com.jiudian.modules.balance.service.BalanceCofigService;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;
import com.jiudian.modules.configthree.service.SysConfigThreeService;
import com.jiudian.modules.member.entity.*;
import com.jiudian.modules.member.service.*;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;
import com.jiudian.modules.sysMsg.service.SysMsgService;
import com.jiudian.modules.userMsg.entity.UserMsgEntity;
import com.jiudian.modules.userMsg.service.UserMsgService;
import com.jiudian.modules.userOpinion.entity.UserOpinionEntity;
import com.jiudian.modules.userOpinion.service.UserOpinionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/app")
@Api("???????????????")
public class AppMemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberPartnerService memberPartnerService;
	@Autowired
	UserService userService;
	@Autowired
	MemberAccountService memberAccountService;
	@Autowired
	BalanceCofigService balanceCofigService;
	@Autowired
	AlbumPictureService albumPictureService;
	@Autowired
	MemberBankAccountService memberBankAccountService;
	@Autowired
	SysConfigThreeService sysConfigThreeService;
	@Autowired
	private MemberExpressAddressService memberExpressAddressService;
	@Autowired
	private MemberAccountRecordsService memberAccountRecordsService;
	@Autowired
	private UserOpinionService userOpinionService;
	@Autowired
	private UserMsgService userMsgService;
	@Autowired
	private SysMsgService sysMsgService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;


    @Login
    @GetMapping("userInfo")
    @ApiOperation("??????????????????")
    public R userInfo(@LoginUser UserEntity user){
    	AlbumPictureEntity info = new AlbumPictureEntity();
    	info = albumPictureService.selectById(user.getUserHeadimg());
    	user.setUserHeadImgDetail(info);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("uid", user.getUserId());
    	MemberEntity memberDetail = memberService.queryByUserDetail(map);
    	if(memberDetail.getPartnerStatus() == null) {
    		if(memberDetail.getPid() != 0l) {
    			memberDetail.setPartnerStatus(3);
    		}else {
    			memberDetail.setPartnerStatus(2);
			}
    	}
    	user.setMemberDetail(memberDetail);
    	user.setPassword("******");
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("????????????ID")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }
    
   

    @Login
    @GetMapping("getTeamList")
    @ApiOperation("????????????????????????")
    public R getTeamList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	Map<Integer,List<MemberEntity>> teamMap = memberService.queryTeamList(userId);
        return R.ok().put("data", teamMap);
    }
    
    @Login
    @GetMapping("getUserLevel")
    @ApiOperation("??????????????????")
    public R getUserLevel(@RequestAttribute("userId") Integer userId){
    	MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
    	int level = rewardCalcuUtil.getCurrentLevel(userId, String.valueOf(memberEntity.getPid()));
        return R.ok().put("level", level);
    }
    
    @Login
    @GetMapping("getTeamCount")
    @ApiOperation("?????????????????????????????????")
    public R getTeamCount(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	params = new HashMap<String, String>();
    	params.put("page", "1");
    	params.put("limit", "10000");
    	Map<Integer,List<MemberEntity>> teamMap = memberService.queryTeamList(userId);
    	Iterator<Integer> iterator = teamMap.keySet().iterator();
    	int count = 0;
    	while (iterator.hasNext()) {
			count += teamMap.get(iterator.next()).size();
		}
//    	List<MemberAccountRecordsEntity> accountRecordsEntities = memberAccountRecordsService.queryTotalPoint(params);
//    	int rank = 0;
//    	for (MemberAccountRecordsEntity are : accountRecordsEntities) {
//    		rank++;
//    		if(are.getUid() == userId) {
//    			break; 
//    		}
//		}
        return R.ok().put("count", count);
    }
    
	@Login
	@GetMapping("getLeaderboard")
	@ApiOperation("?????????????????????")
	public R getLeaderboard(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		List<MemberAccountRecordsEntity> accountRecordsEntities = memberAccountRecordsService.queryTotalPoint(params);
		for (int i = 0; i < accountRecordsEntities.size(); i++) {
			MemberAccountRecordsEntity ma = accountRecordsEntities.get(i);
			UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", ma.getUid()));
			int totalPoint = ma.getTotalpoint();
			accountRecordsEntities.get(i).setNickName(userEntity.getRealName());
			accountRecordsEntities.get(i).setTotalpoint(totalPoint);
		}
		return R.ok().put("data", accountRecordsEntities);
	}
    
    @Login
    @PostMapping("addPartner")
    @ApiOperation("?????????????????????????????????")
    @Transactional
    public R addPartner(@RequestAttribute("userId") Integer userId,@RequestBody AddPartnerForm form) {
        ValidatorUtils.validateEntity(form);
        if(form.getCardFront() == 0 || form.getCardReverse() == 0) {
        	return R.error("??????????????????");
        }
        MemberPartnerEntity info = memberPartnerService.selectOne
        		(new EntityWrapper<MemberPartnerEntity>().eq("uid", userId).ne("status", 2));
        MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
        MemberPartnerEntity info1 = null;
        if(memberEntity.getPid() != 0) {
        	return R.error("?????????????????????????????????????????????????????????????????????????????????????????????");
        }
        if(info != null) {
	    	if(info.getStatus() == 0 ) {
	    		return R.error("??????????????????????????????????????????");
	    	}else if (info.getStatus() == 1) {
	    		return R.error("??????????????????,?????????????????????????????????");
			}
        }else {
			info1 = new MemberPartnerEntity();
		}
    	try {
    		info1.setCreateTime((int)(System.currentTimeMillis()/1000));
        	info1.setStatus(0);
        	info1.setUid(userId);
        	memberPartnerService.insertOrUpdate(info1);

        	MemberEntity objData = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
        	objData.setCardFront(form.getCardFront());
        	objData.setCardReverse(form.getCardReverse());
        	memberService.update(objData, new EntityWrapper<MemberEntity>().eq("uid", userId));
        	
        	UserEntity user = new UserEntity();
        	user.setUserTel(form.getUserTel());
        	user.setRealName(form.getRealName());
        	user.setUserId((long)userId);
        	userService.updateById(user);
    	}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("???????????????fail!");
	    }
        return R.ok();
    }
    
    
    @Login
    @PostMapping("pointExchange")
    @ApiOperation("?????????????????????")
    public R pointExchange(@RequestAttribute("userId") Integer userId,@RequestBody PointExchangeForm form) {
    	try {
            ValidatorUtils.validateEntity(form);
			// spring????????????thread?????????????????????????????????
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			PlatformTransactionManager txManager = (PlatformTransactionManager) SpringContextUtils.getBean(PlatformTransactionManager.class);
//			PlatformTransactionManager txManager = ContextLoader.getCurrentWebApplicationContext()
//					.getBean(PlatformTransactionManager.class);
			TransactionStatus status = txManager.getTransaction(def);
    		MemberAccountEntity info = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
    		if(info != null) {
    		    BigDecimal currentBalance = info.getBalance();
    		    BigDecimal exPoint = new BigDecimal(form.getPointNum());
    		    BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
    		    if(balanceConfigInfo == null) {
    		    	txManager.rollback(status);
    		    	return R.error("????????????????????????????????????????????????????????????");
    		    }
    		    BigDecimal balance = exPoint.divide(balanceConfigInfo.getConvertRate());
    		    if(currentBalance.compareTo(balance) == -1) {
    		    	txManager.rollback(status);
    		    	return R.error("???????????????????????????????????????????????????????????????");
    		    }
//    		    BigDecimal multiplicand = new BigDecimal("-1");
    		    Integer retval = memberAccountService.addMemberAccountData(0,2,userId,1,balance.negate(),3,0,"??????????????????");
    		    if(retval > 0) {
    		    	txManager.commit(status);
    		    	BigDecimal point = new BigDecimal(form.getPointNum());
    		    	List<String> rollBackInfo = new ArrayList<String>();
    		    	Integer rst = memberAccountService.addMemberAccountData(0,1,userId,1,point,3,0,"??????????????????",rollBackInfo);
    	        	if(rst > 0) {
        		    	return R.ok();
    	        	}else {
    	        		boolean tmp = false;
    	        		int i = 0;
    	        		while(!tmp && i <= 2) {	//????????????3???
    	        			i++;
    	        			tmp = balanceRollBack(String.valueOf(userId), balance, rollBackInfo);
    	        		}
        	        	return R.error("????????????" + (tmp ? "" : ("???????????????," + "??????ID??? " 
    	        		+ userId + " ????????? " + balance + " ??????????????? " + 
        	        			(rollBackInfo.size() > 0 ? rollBackInfo.get(0) : ""))));
    	        	}
    	        }else {
    	        	txManager.rollback(status);
//    		        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    	        	return R.error("????????????");
    	        }
    		}else {
				txManager.rollback(status);
			}
    	}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("?????????????????????fail!");
	    }
    	return R.ok();
    }
    
    
    @Login
    @GetMapping("getExchangeMaxPointNum")
    @ApiOperation("?????????????????????????????????")
    public R getExchangeMaxPointNum(@RequestAttribute("userId") Integer userId) {
	    BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
	    if(balanceConfigInfo == null) {
	    	return R.error("????????????????????????????????????????????????????????????");
	    }
		MemberAccountEntity info = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
		BigDecimal point = new BigDecimal(info.getPoint());
		BigDecimal maxPoint = balanceConfigInfo.getConvertRate().multiply(point);
    	return R.ok().put("maxPoint", maxPoint);
    }
    
    @Login
    @GetMapping("getTeamNum")
    @ApiOperation("?????????????????????????????????")
    public R getTeamNum(@RequestAttribute("userId") Integer userId,@LoginUser UserEntity user) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map = memberService.queryTeamNumAmong(userId,user.getUsername());
    	return R.ok(map);
    }
    
    @Login
    @PostMapping("setUserInfo")
    @ApiOperation("??????????????????")
    public R setUserInfo(@RequestAttribute("userId") Integer userId,@LoginUser UserEntity user,@RequestBody UserEntity form) {
        ValidatorUtils.validateEntity(form);
    	user.setUserHeadimg(form.getUserHeadimg());
    	user.setNickName(form.getNickName());
    	user.setSex(form.getSex());
    	user.setUserId((long)userId);
    	userService.updateById(user);
    	return R.ok();
    }
    
    @Login
    @PostMapping("embody")
    @ApiOperation("????????????")
    public R embody(@RequestAttribute("userId") Integer userId,@RequestBody EmbodyForm form) {
        ValidatorUtils.validateEntity(form);
    	BigDecimal cash = form.getCash();  //????????????
    	Integer accountId = form.getMemberBankAccountId();  //????????????ID
    	SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo("WITHDRAW_BALANCE");   //??????????????????
    	if(sysConfigThreeList.getIsUse() != 1) {
    		return R.error("??????????????????????????????,??????????????????!");
    	}
    	String value = sysConfigThreeList.getValue();
    	JSONArray array = JSONArray.fromObject(value);
    	MemberBankAccountEntity info = new MemberBankAccountEntity();
    	info = memberBankAccountService.selectById(accountId);
    	if(info != null) {
//    		String accountTypeName = "";
//    		if(info.getAccountType() == 1) {
//    			accountTypeName = "bankCard";   
//    		}
//    		if(info.getAccountType() == 2) {
//    			accountTypeName = "wechat";
//    		}
//    		if(info.getAccountType() == 3){
//    			accountTypeName = "alipay";
//    		}
//    		boolean flag = false;
//    		for(int i=0;i< array.getJSONObject(0).getJSONArray("withdraw_account").size();i++) {
//    			if(array.getJSONObject(0).getJSONArray("withdraw_account").getJSONObject(i).getString("id").equals(accountTypeName)){
//    				if(array.getJSONObject(0).getJSONArray("withdraw_account").getJSONObject(i).getInt("isChecked") != 1) {
//    					flag = true;
//    					break;
//    				}
//    			}
//    		}
//    		if(flag) {
//    			return R.error("??????????????????????????????????????????????????????????????????????????????!");
//    		}
    		BigDecimal withdrawCashMin = new BigDecimal(array.getJSONObject(0).getString("withdraw_cash_min"));
    		if(cash.compareTo(withdrawCashMin) == -1){
    			return R.error("???????????????????????????????????????????????????????????????!");
    		}
    		MemberAccountEntity memberAccountInfo = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
    		if(memberAccountInfo.getBalance().compareTo(cash) == -1) {
    			return R.error("???????????????????????????????????????");
    		}
    		
    		Integer rst = memberService.memberEmbody(userId,cash,info.getBranchBankName(),info.getRealname(),
    				info.getAccountNumber(),info.getMobile());
    		if(rst <= 0) {
    			return R.error(rst, ErrorMsg.queryCodeByName(rst));
    		}else {
    			return R.ok();
    		}
    	}else {
    		return R.error("????????????????????????");
    	}
    }
    
    
    @Login
    @GetMapping("getBankAccountList")
    @ApiOperation("??????????????????????????????")
    public R getBankAccountList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	PageUtils page = memberBankAccountService.queryPage(params,userId);
    	return R.ok().put("page", page);
    }
    
    
    @Login
    @GetMapping("getBankAccountInfo")
    @ApiOperation("????????????????????????")
    public R getBankAccountInfo(@RequestAttribute("userId") Integer userId) {
    	MemberBankAccountEntity info = memberBankAccountService.selectOne(new EntityWrapper<MemberBankAccountEntity>().eq("uid", userId));
    	return R.ok().put("info", info);
    }
    
    @Login
    @PostMapping("setGetCashInfo")
    @ApiOperation("??????/????????????????????????")
    public R setGetCashInfo(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	String id = params.get("id");
    	String accountType = params.get("accountType");
    	String realname = params.get("realname");
    	try {
			if(realname.getBytes("UTF-8").length > 40) {
				return R.error("??????????????????????????????????????????");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String accountNumber = params.get("accountNumber");
    	MemberBankAccountEntity memberBankAccountEntity = null;
    	boolean res = false;
    	if(StringUtils.isEmpty(id)) {
    		int count = memberBankAccountService.selectCount(new EntityWrapper<MemberBankAccountEntity>().eq("uid", userId));
	    	if(count > 0) {
	    		return R.error("????????????????????????????????????????????????");
	    	}
	    	memberBankAccountEntity =  new MemberBankAccountEntity();
    	}else {
    		memberBankAccountEntity = memberBankAccountService.selectOne
    				(new EntityWrapper<MemberBankAccountEntity>().eq("uid", userId));
		}
    	memberBankAccountEntity.setAccountType(Integer.parseInt(accountType));
    	memberBankAccountEntity.setRealname(realname);
    	memberBankAccountEntity.setAccountNumber(accountNumber);
    	memberBankAccountEntity.setUid(userId);
    	res = memberBankAccountService.insertOrUpdate(memberBankAccountEntity);
    	return res ? R.ok() : R.error("????????????/???????????????");
    }
    
    @Login
    @PostMapping("addOrUploadBankAccount")
    @ApiOperation("?????????????????????????????????")
    public R addOrUploadBankAccount(@RequestAttribute("userId") Integer userId,@RequestBody AddOrUpdateBankAccountForm form,@LoginUser UserEntity user) {
        ValidatorUtils.validateEntity(form);

    	String accountTypeName = null;
    	if(form.getAccountType() == 2) {
    		accountTypeName = "??????";
    	}else if(form.getAccountType() == 3) {
    	    accountTypeName = "?????????";
    	}else {
    		return R.error("?????????????????????????????????");
    	}
    	MemberBankAccountEntity info = new MemberBankAccountEntity();
    	info.setUid(userId);
    	info.setBranchBankName(accountTypeName);
    	info.setRealname(form.getRealname());
    	info.setAccountNumber(form.getAccountNumber());
    	info.setMobile(user.getMobile());
    	info.setIsDefault(0);
    	info.setCreateDate((int)(System.currentTimeMillis() / 1000));
    	info.setAccountType(form.getAccountType());
    	info.setAccountTypeName(accountTypeName);
    	if(form.getId() != null && form.getId() > 0) {
    		info.setId(form.getId());
    		memberBankAccountService.updateById(info);
    	}else {
    		memberBankAccountService.insert(info);
    	}
    	return R.ok();
    }
    
    
    @Login
    @GetMapping("getBalanceAndPoint")
    @ApiOperation("?????????????????????????????????????????????")
    public R getBalanceAndPoint(@RequestAttribute("userId") Integer userId) {
    	MemberAccountEntity info = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
    	Map<String,Object> rspMap = new HashMap<String,Object>();
    	rspMap.put("balance", info.getBalance());
    	rspMap.put("point", info.getPoint());
    	return R.ok(rspMap);
    }
    
    
    @Login
    @GetMapping("getFlowList")
    @ApiOperation("????????????????????????")
    public R getFlowList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	params.put("memberId", userId);
    	PageUtils page = memberService.getAccountList(params);
        return R.ok().put("page", page.getList().isEmpty() ? new Page<String>() : page);
    }
    
    
    @Login
    @PostMapping("setPassword")
    @ApiOperation("????????????")
    public R setPassword(@RequestAttribute("userId") Integer userId,@RequestBody SetPasswordForm form,@LoginUser UserEntity user) {
        ValidatorUtils.validateEntity(form);
    	String newPassword = form.getNewPassword();
    	String lastPassword = form.getLastPassword();
    	//???????????????
    	if(!user.getPassword().equals(DigestUtils.sha256Hex(lastPassword))){
    		return R.error("???????????????!");
    	}
    	user.setPassword(DigestUtils.sha256Hex(newPassword));
    	user.setUserId((long)userId);
    	userService.updateById(user);
    	return R.ok();
    }
    
    
    @Login
    @GetMapping("getMemberExpressAddressList")
    @ApiOperation("??????????????????")
    public R getMemberExpressAddressList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	params.put("uid", userId);
    	PageUtils page = memberService.getMemberExpressAddressList(params);
    	return R.ok().put("page", page);
    }
    
    @Login
    @PostMapping("operationAddress")
    @ApiOperation("???????????????????????????")
    public R operationAddress(@RequestAttribute("userId") Integer userId,@RequestBody OperationAddressForm form) {
    	if(form.getIsDefault() == 1) {
    		Map<String, String> paramMap = new HashMap<String, String>();
    		paramMap.put("uid", String.valueOf(userId));
    		memberExpressAddressService.updateIsDefault(paramMap);
    	}
        ValidatorUtils.validateEntity(form);
        if(form.getId() == null || form.getId() == 0) {
        	memberService.addMemberExpressAddress(userId, form.getConsigner(), form.getMobile(), form.getPhone(), 
        			form.getProvince(), form.getCity(), form.getDistrict(), form.getAddress(), form.getZipCode(), "",
        			form.getIsDefault(),form.getRecvTimeRange());
        }else {
        	memberService.updateMemberExpressAddress(form.getId(), userId, form.getConsigner(), form.getMobile(), 
        			form.getPhone(), form.getProvince(), form.getCity(), form.getDistrict(), form.getAddress(), 
        			form.getZipCode(), "", form.getIsDefault(),form.getRecvTimeRange());
        }
    	return R.ok();
    }
    
    @Login
    @GetMapping("getDefaultExpressAddress")
    @ApiOperation("??????????????????????????????")
    public R getDefaultExpressAddress(@RequestAttribute("userId") Integer userId) {
    	MemberExpressAddressEntity address = memberService.getDefaultExpressAddress(userId);
    	return R.ok().put("address", address);
    }
    
    @Login
    @GetMapping("getMemberExpressAddressDetail")
    @ApiOperation("??????????????????????????????")
    public R getMemberExpressAddressDetail(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	MemberExpressAddressEntity address = memberService.getMemberExpressAddressDetail
    			(Integer.parseInt(params.get("id")),userId);
    	return R.ok().put("address", address);
    }
    
    @Login
    @PostMapping("memberAddressDelete")
    @ApiOperation("????????????????????????")
    public R memberAddressDelete(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	int res = memberService.memberAddressDelete(Integer.parseInt(params.get("id")), userId);
    	return res == 0 ? R.ok() : R.error("???????????????????????????????????????");
    }

    @Login
    @PostMapping("updateAddressDefault")
    @ApiOperation("??????????????????????????????")
    public R updateAddressDefault(@RequestAttribute("userId") Integer userId,@RequestBody MemberExpressAddressEntity form) {
    	memberService.updateAddressDefault(form.getId(), userId);
    	return R.ok();
    }
    
    @Login
    @PostMapping("setUserPaymentPassword")
    @ApiOperation("????????????????????????")
    public R setUserPaymentPassword(@RequestAttribute("userId") Integer userId,@RequestBody ValiPayPwdForm form) {
    	String lastPwd = form.getLastPwd();
    	String newPwd = form.getNewPwd();
    	UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", userId));
    	if(userEntity.getIsSetPaymentPassword() == 1) {
    		String save = userEntity.getPaymentPassword();
    		String now = DigestUtils.md5Hex(lastPwd + userEntity.getPaySalt());
    		if (StringUtils.isEmpty(now) || !now.equals(save)) {
    			return R.error("????????????????????????????????????");
    		}
    	}
    	String uuid = UUID.randomUUID().toString();
    	memberService.setUserPaymentPassword(userId, newPwd, uuid);
    	return R.ok();
    }
    
	@Login
	@PostMapping("findUserPaymentPassword")
	@ApiOperation("????????????????????????")
	public R findUserPaymentPassword(@RequestAttribute("userId") Integer userId, @RequestBody ValidateMsgForm form) {
		ValidatorUtils.validateEntity(form);
		String requestHash = form.getHash();
		String tamp = form.getTamp();
		String msgNum = form.getMsgNum();
		String hash = Md5Utils.hash(AppRegisterController.KEY + "@" + tamp + "@" + msgNum);
		String password = form.getPassword();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(); // ??????????????????
		String currentTime = sf.format(date);
		if (tamp.compareTo(currentTime) > 0) {
			if (hash.equalsIgnoreCase(requestHash)) {
				String uuid = UUID.randomUUID().toString();
				memberService.setUserPaymentPassword(userId, password, uuid);
				return R.ok();
			}
		}
		return R.error("?????????????????????????????????");
	}
    
    @Login
    @PostMapping("updateUserPaymentPassword")
    @ApiOperation("????????????????????????")
    public R updateUserPaymentPassword(@RequestAttribute("userId") Integer userId,@RequestBody SetPasswordForm form) {
        ValidatorUtils.validateEntity(form);
    	String oldPaymentPassword = form.getLastPassword();
    	String newPaymentPassword = form.getNewPassword();
    	memberService.updateUserPaymentPassword(userId, oldPaymentPassword, newPaymentPassword);
    	return R.ok();
    }
    
    
    
    @GetMapping("getCustomerService")
    @ApiOperation("????????????????????????")
    public R getCustomerService() {
    	SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo("CUSTOMERSERVICE");   //?????????????????????
    	return R.ok().put("info", sysConfigThreeList);
    }
    
    
    @GetMapping("notToken")
    @ApiOperation("??????Token????????????")
    public R notToken(){
        return R.ok().put("msg", "??????token?????????????????????");
    }
    
    @Login
    @PostMapping("writeOpinion")
    @ApiOperation("??????????????????")
    public R writeOpinion(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
    	String cotent = params.get("cotent");
    	UserOpinionEntity opinionEntity = new UserOpinionEntity();
    	opinionEntity.setUid(userId);
    	opinionEntity.setCotent(cotent);
    	opinionEntity.setCreateDate(Calendar.getInstance().getTime());
    	return userOpinionService.insert(opinionEntity) ? R.ok() : R.error("??????????????????");
    }
    
    @SuppressWarnings("unchecked")
	@Login
    @GetMapping("getMsgList")
    @ApiOperation("????????????????????????")
    public R getMsgList(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
    	params.put("uid", String.valueOf(userId));
    	PageUtils page = userMsgService.queryByMsgType(params);
    	List<UserMsgEntity> userMsgEntities = (List<UserMsgEntity>) page.getList();
    	userMsgEntities.forEach(ume -> {
    		SysMsgEntity sysMsgEntity = sysMsgService.selectOne(new EntityWrapper<SysMsgEntity>().eq("id", ume.getMsgId()));
    		AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
    				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", sysMsgEntity.getImg()));
    		sysMsgEntity.setImgDetail(albumPictureEntity);
    		ume.setSysMsgEntity(sysMsgEntity);
    	});
    	page.setList(userMsgEntities);
    	return R.ok().put("list", page);
    }
    
    @Login
    @GetMapping("getMsgDetail")
    @ApiOperation("????????????????????????")
    public R getMsgDetail(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
    	String id = params.get("id");
    	UserMsgEntity userMsgEntitiy = userMsgService.selectOne
    			(new EntityWrapper<UserMsgEntity>().eq("uid", userId).eq("id", id));
    	SysMsgEntity sysMsgEntity = sysMsgService.selectOne(new EntityWrapper<SysMsgEntity>().eq("id", userMsgEntitiy.getMsgId()));
    	AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
				(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", sysMsgEntity.getImg()));
		sysMsgEntity.setImgDetail(albumPictureEntity);
		sysMsgEntity.setMsgContent(rewardCalcuUtil.getRichText(sysMsgEntity.getMsgContent()));
    	userMsgEntitiy.setSysMsgEntity(sysMsgEntity);
    	return R.ok().put("data", userMsgEntitiy);
    }
    
    @Login
    @PostMapping("setMsgIsRead")
    @ApiOperation("????????????????????????")
    public R setMsgIsRead(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
    	String id = params.get("id");
    	UserMsgEntity userMsgEntitiy = userMsgService.selectOne
    			(new EntityWrapper<UserMsgEntity>().eq("uid", userId).eq("id", id));
    	userMsgEntitiy.setIsRead(1);
    	boolean res = userMsgService.insertOrUpdate(userMsgEntitiy);
    	return res ? R.ok() : R.error("??????????????????");
    }
    
    //tryType 0 ??????  1???????????? 2????????????
    private boolean balanceRollBack(String uid,BigDecimal num, List<String> rollbackInfo) {
    	DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		PlatformTransactionManager txManager = ContextLoader.getCurrentWebApplicationContext()
				.getBean(PlatformTransactionManager.class);
		TransactionStatus status = txManager.getTransaction(def);	
    	boolean res = false;
		MemberAccountEntity memberAccountEntity = memberAccountService.selectOne
				(new EntityWrapper<MemberAccountEntity>().eq("uid",uid));
		memberAccountEntity.setBalance(memberAccountEntity.getBalance().add(num));
		res = memberAccountService.insertOrUpdate(memberAccountEntity);
		if (res && rollbackInfo.size() > 0) {
			res = memberAccountRecordsService.delete(new EntityWrapper<MemberAccountRecordsEntity>().eq("id", rollbackInfo.get(0)));
		}else {
			txManager.rollback(status);
		}
		if(res) {
			txManager.commit(status);
		}else {
			txManager.rollback(status);
		}
		return res;
    }
    

}
