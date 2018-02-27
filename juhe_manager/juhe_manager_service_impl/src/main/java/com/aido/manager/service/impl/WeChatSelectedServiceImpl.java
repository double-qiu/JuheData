/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:WeChatSelectedServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2016年12月28日下午4:47:04  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.common.httpclient.model.HttpResult;
import com.aido.manager.dto.wechat.WeChatSelectdPageVO;
import com.aido.manager.dto.wechat.WeChatSelectdVO;
import com.aido.manager.service.WeChatSelectedService;

/**  
 * ClassName: WeChatSelectedServiceImpl  
 * 微信精选业务实现接口
 * @author DOUBLE
 * @version   
 */
@Service("weChatSelectedService")
public class WeChatSelectedServiceImpl implements WeChatSelectedService {

	/**  
	 * @param url
	 * @param key
	 * @param pno
	 * @param ps
	 * @param dtype
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public WeChatSelectdPageVO  getWeChatSelectdPage(String url, String key, String pno, String ps, String dtype)
			throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key",key);
		params.put("pno",pno);
		params.put("ps",ps);
		params.put("dtype",dtype);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 3;
		WeChatSelectdPageVO weChatSelectdPageVO = new WeChatSelectdPageVO();
		Map<String, Object> result = HttpClientComponent.getResultMapByGet(url, params, headers, retryTime);
		if(result == null) {
			return weChatSelectdPageVO;
		}
		int totalPageRes = Integer.parseInt(result.get("totalPage").toString());
		List<WeChatSelectdVO> weChatListRes = (List<WeChatSelectdVO>) result.get("list");
		weChatSelectdPageVO.setList(weChatListRes);
		weChatSelectdPageVO.setTotalPage(totalPageRes);
		return weChatSelectdPageVO;
	}

	/**
	 * @param url
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	public HttpResult getWeChatSelectdDetail(String url) throws Exception {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Access-Control-Allow-Origin", "*");
		HttpResult httpRes = HttpClientComponent.getInstance().doGet(url, headers, 3);
		return httpRes;
	}
}
