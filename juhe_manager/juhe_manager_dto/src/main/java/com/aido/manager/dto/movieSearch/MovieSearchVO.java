/**  
 * Project Name:juhe_manager_dto  
 * File Name:MovieSearch.java  
 * Package Name:com.aido.manager.dto.movieSearch  
 * Date:2017年1月10日上午11:09:39  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.dto.movieSearch;

import java.io.Serializable;
import java.util.List;

/**  
 * ClassName: MovieSearch  
 * 影视搜索
 * @author DOUBLE
 * @version   
 */
public class MovieSearchVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;//标题
	
	private String tag;//类型
	
	private String act;//演员
	
	private String year;//年份
	
	private String rating;//播放量
	
	private String area;//地区
	
	private String dir;//导演
	
	private String desc;//描述
	
	private String cover;//图片
	
	private String vdo_status;//播放状态
	
	private PlayLinks playlinks = new PlayLinks();//播放链接
	
	private String play;
	
	private  List<VideoSrc> video_rec;//相关影视链接
	
	private List<Acts> act_s;//演员列表

	
	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getVdo_status() {
		return vdo_status;
	}

	public void setVdo_status(String vdo_status) {
		this.vdo_status = vdo_status;
	}

	public PlayLinks getPlaylinks() {
		return playlinks;
	}

	public void setPlaylinks(PlayLinks playlinks) {
		this.playlinks = playlinks;
	}

	public List<VideoSrc> getVideo_rec() {
		return video_rec;
	}

	public void setVideo_rec(List<VideoSrc> video_rec) {
		this.video_rec = video_rec;
	}

	public List<Acts> getAct_s() {
		return act_s;
	}

	public void setAct_s(List<Acts> act_s) {
		this.act_s = act_s;
	}
}
