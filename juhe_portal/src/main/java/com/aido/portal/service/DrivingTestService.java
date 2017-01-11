/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestService.java  
 * Package Name:com.aido.portal.service  
 * Date:2017年1月11日上午10:35:09  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.service;

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
}
