package com.zs.listener;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.gson.Gson;
import com.zs.entity.other.KdniaoReturn;
import com.zs.entity.other.SendKdniao;
import com.zs.tools.KdniaoTimely1;

public class KdniaoData implements ServletContextListener{


	public void contextInitialized(ServletContextEvent arg0) {
		try {
			System.out.println("-----------进来了一次 -------------");
			SendKdniao sk = new SendKdniao("", "YD", "3974984412257");
			KdniaoTimely1 st1 = new KdniaoTimely1();
			String str = st1.postForm(new Gson().toJson(sk));
			System.out.println(str);
			KdniaoReturn kr = new Gson().fromJson(str, KdniaoReturn.class);
			System.out.println(kr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}
