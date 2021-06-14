package com.jiudian.modules.configthree.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiudian.common.annotation.SysLog;
import com.jiudian.common.utils.R;
import com.jiudian.common.validator.Assert;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;
import com.jiudian.modules.configthree.form.MemberWithdrawSettingForm;
import com.jiudian.modules.configthree.service.SysConfigThreeService;
import com.jiudian.modules.sms.form.SmsconfigForm;

/**
 * 第三方配置表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-20 09:40:02
 */
@RestController
@RequestMapping("sysconfigthree/sysconfigthree")
public class SysConfigThreeController {
	@Autowired
	private SysConfigThreeService sysConfigThreeService;

	/**
	 * 获取配置信息
	 */
	@RequestMapping("/getSysConfigThree/{key}")
	@RequiresPermissions("sysconfigthree:sysconfigthree:getSysConfigThree")
	public R getSysConfigThree(@PathVariable("key") String key) {
		SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo(key);
		return R.ok().put("info", sysConfigThreeList);
	}

	/**
	 * 设置配置信息
	 */
	@SysLog("设置短信配置信息")
	@RequestMapping("/setSmsSysConfigThree")
	@RequiresPermissions("sysconfigthree:sysconfigthree:setSmsSysConfigThree")
	public R setSmsSysConfigThree(@RequestBody SmsconfigForm form) {
		Assert.isNull(form.getKey(), "key值不能为空");
		
//		JSONObject jsonObject = JSONObject.parseObject(form.getValue()); 
//		Boolean isUse = form.getIsUse(); String value = jsonObject.getString("value");
		 
		SysConfigThreeEntity sysConfigThreeList = sysConfigThreeService.queryByKeyInfo(form.getKey());
		if (sysConfigThreeList == null) {
			sysConfigThreeList.setCreateTime((int) (System.currentTimeMillis() / 1000));
			sysConfigThreeList.setIsUse(form.getIsUse() ? 1 : 0);
			sysConfigThreeList.setDesc("手机短信");
			sysConfigThreeList.setKey("MOBILEMESSAGE");
			sysConfigThreeList.setValue(form.getValue());
			sysConfigThreeService.insert(sysConfigThreeList);
			return R.ok();
		}
		sysConfigThreeList.setIsUse(form.getIsUse() ? 1 : 0);
		sysConfigThreeList.setKey(form.getKey());
		sysConfigThreeList.setValue(form.getValue());
		sysConfigThreeList.setModifyTime((int) (System.currentTimeMillis() / 1000));
		boolean rst = sysConfigThreeService.updateById(sysConfigThreeList);
		if (rst) {
			return R.ok();
		}
		return R.error("更新失败");
	}
	
	
	@SysLog("会员提现设置")
	@RequestMapping("/memberWithdrawSetting")
	@RequiresPermissions("sysconfigthree:sysconfigthree:memberWithdrawSetting")
	public R memberWithdrawSetting(@RequestBody MemberWithdrawSettingForm form) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		Map<String,Object> map3 = new HashMap<String,Object>();
		String[] strArray = form.getWithdrawAccount().toString().split(",");
		map.put("id", "bankCard");
		map.put("name", "银行卡");
		map.put("value", 1);
		map.put("isChecked", 0);
		list.add(map);
		map1.put("id","wechat");
		map1.put("name", "微信");
		map1.put("value", 2);
		map1.put("isChecked", 0);
		list.add(map1);
		map2.put("id", "alipay");
		map2.put("name", "支付宝");
		map2.put("value", 3);
		map2.put("isChecked", 0);
		list.add(map2);
        for(int i =0;i<strArray.length;i++) {
        	list.get(new Integer(strArray[i]) - 1).put("isChecked", 1);
		}
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		map3.put("withdraw_cash_min", form.getCashMin());
		map3.put("withdraw_multiple", form.getMultiple());
		map3.put("withdraw_message", form.getMessage());
		map3.put("withdraw_account",list);
		list1.add(map3);
        form.setWithdrawAccountMap(list1);
        String key = "WITHDRAW_BALANCE";
        boolean retval = sysConfigThreeService.setBalanceWithdrawConfig(form.getShopId() == null ? 0 : form.getShopId(),key,form.getWithdrawAccountMap(),form.getIsUse());
        if(retval)
        	return R.ok();
        else
        	return R.error("设置失败!");
	}
	
	
}
