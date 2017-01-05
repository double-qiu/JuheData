/**  
 * Project Name:blogSearch  
 * File Name:BlogService.java  
 * Package Name:com.aido.service  
 * Date:2016年12月21日下午2:18:34  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.service;


import java.util.List;

import com.aido.portal.domain.GoodBookEntity;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;


/**  
 * ClassName: BlogService  
 * csdn博客查询业务接口
 * @author DOUBLE
 * @version   
 */
public interface GoodBookService {
	/**
	 *  save:保存图书
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param goodBookEntity
	 */
	void save(GoodBookEntity goodBookEntity);
	
	/**
	 *  saveGoodBookTypeData:保存图书所以数据
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param url
	 *  @param key
	 *  @param dtype
	 *  @throws Exception
	 */
	void saveGoodBookTypeData(String url, String key,String dtype)  throws Exception ;
	
	/**
	 *  getAllGoodBookTypeList:活动图书类型
	 *  @return_type:List<GoodBookTypeEntity>
	 *  @author DOUBLE
	 *  @return
	 */
	List<GoodBookTypeEntity> getAllGoodBookTypeList();
	
	/**
	 *  getGoodBookTypeListBySort:通过读书大类活动图书类型
	 *  @return_type:List<GoodBookTypeEntity>
	 *  @author DOUBLE
	 *  @param sortId
	 *  @return
	 */
	List<GoodBookTypeEntity> getGoodBookTypeListBySort(String sortId);
	
	/**
	 *  saveGoodBookData:调用接口获取图书分类数据
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param url
	 *  @param key
	 *  @param catalog_id
	 *  @param pn
	 *  @param rn
	 *  @param dtype
	 *  @throws Exception
	 */
	void saveGoodBookData(String url, String key,String catalog_id,String pn,String rn,String dtype) throws Exception;
	
	/**
	 *  getGoodBookPage:调用接口或者图书数据
	 *  @return_type:int
	 *  @author DOUBLE
	 *  @param url
	 *  @param key
	 *  @param catalog_id
	 *  @param pn
	 *  @param rn
	 *  @param dtype
	 *  @return
	 *  @throws Exception
	 */
	int getGoodBookPage(String url, String key,String catalog_id,String pn,String rn,String dtype) throws Exception;

	/**
	 *  checkGoodBook:检查接口数据
	 *  @return_type:boolean
	 *  @author DOUBLE
	 *  @param title
	 *  @return
	 */
	boolean checkGoodBook(String title);

	/**  
	 *  getAllGoodBookSortList:获取所以读书大类
	 *  @return_type:List<GoodBookSortEntity>
	 *  @author DOUBLE
	 *  @return  
	 */
	List<GoodBookSortEntity> getAllGoodBookSortList();
}
