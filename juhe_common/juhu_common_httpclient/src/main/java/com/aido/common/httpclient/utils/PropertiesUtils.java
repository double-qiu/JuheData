package com.aido.common.httpclient.utils;

import java.io.InputStream;
import java.util.Properties;

import com.aido.common.httpclient.model.HttpClientProperties;

/**
 * 加载属性文件
 */
public class PropertiesUtils {
	public static Properties loadProperties(String propertiesName) {
		Properties prop = new Properties();
		InputStream stream = null;
		try {
			stream = PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesName) ;
			if(stream == null) {
				stream = HttpClientProperties.class.getResourceAsStream(propertiesName) ;
			}
			prop.load(stream);
			stream.close();
			return prop;
		} catch (Exception e) {
			return null;
		}
	}
}
