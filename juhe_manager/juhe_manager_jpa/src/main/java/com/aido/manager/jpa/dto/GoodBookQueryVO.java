/**  
 * Project Name:juhe_manager_pojo  
 * File Name:GoodBookEntity.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.dto;

import java.io.Serializable;


/**
 * ClassName: GoodBookQueryVO  
 * 商城图书查询vo
 * @author DOUBLE
 * @version
 */
public class GoodBookQueryVO   implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private int current; //每页数

	private int rowCount; //页数

	private String catalogId;//类型
	
	private String search;//搜索条件
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
}
