/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestDao.java  
 * Package Name:com.aido.portal.dao  
 * Date:2017年1月11日上午10:41:11  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.dao;

import java.util.List;

import com.aido.manager.dto.drivingTest.DrivingTestOutVO;
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
	
	/**
	 *  getDrivingTestPage:驾考题库分页数据
	 *  @return_type:List<DrivingTestOutVO>
	 *  @author DOUBLE
	 *  @param current
	 *  @param rowCount
	 *  @param subject
	 *  @param model
	 *  @return
	 *  @throws Exception
	 */
	List<DrivingTestOutVO> getDrivingTestPage(int current, int rowCount, String subject, String model) throws Exception;
	
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
