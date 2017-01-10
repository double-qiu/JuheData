/**  
 * Project Name:juhe_manager_service  
 * File Name:MovieSearchService.java  
 * Package Name:com.aido.manager.service  
 * Date:2017年1月10日下午12:47:53  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import com.aido.manager.dto.movieSearch.MovieSearchVO;

/**  
 * ClassName: MovieSearchService  
 * 影视搜索服务接口
 * @author DOUBLE
 * @version   
 */
public interface MovieSearchService {
	
	/**
	 *  getMovieByName:通过名称获取影视信息
	 *  @return_type:List<MovieSearch>
	 *  @author DOUBLE
	 *  @param url
	 *  @param key
	 *  @param dtype 
	 *  @param q : 影视搜索名称
	 *  @return
	 */
	MovieSearchVO getMovieByName(String url,String key,String dtype,String q)  throws Exception;

}
