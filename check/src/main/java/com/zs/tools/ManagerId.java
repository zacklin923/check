package com.zs.tools;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.SourceImport;
import com.zs.entity.StaffUser;

public class ManagerId {

	public static final BigDecimal DEVELOPER=new BigDecimal("1");
	public static final BigDecimal MANAGER_1=new BigDecimal("101");
	public static final BigDecimal MANAGER_2=new BigDecimal("102");
	
	/**
	 * 是否能看所有,能看返回null，不能看返回能看的条码
	 */
	public static String isSeeAll(HttpServletRequest req) {
		StaffUser user=(StaffUser) req.getSession().getAttribute("user"); 
		if (user.getStuRole().equals(DEVELOPER) || user.getStuRole().equals(MANAGER_1) || user.getStuRole().equals(MANAGER_2)) {
			return null;
		}
		return Trans.handleCtmBarCode(user.getOwnBarCode());
	}
	
	public static String isSeeAll2(HttpServletRequest req) {
		StaffUser user=(StaffUser) req.getSession().getAttribute("user"); 
		if (user.getStuRole().equals(DEVELOPER) || user.getStuRole().equals(MANAGER_1) || user.getStuRole().equals(MANAGER_2)) {
			return null;
		}
		return user.getStuNum();
	}
	
	public static Date getNow() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
