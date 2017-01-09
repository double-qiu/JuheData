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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.InvokeResult;
import com.aido.portal.domain.GoodBookEntity;
import com.aido.portal.domain.GoodBookOnLineEntity;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;
import com.aido.portal.dto.GoodBookOutVO;
import com.aido.portal.dto.GoodBookQueryVO;
import com.aido.portal.dto.GoodBookSortOutVO;
import com.aido.portal.service.GoodBookService;
import com.aido.portal.utils.Copy;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(value = "获取图书类型列表", notes = "获取图书类型列表")  
	@RequestMapping(value = { "/typeList" }, method = RequestMethod.GET)
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
	/**
	 *  goodBookList:分页图书
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param query
	 *  @return
	 */
	@ApiOperation(value = "获取图书分页列表", notes = "根据图书类型或者查询关键字获取分页图书列表")  
	@ApiImplicitParams({  @ApiImplicitParam(name = "query", value = "图书查询vo", required = true, dataType = "GoodBookQueryVO") }) 
	@RequestMapping(value = { "/bookList" }, method = RequestMethod.GET)
	@ResponseBody
	public InvokeResult goodBookList(GoodBookQueryVO query){
		List<GoodBookOutVO>  outVOList = new ArrayList<GoodBookOutVO>();
		List<GoodBookEntity> bookList = goodBookSerivce.getGoodBookPages(query.getCurrent(), query.getRowCount(), query.getCatalogId(),query.getSearch());
		for (GoodBookEntity goodBookEntity : bookList) {
			GoodBookOutVO outVO = new GoodBookOutVO();
			Copy.simpleCopyExcludeNull(goodBookEntity, outVO);
			outVOList.add(outVO);
		}
		return InvokeResult.success(outVOList);
	}
	/**
	 *  goodBookTotal:获取总页数
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param catalogId
	 *  @return
	 */
	@ApiOperation(value = "获取图书页数", notes = "根据图书类型或者查询关键字获取图书页数")  
	@ApiImplicitParams({  @ApiImplicitParam(name = "query", value = "图书查询vo", required = true, dataType = "GoodBookQueryVO") }) 
	@RequestMapping(value = { "/total" }, method = RequestMethod.GET)
	@ResponseBody
	public InvokeResult goodBookTotal(GoodBookQueryVO query){
		
		int total = goodBookSerivce.getGoodBookTotal(query.getCatalogId(),query.getSearch());
		int pages = total/9+1;
		return InvokeResult.success(pages);
	}
	/**
	 *  goodBookDetail:图书详细
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param id
	 *  @return
	 */
	@ApiOperation(value = "获取图书页数", notes = "根据图书类型或者查询关键字获取图书页数")  
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "图书id", required = true, dataType = "String") }) 
	@RequestMapping(value = { "/detail" }, method = RequestMethod.GET)
	@ResponseBody
	public InvokeResult goodBookDetail(String id){
		 GoodBookOutVO outVO = new GoodBookOutVO();
		 GoodBookEntity book = goodBookSerivce.getGoodBookById(Long.parseLong(id));
		 List<GoodBookOnLineEntity> onLines = goodBookSerivce.getGoodBookOnLineById(String.valueOf(book.getId()));
		 Copy.simpleCopyExcludeNull(book, outVO);
		 String content = outVO.getSub2();
		 if(content.length()>400) {
			 content = content.substring(0,400)+"...";
		 }
		 outVO.setSub2Short(content);
		 outVO.setOnlineList(onLines);
		 return InvokeResult.success(outVO);
	}
}
