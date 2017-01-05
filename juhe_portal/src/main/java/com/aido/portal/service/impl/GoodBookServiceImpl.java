/**  
 * Project Name:blogSearch  
 * File Name:BlogServiceImpl.java  
 * Package Name:com.aido.service.impl  
 * Date:2016年12月21日下午2:22:28  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aido.common.httpclient.HttpClientComponent;
import com.aido.portal.dao.BaseDao;
import com.aido.portal.dao.GoodBookDao;
import com.aido.portal.domain.GoodBookEntity;
import com.aido.portal.domain.GoodBookOnLineEntity;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;
import com.aido.portal.dto.GoodBookOutVO;
import com.aido.portal.dto.GoodBookTypeOutVO;
import com.aido.portal.service.GoodBookService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**  
 * ClassName: GoodBookServiceImpl  
 * 图书业务接口
 * @author DOUBLE
 * @version   
 */

@Service("goodBookService")
public class GoodBookServiceImpl  implements  GoodBookService {

	@Autowired
	private GoodBookDao goodBookDao;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private BaseDao baseDao;

	@Override
	public void save(GoodBookEntity goodBook) {
		goodBookDao.save(goodBook);
	}

	/**  
	 * @param url
	 * @param key
	 * @param dtype
	 * Administrator
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void saveGoodBookTypeData(String url, String key, String dtype) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("dtype",dtype);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		List<Object> result = HttpClientComponent.getResultListByGet(url, params, headers, retryTime);
		for (Object object : result) {
			String str = object.toString();
			GoodBookTypeOutVO outVO = JSON.parseObject(str, GoodBookTypeOutVO.class);
			GoodBookTypeEntity goodBookTypeEntity = new GoodBookTypeEntity();
			goodBookTypeEntity.setTypeId(outVO.getId());
			goodBookTypeEntity.setCatalog(outVO.getCatalog());
			baseDao.save(goodBookTypeEntity);
		}
	}

	/**  
	 * @return
	 * Administrator
	 */
	@Override
	public List<GoodBookTypeEntity> getAllGoodBookTypeList() {
		return goodBookDao.getAllGoodBookTypeList();
	}

	/**  
	 * @param url
	 * @param key
	 * @param catalog_id
	 * @param pn
	 * @param rn
	 * @param dtype
	 * Administrator
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void saveGoodBookData(String url, String key, String catalog_id, String pn, String rn, String dtype) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("dtype",dtype);
		params.put("catalog_id",catalog_id);
		params.put("pn",pn);
		params.put("rn",rn);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		Map<String, Object> result = HttpClientComponent.getResultMapByGet(url, params, headers, retryTime);
		JSONArray jsonArr =  (JSONArray) result.get("data");
		String jsonStr = JSONObject.toJSONString(jsonArr);
		List<GoodBookOutVO> goodBookOutVOList = JSONObject.parseArray(jsonStr, GoodBookOutVO.class);  
		for (GoodBookOutVO goodBookOutVO : goodBookOutVOList) {
			GoodBookEntity goodBookEntity = new GoodBookEntity();
			try {
				boolean falg = checkGoodBook(goodBookOutVO.getTitle());
				if(falg) {
					String onlines = goodBookOutVO.getOnline();
					List<GoodBookOnLineEntity> onLines  = getOnLines(onlines);
					goodBookEntity.setOnLines(onLines);
					goodBookEntity.setTitle(goodBookOutVO.getTitle());
					goodBookEntity.setCatalog_id(catalog_id);
					goodBookEntity.setCatalog(goodBookOutVO.getCatalog());
					goodBookEntity.setTags(goodBookOutVO.getTags());
					goodBookEntity.setSub1(goodBookOutVO.getSub1());
					goodBookEntity.setSub2(goodBookOutVO.getSub2());
					goodBookEntity.setImg(goodBookOutVO.getImg());
					goodBookEntity.setReading(goodBookOutVO.getReading());
					goodBookEntity.setBytime(goodBookOutVO.getBytime());
					baseDao.save(goodBookEntity);
				}
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	/**  
	 *  getOnLines:(这里用一句话描述这个方法的作用). 
	 *  @return_type:List<GoodBookOnLineEntity>
	 *  @author DOUBLE
	 *  @param onlines
	 *  @return  
	 */
	private  List<GoodBookOnLineEntity> getOnLines(String onlines) {
		List<GoodBookOnLineEntity> onLines = new ArrayList<GoodBookOnLineEntity>();
		String[] onlinesArray = onlines.split(" ");
		for (int i = 0; i < onlinesArray.length; i++) {
			GoodBookOnLineEntity onLine = new GoodBookOnLineEntity();
			String onLineStr = onlinesArray[i];
			String[] mallStr = onLineStr.split(":");
			onLine.setMallName(mallStr[0]);
			onLine.setMallUrl(mallStr[1]+":"+mallStr[2]);
			onLines.add(onLine);
		}
		return onLines;
	}

	/**  
	 * @param url
	 * @param key
	 * @param catalog_id
	 * @param pn
	 * @param rn
	 * @param dtype
	 * @return
	 * @throws Exception
	 * Administrator
	 */
	@Override
	public int getGoodBookPage(String url, String key, String catalog_id, String pn, String rn, String dtype)
			throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("dtype",dtype);
		params.put("catalog_id",catalog_id);
		params.put("pn",pn);
		params.put("rn",rn);
		params.put("key",key);
		Map<String, String> headers = new HashMap<String, String>();
		int retryTime = 0;
		Map<String, Object> result = HttpClientComponent.getResultMapByGet(url, params, headers, retryTime);
		String totalNum =  (String) result.get("totalNum");
		return Integer.parseInt(totalNum);
	}

	/**  
	 * @param title
	 * @return
	 * Administrator
	 */
	@Override
	public boolean checkGoodBook(String title) {
		return goodBookDao.checkGoodBook(title);
	}

	/**  
	 * @return
	 * Administrator
	 */
	@Override
	public List<GoodBookSortEntity> getAllGoodBookSortList() {
		return goodBookDao.getAllGoodBookSortList();
	}

	/**  
	 * @param sortId
	 * @return
	 * Administrator
	 */
	@Override
	public List<GoodBookTypeEntity> getGoodBookTypeListBySort(String sortId) {
		return goodBookDao.getGoodBookTypeListBySort(sortId);
	}

	/**  
	 * @param current
	 * @param rowCount
	 * @param catalogId
	 * @return
	 * Administrator
	 */
	@Override
	public List<GoodBookEntity> getGoodBookPages(int current, int rowCount, String catalogId) {
		return goodBookDao.getGoodBookPage(current, rowCount, catalogId);
	}

	/**  
	 * @param goodBookId
	 * @return
	 * Administrator
	 */
	@Override
	public List<GoodBookOnLineEntity> getGoodBookOnLineById(String book) {
		return goodBookDao.getGoodBookOnLineById(book);
	}

	/**  
	 * @param catalogId
	 * @return
	 * Administrator
	 */
	@Override
	public int getGoodBookTotal(String catalogId) {
		return goodBookDao.getGoodBookTotal(catalogId);
	}
}
