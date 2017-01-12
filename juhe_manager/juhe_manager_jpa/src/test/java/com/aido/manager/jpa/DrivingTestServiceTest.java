/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestServiceTest.java  
 * Package Name:com.aido.portal.test  
 * Date:2017年1月11日上午10:58:11  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aido.manager.dto.drivingTest.DrivingTestOutVO;
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
		 String[] models = new String[]{"c1","c2","a1","a2","b1","b2"};
		 for (int i = 0; i < models.length; i++) {
			 drivingTestService.saveData(url, key, "1", models[i]);
		}
		 drivingTestService.saveData(url, key, "4", "");
	 }
	 @Test
	 public void getDrivingTestPageTest() throws Exception {
		 String subject = "1";
		 String model = "a1";
		 int current = 1;
		 int rowCount = 20;
		 List<DrivingTestOutVO> outList = drivingTestService.getDrivingTestPage(current, rowCount, subject, model);
		 System.out.println(outList.size());
	 }
	 @Test
	 public void getDrivingTesTotalTest() throws Exception {
		 String subject = "1";
		 String model = "a1";
		 int total = drivingTestService.getDrivingTestTotal(subject, model);
		 System.out.println(total);
	 }
}
