package com.zs.tools;

import java.util.Calendar;
import java.util.Date;

import com.zs.entity.other.MyDate;

/**
 * 一些与日期时间有关的工具
 * @author 张顺
 *2017-5-27
 */
public class DateTimeHelper {

	
	//得到今天最开始的时间
	public static MyDate getBeginOfNow() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new MyDate(calendar.getTime());
	}
	
	//得到今天最后的时间
	public static MyDate getEndOfNow() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		return new MyDate(calendar.getTime());
	}
	
	//得到昨天8点的时间
	public static MyDate getBeginOfOld() {
		Calendar calendar=Calendar.getInstance();
		Date date = new Date();
		calendar.set(date.getYear()+1900,date.getMonth(),date.getDate()-1,8,0,0);
		return new MyDate(calendar.getTime());
	}
	
	//得到今天最7.59的时间
		public static MyDate getEndOfOld() {
			Calendar calendar=Calendar.getInstance();
			Date date = new Date();
			calendar.set(date.getYear()+1900,date.getMonth(),date.getDate(),7,59,59);
			return new MyDate(calendar.getTime());
		}
	
}
