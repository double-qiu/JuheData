/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestServiceTest.java  
 * Package Name:com.aido.portal.test  
 * Date:2017年1月11日上午10:58:11  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aido.manager.jpa.service.DrivingTestService;

/**  
 * ClassName: DrivingTestServiceTest  
 * 驾考题库
 * @author DOUBLE
 * @version   
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath*:spring.xml")
public class DrivingTestServiceTest  extends AbstractJUnit4SpringContextTests {

	@Autowired
	private	DrivingTestService drivingTestService;
	
	 @Test
	 public void saveDrivingTestDataTest() throws Exception {
		 String url = "http://v.juhe.cn/jztk/query";
		 String key = "a4823a8d04568d4a1ad0ed43f1ffb4c5";
		 String subject = "4";
		 String model = "b2";
		 drivingTestService.saveData(url, key, subject, model);
	 }
}
