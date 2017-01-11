/**  
 * Project Name:juhe_portal  
 * File Name:DrivingTestEntity.java  
 * Package Name:com.aido.portal.domain  
 * Date:2017年1月11日上午10:23:13  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dto;

import java.io.Serializable;

/**  
 * ClassName: DrivingTestOutVO  
 * 驾考题库输出VO
 * @author DOUBLE
 * @version   
 */
public class DrivingTestOutVO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	
	private String id;//编号
	
	private String question;//问题
	
	private String answer;//答案
	
	private String item1;//选项1
	
	private String item2;//选项2
	
	private String item3;//选项2
	
	private String item4;//选项2
	
	private String explains;//解释
	
	private String url;//图片

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
