/**  
 * Project Name:juhe_manager_web  
 * File Name:ChatRobotController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2017年1月12日下午3:38:13  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.InvokeResult;
import com.aido.manager.dto.chatRobot.ChatRobotOutVO;
import com.aido.manager.dto.chatRobot.ChatRobotQueryVO;
import com.aido.manager.service.ChatRobotService;

/**  
 * ClassName: ChatRobotController  
 * 聊天机器人
 * @author DOUBLE
 * @version   
 */

@Controller
@RequestMapping("/chatRobot")
public class ChatRobotController {
	
	private static Logger logger = LoggerFactory.getLogger(DrivingTestManagerController.class);
	@Autowired
	private ChatRobotService chatRobotService;
	
	@RequestMapping("/answer")
	@ResponseBody
	public InvokeResult getAnswer(ChatRobotQueryVO query){
		ChatRobotOutVO outVO = new ChatRobotOutVO();
		try {
			outVO = chatRobotService.getRobotAnswer(query.getUrl(), query.getKey(), query.getInfo());
			outVO.setInfo(query.getInfo());
		}catch (Exception e) {
			logger.error("查询聊天机器人数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(outVO);
	}

}
