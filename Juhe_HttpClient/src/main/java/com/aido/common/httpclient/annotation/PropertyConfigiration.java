package com.aido.common.httpclient.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: PropertiesAnnotation  
 * (属性文件注入)
 * @author DOUBLE  
 * @version
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyConfigiration {
	String location() ;
}
