/**  
 * Project Name:juhe_manager_pojo  
 * File Name:DrivingTestQueryVO.java  
 * Package Name:com.aido.manager.pojo  
 * Date:2016年12月24日下午12:56:52  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.drivingTest;

import java.io.Serializable;

import com.aido.manager.dto.CommonsConstant;


/**
 * ClassName: DrivingTestQueryVO  
 * 驾考题库查询vo
 * @author DOUBLE
 * @version
 */
public class DrivingTestQueryVO   implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int current;
	
	private int rowCount; 

	private String subject;//考试科目类型
	
	private String model;//驾照类型
	
	private String testType;
	
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

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getUrl() {
		return CommonsConstant.HISTORY_TODAY_DETAIL_URL;
	}


	public String getKey() {
		return CommonsConstant.HISTORY_TODAY_KEY;
	}
	
}
