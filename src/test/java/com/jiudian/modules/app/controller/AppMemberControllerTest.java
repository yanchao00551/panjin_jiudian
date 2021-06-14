package com.jiudian.modules.app.controller;


import com.alibaba.fastjson.JSONObject;
import com.jiudian.modules.member.form.AddressInsertForm;
import com.jiudian.modules.member.form.ModifyPasswordForm;

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
public class AppMemberControllerTest {
	
	private static final Logger log= LoggerFactory.getLogger(AppRegisterControllerTest.class);  
	 
	private MockMvc mvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。    
	
	@Autowired    
    private WebApplicationContext wac; // 注入WebApplicationContext  

	
    @Before // 在测试开始前初始化工作    
    public void setup() {    
        this.mvc= MockMvcBuilders.webAppContextSetup(this.wac).build();    
    }    
    
    /**
     * 修改密码
     * @throws Exception
     */
	@Test
    public void modifyPassword() throws Exception {
		log.debug("修改用户密码");  
		long userId = 12;
		String oldPassword = "program";
		String newPassword = "newPassword";
		ModifyPasswordForm form = new ModifyPasswordForm();
		form.setOldPassword(oldPassword);
		form.setNewPassword(newPassword);
        String requestJson = JSONObject.toJSONString(form);
        
        String responseString = mvc.perform( post("/app/modifyPassword").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
    }
	
	/**
	 * 收货地址列表
	 */
	@Test
	public void addressList() throws Exception{
		log.debug("收货地址列表");
		String responseString = mvc.perform( get("/app/addressList").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 会员地址管理 
	 * 添加地址
	 */
	@Test
	public void addressInsert() throws Exception{
		log.debug("会员地址管理");
		AddressInsertForm form = new AddressInsertForm();
		form.setConsigner("收件人");
		form.setMobile("13677371234");
		form.setPhone("13512341234");
		form.setProvince(18);
		form.setCity(185);
		form.setDistrict(1643);
		form.setAddress ("详细地址");
		form.setZipCode ("411100");
		form.setAlias ("地址别名");
		String requestJson = JSONObject.toJSONString(form);
		String responseString = mvc.perform( post("/app/addressInsert").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
	                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
	    System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 编辑收货地址
	 * operationAddress
	 */
	@Test
	public void operationAddress() throws Exception{
		log.debug("会员地址管理");
		AddressInsertForm form = new AddressInsertForm();
		form.setId(1);
		form.setConsigner("收件人");
		form.setMobile("13677371234");
		form.setPhone("13512341234");
		form.setProvince(18);
		form.setCity(185);
		form.setDistrict(1643);
		form.setAddress ("详细地址");
		form.setZipCode ("411100");
		form.setAlias ("地址别名");
		String requestJson = JSONObject.toJSONString(form);
		String responseString = mvc.perform( post("/app/operationAddress").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
	                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
	    System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 获取收货地址
	 * getMemberExpressAddress
	 */
	@Test
	public void getMemberExpressAddress() throws Exception{
		log.debug("获取收货地址");
		String requestJson = "{\"id\":1}";
		String responseString = mvc.perform( post("/app/getMemberExpressAddress").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 修改会员地址
	 */
	public void updateMemberAddress() throws Exception{
		log.debug("修改会员地址");
		AddressInsertForm form = new AddressInsertForm();
		form.setId(1);
		form.setConsigner("收件人");
		form.setMobile("13677371234");
		form.setPhone("13512341234");
		form.setProvince(18);
		form.setCity(185);
		form.setDistrict(1643);
		form.setAddress ("详细地址");
		form.setZipCode ("411100");
		form.setAlias ("地址别名");
		String requestJson = JSONObject.toJSONString(form);
		String responseString = mvc.perform( post("/app/updateMemberAddress").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
	                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
	    System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 获取用户地址详情
	 */
	public void getMemberAddressDetail() throws Exception{
		log.debug("获取收货地址详情");
		String requestJson = "{\"id\":1}";
		String responseString = mvc.perform( post("/app/getMemberAddressDetail").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 会员地址删除
	 */
	public void memberAddressDelete() throws Exception{
		log.debug("会员地址删除");
		String requestJson = "{\"id\":1}";
		String responseString = mvc.perform( post("/app/memberAddressDelete").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 修改会员默认地址
	 */
	public void updateAddressDefault() throws Exception{
		log.debug("修改会员默认地址");
		String requestJson = "{\"id\":1}";
		String responseString = mvc.perform( post("/app/updateAddressDefault").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 获取省列表
	 */
	public void getProvince() throws Exception{
		log.debug("获取省列表");
		String responseString = mvc.perform( get("/app/getProvince").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 获取城市列表
	 * 
	 */
	public void getCity() throws Exception{
		log.debug("获取城市列表");
		
		String requestJson = "{\"province_id\":18}";
		String responseString = mvc.perform( post("/app/updateAddressDefault").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 获取区域地址
	 */
	public void getDistrict() throws Exception{
		log.debug("获取区域列表");

		String requestJson = "{\"city_id\":185}";
		String responseString = mvc.perform( post("/app/updateAddressDefault").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 获取选择地址
	 */
	public void getSelectAddress() throws Exception{
		log.debug("获取选择地址");
		String requestJson = "{\"province_id\":18,\"city_id\":185}";
		String responseString = mvc.perform( post("/app/updateAddressDefault").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 我的订单
	 */
	public void orderList() throws Exception{
		log.debug("我的订单");
		String responseString = mvc.perform( get("/app/orderList").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("status", "all"))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 我的预售订单
	 */
	public void presellOrderList() throws Exception{
		log.debug("我的预售订单");
		String responseString = mvc.perform( get("/app/presellOrderList").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("status", "all"))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 我的收藏
	 */
	public void goodsCollectionList() throws Exception{
		log.debug("我的收藏");
		String responseString = mvc.perform( get("/app/goodsCollectionList").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 订单详情
	 */
	public void orderDetail() throws Exception{
		log.debug("订单详情");
		String responseString = mvc.perform( get("/app/orderDetail").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("orderId", "0"))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	/**
	 * 会员首页
	 */
	public void memberIndex() throws Exception{
		log.debug("会员首页");
		String responseString = mvc.perform( get("/app/memberIndex").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 取消订单
	 */
	public void orderClose() throws Exception{
		String requestJson = "{\"orderId\":185}";
		String responseString = mvc.perform( post("/app/orderClose").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 获取购物车信息
	 */
	public void getShoppingCart() throws Exception{
		log.debug("获取购物车信息");
		String responseString = mvc.perform( get("/app/getShoppingCart").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	
	
	/**
	 * 获取用户余额
	 */
	public void getMemberAccount() throws Exception{
		log.debug("获取用户余额");
		String responseString = mvc.perform( get("/app/getMemberAccount").accept(MediaType.APPLICATION_FORM_URLENCODED).contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 会员积分流水
	 * @throws Exception
	 */
	public void integrallist() throws Exception{
		log.debug("会员积分流水");
		String requestJson = "{\"startTime\":\"2016-01-01\",\"endTime\":\"2099-01-01\",\"page\":1}";
		String responseString = mvc.perform( post("/app/integrallist").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 会员余额流水
	 */
	public void balancelist() throws Exception{
		log.debug("会员余额流水");
		String requestJson = "{\"startTime\":\"2016-01-01\",\"endTime\":\"2099-01-01\",\"page\":1}";
		String responseString = mvc.perform( post("/app/balancelist").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 提现记录
	 * @throws Exception
	 */
	public void balanceWithdrawList() throws Exception{
		log.debug("提现记录");
		String requestJson = "{\"startTime\":\"2016-01-01\",\"endTime\":\"2099-01-01\",\"page\":1}";
		String responseString = mvc.perform( post("/app/balanceWithdrawList").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 余额积分相互兑换
	 * 
	 */
	public void exchange() throws Exception {
		log.debug("余额积分相互兑换");
		String requestJson = "{\"amount\":10.00}";
		String responseString = mvc.perform( post("/app/exchange").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 绑定手机
	 * @throws Exception
	 */
	public void modifyMobile() throws Exception{
		log.debug("绑定手机");
		String requestJson = "{\"mobile\":\"13677375913\",\"mobileCode\":\"234423\"}";
		String responseString = mvc.perform( post("/app/modifyMobile").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 设置用户支付密码
	 * @throws Exception
	 */
	public void setUserPaymentPassword() throws Exception{
		log.debug("设置用户支付密码");
		String requestJson = "{\"paymentPassword\":\"program\"}";
		String responseString = mvc.perform( post("/app/setUserPaymentPassword").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
	/**
	 * 修改用户支付密码
	 */
	public void updateUserPaymentPassword() throws Exception{
		log.debug("设置用户支付密码");
		String requestJson = "{\"oldPaymentPassword\":\"program\",\"newPaymentPassword\":\"newpass\"}";
		String responseString = mvc.perform( post("/app/updateUserPaymentPassword").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(requestJson))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString(); 
        System.out.println("--------返回的json = " + responseString);
	}
	
}
