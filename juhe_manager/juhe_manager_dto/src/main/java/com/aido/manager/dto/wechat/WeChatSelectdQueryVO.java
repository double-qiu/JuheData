/**  
 * Project Name:juhe_manager_dto  
 * File Name:WeChatSelectdQueryVO.java  
 * Package Name:com.aido.manager.dto.historyToday  
 * Date:2016年12月24日下午1:05:17  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.wechat;

import java.io.Serializable;

import com.aido.manager.dto.CommonsConstant;

/**  
 * ClassName: WeChatSelectdQueryVO  
 * 微信精选查询VO
 * @author DOUBLE
 * @version   
 */
public class WeChatSelectdQueryVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String pno;//当前页数
	
	private String ps;//每页返回条数
	

	public String getPno() {
		return pno;
	}


	public void setPno(String pno) {
		this.pno = pno;
	}


	public String getPs() {
		return ps;
	}


	public void setPs(String ps) {
		this.ps = ps;
	}


	public String getUrl() {
		return CommonsConstant.WECHAT_SELECTED_PAGE_URL;
	}


	public String getKey() {
		return CommonsConstant.WECHAT_SELECTED_KEY;
	}

	public String getDtype() {
		return CommonsConstant.DEFAULT_DTYPE ;
	}


}
