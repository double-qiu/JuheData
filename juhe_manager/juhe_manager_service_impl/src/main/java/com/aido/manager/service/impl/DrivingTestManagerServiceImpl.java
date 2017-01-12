/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:DrivingTestManagerServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2017年1月11日下午1:56:14  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.manager.dto.drivingTest.DrivingTestOutVO;
import com.aido.manager.service.DrivingTestManagerService;
import com.alibaba.fastjson.JSON;

/**  
 * ClassName: DrivingTestManagerServiceImpl  
 * 驾考题库业务接口实现
 * @author DOUBLE
 * @version   
 */
@Service("drivingTestManagerService")
public class DrivingTestManagerServiceImpl implements DrivingTestManagerService {

	
	/**  
	 * @param current
	 * @param rowCount
	 * @param subject
	 * @param model
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@Override
	public List<DrivingTestOutVO> getDrivingTestList(String url, String key, String subject, String model,String testType)
			throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("subject",subject);
		params.put("model",model);
		params.put("testType",testType);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		List<DrivingTestOutVO> drivingList = new ArrayList<DrivingTestOutVO>();
		if(result == null) {
			return drivingList;
		}
		for (Object object : result) {
			String str = object.toString();
			DrivingTestOutVO outVO = JSON.parseObject(str, DrivingTestOutVO.class);  
			drivingList.add(outVO);
		}
		return drivingList;
	}
}
