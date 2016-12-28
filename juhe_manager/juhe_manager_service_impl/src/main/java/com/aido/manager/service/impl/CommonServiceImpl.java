/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:CommonServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2016年12月27日下午2:05:43  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aido.manager.dto.historyToday.SingleVO;
import com.aido.manager.service.CommonService;

/**  
 * ClassName: CommonServiceImpl  
 * 公共服务类实现接口
 * @author DOUBLE
 * @version   
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

	/**
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public List<SingleVO> getMonthList() {
		List<SingleVO>  monthList = new ArrayList<SingleVO>();
		for (int i = 0; i < 12; i++) {
			SingleVO singleVO = new SingleVO();
			singleVO.setName((i+1)+"月");
			singleVO.setValue(String.valueOf(i+1));
			monthList.add(singleVO);
		}
		return monthList;
	}

	/**  
	 * @param month
	 * @return
	 * Administrator
	 */
	@Override
	public List<SingleVO> getDayList() {
		List<SingleVO>  dayList = new ArrayList<SingleVO>();
		for (int i = 0; i < 31; i++) {
			SingleVO singleVO = new SingleVO();
			singleVO.setName((i+1)+"日");
			singleVO.setValue(String.valueOf(i+1));
			dayList.add(singleVO);
		}
		return dayList;
	}
}
