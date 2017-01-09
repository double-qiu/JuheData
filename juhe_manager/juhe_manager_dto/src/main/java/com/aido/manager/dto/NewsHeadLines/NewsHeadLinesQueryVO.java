/**  
 * Project Name:juhe_manager_dto  
 * File Name:HistoryTodayOutVO.java  
 * Package Name:com.aido.manager.dto.historyToday  
 * Date:2016年12月24日下午1:05:17  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.NewsHeadLines;

import java.io.Serializable;

import com.aido.manager.dto.CommonsConstant;

/**  
 * ClassName: HistoryTodayOutVO  
 * 新闻头条查询VO
 * @author DOUBLE
 * @version   
 */
public class NewsHeadLinesQueryVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String type;//类型：top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return CommonsConstant.NEWS_HEADLINES_PAGE_URL;
	}

	public String getKey() {
		return CommonsConstant.NEWS_HEADLINES_KEY;
	}
}
