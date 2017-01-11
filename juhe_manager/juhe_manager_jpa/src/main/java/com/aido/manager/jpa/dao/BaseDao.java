/**  
 * Project Name:blogSearch  
 * File Name:BaseDao.java  
 * Package Name:com.aido.dao  
 * Date:2016年12月21日下午2:27:39  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.dao;

import java.io.Serializable;
//import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("baseDao")
@Transactional 
public class BaseDao<T, ID extends Serializable> {

	public static final String ORACLE_SQL = "select * from (select row_.*,rownum rownum_ from ({0}) row_ where rownum <= {1}) where rownum_>{2}"; //oracle

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger
			.getLogger(BaseDao.class);
	/**
	 *  getSession:(获取session). 
	 *  @return_type:Session
	 *  @author Administrator  
	 *  @return
	 */
    public Session getSession() {
        //需要开启事物，才能得到CurrentSession
        return sessionFactory.getCurrentSession();
    }
     
    
    /**
     * 
     *  getSessionFactory:(获取sessionFactory). 
     *  @return_type:SessionFactory
     *  @author Administrator  
     *  @return
     */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * 
	 *  setSessionFactory:(设置sessionFactory). 
	 *  @return_type:void
	 *  @author Administrator  
	 *  @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 
	 *  getEntity:(获取实体). 
	 *  @return_type:T
	 *  @author Administrator  
	 *  @param entityName
	 *  @param id
	 *  @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "hiding" })
	public <T> T getEntity(Class entityName, Serializable id) {
		T t = (T) getSession().get(entityName, id);
		if (t != null) {
			getSession().flush();
		}
		return t;
	}
	/**
	 * 
	 *  deleteEntityById:(根据主键删除指定的实体). 
	 *  @return_type:void
	 *  @author DOUBLE  
	 *  @param entityName
	 *  @param id
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
	public <T> void deleteEntityById(Class entityName, Serializable id) {
		del(get(entityName, id));
		getSession().flush();
	}
	/**
	 * 
	 *  get:(根据Id获取对象). 
	 *  @return_type:T
	 *  @author DOUBLE  
	 *  @param entityClass
	 *  @param id
	 *  @return
	 */
	@SuppressWarnings({"unchecked", "hiding" })
	public <T> T get(Class<T> entityClass, final Serializable id) {
		return (T) getSession().get(entityClass, id);
	}
	
	/**
	 * 
	 *  del:(根据传入的实体删除对象). 
	 *  @return_type:void
	 *  @author DOUBLE  
	 *  @param entity
	 */
	@SuppressWarnings({"hiding" })
	public <T> void del(T entity) {
		try {
			getSession().delete(entity);
			getSession().flush();
			if (logger.isDebugEnabled()) {
				logger.debug("删除成功," + entity.getClass().getName());
			}
		} catch (RuntimeException e) {
			logger.error("删除异常", e);
			throw e;
		}
	}
	
	 /**
	  *  saveOrUpdate:(保存或者更新实体). 
	  *  @return_type:void
	  *  @author DOUBLE  
	  *  @param t
	  */
    @SuppressWarnings("hiding")
	public <T> void saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
    }
	
    /**
     * 
     *  save:(完整保存实体). 
     *  @return_type:void
     *  @author Administrator  
     *  @param entity
     */
	@SuppressWarnings("hiding")
	public <T> void save(T entity) {
    	 this.getSession().save(entity);
	}
	 /**
	  *  findListbySql:(通过sql查询语句查找对象). 
	  *  @return_type:List<T>
	  *  @author Administrator  
	  *  @param sql
	  *  @param entityName
	  *  @return
	  */
		@SuppressWarnings({ "hiding", "rawtypes", "unchecked" })
		public <T> List<T> findListbySql(final String sql,Class entityName) {
			Query querys = getSession().createSQLQuery(sql).addEntity(entityName);
			return querys.list();
		}
		 /**
		  *  deleteAll:( 删除所有). 
		  *  @return_type:void
		  *  @author Administrator  
		  *  @param entities
		  */
	    public void deleteAll(Collection<T> entities) {
	        for(Object entity : entities) {
	            this.getSession().delete(entity);
	        }
	    }
	    /**
	     *  queryHql:(执行Hql语句). 
	     *  @return_type:void
	     *  @author Administrator  
	     *  @param hqlString
	     *  @param values
	     */
	    public void queryHql(String hqlString, Object... values) {
	    	Query query = this.getSession().createQuery(hqlString);
	    	if (values != null) {
	    		for (int i = 0; i < values.length; i++) {
	    			query.setParameter(i, values[i]);
	    		}
	    	}
	    	query.executeUpdate();
	    }
	    
	/**
	 *  querySql:(执行Sql语句). 
	 *  @return_type:void
	 *  @author Administrator  
	 *  @param sqlString
	 *  @param values
	 */
	public void querySql(String sqlString, Object... values) {
		Query query = this.getSession().createSQLQuery(sqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}
	/**
	 *  getByHQL:(根据HQL语句查找唯一实体). 
	 *  @return_type:T
	 *  @author Administrator  
	 *  @param hqlString
	 *  @param values
	 *  @return
	 */
	@SuppressWarnings("unchecked")
	public T getByHQL(String hqlString, Object... values) {
		Query query = this.getSession().createQuery(hqlString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return (T) query.uniqueResult();
	}
	/**
	 *  getBySQL:(根据SQL语句查找唯一实体). 
	 *  @return_type:T
	 *  @author Administrator  
	 *  @param sqlString
	 *  @param values
	 *  @return
	 */
	@SuppressWarnings("unchecked")
	public T getBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        if (values != null)
        {
            for (int i = 0; i < values.length; i++)
            {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }
	/**
	 * 
	 *  getListByHQL:(根据HQL语句，得到对应的list). 
	 *  @return_type:List<T>
	 *  @author Administrator  
	 *  @param hqlString
	 *  @param values
	 *  @return
	 */
	   @SuppressWarnings("unchecked")
		public List<T> getListByHQL(String hqlString, Object... values) {
		        Query query = this.getSession().createQuery(hqlString);
		        if (values != null)
		        {
		            for (int i = 0; i < values.length; i++)
		            {
		                query.setParameter(i, values[i]);
		            }
		        }
		        return query.list();
		    }
	  /**
	   *  getListBySQL:(根据SQL语句，得到对应的list). 
	   *  @return_type:List<T>
	   *  @author Administrator  
	   *  @param sqlString
	   *  @param values
	   *  @return
	   */
	  @SuppressWarnings("unchecked")
	  public List<T> getListBySQL(String sqlString, Object... values ) {
	        Query query = this.getSession().createSQLQuery(sqlString);
	        if (values != null)
	        {
	            for (int i = 0; i < values.length; i++)
	            {
	                query.setParameter(i, values[i]);
	            }
	        }
	        return query.list();
	    }
	  /**
	   *  refresh:(刷新). 
	   *  @return_type:void
	   *  @author Administrator  
	   *  @param t
	   */
	  public void refresh(T t) {
	        this.getSession().refresh(t);
	    }
	  /**
	   *  update:(更新实体). 
	   *  @return_type:void
	   *  @author Administrator  
	   *  @param t
	   */
	  @SuppressWarnings("hiding")
	public <T> void update(T t) {
	        this.getSession().update(t);
	    }
	  
		/**
		 * 
		 *  CreatePageSql:(封装分页查询sql). 
		 *  @return_type:String
		 *  @author Administrator  
		 *  @param sql
		 *  @param page
		 *  @param rows
		 *  @return
		 */
//		public static String CreatePageSql(String sql, int page){
//			String[] sqlParam = new String[3];
//			sqlParam[0] = sql;
//			int beginIndex = (page)*10;
//			int endIndex = beginIndex+10;
//			sqlParam[2] = Integer.toString(beginIndex);
//			sqlParam[1] = Integer.toString(endIndex);
//			String	PageSql = MessageFormat.format(ORACLE_SQL, sqlParam);
//			return PageSql;
//		}
}
