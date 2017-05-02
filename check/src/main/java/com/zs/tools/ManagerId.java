package com.zs.tools;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.http.HttpServletRequest;
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
		return user.getOwnBarCode();
	}
	
	public static String isSeeAll2(HttpServletRequest req) {
		StaffUser user=(StaffUser) req.getSession().getAttribute("user"); 
		if (user.getStuRole().equals(DEVELOPER) || user.getStuRole().equals(MANAGER_1) || user.getStuRole().equals(MANAGER_2)) {
			return null;
		}
		return user.getStuNum();
	}
}
