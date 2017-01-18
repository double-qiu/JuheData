/**  
 * Project Name:juhe_manager_dto  
 * File Name:UserInVO.java  
 * Package Name:com.aido.manager.dto.User  
 * Date:2017年1月16日上午11:18:34  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
/**  
 * ClassName: package-info  
 * (TODO:简述该类作用)
 * @author DOUBLE
 * @version   
 */
package com.aido.manager.dto.User;

import java.io.Serializable;

/**
 * ClassName: User  
 * 用户
 * @author DOUBLE
 * @version
 */
public class UserVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private String email;	
	private String profilePicture;
	private String introduction;
	private Long createTime;
	private Long lastModifyTime;
	private String outDate;
	private String validataCode;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public Long getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Long lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getValidataCode() {
		return validataCode;
	}
	public void setValidataCode(String validataCode) {
		this.validataCode = validataCode;
	}
	
}