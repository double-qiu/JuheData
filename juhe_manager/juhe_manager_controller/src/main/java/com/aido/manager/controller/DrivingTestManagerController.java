/**  
 * Project Name:juhe_manager_web  
 * File Name:DrivingTestController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2017年1月11日下午2:54:03  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.InvokeResult;
import com.aido.manager.dto.drivingTest.DrivingTestOutVO;
import com.aido.manager.dto.drivingTest.DrivingTestQueryVO;
import com.aido.manager.service.DrivingTestManagerService;

/**  
 * ClassName: DrivingTestManagerController  
 * 驾考题库
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/drivingTestManager")
public class DrivingTestManagerController {

	private static Logger logger = LoggerFactory.getLogger(DrivingTestManagerController.class);
	@Autowired
	private DrivingTestManagerService drivingTestManagerService;
	
	@RequestMapping("/page")
	@ResponseBody
	public InvokeResult drivingTestPage(DrivingTestQueryVO query){
		List<DrivingTestOutVO> outList = new ArrayList<DrivingTestOutVO>();
		try {
			outList = drivingTestManagerService.getDrivingTestList(query.getUrl(), query.getKey(), query.getSubject(), query.getModel(), query.getTestType());
		}catch (Exception e) {
			logger.error("查询驾考题库分页数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(outList);
	}
}
