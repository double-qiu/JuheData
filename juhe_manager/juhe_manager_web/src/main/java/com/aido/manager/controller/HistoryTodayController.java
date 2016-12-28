/**  
 * Project Name:juhe_manager_web  
 * File Name:HistoryTodayController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2016年12月26日下午1:58:14  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
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
import com.aido.manager.dto.historyToday.HistoryTodayEventDetailVO;
import com.aido.manager.dto.historyToday.HistoryTodayEventListVO;
import com.aido.manager.dto.historyToday.HistoryTodayEventQueryVO;
import com.aido.manager.dto.historyToday.SingleVO;
import com.aido.manager.service.CommonService;
import com.aido.manager.service.HistoryTodayService;

/**  
 * ClassName: HistoryTodayController  
 * 历史的今天控制类
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/historyToday")
public class HistoryTodayController {
	
	private static Logger logger = LoggerFactory.getLogger(HistoryTodayController.class);
	@Autowired
	private HistoryTodayService historyTodayService;
	
	@Autowired
	private CommonService commonService;
	
	/**
	 *  historyTodayEventList:历史的今天列表请求
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param query
	 *  @return
	 */
	@RequestMapping("/eventList")
	@ResponseBody
	public InvokeResult historyTodayEventList(HistoryTodayEventQueryVO query){
		List<HistoryTodayEventListVO> historyTodayList = new ArrayList<HistoryTodayEventListVO>();
		try {
			historyTodayList =historyTodayService.getHistoryTodayEventList(query.getUrl("list"), query.getKey(), query.getV(), query.getMonth(), query.getDay());
		} catch (Exception e) {
			logger.error("查询历史的今天列表数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(historyTodayList);
	}
	
	@RequestMapping("/eventDetail")
	@ResponseBody
	public InvokeResult historyTodayEventDetail(HistoryTodayEventQueryVO query){
		HistoryTodayEventDetailVO historyTodayDetail = new HistoryTodayEventDetailVO();
		try {
			historyTodayDetail =historyTodayService.getHistoryTodayEventDetail(query.getUrl("detail"), query.getKey(), query.getV(),query.getId());
		} catch (Exception e) {
			logger.error("查询历史的今天详细数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(historyTodayDetail);
	}
	
	
	/**
	 *  getMonths:获取月份 
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @return
	 */
	@RequestMapping("/getMonths")
	@ResponseBody
	public InvokeResult getMonths(){
		List<SingleVO> monthList = new ArrayList<SingleVO>();
		try {
			monthList = commonService.getMonthList();
		} catch (Exception e) {
			logger.error("查询历史的今天数据失败：" + e.getMessage(),e);
		}
		return InvokeResult.success(monthList);
	}
	@RequestMapping("/getDays")
	@ResponseBody
	public InvokeResult getDays(){
		List<SingleVO> monthList = new ArrayList<SingleVO>();
		try {
			monthList = commonService.getDayList();
		} catch (Exception e) {
			logger.error("查询历史的今天数据失败：" + e.getMessage(),e);
		}
		return InvokeResult.success(monthList);
	}
	
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
