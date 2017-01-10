/**  
 * Project Name:juhe_manager_dto  
 * File Name:MovieSearchQueryVO.java  
 * Package Name:com.aido.manager.dto.movieSearch  
 * Date:2017年1月10日13:08:31
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.movieSearch;

import java.io.Serializable;

import com.aido.manager.dto.CommonsConstant;

/**  
 * ClassName: MovieSearchQueryVO  
 * 影视搜索查询VO
 * @author DOUBLE
 * @version   
 */
public class MovieSearchQueryVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String q;//影视搜索名称
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getUrl() {
		return CommonsConstant.MOVIE_SEARCH_PAGE_URL;
	}

	public String getKey() {
		return CommonsConstant.MOVIE_SEARCH_KEY;
	}
	
	public String getDtype() {
		return CommonsConstant.DEFAULT_DTYPE;
	}
	
}
