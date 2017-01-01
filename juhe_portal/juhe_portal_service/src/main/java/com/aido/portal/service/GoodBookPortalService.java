/**  
 * Project Name:juhe_portal_service  
 * File Name:GoodBookService.java  
 * Package Name:com.aido.portal.service  
 * Date:2017年1月1日17:30:51
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.service;

import java.util.List;

import com.aido.portal.domain.GoodBookTypeEntity;

/**  
 * ClassName: GoodBookService  
 * 聚合数据：图书商城
 * @author DOUBLE
 * @version   
 */
public interface GoodBookPortalService {
	
	List<GoodBookTypeEntity> getGoodBookTypeListPortal();
	

}
