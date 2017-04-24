package com.zs.tools;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Trans {
	
	static Logger log = Logger.getLogger(Trans.class);

	public static Date TransToDate(String str){
		if(str!=null && !str.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			try {
				Date date = sdf.parse(str);
				return date;
			} catch (ParseException e) {
				try {
					Date date = sdf2.parse(str);
					return date;
				} catch (Exception e2) {
					e.printStackTrace();
					log.error("字符串转Date类型失败，错误字符转为："+str);
					return null;
				}
			}
		}else{
			return null;
		}
	}
	
	public static Date TransToDate(String str,String df){
		if(str!=null && !str.trim().equals("") && df!=null && !df.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat(df);
			try {
				Date date = sdf.parse(str);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
				log.error("字符串转Date类型失败，错误字符转为："+str);
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static Integer TransToInteger(String str){
		Integer i=null;
		if(str!=null && !str.trim().equals("")){
			try {
				i=Integer.valueOf(str);
				return i;
			} catch (Exception e) {
				log.error("字符串转Integer类型失败，错误字符转为："+str);
				return i;
			}
		}
		return i;
	}
	public static String TransToString(Date date){
		String str=null;
		if(date!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
			try {
				str=sdf.format(date);
				return str;
			} catch (Exception e) {
				log.error("Date转String类型失败，错误为："+date);
				return str;
			}
		}
		return str;
	}
	
	public static Double toDouble(String str) {
		Double d=null;
		if (str!=null && !str.trim().equals("")) {
			try {
				d=Double.valueOf(str);
			} catch (Exception e) {
				log.error("String转Double类型失败，错误为："+str);
			}
		}
		return d;
	}
	public static String toString(Double d) {
		String str=null;
		if (d!=null) {
			try {
				str=String.valueOf(d);
			} catch (Exception e) {
				log.error("Double转String类型失败，错误为："+d);
			}
		}
		return str;
	}
	
	public static Timestamp toTimestamp(String str){
		if(str!=null && !str.trim().equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date date = sdf.parse(str);
				return new Timestamp(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
				log.error("字符串转Timestamp类型失败，错误字符转为："+str);
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static String TimestampTransToString(Date time){
		String str=null;
		if(time!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			try {
				str=sdf.format(time);
				return str;
			} catch (Exception e) {
				log.error("Date转String类型失败，错误为："+time);
				return str;
			}
		}
		return str;
	}
	
	public static BigDecimal toBigDecimal(String str){
		if (str!=null) {
			return new BigDecimal(str);
		}
		return null;
	}
}
