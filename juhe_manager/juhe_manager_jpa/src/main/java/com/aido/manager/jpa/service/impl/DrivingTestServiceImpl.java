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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.manager.dto.drivingTest.DrivingTestOutVO;
import com.aido.manager.jpa.dao.DrivingTestDao;
import com.aido.manager.jpa.domain.DrivingTestEntity;
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
			drivingTestEntity.setId(outVO.getId()+"、");
			if(StringUtils.isNotEmpty(outVO.getItem2())) {
				drivingTestEntity.setItem1("A、"+outVO.getItem1());
			}
			if(StringUtils.isNotEmpty(outVO.getItem2())) {
				drivingTestEntity.setItem2("B、"+outVO.getItem2());
			}
			if(StringUtils.isNotEmpty(outVO.getItem3())) {
				drivingTestEntity.setItem3("C、"+outVO.getItem3());
			}
			if(StringUtils.isNotEmpty(outVO.getItem4())) {
				drivingTestEntity.setItem4("D、"+outVO.getItem4());
			}
			drivingTestEntity.setSubject(subject);
			drivingTestEntity.setModel(model);
			drivingTestDao.save(drivingTestEntity);
		}
	}


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
	public List<DrivingTestOutVO> getDrivingTestPage(int current, int rowCount, String subject, String model)
			throws Exception {
		
		
		return drivingTestDao.getDrivingTestPage(current, rowCount, subject, model);
	}


	/**  
	 * @param subject
	 * @param model
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@Override
	public int getDrivingTestTotal(String subject, String model) throws Exception {
		return drivingTestDao.getDrivingTestTotal(subject, model);
	}
}
