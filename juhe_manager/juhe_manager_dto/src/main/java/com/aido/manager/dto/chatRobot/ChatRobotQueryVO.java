/**  
 * Project Name:juhe_manager_pojo  
 * File Name:RobotQueryVO.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2017年1月12日14:46:59
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.chatRobot;

import java.io.Serializable;

import com.aido.manager.dto.CommonsConstant;


/**
 * ClassName: RobotQueryVO  
 * 聊天机器人查询vo
 * @author DOUBLE
 * @version
 */
public class ChatRobotQueryVO   implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String info;//要发送给机器人的内容，不要超过30个字符
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getUrl() {
		return CommonsConstant.CHAT_ROBOT_PAGE_URL;
	}

	public String getKey() {
		return CommonsConstant.CHAT_ROBOT_KEY;
	}
	
}
