/**  
 * Project Name:juhe_manager_web  
 * File Name:NewsHeadLinesController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2017年1月9日15:05:27
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
import com.aido.manager.dto.NewsHeadLines.NewsHeadLinesQueryVO;
import com.aido.manager.dto.NewsHeadLines.NewsHeadLinesVO;
import com.aido.manager.service.NewsHeadLinesService;

/**  
 * ClassName: HistoryTodayController  
 * 新闻头条
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/news")
public class NewsHeadLinesController {
	
	private static Logger logger = LoggerFactory.getLogger(NewsHeadLinesController.class);
	@Autowired
	private NewsHeadLinesService newsHeadLinesService;
	
	
	/**
	 *  historyTodayEventList:新闻头条
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param query
	 *  @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public InvokeResult historyTodayEventList(NewsHeadLinesQueryVO query){
		List<NewsHeadLinesVO> newsList = new ArrayList<NewsHeadLinesVO>();
		try {
			newsList =newsHeadLinesService.getNewsHeadLinesList(query.getUrl(), query.getKey(), query.getType());
		} catch (Exception e) {
			logger.error("查询新闻头条数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(newsList);
	}
	
}
