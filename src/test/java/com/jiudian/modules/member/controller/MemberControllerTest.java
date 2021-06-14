package com.jiudian.modules.member.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiudian.modules.sys.form.SysLoginForm;

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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)  
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@Rollback(value=true)
@Transactional

@SpringBootTest 
public class MemberControllerTest {
	
	private static final Logger log= LoggerFactory.getLogger(MemberController.class);  
	 
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
    public void userDetail() throws Exception {
		log.debug("会员详情流水分页列表");  
		String token = this.getToken();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("limit", "10");
		params.set("page","1");
		params.set("memberId", "13");
		String responseString = mvc.perform( get("/member/member/userDetail").header("token", token).accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_FORM_URLENCODED).params(params))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
    }

	/**
	 * 获取token
	 * @return
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	public String getToken() throws  Exception {
		log.debug("获取TOKEN");  
		String username = "admin";
		String password = "admin";
		SysLoginForm loginForm = new SysLoginForm();
        loginForm.setUsername(username);
        loginForm.setPassword(password);
        String requestJson = JSONObject.toJSONString(loginForm);
        String responseString = mvc.perform( post("/sys/login").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
        JSONObject obj = JSONObject.parseObject(responseString);
        return obj.getString("token");
	}
	


}
