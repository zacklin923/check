package com.zs.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SimpleThreadPoolTaskExecutor;
import org.springframework.web.context.WebApplicationContext;
import com.zs.service.ReportSignSer;
import com.zs.service.SourceImportSer;

public class ReportDataListener implements ServletContextListener{

	private ReportSignSer reportSignSer;
	ObtainThread thread;
	private Logger log = Logger.getLogger(ObtainThread.class);
	
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();  
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(  
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);   
        //建立对应的service当spring上下文初始化之后  ,使用spring框架中已经初始化的memberService  
        reportSignSer=(ReportSignSer)context.getBean("reportSignSer");
        thread=new ObtainThread(reportSignSer);
		new Thread(thread).start();
	}
	public void contextDestroyed(ServletContextEvent sce) {
		thread=null;
	}
	
	/**
	 * 每天14点计算昨天的数据
	 * @author 张顺，2017-6-26
	 */
	private class ObtainThread implements Runnable{
		private ReportSignSer reportSignSer;
		private Calendar calendar;
		private boolean hasPushedOnDay=false;//今天是否推送过的标志
		private final int SEND_TIME_HOUR=10;//每天推送的小时数
		
		public ObtainThread(ReportSignSer reportSignSer) {
			super();
			this.reportSignSer = reportSignSer;
		}
		
		
		public void run() {
			while(true){
				
			}
		}
		
	}
}
