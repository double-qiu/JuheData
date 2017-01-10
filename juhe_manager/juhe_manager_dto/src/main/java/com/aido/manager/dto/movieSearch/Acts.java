/**  
 * Project Name:juhe_manager_dto  
 * File Name:Acts.java  
 * Package Name:com.aido.manager.dto.movieSearch  
 * Date:2017年1月10日上午11:17:33  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.movieSearch;

import java.io.Serializable;

/**  
 * ClassName: Acts  
 * 演员相关
 * @author DOUBLE
 * @version   
 */
public class Acts implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;//演员名字
	
	private String url;//演员介绍
	
	private String image;//演员照片

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
