/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestEntity.java  
 * Package Name:com.aido.portal.domain  
 * Date:2017年1月11日上午10:23:13  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
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
 * ClassName: DrivingTestEntity  
 * 驾考题库实体
 * @author DOUBLE
 * @version   
 */
@Entity
@Table(name="q_driving_test")
public class DrivingTestEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private long tid;
	
	private String subject;//选择考试科目类型，1：科目1；4：科目4
	
	private String model;//驾照类型，可选择参数为：c1,c2,a1,a2,b1,b2；当subject=4时可省略
	
	private String id;//编号
	
	private String question;//问题
	
	private String answer;//答案
	
	private String item1;//选项1
	
	private String item2;//选项2
	
	private String item3;//选项2
	
	private String item4;//选项2
	
	private String explains;//解释
	
	private String url;//图片

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="tid",nullable=false,length=36)
	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	@Column(name ="subject",nullable=true,length=255)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name ="model",nullable=true,length=255)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name ="id",nullable=true,length=255)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name ="question",nullable=true,length=500)
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name ="answer",nullable=true,length=50)
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name ="item1",nullable=true,length=255)
	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	@Column(name ="item2",nullable=true,length=255)
	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	@Column(name ="item3",nullable=true,length=255)
	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	@Column(name ="item4",nullable=true,length=255)
	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	@Column(name ="explains",nullable=true,length=500)
	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

	@Column(name ="url",nullable=true,length=500)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
