/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:HistoryTodayServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2016年12月24日下午1:28:39  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aido.common.jpa.BaseDao;
import com.aido.common.jpa.BaseDaoImpl;
import com.aido.portal.domain.GoodBookTypeEntity;
import com.aido.portal.service.GoodBookPortalService;


/**  
 * ClassName: HistoryTodayServiceImpl  
 * 图书商城接口业务实现
 * @author DOUBLE
 * @version   
 */
@Service("goodBookPortalService")
public class GoodBookPortalServiceImpl  extends BaseDaoImpl  implements GoodBookPortalService {

	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GoodBookTypeEntity> getGoodBookTypeListPortal() {
		return baseDao.findListbySql("select * from q_goodbook_type", GoodBookTypeEntity.class);
	}

}
