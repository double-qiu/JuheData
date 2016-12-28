/**  
 * Project Name:juhe_manager_service  
 * File Name:WeChatSelectedService.java  
 * Package Name:com.aido.manager.service  
 * Date:2016年12月28日16:26:03
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import java.util.List;

import com.aido.manager.dto.wechat.WeChatSelectdPageVO;

/**  
 * ClassName: WeChatSelectedService  
 * 聚合数据：微信精选
 * @author DOUBLE
 * @version   
 */
public interface WeChatSelectedService {

	/**
	 *  getWeChatSelectdPage:获取微信精选分页数据 
	 *  @return_type:List<WeChatSelectdPageVO>
	 *  @author DOUBLE
	 *  @param url ：接口url
	 *  @param key : 接口key
	 *  @param pno : 当前页数，默认1
	 *  @param ps ： 每页返回条数，最大50，默认20
	 *  @param dtype ：返回数据的格式,xml或json，默认json
	 *  @return
	 *  @throws Exception
	 */
	WeChatSelectdPageVO getWeChatSelectdPage(String url,String key,String pno,String ps,String dtype) throws Exception ;
	
}
