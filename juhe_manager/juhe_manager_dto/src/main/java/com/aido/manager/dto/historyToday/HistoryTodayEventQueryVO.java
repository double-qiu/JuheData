/**  
 * Project Name:juhe_manager_dto  
 * File Name:HistoryTodayOutVO.java  
 * Package Name:com.aido.manager.dto.historyToday  
 * Date:2016年12月24日下午1:05:17  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.historyToday;

import java.io.Serializable;

import com.aido.manager.dto.CommonsConstant;

/**  
 * ClassName: HistoryTodayOutVO  
 * 历史的今天查询VO
 * @author DOUBLE
 * @version   
 */
public class HistoryTodayEventQueryVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String month;//月
	
	private String day;//日
	
	private String id;//主键
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUrl(String type) {
		return type == "list"?CommonsConstant.HISTORY_TODAY_List_URL:CommonsConstant.HISTORY_TODAY_DETAIL_URL;
	}


	public String getKey() {
		return CommonsConstant.HISTORY_TODAY_KEY;
	}


	public String getV() {
		return CommonsConstant.HISTORY_TODAY_V;
	}


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
