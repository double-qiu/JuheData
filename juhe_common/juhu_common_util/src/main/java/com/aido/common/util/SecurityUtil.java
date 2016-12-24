package com.aido.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;

public class SecurityUtil {
	
	static Logger logger = Logger.getLogger(SecurityUtil.class);
	
	private SecurityUtil() {
		
	}
	
	//--------------------------------------MD5信息摘要方法-------------------------------------
	public static byte[] MD5(String source){
		byte src[] = source.getBytes();
		byte target[] = MD5(src);
		return target;
	}
	public static byte[] MD5(byte source[]){
		byte[] mdValue = null;
		try{
			MessageDigest mdInstance = MessageDigest.getInstance("MD5");
			mdInstance.update(source);
			mdValue = mdInstance.digest();
		}catch(NoSuchAlgorithmException e){
			logger.error("MD5 error : ",e);
		}
		return mdValue;
	}
	
	//对字符串进行加密, 返回加密后的16进制的字符串表示
	public static String MD5String(String source){
		byte md5Bytes[] = MD5(source);
		String result = transferByte(md5Bytes);
		return result;
	}
	
	//对字节数组进行加密, 返回加密后的16进制的字符串表示
	public static String MD5String(byte source[]){
		byte md5Bytes[] = MD5(source);
		String result = transferByte(md5Bytes);
		return result;
	}
	
	private static String transferByte(byte[] byteArray){
		String str = CodeUtils.encodeHexString(byteArray);
		return str;
	}
}
