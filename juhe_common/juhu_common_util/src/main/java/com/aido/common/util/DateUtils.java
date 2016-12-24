package com.aido.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * The Class DateUtils.
 * 
 * @author
 */
public abstract class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	public static void main(String[] args) {
		System.out.println(DateUtils.getNowYear() + "-" + DateUtils.getNowMonth() + "-" + DateUtils.getNowDay());
	}

	/**
	 * 获取年份
	 * 
	 * @return
	 * @author nibili 2016年10月12日
	 */
	public static String getNowYear() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		int year = calNow.get(Calendar.YEAR);
		return String.valueOf(year);
	}

	/**
	 * 获取月份
	 * 
	 * @return
	 * @author nibili 2016年10月12日
	 */
	public static String getNowMonth() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		int month = calNow.get(Calendar.MONTH)+1;
		String monthString = "";
		if (month < 10) {
			monthString = "0" + month;
		} else {
			monthString = String.valueOf(month);
		}
		return monthString;
	}

	/**
	 * 获取天
	 * 
	 * @return
	 * @author nibili 2016年10月12日
	 */
	public static String getNowDay() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		int day = calNow.get(Calendar.DAY_OF_MONTH);
		String dayString = "";
		if (day < 10) {
			dayString = "0" + day;
		}else{
			dayString = String.valueOf(day);
		}
		return dayString;
	}

	/**
	 * 获取当前的小时
	 * 
	 * @return
	 * @auth nibili 2015年6月13日
	 */
	public static int getNowHour() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		return calNow.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回当前时间.
	 * 
	 * @return 返回当前时间
	 */
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		return dtNow;
	}

	/**
	 * Gets the today.
	 * 
	 * @return 返回今天日期，时间部分为0。例如：2006-4-8 00:00:00
	 */
	public static Date getToday() {
		return truncate(new Date(), Calendar.DATE);
	}

	/**
	 * Gets the today end.
	 * 
	 * @return 返回今天日期，时间部分为23:59:59.999。例如：2006-4-19 23:59:59.999
	 */
	public static Date getTodayEnd() {
		return getDayEnd(new Date());
	}

	/**
	 * 将字符串转换为日期（不包括时间）.
	 * 
	 * @param dateString
	 *            "yyyy-MM-dd"格式的日期字符串
	 * @return 日期
	 */
	public static Date convertToDate(String dateString) {
		try {
			return FormatConstants.DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 检查字符串是否为日期格式yyyy-MM-dd.
	 * 
	 * @param dateString
	 *            the date string
	 * @return true=是；false=否
	 */
	public static boolean checkDateString(String dateString) {
		return (convertToDate(dateString) != null);
	}

	/**
	 * 将字符串转换为日期（包括时间）.
	 * 
	 * @param dateTimeString
	 *            the date time string
	 * @return 日期时间
	 */
	public static Date convertToDateTime(String dateTimeString) {
		try {
			return FormatConstants.DATE_TIME_FORMAT.parse(dateTimeString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 检查字符串是否为日期时间格式yyyy-MM-dd HH:mm:ss.
	 * 
	 * @param dateTimeString
	 *            the date time string
	 * @return true=是；false=否
	 */
	public static boolean checkDateTimeString(String dateTimeString) {
		return (convertToDateTime(dateTimeString) != null);
	}

	/**
	 * 获取月底.
	 * 
	 * @param year
	 *            年 4位年度
	 * @param month
	 *            月 1~12
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(int year, int month) {
		StringBuffer sb = new StringBuffer(10);
		Date date;
		if (month < 12) {
			sb.append(Integer.toString(year));
			sb.append("-");
			sb.append(month + 1);
			sb.append("-1");
			date = convertToDate(sb.toString());
		} else {
			sb.append(Integer.toString(year + 1));
			sb.append("-1-1");
			date = convertToDate(sb.toString());
		}
		date.setTime(date.getTime() - 1);
		return date;
	}

	/**
	 * 获取月底.
	 * 
	 * @param when
	 *            要计算月底的日期
	 * @return 月底的Date对象。例如：2006-3-31 23:59:59.999
	 */
	public static Date getMonthEnd(Date when) {
		Assert.notNull(when, "date must not be null !");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		return getMonthEnd(year, month);
	}

	/**
	 * 获取给定日的最后一刻。.
	 * 
	 * @param when
	 *            给定日
	 * @return 最后一刻。例如：2006-4-19 23:59:59.999
	 */
	public static Date getDayEnd(Date when) {
		Date date = truncate(when, Calendar.DATE);
		date = addDays(date, 1);
		date.setTime(date.getTime() - 1);
		return date;
	}

	/**
	 * 获取给定日的第一刻。.
	 * 
	 * @param when
	 *            给定日
	 * @return 最后一刻。例如：2006-4-19 23:59:59.999
	 */
	public static Date getDay(Date when) {
		Date date = truncate(when, Calendar.DATE);
		date = addDays(date, -1);
		date.setTime(date.getTime() + 1);
		return date;
	}

	/**
	 * 日期加法.
	 * 
	 * @param when
	 *            被计算的日期
	 * @param field
	 *            the time field. 在Calendar中定义的常数，例如Calendar.DATE
	 * @param amount
	 *            加数
	 * @return 计算后的日期
	 */
	public static Date add(Date when, int field, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 计算给定的日期加上给定的天数。.
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的天数
	 * @return 计算后的日期
	 */
	public static Date addDays(Date when, int amount) {
		return add(when, Calendar.DAY_OF_YEAR, amount);
	}

	/**
	 * 计算给定的日期加上给定的月数。.
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的月数
	 * @return 计算后的日期
	 */
	public static Date addMonths(Date when, int amount) {
		return add(when, Calendar.MONTH, amount);
	}

	/**
	 * Format date.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @return the string
	 */
	public static String formatDate(Date date, String format) {
		if (StringUtils.isNotBlank(format)) {
			DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(format, java.util.Locale.CHINA);
			return DATE_TIME_FORMAT.format(date);
		}
		return FormatConstants.DATE_TIME_FORMAT.format(date);
	}
}
