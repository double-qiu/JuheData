/**  
 * Project Name:juhe_portal  
 * File Name:GoodBookController.java  
 * Package Name:com.aido.portal.controller  
 * Date:2017年1月1日下午7:50:58  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.InvokeResult;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;
import com.aido.portal.dto.GoodBookSortOutVO;
import com.aido.portal.service.GoodBookService;

/**  
 * ClassName: GoodBookController  
 * 图书控制类
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/goodbook")
public class GoodBookController {

	private static Logger logger = LoggerFactory.getLogger(GoodBookController.class);
	
	@Autowired
	private GoodBookService goodBookSerivce;
	
	/**
	 *  goodBookTypeList:图书管理类型列表
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param query
	 *  @return
	 */
	@RequestMapping("/typeList")
	@ResponseBody
	public InvokeResult goodBookTypeList(){
		
		List<GoodBookSortOutVO>  outVOList = new ArrayList<GoodBookSortOutVO>();
		try {
			List<GoodBookSortEntity> sortList = goodBookSerivce.getAllGoodBookSortList();
			for (GoodBookSortEntity goodBookSortEntity : sortList) {
				GoodBookSortOutVO outVO = new GoodBookSortOutVO();
				outVO.setId(goodBookSortEntity.getId());
				outVO.setName(goodBookSortEntity.getName());
				List<GoodBookTypeEntity> typeList  = goodBookSerivce.getGoodBookTypeListBySort(String.valueOf(outVO.getId()));
				outVO.setTypeList(typeList);
				outVOList.add(outVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询历史的今天列表数据失败：" + e.getMessage(),e);
			return InvokeResult.failure(e.getMessage());
		}
		return InvokeResult.success(outVOList);
	}
	
}
