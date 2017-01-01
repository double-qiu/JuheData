/**  
 * Project Name:juhe_manager_pojo  
 * File Name:GoodBookEntity.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dto;

import java.io.Serializable;

/**
 * ClassName: GoodBookEntity  
 * 商城图书
 * @author DOUBLE
 * @version
 */
public class GoodBookOutVO   implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String title;

	private String catalog;

	private String tags;

	private String sub1;

	private String sub2;

	private String img;
	
	private String reading;
	
	private String bytime;
	
	private String  online;
	

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}
	public String getBytime() {
		return bytime;
	}

	public void setBytime(String bytime) {
		this.bytime = bytime;
	}
}
