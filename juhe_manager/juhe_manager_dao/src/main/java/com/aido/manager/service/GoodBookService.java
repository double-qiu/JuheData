/**  
 * Project Name:blogSearch  
 * File Name:BlogService.java  
 * Package Name:com.aido.service  
 * Date:2016年12月21日下午2:18:34  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service;


import java.util.List;

import com.aido.manager.domain.GoodBookEntity;
import com.aido.manager.domain.GoodBookTypeEntity;


/**  
 * ClassName: BlogService  
 * csdn博客查询业务接口
 * @author DOUBLE
 * @version   
 */
public interface GoodBookService {
	
	void save(GoodBookEntity goodBookEntity);
	
	void saveGoodBookTypeData(String url, String key,String dtype)  throws Exception ;
	
	List<GoodBookTypeEntity> getAllGoodBookTypeList();
	
	void saveGoodBookData(String url, String key,String catalog_id,String pn,String rn,String dtype) throws Exception;
	
	int getGoodBookPage(String url, String key,String catalog_id,String pn,String rn,String dtype) throws Exception;

	boolean checkGoodBook(String title);
}
