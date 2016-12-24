/**  
 * Project Name:juhe_manager_service  
 * File Name:HistoryTodayService.java  
 * Package Name:com.aido.manager.service  
 * Date:2016年12月24日下午12:22:47  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import java.util.List;

import com.aido.manager.dto.historyToday.HistoryTodayEventDetailOutVO;
import com.aido.manager.dto.historyToday.HistoryTodayEventListOutVO;

/**  
 * ClassName: HistoryTodayService  
 * 聚合数据：历史的今天
 * @author DOUBLE
 * @version   
 */
public interface HistoryTodayService {

	/**
	 *  getHistoryTodayEventList:事件列表
	 *  @return_type:List<HistoryTodayOutVO>
	 *  @author DOUBLE
	 *  @param url 接口请求url
	 *  @param key 接口key : 5441f38932f99138892ff6dd4b76eb5d
	 *  @param v 接口版本 当前1.0
	 *  @param month 月
	 *  @param day 日
	 *  @return
	 */
	List<HistoryTodayEventListOutVO> getHistoryTodayEventList(String url,String key,String v,String month,String day) throws Exception ;
	
	/**
	 *  getHistoryTodayEventDetail:根据ID查询事件详情
	 *  @return_type:HistoryTodayEventDetailOutVO
	 *  @author DOUBLE
	 *  @param url 接口请求url
	 *  @param key 接口key : 5441f38932f99138892ff6dd4b76eb5d
	 *  @param v 接口版本 当前1.0
	 *  @param id 事件id
	 *  @return
	 */
	HistoryTodayEventDetailOutVO getHistoryTodayEventDetail(String url,String key,String v,String id) throws Exception ;
	
	/**
	 *  getHistoryTodayEventList:事件列表 v2.0
	 *  @return_type:List<HistoryTodayOutVO>
	 *  @author DOUBLE
	 *  @param url 接口请求url
	 *  @param key 接口key : 5441f38932f99138892ff6dd4b76eb5d
	 *  @param date 日期,格式:月/日 如:1/1,/10/1,12/12 如月或者日小于10,前面无需加0
	 *  @return
	 */
	List<HistoryTodayEventListOutVO> getHistoryTodayEventList(String url,String key,String date) throws Exception ;
	
	/**
	 *  getHistoryTodayEventDetail:根据ID查询事件详情 v2.0
	 *  @return_type:HistoryTodayEventDetailOutVO
	 *  @author DOUBLE
	 *  @param url 接口请求url
	 *  @param key 接口key : 5441f38932f99138892ff6dd4b76eb5d
	 *  @param e_id 事件id
	 *  @return
	 */
	HistoryTodayEventDetailOutVO getHistoryTodayEventDetail(String url,String key,String e_id) throws Exception ;
}
