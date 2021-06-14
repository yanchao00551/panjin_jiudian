package com.jiudian.modules.app.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiudian.modules.app.form.SendMsgForm;
import com.jiudian.modules.app.form.ValidateMsgForm;

import org.junit.Before;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)  
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@Rollback(value=false)
@Transactional

@SpringBootTest 
public class AppRegisterControllerTest {
	
	private static final Logger log= LoggerFactory.getLogger(AppRegisterControllerTest.class);  
	 
	private MockMvc mvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。    
	
	@Autowired    
    private WebApplicationContext wac; // 注入WebApplicationContext  

	
    @Before // 在测试开始前初始化工作    
    public void setup() {    
        this.mvc= MockMvcBuilders.webAppContextSetup(this.wac).build();    
    }    
    
    /**
     * 获取验证码-验证验证登陆并注册
     * @throws Exception
     */
	@Test
    public void sendMsgValidateNum() throws Exception {
		log.debug("获取验证码-验证验证登陆并注册");  
		String mobile = "13677375913";
		String password = "program";
        SendMsgForm sendMsgForm = new SendMsgForm();
        sendMsgForm.setMobile(mobile);
        String requestJson = JSONObject.toJSONString(sendMsgForm);
        
        String responseString = mvc.perform( post("/app/sendMsg").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
        
        //验证登陆
        JSONObject obj = JSONObject.parseObject(responseString);
        ValidateMsgForm form = new ValidateMsgForm();       
        form.setHash(obj.getString("hash"));
        form.setMobile(mobile);
        form.setMsgNum(obj.getString("validateNum"));
        form.setPassword(password);
        form.setTamp(obj.getString("tamp"));
        requestJson = JSONObject.toJSONString(form);
	    responseString = mvc.perform( post("/app/validateNum").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
	                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
	    System.out.println("--------返回的json = " + responseString);
    }




}
