/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestDaoImpl.java  
 * Package Name:com.aido.portal.dao.impl  
 * Date:2017年1月11日上午10:42:29  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aido.manager.jpa.dao.BaseDao;
import com.aido.manager.jpa.dao.DrivingTestDao;
import com.aido.manager.jpa.domain.DrivingTestEntity;

/**  
 * ClassName: DrivingTestDaoImpl  
 * 驾考题库数据后台服务接口实现
 * @author DOUBLE
 * @version   
 */
@Repository("drivingTestDaoImpl")
public class DrivingTestDaoImpl implements DrivingTestDao {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	/**  
	 * @param drivingTestEntity
	 * @author DOUBLE
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save(DrivingTestEntity drivingTestEntity) {
		baseDao.save(drivingTestEntity);
	}
}
