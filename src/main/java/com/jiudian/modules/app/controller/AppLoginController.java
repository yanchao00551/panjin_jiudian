package com.jiudian.modules.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.Constant;
import com.jiudian.common.utils.R;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.entity.StartPageEntity;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.form.LoginForm;
import com.jiudian.modules.app.service.StartPageService;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.app.utils.JwtUtils;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;
import com.jiudian.modules.goods.service.GoodsCategoryService;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * APP登录授权控制器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/app")
@Api("APP登录接口")
public class AppLoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private StartPageService startPageService;
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	
	/**
	 * 首页
	 * 
	 **/
//	@Login
	@GetMapping("startPage")
	@ApiOperation("首页")
	public R getStartPage(@RequestParam Map<String, String> params) {
		StartPageEntity startPageEntity = startPageService.getStartPage(params);
		return R.ok().put("startPage", startPageEntity);
	}

	@GetMapping("getGroupList")
	@ApiOperation("首页-酒店列表")
	public R getGroupList() {
		List<GoodsGroupEntity> goodsGroupEntities = startPageService.getGroupList();
		return R.ok().put("groupList", goodsGroupEntities);
	}

	@GetMapping("getCategoryList")
	@ApiOperation("首页-商品分类")
	public R getCategoryList() {
		List<GoodsCategoryEntity> categoryEntities = goodsCategoryService
				.selectList(new EntityWrapper<GoodsCategoryEntity>().ne("category_id", 1));
		return R.ok().put("categoryList", categoryEntities);
	}

	@GetMapping("userAgreement")
	@ApiOperation("用户协议")
	public R getUserAgreement(@RequestParam Map<String, String> param) {
		byte[] tempbytes = null;
		int type = Integer.parseInt(param.get("type"));
		Constant.Template template = Constant.Template.valueOf(type);
//		String filePath = "src/main/resources/static/templates/";
		String filePath = "classes/static/templates/";
		filePath += Constant.Template.valueOf(template.ordinal()).name() + ".tpl";
		File file = new File(filePath);
		long len = 4096;
		StringBuilder builder = new StringBuilder();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			tempbytes = new byte[(int) len];
			while (fileInputStream.read(tempbytes) != -1) {
				builder.append(new String(tempbytes));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return R.ok().put("data", builder);
	}

	/**
	 * 登录
	 */
	@PostMapping("login")
	@ApiOperation("登录")
	public R login(@RequestBody LoginForm form) {
		// 表单校验
		ValidatorUtils.validateEntity(form);

		// 用户登录
		long userId = userService.login(form);

		// 生成token
		String token = jwtUtils.generateToken(userId);
		
		MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
		int level = rewardCalcuUtil.getCurrentLevel((int)userId, String.valueOf(memberEntity.getPid()));
		String userPrice = "";
		switch (level) {
		case 1:
			userPrice = "price1";
			break;
		case 2:
		case 3:
			userPrice = "price2";
			break;
		case 4:
			userPrice = "price0";
			break;
		default:
			userPrice = "price0";
			break;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", jwtUtils.getExpire());
		map.put("userPrice", userPrice);
		UserEntity entity = new UserEntity();
		entity.setLastLoginTime(new Date());
		userService.update(entity, new EntityWrapper<UserEntity>().eq("user_id", userId));
		return R.ok(map);
	}

}
