package com.zs.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.zs.entity.other.KdniaoReturnInteface;
import com.zs.entity.other.SendKdniao;

public class test {
	
	
	
	public void kdniaotest(){
		
		try {
			List<String> list = new ArrayList<String>();
			list.add("3974984442042");
			list.add("3974984442039");
			list.add("3974984442034");
			list.add("3974984442019");
			list.add("3974984441998");
			list.add("3974984441983");
			list.add("3974984441836");
			list.add("3974984441833");
			list.add("3974984441822");
			list.add("3974984441802");
			Date d1 = new Date();
			for (int i = 0; i < list.size(); i++) {
				SendKdniao sk3 = new SendKdniao("", "YD", "3974984442042");
				String  str3 = new KdniaoTimely3().postForm(new Gson().toJson(sk3));
				KdniaoReturnInteface kr = new Gson().fromJson(str3, KdniaoReturnInteface.class);
				System.out.println(kr);
			}
			Date d2 = new Date();
			System.out.println("10条共耗时"+(d2.getTime()-d1.getTime())+"毫秒");		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testBig(){
		BigDecimal b1= new BigDecimal(0);
		System.out.println(b1);
		BigDecimal b2 = new BigDecimal(33);
		System.out.println(b2);
		BigDecimal b3 = b1.add(b2);
		System.out.println(b3);
	}
	
}
