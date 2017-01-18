package com.aido.manager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

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
	
	@RequestMapping("/home")
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
}
