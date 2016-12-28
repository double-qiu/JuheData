/**  
 * Project Name:juhe_manager_dto  
 * File Name:HistoryTodayOutVO.java  
 * Package Name:com.aido.manager.dto.historyToday  
 * Date:2016年12月24日下午1:05:17  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.historyToday;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**  
 * ClassName: HistoryTodayOutVO  
 * 历史的今天获取数据输出VO
 * @author DOUBLE
 * @version   
 */
public class HistoryTodayEventDetailVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String _id;//主键
	
	private String title;//标题
	
	private String pic;//图片url
	
	private int year;//年
	
	private int month;//月
	
	private int day;//日
	
	private String des;//简述
	
	private String content;//描述
	
	private String lunar;//阴历日期

	@JSONField(name="_id")
	public String get_id() {
		return _id;
	}
	@JSONField(name="_id")
	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}

	@Override
	public String toString() {
		return "HistoryTodayEventDetailOutVO [title=" + title + ", pic=" + pic + ", year=" + year + ", month=" + month
				+ ", day=" + day + ", des=" + des + ", content=" + content + ", lunar=" + lunar + "]";
	}
}
