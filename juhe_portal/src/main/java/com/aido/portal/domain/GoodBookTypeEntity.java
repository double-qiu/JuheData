/**  
 * Project Name:juhe_portal  
 * File Name:OnLineEntity.java  
 * Package Name:com.aido.portal.domain
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName: OnLineEntity  
 * 书本商城地址
 * @author DOUBLE
 * @version
 */
@Entity
@Table(name="q_goodbook_type")
public class GoodBookTypeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String  typeId;
	
	private String catalog;
	
	private String sort;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id",nullable=false,length=36)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name ="catalog",nullable=true,length=300)
	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	@Column(name ="typeId",nullable=true,length=300)
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Column(name ="sort",nullable=true,length=300)
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
