/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestService.java  
 * Package Name:com.aido.portal.service  
 * Date:2017年1月11日上午10:35:09  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.service;

import java.util.List;

import com.aido.manager.dto.drivingTest.DrivingTestOutVO;



/**  
 * ClassName: DrivingTestService  
 * 驾考题库接口服务
 * @author DOUBLE
 * @version   
 */
public interface DrivingTestService {

	/**
	 *  save:保存驾考题库数据
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param drivingTestEntity
	 */
	void saveData(String url, String key, String subject,String model)  throws Exception;
	
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
	List<DrivingTestOutVO> getDrivingTestPage(int current,int rowCount,String subject,String model) throws Exception ;
	
	/**
	 *  getDrivingTesTotal:驾考题库总数
	 *  @return_type:int
	 *  @author DOUBLE
	 *  @param subject
	 *  @param model
	 *  @return
	 *  @throws Exception
	 */
	int getDrivingTestTotal(String subject, String model) throws Exception;
}
