/**  
 * Project Name:juhe_manager_controller  
 * File Name:UserController.java  
 * Package Name:com.aido.manager.controller  
 * Date:2017年1月16日上午11:15:33  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aido.common.util.Copy;
import com.aido.common.util.DateUtils;
import com.aido.common.util.ExceptionMsg;
import com.aido.common.util.InvokeResult;
import com.aido.manager.constant.Const;
import com.aido.manager.dto.User.UserVO;
import com.aido.manager.repo.domain.User;
import com.aido.manager.service.UserService;

/**  
 * ClassName: UserController  
 * 用户控制服务
 * @author DOUBLE
 * @version   
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	/**
	 *  registerUser:注册
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param userVO
	 *  @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public InvokeResult registerUser(UserVO userVO){
		User user = new User();
		try {
			User registUser = userService.findByEmail(userVO.getEmail());
			if (null != registUser) {
				return InvokeResult.failure(ExceptionMsg.EmailUsed.getMsg());
			}
			User userNameUser = userService.findByUserName(userVO.getUserName());
			if (null != userNameUser) {
				return InvokeResult.failure(ExceptionMsg.UserNameUsed.getMsg());
			}
			Copy.simpleCopyExcludeNull(userVO, user);
			user.setPassWord(getPwd(userVO.getPassWord()));
			user.setCreateTime(DateUtils.getCurrentTime());
			user.setLastModifyTime(DateUtils.getCurrentTime());
			user.setProfilePicture("img/favicon.png");
			userService.create(user);
			getSession().setAttribute(Const.LOGIN_SESSION_KEY, user);
		} catch (Exception e) {
			logger.error("用户注册失败：" + e.getMessage(),e);
			return InvokeResult.failure(ExceptionMsg.REGISTERFAILED.getMsg());
		}
		return InvokeResult.success(user.getId());
	}
	/**
	 *  login:登陆
	 *  @return_type:InvokeResult
	 *  @author DOUBLE
	 *  @param userVO
	 *  @param response
	 *  @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public InvokeResult login(UserVO userVO,HttpServletResponse response) {
		try {
			User loginUser = userService.findByUserNameOrEmail(userVO.getUserName(), userVO.getUserName());
			if (loginUser == null ) {
				return InvokeResult.failure(ExceptionMsg.LoginNameNotExists.getMsg());
			}else if(!loginUser.getPassWord().equals(getPwd(userVO.getPassWord()))){
				return InvokeResult.failure(ExceptionMsg.LoginNameOrPassWordError.getMsg());
			}
			Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, cookieSign(loginUser.getId().toString()));
			cookie.setMaxAge(Const.COOKIE_TIMEOUT);
			cookie.setPath("/");
			response.addCookie(cookie);
			getSession().setAttribute(Const.LOGIN_SESSION_KEY, loginUser);
			String preUrl = "/";
			if(null != getSession().getAttribute(Const.LAST_REFERER)){
				preUrl = String.valueOf(getSession().getAttribute(Const.LAST_REFERER));
				if(preUrl.indexOf("/collect?") < 0){
					preUrl = "/";
				}
			}
			return  InvokeResult.success(ExceptionMsg.SUCCESS.getCode());
		} catch (Exception e) {
			logger.error("用户登陆失败：" + e.getMessage(),e);
			return InvokeResult.failure(ExceptionMsg.LOGINFAILED.getMsg());
		}
	}
	
}
