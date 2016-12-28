/**  
 * Project Name:juhe_manager_service  
 * File Name:CommonService.java  
 * Package Name:com.aido.manager.service  
 * Date:2016年12月24日下午12:22:47  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;

import java.util.List;

import com.aido.manager.dto.historyToday.SingleVO;

/**  
 * ClassName: CommonService  
 * 公共service
 * @author DOUBLE
 * @version   
 */
public interface CommonService {

	/**
	 *  getMonthList:获取所以月份
	 *  @return_type:List<SingleVO>
	 *  @author DOUBLE
	 *  @return
	 */
	List<SingleVO> getMonthList();

	/**  
	 *  getDayList:获取月份的天数
	 *  @return_type:List<SingleVO>
	 *  @author DOUBLE
	 *  @param month
	 *  @return  
	 */
	List<SingleVO> getDayList();

	
}
