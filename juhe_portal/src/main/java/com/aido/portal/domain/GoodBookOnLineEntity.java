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
@Table(name="q_goodbook_online")
public class GoodBookOnLineEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String  mallName;
	
	private String mallUrl;
	
	private String book;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id",nullable=false,length=36)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name ="mallName",nullable=true,length=300)
	public String getMallName() {
		return mallName;
	}

	public void setMallName(String mallName) {
		this.mallName = mallName;
	}
	@Column(name ="mallUrl",nullable=true,length=5000)
	public String getMallUrl() {
		return mallUrl;
	}

	public void setMallUrl(String mallUrl) {
		this.mallUrl = mallUrl;
	}
	@Column(name ="book",nullable=true,length=300)
	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
}
