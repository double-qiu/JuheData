/**  
 * Project Name:juhe_manager_service_impl  
 * File Name:UserServiceImpl.java  
 * Package Name:com.aido.manager.service.impl  
 * Date:2017年1月15日下午7:12:36  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aido.manager.repo.domain.User;
import com.aido.manager.repo.repository.UserRepository;
import com.aido.manager.service.UserService;

/**  
 * ClassName: UserServiceImpl  
 * 用户管理服务接口实现
 * @author DOUBLE
 * @version   
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * @param user
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	/**  
	 * @param userName
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	/**  
	 * @param username
	 * @param email
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public User findByUserNameOrEmail(String username, String email) {
		return userRepository.findByUserNameOrEmail(username, email);
	}

	/**  
	 * @param email
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/**  
	 * @param outDate
	 * @param validataCode
	 * @param email
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public int setOutDateAndValidataCode(String outDate, String validataCode, String email) {
		return userRepository.setOutDateAndValidataCode(outDate, validataCode, email);
	}

	/**  
	 * @param passWord
	 * @param email
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public int setNewPassword(String passWord, String email) {
		return userRepository.setNewPassword(passWord, email);
	}

	/**  
	 * @param introduction
	 * @param email
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public int setIntroduction(String introduction, String email) {
		return userRepository.setIntroduction(introduction, email);
	}

	/**  
	 * @param userName
	 * @param email
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public int setUserName(String userName, String email) {
		return userRepository.setUserName(userName, email);
	}

	/**  
	 * @param profilePicture
	 * @param id
	 * @return
	 * @author DOUBLE
	 */
	@Override
	public int setProfilePicture(String profilePicture, Long id) {
		return userRepository.setProfilePicture(profilePicture, id);
	}
	

}
