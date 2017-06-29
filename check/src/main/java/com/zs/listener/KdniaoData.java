package com.zs.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import com.zs.entity.other.EasyUIAccept;
import com.zs.service.KdniaoLogisticcodeSer;
import com.zs.service.ReportSignSer;
import com.zs.tools.DateTimeHelper;

public class KdniaoData implements ServletContextListener{
	
	private KdniaoLogisticcodeSer kdniaoLogisticcodeSer;
	KdniaoDataThread thread;
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(1111);
		ServletContext servletContext = sce.getServletContext();  
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(  
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);   
        //建立对应的service当spring上下文初始化之后  ,使用spring框架中已经初始化的memberService  
        kdniaoLogisticcodeSer=(KdniaoLogisticcodeSer)context.getBean("kdniaoLogisticcodeSer");
        thread=new KdniaoDataThread(kdniaoLogisticcodeSer);
		new Thread(thread).start();
        
//		try {
//			System.out.println("-----------进来了一次 -------------");
//			SendKdniao sk = new SendKdniao("", "YD", "3974984412257");
//			KdniaoTimely1 st1 = new KdniaoTimely1();
//			String str = st1.postForm(new Gson().toJson(sk));
//			System.out.println(str);
//			KdniaoReturn kr = new Gson().fromJson(str, KdniaoReturn.class);
//			System.out.println(kr);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}

	private class KdniaoDataThread implements Runnable{
		private KdniaoLogisticcodeSer kdniaoLogisticcodeSer;

		public KdniaoDataThread(KdniaoLogisticcodeSer kdniaoLogisticcodeSer) {
			super();
			this.kdniaoLogisticcodeSer = kdniaoLogisticcodeSer;
		}
		
		public void run() {
//			while(true){
//				try {
//					EasyUIAccept accept = new EasyUIAccept();
//			    	accept.setDate1(DateTimeHelper.getstartolddate8(new Date()));
//			    	accept.setDate2(DateTimeHelper.getendnewdate8(new Date()));
//			    	System.out.println(accept.getDate1());
//			    	System.out.println(accept.getDate2());
//			    	System.out.println(new Date());
//			    	kdniaoLogisticcodeSer.UpdateLogisticcode(accept);
//			    	System.out.println(new Date());
//					Thread.sleep(1000000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		thread=null;
	}
}
