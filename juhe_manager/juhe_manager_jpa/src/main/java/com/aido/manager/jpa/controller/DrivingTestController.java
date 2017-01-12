/**  
 * Project Name:juhe_manager_jpa  
 * File Name:DrivingTestController.java  
 * Package Name:com.aido.manager.jpa.controller  
 * Date:2017年1月12日上午9:25:24  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.controller;

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
import com.aido.manager.jpa.service.DrivingTestService;

/**  
 * ClassName: DrivingTestController  
 * 驾考题库
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/drivingTest")
public class DrivingTestController {

	private static Logger logger = LoggerFactory.getLogger(DrivingTestController.class);
	@Autowired
	private DrivingTestService drivingTestService;
	
	@RequestMapping("/page")
	@ResponseBody
	public InvokeResult drivingTestPage(DrivingTestQueryVO query){
		List<DrivingTestOutVO> outList = new ArrayList<DrivingTestOutVO>();
		try {
			outList = drivingTestService.getDrivingTestPage(query.getCurrent(), query.getRowCount(), query.getSubject(), query.getModel());
		}catch (Exception e) {
			logger.error("查询驾考题库分页数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(outList);
	}
	@RequestMapping("/total")
	@ResponseBody
	public InvokeResult drivingTestTotal(DrivingTestQueryVO query){
		int pages = 0;
		try {
			int totalNum = drivingTestService.getDrivingTestTotal( query.getSubject(), query.getModel());
			pages = totalNum/20+1;
		}catch (Exception e) {
			logger.error("查询驾考题库总数数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(pages);
	}
}
