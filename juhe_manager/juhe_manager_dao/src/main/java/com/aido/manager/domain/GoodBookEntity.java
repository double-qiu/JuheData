/**  
 * Project Name:juhe_manager_pojo  
 * File Name:GoodBookEntity.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 * ClassName: GoodBookEntity  
 * 商城图书
 * @author DOUBLE
 * @version
 */
@Entity
@Table(name="q_goodbook")
public class GoodBookEntity   implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String title;

	private String catalog;

	private String tags;

	private String sub1;

	private String sub2;

	private String img;
	
	private String reading;
	
	private String bytime;
	
	private String catalog_id;
	
	@Column(name ="catalog_id",nullable=true,length=30)
	public String getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}

	private List<GoodBookOnLineEntity> onLines;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "goodBookFkId")	
	public List<GoodBookOnLineEntity> getOnLines() {
		return onLines;
	}

	public void setOnLines(List<GoodBookOnLineEntity> onLines) {
		this.onLines = onLines;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id",nullable=false,length=36)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Column(name ="title",nullable=true,length=300)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name ="catalog",nullable=true,length=300)
	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	@Column(name ="tags",nullable=true,length=300)
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	@Column(name ="sub1",nullable=true,length=3000)
	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}
	@Column(name ="sub2",nullable=true,length=5000)
	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}
	@Column(name ="img",nullable=true,length=1000)
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	@Column(name ="reading",nullable=true,length=300)
	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}
	@Column(name ="bytime",nullable=true,length=300)
	public String getBytime() {
		return bytime;
	}

	public void setBytime(String bytime) {
		this.bytime = bytime;
	}
}
