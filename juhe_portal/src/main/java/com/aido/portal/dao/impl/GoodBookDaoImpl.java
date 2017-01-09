/**  
 * Project Name:juhe_portal
 * File Name:BlogDaoImpl.java  
 * Package Name:com.aido.portal.dao.impl
 * Date:2016年12月30日下午2:28:29  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.dao.impl;




import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aido.portal.dao.BaseDao;
import com.aido.portal.dao.GoodBookDao;
import com.aido.portal.domain.GoodBookEntity;
import com.aido.portal.domain.GoodBookOnLineEntity;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;


/**  
 * ClassName: GoodBookDaoImpl  
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

	/**  
	 * @param current
	 * @param rowCount
	 * @param catalogId
	 * @return
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodBookEntity> getGoodBookPage(int current, int rowCount, String catalogId,String search) {
		StringBuffer sql = new StringBuffer();
		int index = (current-1)*rowCount;
		sql.append("select *  from q_goodbook a  where 1 = 1");
		if(!"null".equals(catalogId)&&StringUtils.isNotBlank(catalogId)){
			sql.append(" and a.catalog_id = '"+catalogId+"'");
		}else if(StringUtils.isNotBlank(search)){
			sql.append("  and MATCH (a.title,a.catalog,a.tags,a.sub1,a.sub2) AGAINST ('"+search+"')");
		}
		sql.append("  order by CONVERT(reading,SIGNED)   desc ");
		sql.append("  limit "+index+","+rowCount);
		return baseDao.findListbySql(sql.toString(), GoodBookEntity.class);
	}

	/**  
	 * @param title
	 * Administrator
	 */
	@Override
	public boolean checkGoodBook(String title) {
		StringBuffer sql = new StringBuffer();
		sql.append("select COUNT(gb.id)  from q_goodbook gb where 1 = 1  ");
		sql.append(" and gb.title = ?");
		int gdNum = jdbcTemplate.queryForObject(sql.toString(),new Object[] { String.valueOf(title) },Integer.class);
		return gdNum == 0 ? Boolean.TRUE:Boolean.FALSE;
		
	}

	/**  
	 * @return
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodBookSortEntity> getAllGoodBookSortList() {
		return baseDao.findListbySql("select * from q_goodbook_sort", GoodBookSortEntity.class);
	}

	/**  
	 * @param sortId
	 * @return
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodBookTypeEntity> getGoodBookTypeListBySort(String sortId) {
		return baseDao.findListbySql("select * from q_goodbook_type where sort =  '"+sortId+"'", GoodBookTypeEntity.class);
	}

	/**  
	 * @return
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodBookTypeEntity> getAllGoodBookTypeList() {
		return baseDao.findListbySql("select * from q_goodbook_type", GoodBookTypeEntity.class);
	}

	/**  
	 * @param goodBookId
	 * @return
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodBookOnLineEntity> getGoodBookOnLineById(String book) {
		return baseDao.findListbySql("select * from q_goodbook_online where book = '"+book+"'", GoodBookOnLineEntity.class);
	}

	/**  
	 * @param catalogId
	 * @return
	 * Administrator
	 */
	@Override
	public int getGoodBookTotal(String catalogId,String search) {
		StringBuffer sql = new StringBuffer();
		sql.append("select COUNT(gb.id)  from q_goodbook gb where 1 = 1  ");
		int gdNum = 0;
		if(StringUtils.isNotBlank(catalogId)) {
			sql.append(" and gb.catalog_id = ?");
			Object[] obj =new Object[] { String.valueOf(catalogId) };
			gdNum = jdbcTemplate.queryForObject(sql.toString(),obj,Integer.class);
		} else if(StringUtils.isNotBlank(search)) {
			sql.append(" and MATCH (gb.title,gb.catalog,gb.tags,gb.sub1,gb.sub2) AGAINST  ('"+search+"')");
			gdNum = jdbcTemplate.queryForObject(sql.toString(),Integer.class);
		}
		else {
			 gdNum = jdbcTemplate.queryForObject(sql.toString(),Integer.class);
		}
		return gdNum;
	}

	/**  
	 * @param id
	 * @return
	 * Administrator
	 */
	@Override
	public GoodBookEntity getGoodBookById(long id) {
		return (GoodBookEntity) baseDao.getEntity(GoodBookEntity.class, id);
	}
}
