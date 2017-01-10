/**  
 * Project Name:juhe_manager_dto  
 * File Name:NewsHeadLinesVO.java  
 * Package Name:com.aido.manager.dto.NewsHeadLines  
 * Date:2017年1月9日下午2:41:02  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.newsHeadLines;

import java.io.Serializable;

/**  
 * ClassName: NewsHeadLinesVO  
 * 新闻头条输出VO
 * @author DOUBLE
 * @version   
 */
public class NewsHeadLinesVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String uniquekey;//主键
	
	private String title;//标题
	
	private String date;//时间
	
	private String category;//类型
	
	private String author_name;//来源名称
	
	private String url;//原文地址
	
	private String thumbnail_pic_s;//图片1
	
	private String thumbnail_pic_s02;//图片2

	private String thumbnail_pic_s03;//图片3

	public String getUniquekey() {
		return uniquekey;
	}

	public void setUniquekey(String uniquekey) {
		this.uniquekey = uniquekey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail_pic_s() {
		return thumbnail_pic_s;
	}

	public void setThumbnail_pic_s(String thumbnail_pic_s) {
		this.thumbnail_pic_s = thumbnail_pic_s;
	}

	public String getThumbnail_pic_s02() {
		return thumbnail_pic_s02;
	}

	public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
		this.thumbnail_pic_s02 = thumbnail_pic_s02;
	}

	public String getThumbnail_pic_s03() {
		return thumbnail_pic_s03;
	}

	public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
		this.thumbnail_pic_s03 = thumbnail_pic_s03;
	}
}
