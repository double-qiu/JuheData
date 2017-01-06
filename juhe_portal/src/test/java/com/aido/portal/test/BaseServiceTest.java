
/**  
 * Project Name:blogSearch  
 * File Name:BlogServiceTest.java  
 * Package Name:BlogService  
 * Date:2016年12月21日下午3:02:09  
 * Copyright (c) 2016, LoveBeanTec All Rights Reserved.  
 */
package com.aido.portal.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aido.portal.domain.GoodBookEntity;
import com.aido.portal.domain.GoodBookOnLineEntity;
import com.aido.portal.domain.GoodBookSortEntity;
import com.aido.portal.domain.GoodBookTypeEntity;
import com.aido.portal.service.GoodBookService;



/**  
 * ClassName: BlogServiceTest  
 * 业务单元测试
 * @author DOUBLE
 * @version   
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath*:spring.xml")
public class BaseServiceTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private GoodBookService goodBookService;
	
	
	 //@Test
	 public void getGoodBookSaveTest() {
		 GoodBookEntity goodBookEntity = new GoodBookEntity();
		 goodBookEntity.setTitle("梦里花落知多少");
		 goodBookEntity.setCatalog("中国文学 散文");
		 goodBookEntity.setTags("中国文学经典 好书 好书推荐 爱情 经典散文推荐 ");
		 goodBookEntity.setSub1("三毛散文集：《梦里花落知多少》");
		 
		 goodBookService.save(goodBookEntity);
		System.out.println("ddd");
	 }
	 @Test
	 public void saveGoodBookTypeDataTest() throws Exception {
		 String url = "http://apis.juhe.cn/goodbook/catalog";
		 String key = "c830c2bddea44b8812d6e1221fd58459";
		 String dtype = "json";
		 goodBookService.saveGoodBookTypeData(url, key, dtype);
	 }
	 @Test
	 public void findAllGoodBookTypeTest() throws Exception {
		List<GoodBookTypeEntity> goodBookTypeList  =  goodBookService.getAllGoodBookTypeList();
		System.out.println("goodbooktype size  is "+goodBookTypeList.size());
	 }
	 
	 @Test
	 public void findAllGoodBookSortTest() throws Exception {
		List<GoodBookSortEntity> goodBookTypeList  =  goodBookService.getAllGoodBookSortList();
		System.out.println("goodbooktype size  is "+goodBookTypeList.size());
	 }
	 @Test
	 public void findGoodBookTypeSortTest() throws Exception {
		List<GoodBookTypeEntity> goodBookTypeList  =  goodBookService.getGoodBookTypeListBySort("1");
		System.out.println("goodbooktype size  is "+goodBookTypeList.size());
	 }
	 @Test
	 public void saveGoodBookDataTest() throws Exception {
		 String url = "http://apis.juhe.cn/goodbook/query";
		 String pn = "1";
		 String rn = "20";
		 String key = "c830c2bddea44b8812d6e1221fd58459";
		 String dtype = "json";
		 List<GoodBookTypeEntity> goodBookTypeList  =  goodBookService.getAllGoodBookTypeList();
		 for (GoodBookTypeEntity goodBookTypeEntity : goodBookTypeList) {
			 String catalog_id = goodBookTypeEntity.getTypeId();
			 int totalNum = goodBookService.getGoodBookPage(url, key, catalog_id, pn, rn, dtype);
			 for (int i = 1; i < totalNum; i++) {
				 goodBookService.saveGoodBookData(url, key, catalog_id, String.valueOf(i), rn, dtype);
			}
		}
	 }
	 @Test
	 public void saveGoodBookPageTest() throws Exception {
		 String url = "http://apis.juhe.cn/goodbook/query";
		 String catalog_id = "242";
		 String pn = "1";
		 String rn = "20";
		 String key = "c830c2bddea44b8812d6e1221fd58459";
		 String dtype = "json";
		 int totalNum = goodBookService.getGoodBookPage(url, key, catalog_id, pn, rn, dtype);
		 System.out.println("goodbook size  is "+totalNum);
	 }
	 @Test
	 public void checkGoodBookTest() throws Exception {
		System.out.println(goodBookService.checkGoodBook("檀香刑"));
	 }
	 
	 @Test
	 public void getGoodBookPageTest() throws Exception {
		List<GoodBookEntity> pageList = goodBookService.getGoodBookPages(1, 9, "");
		System.out.println(pageList);
	 }
	 
	 @Test
	 public void getGoodBookOnlineTest() throws Exception {
		List<GoodBookOnLineEntity> pageList = goodBookService.getGoodBookOnLineById("3679");
		System.out.println(pageList);
	 }
	 
	 @Test
	 public void getGoodBookTotalTest() throws Exception {
		int total = goodBookService.getGoodBookTotal("242");
		System.out.println(total);
	 }
	 @Test
	 public void getGoodBookByIdTest() throws Exception {
		GoodBookEntity book = goodBookService.getGoodBookById(3680L);
		System.out.println(book.getTitle());
	 }
}
