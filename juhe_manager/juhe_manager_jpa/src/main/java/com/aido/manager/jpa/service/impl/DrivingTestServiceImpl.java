/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestServiceImpl.java  
 * Package Name:com.aido.portal.service.impl  
 * Date:2017年1月11日上午10:39:00  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.manager.jpa.dao.DrivingTestDao;
import com.aido.manager.jpa.domain.DrivingTestEntity;
import com.aido.manager.jpa.dto.DrivingTestOutVO;
import com.aido.manager.jpa.service.DrivingTestService;
import com.aido.manager.jpa.utils.Copy;
import com.alibaba.fastjson.JSON;

/**  
 * ClassName: DrivingTestServiceImpl  
 * 驾考题库接口服务实现
 * @author DOUBLE
 * @version   
 */
@Service("drivingTestService")
public class DrivingTestServiceImpl implements DrivingTestService {

	@Autowired
	private DrivingTestDao drivingTestDao;
	
	
	/**  
	 * @param drivingTestEntity
	 * @author DOUBLE
	 * @throws Exception 
	 */
	@Override
	public void saveData(String url, String key, String subject,String model) throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("subject",subject);
		params.put("model",model);
		params.put("testType","order");
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		for (Object object : result) {
			String str = object.toString();
			DrivingTestOutVO outVO = JSON.parseObject(str,DrivingTestOutVO.class);
			DrivingTestEntity drivingTestEntity = new DrivingTestEntity();
			Copy.simpleCopyExcludeNull(outVO, drivingTestEntity);
			drivingTestEntity.setSubject(subject);
			drivingTestEntity.setModel(model);
			drivingTestDao.save(drivingTestEntity);
		}
	}
}
