/**  
 * Project Name:juhe_portal
 * File Name:GoodBookSortEntity.java  
 * Package Name:com.aido.portal.domain
 * Date:2017年1月3日11:15:17
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName: GoodBookSortEntity  
 * 图书大类
 * @author DOUBLE
 * @version
 */
@Entity
@Table(name="q_goodbook_sort")
public class GoodBookSortEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String  name;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id",nullable=false,length=36)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name ="name",nullable=true,length=300)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
