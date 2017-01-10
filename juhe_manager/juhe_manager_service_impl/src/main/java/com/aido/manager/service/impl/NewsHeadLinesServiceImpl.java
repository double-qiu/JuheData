/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:NewsHeadLinesServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2017年1月9日下午2:47:04  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.manager.dto.newsHeadLines.NewsHeadLinesVO;
import com.aido.manager.service.NewsHeadLinesService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**  
 * ClassName: NewsHeadLinesServiceImpl  
 * 新闻头条业务实现接口
 * @author DOUBLE
 * @version   
 */
@Service("newsHeadLinesService")
public class NewsHeadLinesServiceImpl implements NewsHeadLinesService {

	/**  
	 * @param url
	 * @param key
	 * @param type
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@Override
	public List<NewsHeadLinesVO> getNewsHeadLinesList(String url, String key, String type) throws Exception {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("key",key);
		params.put("type",type);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 3;
		Map<String, Object> result = HttpClientComponent.getResultMapByGet(url, params, headers, retryTime);
		JSONArray data  = (JSONArray) result.get("data");
		List<NewsHeadLinesVO> newsListRes = JSON.parseArray(JSON.toJSONString(data) , NewsHeadLinesVO.class);
		return newsListRes;
	}
}
