/**  
 * Project Name:juhe_manager_web  
 * File Name:HistoryTodayController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2016年12月26日下午1:58:14  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.InvokeResult;
import com.aido.manager.dto.wechat.WeChatSelectdPageVO;
import com.aido.manager.dto.wechat.WeChatSelectdQueryVO;
import com.aido.manager.service.WeChatSelectedService;

/**  
 * ClassName: HistoryTodayController  
 * 微信精选控制类
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/weChatSelected")
public class WeChatSelectedController {
	
	private static Logger logger = LoggerFactory.getLogger(WeChatSelectedController.class);
	@Autowired
	private WeChatSelectedService weChatSelectedService;
	
	/**
	 *  historyTodayEventList:历史的今天列表请求
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param query
	 *  @return
	 */
	@RequestMapping("/page")
	@ResponseBody
	public InvokeResult weChatPage(WeChatSelectdQueryVO query){
		WeChatSelectdPageVO weChatSelectdPage = new WeChatSelectdPageVO();
		try {
			weChatSelectdPage =weChatSelectedService.getWeChatSelectdPage(query.getUrl(), query.getKey(), query.getPno(), query.getPs(), query.getDtype());
		} catch (Exception e) {
			logger.error("查询微信精选列表数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(weChatSelectdPage);
	}
}
