/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:ChatRobotServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2017年1月12日下午2:50:42  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.common.util.DateUtil;
import com.aido.manager.dto.chatRobot.ChatRobotOutVO;
import com.aido.manager.service.ChatRobotService;
import com.alibaba.fastjson.JSON;

/**  
 * ClassName: ChatRobotServiceImpl  
 * 聊天机器人业务接口实现
 * @author DOUBLE
 * @version   
 */
@Service("chatRobotService")
public class ChatRobotServiceImpl implements ChatRobotService {

	/**  
	 * @param url
	 * @param key
	 * @param info
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@Override
	public ChatRobotOutVO getRobotAnswer(String url, String key, String info) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("key",key);
		params.put("info",info);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 3;
		Map<String, Object> result = HttpClientComponent.getResultMapByGet(url, params, headers, retryTime);
		ChatRobotOutVO outVO = new ChatRobotOutVO();
		if(result == null) {
			return outVO;
		}
		outVO = JSON.parseObject(JSON.toJSONString(result), ChatRobotOutVO.class);
		outVO.setTime(DateUtil.getNowDateStr());
		return outVO;
	}
}
