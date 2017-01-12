/**  
 * Project Name:juhe_manager_service  
 * File Name:ChatRobotService.java  
 * Package Name:com.aido.manager.service  
 * Date:2017年1月12日下午2:47:39  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import com.aido.manager.dto.chatRobot.ChatRobotOutVO;

/**  
 * ClassName: ChatRobotService  
 * 聊天机器人业务接口
 * @author DOUBLE
 * @version   
 */
public interface ChatRobotService {

	/**
	 *  getRobotAnswer:获取机器人答案
	 *  @return_type:RobotOutVO
	 *  @author DOUBLE
	 *  @param url
	 *  @param key
	 *  @param info
	 *  @return
	 *  @throws Exception
	 */
	ChatRobotOutVO getRobotAnswer(String url,String key,String info) throws Exception;
}
