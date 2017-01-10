/**  
 * Project Name:juhe_manager_web  
 * File Name:NewsHeadLinesController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2017年1月9日15:05:27
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.InvokeResult;
import com.aido.manager.dto.movieSearch.MovieSearchQueryVO;
import com.aido.manager.dto.movieSearch.MovieSearchVO;
import com.aido.manager.service.MovieSearchService;

/**  
 * ClassName: HistoryTodayController  
 * 新闻头条
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/movie")
public class MovieSearchController {
	
	private static Logger logger = LoggerFactory.getLogger(MovieSearchController.class);
	@Autowired
	private MovieSearchService movieSearchService;
	
	
	/**
	 *  MovieSearch:影视搜索信息
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param query
	 *  @return
	 */
	
	@RequestMapping("/search")
	@ResponseBody
	public InvokeResult MovieSearch(MovieSearchQueryVO query){
		MovieSearchVO moiveVO = new MovieSearchVO();
		try {
				moiveVO =movieSearchService.getMovieByName(query.getUrl(), query.getKey(), query.getDtype(),query.getQ());
				if(moiveVO == null) {
					return InvokeResult.failure("未找到相关影视");
				}
		} catch (Exception e) {
			logger.error("查询影视数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(moiveVO);
	}
}
