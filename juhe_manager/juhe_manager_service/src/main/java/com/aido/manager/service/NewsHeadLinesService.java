/**  
 * Project Name:juhe_manager_service  
 * File Name:NewsHeadLinesService.java  
 * Package Name:com.aido.manager.service 
 * Date:2017年1月9日14:39:51
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import java.util.List;

import com.aido.manager.dto.NewsHeadLines.NewsHeadLinesVO;

/**  
 * ClassName: NewsHeadLinesService  
 * 聚合数据：新闻头条
 * @author DOUBLE
 * @version   
 */
public interface NewsHeadLinesService {

	/**
	 *  getNewsHeadLinesList:新闻头条
	 *  @return_type:List<NewsHeadLinesVO>
	 *  @author DOUBLE
	 *  @param url
	 *  @param key
	 *  @param type : 类型
	 *  @return
	 *  @throws Exception
	 */
	List<NewsHeadLinesVO> getNewsHeadLinesList(String url,String key,String type) throws Exception ;
	
	
}
