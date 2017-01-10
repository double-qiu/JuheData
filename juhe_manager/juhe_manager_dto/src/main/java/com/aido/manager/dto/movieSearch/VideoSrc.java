/**  
 * Project Name:juhe_manager_dto  
 * File Name:VideoSrc.java  
 * Package Name:com.aido.manager.dto.movieSearch  
 * Date:2017年1月10日上午11:16:54  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.movieSearch;

import java.io.Serializable;

/**  
 * ClassName: VideoSrc  
 * 相关影视剧播放链接
 * @author DOUBLE
 * @version   
 */
public class VideoSrc implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cover;//图片
	
	private String detail_url;//地址
	
	private String title;//标题

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDetail_url() {
		return detail_url;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
