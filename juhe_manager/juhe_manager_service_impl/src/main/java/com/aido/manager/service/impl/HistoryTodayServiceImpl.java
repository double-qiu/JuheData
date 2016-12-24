/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:HistoryTodayServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2016年12月24日下午1:28:39  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.manager.dto.historyToday.HistoryTodayEventDetailOutVO;
import com.aido.manager.dto.historyToday.HistoryTodayEventListOutVO;
import com.aido.manager.service.HistoryTodayService;
import com.alibaba.fastjson.JSON;

/**  
 * ClassName: HistoryTodayServiceImpl  
 * 历史的今天数据接口业务实现
 * @author DOUBLE
 * @version   
 */
@Service("historyTodayService")
public class HistoryTodayServiceImpl implements HistoryTodayService {

	/**  
	 * @param url
	 * @param key
	 * @param v
	 * @param month
	 * @param day
	 * @return
	 * Administrator
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@Override
	public List<HistoryTodayEventListOutVO> getHistoryTodayEventList(String url, String key, String v, String month,
			String day) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("v",v);
		params.put("month",month);
		params.put("day",day);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<HistoryTodayEventListOutVO> eventList = new ArrayList<HistoryTodayEventListOutVO>();
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		if(result == null) {
			return eventList;
		} 
		for (Object object : result) {
			String str = object.toString();
			HistoryTodayEventListOutVO outVO = JSON.parseObject(str, HistoryTodayEventListOutVO.class);  
			eventList.add(outVO);
		}
		return eventList;
	}
	/**  
	 * @param url
	 * @param key
	 * @param v
	 * @param id
	 * @return
	 * Administrator
	 * @throws Exception 
	 */
	@Override
	public HistoryTodayEventDetailOutVO getHistoryTodayEventDetail(String url, String key, String v, String id) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("v",v);
		params.put("id",id);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		if(result == null) {
			return new HistoryTodayEventDetailOutVO();
		}
		String str = result.get(0).toString();
		HistoryTodayEventDetailOutVO outVO = JSON.parseObject(str, HistoryTodayEventDetailOutVO.class);  
		return outVO;
	}

	/**  
	 * @param url
	 * @param key
	 * @param date
	 * @return
	 * Administrator
	 * @throws Exception 
	 */
	@Override
	public List<HistoryTodayEventListOutVO> getHistoryTodayEventList(String url, String key, String date) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("date",date);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<HistoryTodayEventListOutVO> eventList = new ArrayList<HistoryTodayEventListOutVO>();
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		if(result == null) {
			return eventList;
		} 
		for (Object object : result) {
			String str = object.toString();
			HistoryTodayEventListOutVO outVO = JSON.parseObject(str, HistoryTodayEventListOutVO.class);  
			eventList.add(outVO);
		}
		return eventList;
	}

	/**  
	 * @param url
	 * @param key
	 * @param e_id
	 * @return
	 * Administrator
	 * @throws Exception 
	 */
	@Override
	public HistoryTodayEventDetailOutVO getHistoryTodayEventDetail(String url, String key, String e_id) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("e_id",e_id);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		if(result == null) {
			return new HistoryTodayEventDetailOutVO();
		}
		String str = result.get(0).toString();
		HistoryTodayEventDetailOutVO outVO = JSON.parseObject(str, HistoryTodayEventDetailOutVO.class);  
		return outVO;
	}
}
