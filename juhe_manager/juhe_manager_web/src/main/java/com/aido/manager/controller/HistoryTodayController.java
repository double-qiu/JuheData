/**  
 * Project Name:juhe_manager_web  
 * File Name:HistoryTodayController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2016年12月26日下午1:58:14  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.manager.dto.historyToday.HistoryTodayEventListOutVO;
import com.aido.manager.service.HistoryTodayService;

/**  
 * ClassName: HistoryTodayController  
 * 历史的今天控制类
 * @author DOUBLE
 * @version   
 */
@Controller
public class HistoryTodayController {
	@Autowired
	private HistoryTodayService historyTodayService;
	@RequestMapping("/historyTodayEventList")
	@ResponseBody
	public String historyTodayEventList(Model model){
		List<HistoryTodayEventListOutVO> historyTodayList;
		try {
			historyTodayList =historyTodayService.getHistoryTodayEventList("http://api.juheapi.com/japi/toh", "5441f38932f99138892ff6dd4b76eb5d", "1.0", "12", "26");
			System.out.println("SIZE=="+historyTodayList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
