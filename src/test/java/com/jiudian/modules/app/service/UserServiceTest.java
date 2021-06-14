package com.jiudian.modules.app.service;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.After;
import org.junit.AfterClass;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setUpBeforeClass()...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is tearDownAfterClass()...");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("this is setUp()...");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this is tearDown()...");
	}
	
	/**
	 * 发送验证码
	 * @throws Exception
	 */
	@Test
	public void sendMsg() throws Exception {
		String strObject = "{\"number\":\"1234\"}";
		int rst = userService.sendMsg("register_validate","13677375913",strObject);
		Assert.assertEquals(0, rst);
	}

}
