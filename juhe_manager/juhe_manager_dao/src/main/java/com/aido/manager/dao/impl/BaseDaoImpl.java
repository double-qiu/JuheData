/**  
 * Project Name:blogSearch  
 * File Name:BlogDaoImpl.java  
 * Package Name:com.aido.dao.impl  
 * Date:2016年12月21日下午2:28:29  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dao.impl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDaoImpl")
public class BaseDaoImpl extends HibernateDaoSupport {

	@Autowired
	
	public JdbcTemplate jdbcTemplate;
	
	@Autowired  
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {  
        super.setSessionFactory(sessionFactory); 
    }  
}
  
