/**  
 * Project Name:juhe_manager_controller  
 * File Name:LoggerManage.java  
 * Package Name:com.aido.manager.comm.aop  
 * Date:2017年1月19日下午4:26:31  
 * Copyright (c) 2017, LoveBeanTec All Rights Reserved.  
 */
package com.aido.manager.comm.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: LoggerManage  
 * 日志注解
 * @author DOUBLE
 * @version
 */
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

	public String description();
}
