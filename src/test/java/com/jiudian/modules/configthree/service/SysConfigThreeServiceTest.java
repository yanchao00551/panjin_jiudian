package com.jiudian.modules.configthree.service;

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
import java.util.List;

import com.jiudian.modules.sms.service.SysNoticeTemplateService;
import com.jiudian.modules.sms.entity.SysNoticeTemplateEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysConfigThreeServiceTest {
	@Autowired
	private SysNoticeTemplateService sysNoticeTemplateService;

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

	@Test
	public void queryTemplateCodeByInfo() throws Exception {
		List<SysNoticeTemplateEntity> list = sysNoticeTemplateService.queryByTemplateCodeInfo("after_register");
		Assert.assertEquals(new String("after_register"), list.get(0).getTemplateCode());
	}

}
