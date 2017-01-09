/**  
 * Project Name:blogSearch  
 * File Name:BlogDao.java  
 * Package Name:com.aido.dao  
 * Date:2016年12月21日下午2:27:39  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dao;


import java.util.List;

import com.aido.portal.domain.GoodBookEntity;
import com.aido.portal.domain.GoodBookOnLineEntity;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;


/**  
 * ClassName: BlogDao  
 * 后台数据查询
 * @author DOUBLE
 * @version   
 */
public interface GoodBookDao {
	
	void save(GoodBookEntity goodBookEntity);

	/**  
	 *  getGoodBookPage:(这里用一句话描述这个方法的作用). 
	 *  @return_type:List<GoodBookEntity>
	 *  @author DOUBLE
	 *  @param current
	 *  @param rowCount
	 *  @param catalogId
	 *  @return  
	 */
	List<GoodBookEntity> getGoodBookPage(int current, int rowCount, String catalogId,String search);

	/**  
	 *  checkGoodBook:检验是否有已经在库中的图书
	 *  @return_type:void
	 *  @author DOUBLE
	 *  @param title  
	 */
	boolean checkGoodBook(String title);

	/**  
	 *  getAllGoodBookSortList:查询所有图书大类
	 *  @return_type:List<GoodBookSortEntity>
	 *  @author DOUBLE
	 *  @return  
	 */
	List<GoodBookSortEntity> getAllGoodBookSortList();

	/**  
	 *  getGoodBookTypeListBySort:查询图书大类下的图书类型
	 *  @return_type:List<GoodBookTypeEntity>
	 *  @author DOUBLE
	 *  @param sortId
	 *  @return  
	 */
	List<GoodBookTypeEntity> getGoodBookTypeListBySort(String sortId);

	/**  
	 *  getAllGoodBookTypeList:查询所有图书类型
	 *  @return_type:List<GoodBookTypeEntity>
	 *  @author DOUBLE
	 *  @return  
	 */
	List<GoodBookTypeEntity> getAllGoodBookTypeList();

	/**  
	 *  getGoodBookOnLineById:查询图书下的购买路径
	 *  @return_type:List<GoodBookOnLineEntity>
	 *  @author DOUBLE
	 *  @param goodBookId
	 *  @return  
	 */
	List<GoodBookOnLineEntity> getGoodBookOnLineById(String book);

	/**  
	 *  getGoodBookTotalByCatalogId:等到总条数
	 *  @return_type:int
	 *  @author DOUBLE
	 *  @param catalogId
	 *  @return  
	 */
	int getGoodBookTotal(String catalogId,String search);

	/**  
	 *  getGoodBookById:获取详细信息
	 *  @return_type:GoodBookEntity
	 *  @author DOUBLE
	 *  @param id
	 *  @return  
	 */
	GoodBookEntity getGoodBookById(long id);
}
