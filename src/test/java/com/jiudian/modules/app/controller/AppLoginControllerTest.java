package com.jiudian.modules.app.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiudian.modules.app.form.LoginForm;

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
@Rollback(value=true)
@Transactional

@SpringBootTest 
public class AppLoginControllerTest {
	
	private static final Logger log= LoggerFactory.getLogger(AppRegisterControllerTest.class);  
	 
	private MockMvc mvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。    
	
	@Autowired    
    private WebApplicationContext wac; // 注入WebApplicationContext  

	
    @Before // 在测试开始前初始化工作    
    public void setup() {    
        this.mvc= MockMvcBuilders.webAppContextSetup(this.wac).build();    
    }    
    
    /**
     * 用户名密码登陆
     * @throws Exception
     */
	@Test
    public void login() throws Exception {
		log.debug("用户名密码登陆");  
		String mobile = "13677375913";
		String password = "program";
		LoginForm loginForm = new LoginForm();
        loginForm.setMobile(mobile);
        loginForm.setPassword(password);
        String requestJson = JSONObject.toJSONString(loginForm);
        
        String responseString = mvc.perform( post("/app/login").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
    }




}
