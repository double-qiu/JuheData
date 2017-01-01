/**  
 * Project Name:blogSearch  
 * File Name:BlogDaoImpl.java  
 * Package Name:com.aido.dao.impl  
 * Date:2016年12月21日下午2:28:29  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dao.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aido.portal.dao.BaseDao;
import com.aido.portal.dao.GoodBookDao;
import com.aido.portal.domain.GoodBookEntity;


/**  
 * ClassName: BlogDaoImpl  
 * 数据库操作
 * @author DOUBLE
 * @version   
 */
@Repository("goodBookDaoImpl")
public class GoodBookDaoImpl  extends BaseDaoImpl implements GoodBookDao {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;

	@SuppressWarnings("unchecked")
	@Override
	public void save(GoodBookEntity goodBookEntity) {
		baseDao.save(goodBookEntity);
	}
}
