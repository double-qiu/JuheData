package com.aido.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 用于前端 金额 输出用千分号格式式的，自定义JSTL
 * 
 * @author nibili 2014-12-04
 * 
 */
public class AmountToPerThousandSignTag {

	public static void main(String[] args) {
		System.out.println(AmountToPerThousandSignTag.toPerThousandSign("123456789.03"));
	}

	/**
	 * 字符串的金额转成 千分啊的金额
	 * @param amount
	 * @return
	 * @author nibili 2016年10月11日
	 */
	public static String toPerThousandSign(String amount) {
		if (amount != null) {
			DecimalFormat df = new DecimalFormat("###,##0.00");
			return df.format(Double.valueOf(amount));
		} else {
			return "0.00";
		}
	}

	/**
	 * 千分号格式化金额输出
	 * 
	 * @param amount
	 *            金额
	 * @return
	 */
	public static String toPerThousandSign(BigDecimal amount) {
		if (amount != null) {
			DecimalFormat df = new DecimalFormat("###,##0.00");
			return df.format(amount);
		} else {
			return "0.00";
		}
	}

}
