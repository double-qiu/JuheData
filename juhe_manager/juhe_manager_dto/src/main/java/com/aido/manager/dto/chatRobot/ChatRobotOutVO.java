/**  
 * Project Name:juhe_manager_dto  
 * File Name:RobotOutVO.java  
 * Package Name:com.aido.manager.dto.chatRobot  
 * Date:2017年1月12日下午2:37:13  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */

package com.aido.manager.dto.chatRobot;

/**  
 * ClassName: RobotOutVO
 * 聊天机器人
 * @author DOUBLE
 * @version   
 */
public class ChatRobotOutVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String code;//返回code
	
	private String text;//返回text
	
	private String time;//时间
	
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "RobotOutVO [code=" + code + ", text=" + text + ", time=" + time + "]";
	}
}