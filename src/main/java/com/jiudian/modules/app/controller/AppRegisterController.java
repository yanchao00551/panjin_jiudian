
package com.jiudian.modules.app.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.IPUtils;
import com.jiudian.common.utils.Md5Utils;
import com.jiudian.common.utils.R;
import com.jiudian.common.utils.SMSConfig;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.form.SendMsgForm;
import com.jiudian.modules.app.form.ValidateMsgForm;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.app.utils.JwtUtils;
import com.jiudian.modules.imgCode.entity.ImgCodeEntity;
import com.jiudian.modules.imgCode.service.ImgCodeService;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberAccountService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;
import com.jiudian.modules.sysMsg.service.SysMsgService;
import com.jiudian.modules.userMsg.entity.UserMsgEntity;
import com.jiudian.modules.userMsg.service.UserMsgService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/app")
@Api("APP????????????")
public class AppRegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired  
    private HttpServletRequest request;  
//	@Autowired
//	private MemberPartnerService memberPartnerService;
	@Autowired
	private UserMsgService userMsgService;
	@Autowired
	private SysMsgService sysMsgService;
	@Autowired
	private MemberAccountService memberAccountService;
	@Autowired
	private ImgCodeService imgCodeService;

	public static final String KEY = "abc123"; // KEY??????????????????
	
	@GetMapping("getImgCode")
	@ApiOperation("?????????????????????")
	public R getImgCode(@RequestParam Map<String, String> params,HttpServletRequest request) {
		String imgCode = RandomStringUtils.randomAlphanumeric(5);
		String ipAddr = getIpAddr(request);
		ImgCodeEntity imgCodeEntity = imgCodeService.selectOne(new EntityWrapper<ImgCodeEntity>().eq("remote_ip", ipAddr));
		if(imgCodeEntity == null) {
			imgCodeEntity = new ImgCodeEntity();
		}
		imgCodeEntity.setImgCode(imgCode);
		imgCodeEntity.setRemoteIp(ipAddr);
		imgCodeEntity.setCreateTime(Calendar.getInstance().getTime());
		imgCodeService.insertOrUpdate(imgCodeEntity);
		return R.ok().put("code", imgCode);
	}


	@PostMapping("sendMsg")
	@ApiOperation("???????????????")
	public R sendMsg(@RequestBody SendMsgForm form, HttpServletRequest request) {
		// ????????????
		ValidatorUtils.validateEntity(form);
		if(StringUtils.isEmpty(form.getSendType())) {
			return R.error("????????????????????????");
		}
		//?????????????????????
//		String imgCode = form.getImgCode();
//		if(StringUtils.isEmpty(imgCode)) {
//			return R.error("???????????????????????????????????????????????????????????????");
//		}
//		String ipAddr = getIpAddr(request);
//		ImgCodeEntity imgCodeEntity = imgCodeService.selectOne(new EntityWrapper<ImgCodeEntity>().eq("remote_ip", ipAddr));
//		if(imgCodeEntity == null || !adjustImgCode(imgCode).equals(adjustImgCode(imgCodeEntity.getImgCode()))) {
//			return R.error("?????????????????????");
//		}else {
//			imgCodeService.deleteById(imgCodeEntity);
//		}
		String phoneNumber = form.getMobile();
		String randomNum = RandomStringUtils.randomNumeric(6);
		// ???????????????
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 5);
		String currentTime = sf.format(c.getTime());// ??????2??????????????????????????????????????????
//		String sendContext = "{\"number\":\"" + randomNum +"\"}";
		//????????????
//		int ret = userService.sendMsg("register_validate",phoneNumber,sendContext); // ???????????????????????????????????????
		int res = userService.sendValiMsg(phoneNumber, randomNum, getIpAddr(request), form.getSendType());
		if (res == 1) {
			return R.error("??????IP???????????????????????????????????????"+ String.valueOf(SMSConfig.SEND_INTERVALS) +"???");
		}else if (res == 2) {
			return R.error("??????IP??????????????????"+ String.valueOf(SMSConfig.MAX_TIMES) +"??????????????????");
		}else if (res == 3) {
			return R.error("?????????????????????");
		}
