/**  
 * Project Name:juhe_manager_dto  
 * File Name:HistoryTodayOutVO.java  
 * Package Name:com.aido.manager.dto.historyToday  
 * Date:2016年12月24日下午1:05:17  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.wechat;

import java.io.Serializable;


/**  
 * ClassName: HistoryTodayOutVO  
 * 历史的今天获取数据输出VO
 * @author DOUBLE
 * @version   
 */
public class WeChatSelectdVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;//主键
	
	private String title;//标题
	
	private String source;//来源
	
	private int firstImg;//第一张图片
	
	private int mark;//月
	
	private int url;//日

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getFirstImg() {
		return firstImg;
	}

	public void setFirstImg(int firstImg) {
		this.firstImg = firstImg;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getUrl() {
		return url;
	}

	public void setUrl(int url) {
		this.url = url;
	}
}
