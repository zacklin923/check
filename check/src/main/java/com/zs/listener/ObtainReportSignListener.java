package com.zs.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import com.zs.service.ReportSignSer;
import com.zs.service.SourceImportSer;

public class ObtainReportSignListener implements ServletContextListener{

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
		private final int SEND_TIME_HOUR=14;//每天推送的小时数
		

		public ObtainThread(ReportSignSer reportSignSer) {
			super();
			this.reportSignSer = reportSignSer;
		}
		
		public void run() {
			while(true){
				try {
					//定时间点推送
					calendar=Calendar.getInstance();
					if (calendar.get(Calendar.HOUR_OF_DAY)==SEND_TIME_HOUR && hasPushedOnDay==false) {
						log.error("[签收报表]我走了一次");
						Date d1=new Date();
						Calendar calendar=Calendar.getInstance();
						calendar.add(Calendar.DATE, -1);
						Date d=calendar.getTime();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String date=sdf.format(d);
						reportSignSer.obtainReportSign(date,null,null);
						reportSignSer.obtainReportSignUpdate();
						hasPushedOnDay=true;
						Date d2=new Date();
						log.error("[签收报表]本次计算的是["+date+"]的数据，耗时["+(d2.getTime()-d1.getTime())+"ms]");
					}else{
						if (calendar.get(Calendar.HOUR_OF_DAY)!=SEND_TIME_HOUR && hasPushedOnDay==true) {
							log.error("[签收报表]我改了一次");
							hasPushedOnDay=false;
						}
						Thread.sleep(10000);
//						log.error("[签收报表]我在正常的循环");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