//		else if(ret == 2) {
//			//return R.error(ErrorMsg.SMS_TEMPLATE_CODE_ISENABLE.getCode(), ErrorMsg.SMS_TEMPLATE_CODE_ISENABLE.getName());
//		}
		String hash = Md5Utils.hash(KEY + "@" + currentTime + "@" + randomNum);// ??????MD5???
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("hash", hash);
		resultMap.put("tamp", currentTime);
		resultMap.put("validateNum", randomNum);
		return R.ok(resultMap);
	}

	@PostMapping("validateNum")
	@ApiOperation("????????????????????????")
	public R validateNum(@RequestBody ValidateMsgForm form) throws Exception {
		try {
			// ????????????
			ValidatorUtils.validateEntity(form);
			String requestHash = form.getHash();
			String tamp = form.getTamp();
			String msgNum = form.getMsgNum();
			String hash = Md5Utils.hash(KEY + "@" + tamp + "@" + msgNum);
			String mobile = form.getMobile();
			String password = form.getPassword();
			String promoter = form.getPromoter(); // ?????????ID
			String birthDate = form.getBirthDate();
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date(); // ??????????????????
			String currentTime = sf.format(date);
			long userId = 0l;
			if (tamp.compareTo(currentTime) > 0) {
				if (hash.equalsIgnoreCase(requestHash)) {
					// ????????????
					UserEntity user = new UserEntity();
					Map<String, Object> map = new HashMap<>();
					map.put("username", mobile);
					List<UserEntity> isUser = userService.selectByMap(map);
					if (isUser.isEmpty()) {
						MemberEntity info = new MemberEntity();
						if (promoter != null && !promoter.equals("")) {
							info = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("promoter", promoter));
							if (info == null) {
								return R.error(ErrorMsg.NOT_PROMOTER_USER.getCode(),
										ErrorMsg.NOT_PROMOTER_USER.getName());
							}
						}
						user.setMobile(mobile);
						user.setUsername(mobile);
						if (password != null && !password.equals("")) {
							user.setPassword(DigestUtils.sha256Hex(password));
						} else {
							user.setPassword(DigestUtils.sha256Hex(mobile)); // ???????????????????????????
						}
						user.setRegTime(new Date());
						user.setIsMember(1);
						user.setUserTel(mobile);
						user.setCurrentLoginIp(IPUtils.getIpAddr(request));
						user.setCurrentLoginType(1);
						user.setLastLoginIp(IPUtils.getIpAddr(request));
						user.setLastLoginType(1);
						user.setLoginNum(1);
						user.setCurrentLoginTime(new Date());
						userService.insert(user);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						MemberEntity member = new MemberEntity();
						userId = user.getUserId();
						member.setUid(userId);
						member.setRegTime(new Date());
						member.setMemberName(mobile);
						member.setPid(info.getUid());
						if(!StringUtils.isEmpty(birthDate)) {
							member.setBirthDate(sdf.parse(birthDate));
						}
//		    			getCurrentLevel(promoter);
						int promoterNum = generatePromtionCode(); // ???????????????
						member.setPromoter(String.valueOf(promoterNum));
						memberService.insert(member);
					} else {
						if(form.getType() == 0) {
							return R.error("??????????????????????????????");
						}
						userId = isUser.get(0).getUserId();
						UserEntity user1 = isUser.get(0);
						user1.setLastLoginIp(user1.getCurrentLoginIp());
						user1.setCurrentLoginIp(IPUtils.getIpAddr(request));
						user1.setLastLoginTime(user1.getCurrentLoginTime());
						user1.setCurrentLoginTime(new Date());
						if (password != null) {
							user1.setPassword(DigestUtils.sha256Hex(password));
						}
						userService.updateById(user1);
					}
				} else {
					// ?????????????????????????????????
					return R.error(ErrorMsg.REGISTER_VALIDATENUM_ERROR.getCode(),
							ErrorMsg.REGISTER_VALIDATENUM_ERROR.getName());
				}
			} else {
				// ??????
				return R.error(ErrorMsg.REGISTER_VALIDATENUM_OUT_TIME.getCode(),
						ErrorMsg.REGISTER_VALIDATENUM_OUT_TIME.getName());
			}

			// ??????token
			String token = jwtUtils.generateToken(userId);
			Map<String, Object> map = new HashMap<>();
			map.put("token", token);
			map.put("expire", jwtUtils.getExpire());

			// ??????????????????
			int uid = new Long(userId).intValue();
			Date currDate = Calendar.getInstance().getTime();
			List<SysMsgEntity> sysMsgEntities = sysMsgService
					.selectList(new EntityWrapper<SysMsgEntity>().eq("to_type", 0)); // ????????????????????????
			sysMsgEntities.forEach(se -> {
				UserMsgEntity userMsgEntity = new UserMsgEntity();
				userMsgEntity.setIsRead(0);
				userMsgEntity.setMsgId(se.getId());
				userMsgEntity.setRecieveDate(currDate);
				userMsgEntity.setUid(uid);
				userMsgService.insert(userMsgEntity);
				se.setSendTimes(se.getSendTimes() + 1);
				se.setLastSendDate(currDate);
				sysMsgService.insertOrUpdate(se);
			});
			MemberAccountEntity memberAccountEntity = memberAccountService.selectOne
					(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
			if(memberAccountEntity == null) {
				// ????????????????????????
				memberAccountEntity = new MemberAccountEntity();
				memberAccountEntity.setShopId(0);
				memberAccountEntity.setUid(uid);
				memberAccountService.insert(memberAccountEntity);
			}
			return R.ok(map);
		} catch (Exception e) {
			throw e;
		}
	}
	
	//???????????????
	private int generatePromtionCode() {
		String uid = UUID.randomUUID().toString();
		int res = uid.hashCode();
		return res > 0 ? res : -res;
	}
	
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		try {
			ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getRemoteAddr();
				if (ipAddress.equals("127.0.0.1")) {
					// ??????????????????????????????IP
					InetAddress inet = null;
					try {
						inet = InetAddress.getLocalHost();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
					ipAddress = inet.getHostAddress();
				}
			}
			// ?????????????????????????????????????????????IP??????????????????IP,??????IP??????','??????
			if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
																// = 15
				if (ipAddress.indexOf(",") > 0) {
					ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
				}
			}
		} catch (Exception e) {
			ipAddress = "";
		}
		// ipAddress = this.getRequest().getRemoteAddr();

		return ipAddress;
	}
	
	@SuppressWarnings("unused")
	private String adjustImgCode(String str) {
		String res = str.toLowerCase();
		res = res.replaceAll("o", "0");
		return res.trim();
	}
}
