package com.jiudian.modules.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.R;
import com.jiudian.modules.aboutUs.entity.AboutUsEntity;
import com.jiudian.modules.aboutUs.service.AboutUsService;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/app/constant")
@Api("静态信息获取")
public class AppConstantController {
	private final static String HOTEL_ADDRESS = "盘锦市兴隆台区双兴中路77号";
	
	private final static String HOTEL_TEL_NUM = "0427-12345678";
	
	private final static String HOTEL_ADDR_COORDINATE = "41.1413540000,122.0728550000";
	
	private final static String BGM_ADDR = "/qrcode/BGM.mp3";
	
	private final static Map<Integer, String> timeRanges = new HashMap<Integer, String>();
	
	@Autowired
	private AboutUsService aboutUsService;
	
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	
	public AppConstantController() {
		timeRanges.put(0, "收货时间不限");
		timeRanges.put(1, "8:00-10:00");
		timeRanges.put(2, "10:00-12:00");
		timeRanges.put(3, "12:00-14:00");
		timeRanges.put(4, "14:00-16:00");
		timeRanges.put(5, "16:00-18:00");
		timeRanges.put(6, "18:00-20:00");
	}

	@GetMapping("hotelAddr")
	public R hotelAddr() {
		List<String> addr = new ArrayList<>();
		addr.add(HOTEL_ADDRESS);
		addr.add(HOTEL_ADDR_COORDINATE);
		return R.ok().put("data", addr);
	}
	
	@GetMapping("hotelNum")
	public R hotelNum() {
		return R.ok().put("data", HOTEL_TEL_NUM);
	}
	
	@GetMapping("timeRanges")
	public R timeRanges() {
		return R.ok().put("data", timeRanges);
	}
	
	@GetMapping("bgm")
	public R bgm() {
		return R.ok().put("data", BGM_ADDR);
	}
	
	@GetMapping("aboutUs")
	public R aboutUs() {
		AboutUsEntity aboutUsEntity = null;
		List<AboutUsEntity> aboutUsEntities = aboutUsService.selectList(new EntityWrapper<AboutUsEntity>()); 
		if(aboutUsEntities != null && aboutUsEntities.size() > 0) {
			aboutUsEntity = aboutUsEntities.get(0);
			aboutUsEntity.setContent(rewardCalcuUtil.getRichText(aboutUsEntity.getContent()));
		}
		return R.ok().put("data", aboutUsEntity);
	}
}
