/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestDao.java  
 * Package Name:com.aido.portal.dao  
 * Date:2017年1月11日上午10:41:11  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.dao;

import com.aido.manager.jpa.domain.DrivingTestEntity;

/**  
 * ClassName: DrivingTestDao  
 * 驾考题库数据后台服务接口
 * @author DOUBLE
 * @version   
 */
public interface DrivingTestDao {

	/**
	 *  save:保存驾考题库数据
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param drivingTestEntity
	 */
	void save(DrivingTestEntity drivingTestEntity);
}
