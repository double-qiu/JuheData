/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:MovieSearchServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2017年1月10日下午12:51:03  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.manager.dto.movieSearch.MovieSearchVO;
import com.aido.manager.service.MovieSearchService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**  
 * ClassName: MovieSearchServiceImpl  
 * 影视搜索接口服务实现
 * @author DOUBLE
 * @version   
 */
@Service("movieSearchService")
public class MovieSearchServiceImpl implements MovieSearchService {

	/**  
	 * @param url
	 * @param key
	 * @param dtype
	 * @param q
	 * @return
	 * Administrator
	 * @throws Exception 
	 */
	@Override
	public MovieSearchVO getMovieByName(String url, String key, String dtype, String q) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key",key);
		params.put("dtype",dtype);
		params.put("q",q);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 3;
		Map<String, Object> result = HttpClientComponent.getResultMapByGet(url, params, headers, retryTime);
		if(result == null) {
			return null;
		}
		Object obj = result.get("playlinks");
		String play = "http://www.360kan.com/#";
		if(StringUtils.isEmpty(obj.toString())) {
			result.put("playlinks", null);
		} else {
			JSONObject playlinks = (JSONObject) obj;
			 play = getPlayUrl(playlinks);
		}
		MovieSearchVO outVO = JSON.parseObject(JSON.toJSONString(result), MovieSearchVO.class);  
		outVO.setPlay(play);
		return outVO;
	}
	

	/**  
	 *  setPlayUrl:(这里用一句话描述这个方法的作用). 
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param playlinks  
	 */
	private String getPlayUrl(JSONObject playJson ) {
		String qq = (String) playJson.get("qq");
		if(StringUtils.isNotBlank(qq)) {
			return qq;
		}
		String qiyi = (String) playJson.get("qiyi");
		if(StringUtils.isNotBlank(qiyi)) {
			return qiyi;
		}
		String tudou = (String) playJson.get("tudou");
		if(StringUtils.isNotBlank(tudou)) {
			return tudou;
		}
		String youku = (String) playJson.get("youku");
		if(StringUtils.isNotBlank(youku)) {
			return youku;
		}
		String leshi = (String) playJson.get("leshi");
		if(StringUtils.isNotBlank(leshi)) {
			return leshi;
		}
		String sohu = (String) playJson.get("sohu");
		if(StringUtils.isNotBlank(sohu)) {
			return sohu;
		}
		String imgo = (String) playJson.get("imgo");
		if(StringUtils.isNotBlank(imgo)) {
			return imgo;
		}
		String pptv = (String) playJson.get("pptv");
		if(StringUtils.isNotBlank(pptv)) {
			return pptv;
		}
		String baofeng = (String) playJson.get("baofeng");
		if(StringUtils.isNotBlank(baofeng)) {
			return baofeng;
		}
		String huashu = (String) playJson.get("huashu");
		if(StringUtils.isNotBlank(huashu)) {
			return huashu;
		}
		String fengxing = (String) playJson.get("fengxing");
		if(StringUtils.isNotBlank(fengxing)) {
			return fengxing;
		}
		return "http://www.360kan.com/#";
	}
}
