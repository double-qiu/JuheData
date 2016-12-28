package com.aido.manager.dto.wechat;

import java.io.Serializable;
import java.util.List;

public class WeChatSelectdPageVO  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int totalPage;
	private List<WeChatSelectdVO> list;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<WeChatSelectdVO> getList() {
		return list;
	}
	public void setList(List<WeChatSelectdVO> list) {
		this.list = list;
	}
}
