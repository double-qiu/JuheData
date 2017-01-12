/**  
 * Project Name:juhe_manager_jpa
 * File Name:DrivingTestDaoImpl.java  
 * Package Name:com.aido.manager.jpa.dao.impl
 * Date:2017年1月11日上午10:42:29  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aido.manager.dto.drivingTest.DrivingTestOutVO;
import com.aido.manager.jpa.constant.AnswerStatus;
import com.aido.manager.jpa.dao.BaseDao;
import com.aido.manager.jpa.dao.DrivingTestDao;
import com.aido.manager.jpa.domain.DrivingTestEntity;
import com.aido.manager.jpa.utils.Copy;

/**  
 * ClassName: DrivingTestDaoImpl  
 * 驾考题库数据后台服务接口实现
 * @author DOUBLE
 * @version   
 */
@Repository("drivingTestDaoImpl")
public class DrivingTestDaoImpl extends BaseDaoImpl implements DrivingTestDao {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	/**  
	 * @param drivingTestEntity
	 * @author DOUBLE
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save(DrivingTestEntity drivingTestEntity) {
		baseDao.save(drivingTestEntity);
	}
	/**  
	 * @param current
	 * @param rowCount
	 * @param subject
	 * @param model
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DrivingTestOutVO> getDrivingTestPage(int current, int rowCount, String subject, String model)
			throws Exception {
		StringBuffer sql = new StringBuffer();
		int index = (current-1)*rowCount;
		sql.append("select *  from q_driving_test a  where 1 = 1");
		sql.append(" and a.subject = '"+subject+"'");
		if(!"4".equals(subject)) {
			sql.append(" and a.model = '"+model+"'");
		}
		sql.append("  order by CONVERT(a.id,SIGNED) ");
		sql.append("  limit "+index+","+rowCount);
		List<DrivingTestEntity> entityList =  baseDao.findListbySql(sql.toString(), DrivingTestEntity.class);
		List<DrivingTestOutVO> outList = new  ArrayList<DrivingTestOutVO>();
		for (DrivingTestEntity drivingTestEntity : entityList) {
			DrivingTestOutVO outVO = new DrivingTestOutVO();
			Copy.simpleCopyExcludeNull(drivingTestEntity, outVO);
			String answerUS = AnswerStatus.getValue(drivingTestEntity.getAnswer());
			outVO.setAnswerUS(answerUS);
			outList.add(outVO);
		}
		return outList;
	}
	/**  
	 * @param subject
	 * @param model
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@Override
	public int getDrivingTestTotal(String subject, String model) throws Exception {
		int gdNum = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("select COUNT(a.tid)  from q_driving_test a  where 1 = 1  ");
		sql.append(" and a.subject = ? ");
		Object[] obj = null;
		if(!"4".equals(subject)) {
			sql.append(" and a.model = ? ");
			 obj = new Object[] {  String.valueOf(subject),  String.valueOf(model)};
		}else {
			 obj =new Object[] {   String.valueOf(subject)};
		}
		gdNum = jdbcTemplate.queryForObject(sql.toString(),obj,Integer.class);
		return gdNum;
	}
}
