/**  
 * Project Name:juhe_manager_pojo  
 * File Name:HistoryTodayEntiy.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.pojo;

/**  
 * ClassName: HistoryTodayEntiy  
 * 历史的今天实体
 * @author DOUBLE
 * @version   
 */
public class HistoryTodayEntiy {

	private String id;//主键
	
	private String title;//标题
	
	private String pic;//图片url
	
	private int year;//年
	
	private int month;//月
	
	private int day;//日
	
	private String des;//描述
	
	private String lunar;//阴历日期

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

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}
	
}
