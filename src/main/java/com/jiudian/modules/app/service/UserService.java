package com.jiudian.modules.app.service;


import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.form.LoginForm;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface UserService extends IService<UserEntity> {
	PageUtils queryPage(Map<String, Object> params);
	
	UserEntity queryByMobile(String mobile);
	

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
	
	/**
	 * 根据模板事件发送短信
	 * @param templateCode
	 * @param replaceName
	 * @return
	 */
	public abstract int sendMsg(String templateCode,String mobile,String replaceName);
	
	public int sendValiMsg(String mobile, String valiNum,String remoteIp, String sendType);


}
