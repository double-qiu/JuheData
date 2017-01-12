/**  
 * Project Name:juhe_manager_service  
 * File Name:DrivingTestManagerService.java  
 * Package Name:com.aido.manager.service 
 * Date:2017年1月11日13:49:36
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import java.util.List;

import com.aido.manager.dto.drivingTest.DrivingTestOutVO;

/**  
 * ClassName: DrivingTestManagerService  
 * 聚合数据：驾考题库
 * @author DOUBLE
 * @version   
 */
public interface DrivingTestManagerService {

	/**
	 *  getDrivingTestPage:获取驾考题库分页数据
	 *  @return_type:List<DrivingTestOutVO>
	 *  @author DOUBLE
	 *  @param current ：第几页
	 *  @param rowCount：每页多少条
	 *  @param subject  ：选择考试科目类型，1：科目1；4：科目4
	 *  @param model ：驾照类型，可选择参数为：c1,c2,a1,a2,b1,b2；当subject=4时可省略
	 *  @return
	 *  @throws Exception
	 */
	List<DrivingTestOutVO> getDrivingTestList(String url, String key, String subject, String model,String testType) throws Exception;
	
}
