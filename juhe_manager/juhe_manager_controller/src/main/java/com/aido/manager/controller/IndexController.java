package com.aido.manager.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aido.manager.constant.Const;


@Controller
public class IndexController extends BaseController {

	/**
	 *  index:首页
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	/**
	 *  login:登陆
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "/user/login";
	}
	/**
	 *  forgotPassword:重置密码
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @return
	 */
	@RequestMapping("/forgotPassword")
	public String forgotPassword() {
		return "/user/forgotPassword";
	}
	/**
	 *  register:注册
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @return
	 */
	@RequestMapping("/register")
	public String register() {
		return "/user/register";
	}
	/**
	 *  logout:登出
	 *  @return_type:String
	 *  @author DOUBLE
	 *  @param response
	 *  @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletResponse response) {
		getSession().removeAttribute(Const.LOGIN_SESSION_KEY);
		getSession().removeAttribute(Const.LAST_REFERER);
		Cookie cookie = new Cookie(Const.LOGIN_SESSION_KEY, "");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "index";
	}
}
