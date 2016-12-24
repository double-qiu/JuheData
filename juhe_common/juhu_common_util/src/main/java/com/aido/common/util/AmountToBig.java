package com.aido.common.util;

/**
 * 金额小写转大写
 * 
 * @author nibili 2016年10月11日
 * 
 */
public class AmountToBig {

	public static void main(String[] args) {
		System.out.println(AmountToBig.amountToBig(Double.valueOf("6789.08")));
	}

	/** 单位 */
	private static final String UNIT = "万千佰拾亿千佰拾万千佰拾元角分";
	/** 数字大写 */
	private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
	/** */
	private static final double MAX_VALUE = 9999999999999.99D;

	/**
	 * 金额小写转大写
	 * 
	 * @param amount
	 * @return
	 * @author nibili 2016年10月11日
	 */
	public static String amountToBig(String amount) {
		return AmountToBig.amountToBig(Double.valueOf(amount));
	}

	/**
	 * 金额小写转大写
	 * 
	 * @param v
	 *            金额
	 * @return
	 * @author nibili 2016年10月11日
	 */
	public static String amountToBig(double v) {
		if (v < 0 || v > MAX_VALUE) {
			return "参数非法!";
		}
		long l = Math.round(v * 100);
		if (l == 0) {
			return "零元整";
		}
		String strValue = l + "";
		// i用来控制数
		int i = 0;
		// j用来控制单位
		int j = UNIT.length() - strValue.length();
		String rs = "";
		boolean isZero = false;
		for (; i < strValue.length(); i++, j++) {
			char ch = strValue.charAt(i);
			if (ch == '0') {
				isZero = true;
				if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
					rs = rs + UNIT.charAt(j);
					isZero = false;
				}
			} else {
				if (isZero) {
					rs = rs + "零";
					isZero = false;
				}
				rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
			}
		}
		if (!rs.endsWith("分")) {
			rs = rs + "整";
		}
		rs = rs.replaceAll("亿万", "亿");
		return rs;
	}

}
