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
@Api("会员控制器")
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
    @ApiOperation("获取用户信息")
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
    @ApiOperation("获取用户ID")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }
    
   

    @Login
    @GetMapping("getTeamList")
    @ApiOperation("获取我的团队列表")
    public R getTeamList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	Map<Integer,List<MemberEntity>> teamMap = memberService.queryTeamList(userId);
        return R.ok().put("data", teamMap);
    }
    
    @Login
    @GetMapping("getUserLevel")
    @ApiOperation("获取用户级别")
    public R getUserLevel(@RequestAttribute("userId") Integer userId){
    	MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
    	int level = rewardCalcuUtil.getCurrentLevel(userId, String.valueOf(memberEntity.getPid()));
        return R.ok().put("level", level);
    }
    
    @Login
    @GetMapping("getTeamCount")
    @ApiOperation("获取我的团队人数及排行")
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
	@ApiOperation("获取排行榜信息")
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
    @ApiOperation("普通用户申请成为合伙人")
    @Transactional
    public R addPartner(@RequestAttribute("userId") Integer userId,@RequestBody AddPartnerForm form) {
        ValidatorUtils.validateEntity(form);
        if(form.getCardFront() == 0 || form.getCardReverse() == 0) {
        	return R.error("请上传身份证");
        }
        MemberPartnerEntity info = memberPartnerService.selectOne
        		(new EntityWrapper<MemberPartnerEntity>().eq("uid", userId).ne("status", 2));
        MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
        MemberPartnerEntity info1 = null;
        if(memberEntity.getPid() != 0) {
        	return R.error("您已有上级，不能申请合伙人，如需成为合伙人，请重新注册账号申请");
        }
        if(info != null) {
	    	if(info.getStatus() == 0 ) {
	    		return R.error("申请正在审核中，不能重复申请");
	    	}else if (info.getStatus() == 1) {
	    		return R.error("已经是合伙人,不能再次申请成为合伙人");
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
	        throw new RRException("申请合伙人fail!");
	    }
        return R.ok();
    }
    
    
    @Login
    @PostMapping("pointExchange")
    @ApiOperation("余额兑换成积分")
    public R pointExchange(@RequestAttribute("userId") Integer userId,@RequestBody PointExchangeForm form) {
    	try {
            ValidatorUtils.validateEntity(form);
			// spring无法处理thread的事务，声明式事务无效
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
    		    	return R.error("系统当前未设置余额兑换比例，请联系管理员");
    		    }
    		    BigDecimal balance = exPoint.divide(balanceConfigInfo.getConvertRate());
    		    if(currentBalance.compareTo(balance) == -1) {
    		    	txManager.rollback(status);
    		    	return R.error("您兑换的积分数量已超出您的余额可兑换数量！");
    		    }
//    		    BigDecimal multiplicand = new BigDecimal("-1");
    		    Integer retval = memberAccountService.addMemberAccountData(0,2,userId,1,balance.negate(),3,0,"余额兑换积分");
    		    if(retval > 0) {
    		    	txManager.commit(status);
    		    	BigDecimal point = new BigDecimal(form.getPointNum());
    		    	List<String> rollBackInfo = new ArrayList<String>();
    		    	Integer rst = memberAccountService.addMemberAccountData(0,1,userId,1,point,3,0,"余额兑换积分",rollBackInfo);
    	        	if(rst > 0) {
        		    	return R.ok();
    	        	}else {
    	        		boolean tmp = false;
    	        		int i = 0;
    	        		while(!tmp && i <= 2) {	//回滚尝试3次
    	        			i++;
    	        			tmp = balanceRollBack(String.valueOf(userId), balance, rollBackInfo);
    	        		}
        	        	return R.error("兑换失败" + (tmp ? "" : ("且回滚失败," + "用户ID： " 
    	        		+ userId + " 余额： " + balance + " 流水记录： " + 
        	        			(rollBackInfo.size() > 0 ? rollBackInfo.get(0) : ""))));
    	        	}
    	        }else {
    	        	txManager.rollback(status);
//    		        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    	        	return R.error("兑换失败");
    	        }
    		}else {
				txManager.rollback(status);
			}
    	}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("积分兑换成余额fail!");
	    }
    	return R.ok();
    }
    
    
    @Login
    @GetMapping("getExchangeMaxPointNum")
    @ApiOperation("获取最大可兑换积分额度")
    public R getExchangeMaxPointNum(@RequestAttribute("userId") Integer userId) {
	    BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
	    if(balanceConfigInfo == null) {
	    	return R.error("系统当前未设置余额兑换比例，请联系管理员");
	    }
		MemberAccountEntity info = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
		BigDecimal point = new BigDecimal(info.getPoint());
		BigDecimal maxPoint = balanceConfigInfo.getConvertRate().multiply(point);
    	return R.ok().put("maxPoint", maxPoint);
    }
    
    @Login
    @GetMapping("getTeamNum")
    @ApiOperation("获取我的团队人数和排行")
    public R getTeamNum(@RequestAttribute("userId") Integer userId,@LoginUser UserEntity user) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	map = memberService.queryTeamNumAmong(userId,user.getUsername());
    	return R.ok(map);
    }
    
    @Login
    @PostMapping("setUserInfo")
    @ApiOperation("设置个人信息")
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
    @ApiOperation("提现申请")
    public R embody(@RequestAttribute("userId") Integer userId,@RequestBody EmbodyForm form) {
        ValidatorUtils.validateEntity(form);
    	BigDecimal cash = form.getCash();  //提现金额
    	Integer accountId = form.getMemberBankAccountId();  //提现账户ID
    	SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo("WITHDRAW_BALANCE");   //获取提现配置
    	if(sysConfigThreeList.getIsUse() != 1) {
    		return R.error("后台提现功能尚未启用,请联系管理员!");
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
//    			return R.error("您所选提现账户类型后台未启用，如要启用，请联系管理员!");
//    		}
    		BigDecimal withdrawCashMin = new BigDecimal(array.getJSONObject(0).getString("withdraw_cash_min"));
    		if(cash.compareTo(withdrawCashMin) == -1){
    			return R.error("您的提现金额小于最小提现金额，请联系管理员!");
    		}
    		MemberAccountEntity memberAccountInfo = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
    		if(memberAccountInfo.getBalance().compareTo(cash) == -1) {
    			return R.error("提现金额超出余额可提现限额");
    		}
    		
    		Integer rst = memberService.memberEmbody(userId,cash,info.getBranchBankName(),info.getRealname(),
    				info.getAccountNumber(),info.getMobile());
    		if(rst <= 0) {
    			return R.error(rst, ErrorMsg.queryCodeByName(rst));
    		}else {
    			return R.ok();
    		}
    	}else {
    		return R.error("提现账号不存在！");
    	}
    }
    
    
    @Login
    @GetMapping("getBankAccountList")
    @ApiOperation("获取我的提现账号列表")
    public R getBankAccountList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	PageUtils page = memberBankAccountService.queryPage(params,userId);
    	return R.ok().put("page", page);
    }
    
    
    @Login
    @GetMapping("getBankAccountInfo")
    @ApiOperation("获取提现账号详情")
    public R getBankAccountInfo(@RequestAttribute("userId") Integer userId) {
    	MemberBankAccountEntity info = memberBankAccountService.selectOne(new EntityWrapper<MemberBankAccountEntity>().eq("uid", userId));
    	return R.ok().put("info", info);
    }
    
    @Login
    @PostMapping("setGetCashInfo")
    @ApiOperation("新增/修改提现账号信息")
    public R setGetCashInfo(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	String id = params.get("id");
    	String accountType = params.get("accountType");
    	String realname = params.get("realname");
    	try {
			if(realname.getBytes("UTF-8").length > 40) {
				return R.error("真实姓名输入过长，请重新输入");
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
	    		return R.error("每个用户只可以设置一条提现信息！");
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
    	return res ? R.ok() : R.error("数据新增/更新失败！");
    }
    
    @Login
    @PostMapping("addOrUploadBankAccount")
    @ApiOperation("添加或修改会员提现账号")
    public R addOrUploadBankAccount(@RequestAttribute("userId") Integer userId,@RequestBody AddOrUpdateBankAccountForm form,@LoginUser UserEntity user) {
        ValidatorUtils.validateEntity(form);

    	String accountTypeName = null;
    	if(form.getAccountType() == 2) {
    		accountTypeName = "微信";
    	}else if(form.getAccountType() == 3) {
    	    accountTypeName = "支付宝";
    	}else {
    		return R.error("只支持微信和支付宝账户");
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
    @ApiOperation("获取我的余额及可提现额度和积分")
    public R getBalanceAndPoint(@RequestAttribute("userId") Integer userId) {
    	MemberAccountEntity info = memberAccountService.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
    	Map<String,Object> rspMap = new HashMap<String,Object>();
    	rspMap.put("balance", info.getBalance());
    	rspMap.put("point", info.getPoint());
    	return R.ok(rspMap);
    }
    
    
    @Login
    @GetMapping("getFlowList")
    @ApiOperation("获取我的流水列表")
    public R getFlowList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	params.put("memberId", userId);
    	PageUtils page = memberService.getAccountList(params);
        return R.ok().put("page", page.getList().isEmpty() ? new Page<String>() : page);
    }
    
    
    @Login
    @PostMapping("setPassword")
    @ApiOperation("重置密码")
    public R setPassword(@RequestAttribute("userId") Integer userId,@RequestBody SetPasswordForm form,@LoginUser UserEntity user) {
        ValidatorUtils.validateEntity(form);
    	String newPassword = form.getNewPassword();
    	String lastPassword = form.getLastPassword();
    	//原密码错误
    	if(!user.getPassword().equals(DigestUtils.sha256Hex(lastPassword))){
    		return R.error("原密码错误!");
    	}
    	user.setPassword(DigestUtils.sha256Hex(newPassword));
    	user.setUserId((long)userId);
    	userService.updateById(user);
    	return R.ok();
    }
    
    
    @Login
    @GetMapping("getMemberExpressAddressList")
    @ApiOperation("收货地址列表")
    public R getMemberExpressAddressList(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,Object> params) {
    	params.put("uid", userId);
    	PageUtils page = memberService.getMemberExpressAddressList(params);
    	return R.ok().put("page", page);
    }
    
    @Login
    @PostMapping("operationAddress")
    @ApiOperation("编辑或添加收货地址")
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
    @ApiOperation("获取会员默认收货地址")
    public R getDefaultExpressAddress(@RequestAttribute("userId") Integer userId) {
    	MemberExpressAddressEntity address = memberService.getDefaultExpressAddress(userId);
    	return R.ok().put("address", address);
    }
    
    @Login
    @GetMapping("getMemberExpressAddressDetail")
    @ApiOperation("获取会员收货地址详情")
    public R getMemberExpressAddressDetail(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	MemberExpressAddressEntity address = memberService.getMemberExpressAddressDetail
    			(Integer.parseInt(params.get("id")),userId);
    	return R.ok().put("address", address);
    }
    
    @Login
    @PostMapping("memberAddressDelete")
    @ApiOperation("删除会员收货地址")
    public R memberAddressDelete(@RequestAttribute("userId") Integer userId,@RequestParam Map<String,String> params) {
    	int res = memberService.memberAddressDelete(Integer.parseInt(params.get("id")), userId);
    	return res == 0 ? R.ok() : R.error("不能删除最后一条收货地址！");
    }

    @Login
    @PostMapping("updateAddressDefault")
    @ApiOperation("修改会员默认收货地址")
    public R updateAddressDefault(@RequestAttribute("userId") Integer userId,@RequestBody MemberExpressAddressEntity form) {
    	memberService.updateAddressDefault(form.getId(), userId);
    	return R.ok();
    }
    
    @Login
    @PostMapping("setUserPaymentPassword")
    @ApiOperation("设置会员支付密码")
    public R setUserPaymentPassword(@RequestAttribute("userId") Integer userId,@RequestBody ValiPayPwdForm form) {
    	String lastPwd = form.getLastPwd();
    	String newPwd = form.getNewPwd();
    	UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", userId));
    	if(userEntity.getIsSetPaymentPassword() == 1) {
    		String save = userEntity.getPaymentPassword();
    		String now = DigestUtils.md5Hex(lastPwd + userEntity.getPaySalt());
    		if (StringUtils.isEmpty(now) || !now.equals(save)) {
    			return R.error("原始密码错误，无法修改！");
    		}
    	}
    	String uuid = UUID.randomUUID().toString();
    	memberService.setUserPaymentPassword(userId, newPwd, uuid);
    	return R.ok();
    }
    
	@Login
	@PostMapping("findUserPaymentPassword")
	@ApiOperation("会员支付密码找回")
	public R findUserPaymentPassword(@RequestAttribute("userId") Integer userId, @RequestBody ValidateMsgForm form) {
		ValidatorUtils.validateEntity(form);
		String requestHash = form.getHash();
		String tamp = form.getTamp();
		String msgNum = form.getMsgNum();
		String hash = Md5Utils.hash(AppRegisterController.KEY + "@" + tamp + "@" + msgNum);
		String password = form.getPassword();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(); // 获取当前时间
		String currentTime = sf.format(date);
		if (tamp.compareTo(currentTime) > 0) {
			if (hash.equalsIgnoreCase(requestHash)) {
				String uuid = UUID.randomUUID().toString();
				memberService.setUserPaymentPassword(userId, password, uuid);
				return R.ok();
			}
		}
		return R.error("验证失败，无法修改密码");
	}
    
    @Login
    @PostMapping("updateUserPaymentPassword")
    @ApiOperation("修改用户支付密码")
    public R updateUserPaymentPassword(@RequestAttribute("userId") Integer userId,@RequestBody SetPasswordForm form) {
        ValidatorUtils.validateEntity(form);
    	String oldPaymentPassword = form.getLastPassword();
    	String newPaymentPassword = form.getNewPassword();
    	memberService.updateUserPaymentPassword(userId, oldPaymentPassword, newPaymentPassword);
    	return R.ok();
    }
    
    
    
    @GetMapping("getCustomerService")
    @ApiOperation("获取客户服务信息")
    public R getCustomerService() {
    	SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo("CUSTOMERSERVICE");   //获客户服务信息
    	return R.ok().put("info", sysConfigThreeList);
    }
    
    
    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }
    
    @Login
    @PostMapping("writeOpinion")
    @ApiOperation("填写意见反馈")
    public R writeOpinion(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
    	String cotent = params.get("cotent");
    	UserOpinionEntity opinionEntity = new UserOpinionEntity();
    	opinionEntity.setUid(userId);
    	opinionEntity.setCotent(cotent);
    	opinionEntity.setCreateDate(Calendar.getInstance().getTime());
    	return userOpinionService.insert(opinionEntity) ? R.ok() : R.error("数据更新失败");
    }
    
    @SuppressWarnings("unchecked")
	@Login
    @GetMapping("getMsgList")
    @ApiOperation("获取通知消息列表")
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
    @ApiOperation("获取通知消息详情")
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
    @ApiOperation("设置通知消息已读")
    public R setMsgIsRead(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
    	String id = params.get("id");
    	UserMsgEntity userMsgEntitiy = userMsgService.selectOne
    			(new EntityWrapper<UserMsgEntity>().eq("uid", userId).eq("id", id));
    	userMsgEntitiy.setIsRead(1);
    	boolean res = userMsgService.insertOrUpdate(userMsgEntitiy);
    	return res ? R.ok() : R.error("数据更新失败");
    }
    
    //tryType 0 全部  1回滚余额 2回滚记录
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
