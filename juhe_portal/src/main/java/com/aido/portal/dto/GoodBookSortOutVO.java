/**  
 * Project Name:juhe_manager_pojo  
 * File Name:OnLineEntity.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dto;

import java.io.Serializable;
import java.util.List;

import com.aido.portal.domain.GoodBookTypeEntity;


/**
 * ClassName: OnLineEntity  
 * 书本商城地址
 * @author DOUBLE
 * @version
 */
public class GoodBookSortOutVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long  id;
	
	private String  name;
	
	private List<GoodBookTypeEntity> typeList;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GoodBookTypeEntity> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<GoodBookTypeEntity> typeList) {
		this.typeList = typeList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
