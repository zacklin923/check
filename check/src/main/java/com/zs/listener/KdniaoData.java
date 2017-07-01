package com.zs.listener;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.zs.entity.KdniaoLogisticcode;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.KdniaoReturnInteface;
import com.zs.entity.other.SendKdniao;
import com.zs.service.KdniaoLogisticcodeSer;
import com.zs.service.ReportSignSer;
import com.zs.tools.DateTimeHelper;
import com.zs.tools.KdniaoTimely1;
import com.zs.tools.KdniaoTimely2;
import com.zs.tools.KdniaoTimely3;

public class KdniaoData implements ServletContextListener{
	
	private KdniaoLogisticcodeSer kdniaoLogisticcodeSer;
	KdniaoDataThread thread;
	private Logger log = Logger.getLogger(KdniaoDataThread.class);
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();  
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(  
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);   
        //建立对应的service当spring上下文初始化之后  ,使用spring框架中已经初始化的memberService  
        kdniaoLogisticcodeSer=(KdniaoLogisticcodeSer)context.getBean("kdniaoLogisticcodeSer");
        thread=new KdniaoDataThread(kdniaoLogisticcodeSer);
		new Thread(thread).start();
	}

	private class KdniaoDataThread implements Runnable{
		private KdniaoLogisticcodeSer kdniaoLogisticcodeSer;
		private Calendar calendar;
		List<KdniaoLogisticcode>  lists = new ArrayList<KdniaoLogisticcode>();
		List<KdniaoLogisticcode>  lists1 = new ArrayList<KdniaoLogisticcode>();
		List<KdniaoLogisticcode>  lists2 = new ArrayList<KdniaoLogisticcode>();
		List<KdniaoLogisticcode>  lists3 = new ArrayList<KdniaoLogisticcode>();
		Gson g = new Gson();
		private boolean run4 =true;
		private int count = 0;
		private boolean hasPushedOnDay=false;//今天是否推送过的标志
		private final int SEND_TIME_HOUR=12;//每天推送的小时数
		public KdniaoDataThread(KdniaoLogisticcodeSer kdniaoLogisticcodeSer) {
			super();
			this.kdniaoLogisticcodeSer = kdniaoLogisticcodeSer;
		}
		
		public void run() {
			while(true){
				try {
					//定时间点推送
					calendar=Calendar.getInstance();
					if (calendar.get(Calendar.HOUR_OF_DAY)==SEND_TIME_HOUR && hasPushedOnDay==false) {
						run4 =true;
						log.error("我跑了一次数据");
						EasyUIAccept accept = new EasyUIAccept();
				    	accept.setDate1(DateTimeHelper.getstartolddate8(new Date()));
				    	accept.setDate2(DateTimeHelper.getendnewdate8(new Date()));
				    	System.out.println(accept.getDate1());
				    	System.out.println(accept.getDate2());
				    	Date d1 = new Date();
				    	kdniaoLogisticcodeSer.UpdateLogisticcode(accept);
				    	Date d2 = new Date();
				    	System.out.println("提取共耗时"+(d2.getTime()-d1.getTime()));
				    	System.out.println("提取共耗时"+d2.getTime());
				    	lists = kdniaoLogisticcodeSer.query9000logisticcode();
				    	if(lists.size()>3000){
				    		lists1 = lists.subList(0, 3000);
				    		if(lists.size()>6000){
				    			lists2 = lists.subList(3000, 6000);
				    			if(lists.size()>9000){
				    				lists3 = lists.subList(6000, 9000);
				    			}
				    		}else{
				    			lists2 = lists.subList(3000, lists.size());
				    		}
				    	}else{
				    		lists1 = lists.subList(0, lists.size());
				    	}
				    	
				    	
			    	ExecutorService executorService=Executors.newFixedThreadPool(10);
			    	
	    			executorService.execute(new Runnable() {
	    				public void run() {
	    					if(lists1!=null){
//	    						Date dd1 = new Date();
	    						for (int i = 0; i < lists1.size(); i++) {
	    							SendKdniao sk1 = new SendKdniao("", "YD", lists1.get(i).getLogisticcode());
									try {
										String str1 = new KdniaoTimely1().postForm(g.toJson(sk1));
										KdniaoReturnInteface kr = g.fromJson(str1, KdniaoReturnInteface.class);
										log.info(kr);
										if(kr.getSuccess()==true){
											kdniaoLogisticcodeSer.insertKdniaoReturn(kr);
										}
										if(kr.getReason()!=null){
											if(kr.getReason().equals("当前无可用的套餐")){
												i=lists1.size();
												lists1=null;
												count = count+lists1.size();
//												System.out.println("-----------------------------------21213123--------------------------");
											}
										}
									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
		    					}
	    						count = count+lists1.size();
//	    						Date dd2 = new Date();
//	    						System.out.println("-----------------方式1耗时---------------"+(dd2.getTime()-dd1.getTime()));
		    				}
	    				}
	    			});
			    	executorService.execute(new Runnable() {
			    		public void run() {
			    			if(lists2!=null){
//				    			Date ds2 = new Date();
			    				for (int j = 0; j < lists2.size(); j++) {
									SendKdniao sk2 = new SendKdniao("", "YD", lists2.get(j).getLogisticcode());
									try {
										String str2 = new KdniaoTimely2().postForm(g.toJson(sk2));
										KdniaoReturnInteface kr = g.fromJson(str2, KdniaoReturnInteface.class);
										log.info(kr);
										if(kr.getSuccess()==true){
											kdniaoLogisticcodeSer.insertKdniaoReturn(kr);
										}
										if(kr.getReason()!=null){
											if(kr.getReason().equals("当前无可用的套餐")){
												j=lists2.size();
												lists2=null;
//												System.out.println("-----------------------------------21213123--------------------------");
												count = count+lists2.size();
											}
										}
									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
//			    				Date de2 = new Date();
//				    			System.out.println("-----------------方式2共耗时-----------------"+(de2.getTime()-ds2.getTime()));
				    			count = count+lists2.size();
			    			}
			    		}
		            });
		    		executorService.execute(new Runnable() {
			    		public void run() {
			    			if(lists3!=null){
//					    		System.out.println("11111111111111111111111");
			    				for (int k = 0; k < lists3.size(); k++) {
									SendKdniao sk3 = new SendKdniao("", "YD", lists3.get(k).getLogisticcode());
									try {
										String str3 = new KdniaoTimely3().postForm(g.toJson(sk3));
										KdniaoReturnInteface kr = g.fromJson(str3, KdniaoReturnInteface.class);
										log.info(kr);
										if(kr.getSuccess()==true){
											kdniaoLogisticcodeSer.insertKdniaoReturn(kr);
										}
										if(kr.getReason()!=null){
											if(kr.getReason().equals("当前无可用的套餐")){
												k=lists3.size();
												lists3=null;
//												System.out.println("-----------------------------------21213123--------------------------");
												count = count+lists3.size();
											}
										}
									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
			    				count = count+lists3.size();
//					    		System.out.println("-----------------退出3-----------------");
			    			}
				    	}
			         });
		    		executorService.execute(new Runnable() {
			    		public void run() {
				    		while(run4){
				    			if(count==(lists1.size()+lists2.size()+lists3.size())){
						    		Date d3 = new Date();
						    		System.out.println("推送返回共耗时"+d3.getTime());
						    		kdniaoLogisticcodeSer.drawKdniaoSign();
						    		Date d4 = new Date();
						    		System.out.println("签收共耗时"+(d4.getTime()-d3.getTime()));
						    		count=0;
						    		run4=false;
					    		}else{
					    			try {
//										System.out.println("休息10秒");
					    				Thread.sleep(10000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
					    		}
				    		}
			    		}
		    		});
		    		hasPushedOnDay=true;
					}else{
						if (calendar.get(Calendar.HOUR_OF_DAY) != SEND_TIME_HOUR && hasPushedOnDay==true) {
							hasPushedOnDay=false;
						}
						Thread.sleep(60000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		thread=null;
	}
}
