/**  
 * Project Name:juhe_manager_pojo  
 * File Name:OnLineEntity.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dto;

import java.io.Serializable;


/**
 * ClassName: OnLineEntity  
 * 书本商城地址
 * @author DOUBLE
 * @version
 */
public class GoodBookTypeOutVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String  id;
	
	private String catalog;


	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
