package com.dscexpen.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 功能描述：日期相关的转换和计�?
 * 
 * @author
 * @since
 */
public class DateTools {

	/**
	 * 获得两时间相差的天数
	 * 
	 * @param g1
	 *            时间1
	 * @param g2
	 *            时间2
	 * @return 时间1与时�?2相差的天�?
	 */
	public int getDays(GregorianCalendar g1, GregorianCalendar g2) {
		int elapsed = 0;
		GregorianCalendar gc1, gc2;

		if (g2.after(g1)) {
			gc2 = (GregorianCalendar) g2.clone();
			gc1 = (GregorianCalendar) g1.clone();
		} else {
			gc2 = (GregorianCalendar) g1.clone();
			gc1 = (GregorianCalendar) g2.clone();
		}

		gc1.clear(Calendar.MILLISECOND);
		gc1.clear(Calendar.SECOND);
		gc1.clear(Calendar.MINUTE);
		gc1.clear(Calendar.HOUR_OF_DAY);

		gc2.clear(Calendar.MILLISECOND);
		gc2.clear(Calendar.SECOND);
		gc2.clear(Calendar.MINUTE);
		gc2.clear(Calendar.HOUR_OF_DAY);

		while (gc1.before(gc2)) {
			gc1.add(Calendar.DATE, 1);
			elapsed++;
		}
		return elapsed - 1;
	}

	/**
	 * 计算与一个日期相差若干天的日�?
	 * 
	 * @param inputDate
	 *            要计算日�?
	 * @param dayNumber
	 *            相差的天数，可以 <0
	 * @return 计算后的日期
	 */
	public static Date intervalDays(Date inputDate, long dayNumber) {
		Date returnDate = new Date();
		long dayMS = 86400000;// һ��ĺ�����?
		long tempMS = 0;

		tempMS = inputDate.getTime();
		tempMS = tempMS + dayNumber * dayMS;

		returnDate.setTime(tempMS);

		return returnDate;
	}

	/**
	 * 计算指定年月的天数 传入年份，传入月份-1，即可算出此月有多少天
	 */
	public static int getMonthDays(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year); // 年
		c.set(Calendar.MONTH, month); // 月
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取几天前的时间 时间格式yyyy-MM-dd
	 * 
	 * @param beforeDay
	 * @return
	 */
	public static String getByBeforeDay(int beforeDay) {
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, -beforeDay);
		// cal1.set(2000,1,29);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String towDaysBefore = sdf.format(cal1.getTime());
		return towDaysBefore;
	}

	/**
	 * 类型转换 日期转换字符串
	 * 
	 * @return返回字符串格式 yyyyMMddHHmmss
	 */
	public static String DateToString() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 类型转换 日期转换字符串
	 * 
	 * @param dateformat
	 *            可以是yyyy-MM-dd HH:mm:ss，yyyyMMddHHmmss，yyyy-MM-dd任何需要得到的模式
	 * @return
	 */
	public static String DateToString(String dateformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 类型转换 日期转换字符串
	 * 
	 * @param dateformat
	 *            可以是yyyy-MM-dd HH:mm:ss，yyyyMMddHHmmss，yyyy-MM-dd任何需要得到的模式
	 * @return
	 */
	public static String DateToString(Date date, String dateformat) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateformat);
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 把日期字符串转换为具体日期刊
	 * 
	 * @param origin
	 *            要转换的日期字符串，格式：yyyy-MM-dd HH:mm:ss,如果字符串为""，返回null
	 * @return 转换后的日期
	 */
	public static Date StringToDate(String origin) {
		Date tempDate = null;

		if (origin == null)
			return tempDate;
		if (origin.equals(""))
			return tempDate;

		SimpleDateFormat dateformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			String yyyy = origin.substring(0, 4);
			String MM = origin.substring(4, 6);
			String dd = origin.substring(6, 8);
			String HH = origin.substring(8, 10);
			String mm = origin.substring(10, 12);
			String ss = origin.substring(11, 14);
			origin = yyyy + "-" + MM + "-" + dd + " " + HH + ":" + mm + ":"
					+ ss;
			tempDate = dateformat.parse(origin);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return tempDate;
	}

	/**
	 * 把日期字符串转换为具体日期刊
	 * 
	 * @param dateString
	 * @param format
	 *            可以是yyyy-MM-dd HH:mm:ss，yyyyMMddHHmmss，yyyy-MM-dd任何需要得到的模式
	 * @return
	 */
	public static Date StringToDate(String dateString, String format) {
		Date tempDate = null;

		if (dateString == null)
			return tempDate;
		if (dateString.equals(""))
			return tempDate;

		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		try {
			tempDate = dateformat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return tempDate;
	}
	/**
	 * 把日期字符串转换为具体日期刊
	 * 
	 * @param dateString
	 * @param  dateString 可以是yyyy-MM-dd HH:mm:ss，yyyyMMddHHmmss，yyyy-MM-dd任何需要得到的模式
	 * @return
	 */
	public static Date StringToDatetime(String dateString) {
		Date tempDate = null;

		if (dateString == null)
			return tempDate;
		if (dateString.equals(""))
			return tempDate;

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			tempDate = dateformat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return tempDate;
	}
}
