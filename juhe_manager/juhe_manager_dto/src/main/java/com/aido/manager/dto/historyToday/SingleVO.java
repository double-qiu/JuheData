/**  
 * Project Name:juhe_manager_dto  
 * File Name:MonthListVO.java  
 * Package Name:com.aido.manager.dto.historyToday  
 * Date:2016年12月27日下午2:01:20  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.historyToday;

import java.io.Serializable;

/**  
 * ClassName: MonthListVO  
 * 月份VO
 * @author DOUBLE
 * @version   
 */
public class SingleVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String value;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
