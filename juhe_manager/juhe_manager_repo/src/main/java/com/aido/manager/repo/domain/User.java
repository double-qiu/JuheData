package com.aido.manager.repo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * ClassName: User  
 * 用户
 * @author DOUBLE
 * @version
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = true, unique = true)
	private String userName;
	@Column(nullable = true)
	private String passWord;
	@Column(nullable = true, unique = true)
	private String email;	
	@Column(nullable = true)
	private String profilePicture;
	@Column(nullable = true,length = 65535,columnDefinition="Text")
	private String introduction;
	@Column(nullable = true)
	private Long createTime;
	@Column(nullable = true)
	private Long lastModifyTime;
	@Column(nullable = true)
	private String outDate;
	@Column(nullable = true)
	private String validataCode;

	public User() {
		super();
	}
	public User(String email, String nickName, String passWord, String userName) {
		super();
		this.email = email;
		this.passWord = passWord;
		this.userName = userName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
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