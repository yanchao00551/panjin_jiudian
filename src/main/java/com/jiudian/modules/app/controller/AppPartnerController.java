package com.jiudian.modules.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.Constant;
import com.jiudian.common.utils.R;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/app")
@Api("APP合伙人接口")
public class AppPartnerController {
	@Autowired
	private MemberService memberService; 

	@Login
	@GetMapping("getQRcode")
	@ApiOperation("获取推广码")
	public R getQRcode(@RequestAttribute("userId") Integer userId,@RequestParam Map<String, String> params) {
		String type = params.get("type");//0IOS 1Android
		String qrcodePath = "0".equals(type) ? Constant.IOS_QRCODE_URL_PATH : Constant.ANDROID_QRCODE_URL_PATH;
		MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
		String promotionCode = memberEntity.getPromoter();
		if(StringUtils.isEmpty(promotionCode)) {
			promotionCode = String.valueOf(generatePromtionCode());
			memberEntity.setPromoter(promotionCode);
			memberService.insertOrUpdate(memberEntity);
		}
		Map<String,String> dataMap = new HashMap<String,String>();
		dataMap.put("backgroundImg", Constant.BG_IMG_PATH);
		dataMap.put("qrcodeImg", qrcodePath);
		dataMap.put("promotionCode", promotionCode);
		return R.ok().put("data", dataMap);
	}
	
	//生成推广码
	private int generatePromtionCode() {
		String uid = UUID.randomUUID().toString();
		int res = uid.hashCode();
		return res > 0 ? res : -res;
	}
}
