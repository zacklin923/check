package com.zs.listener;

import java.util.Calendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import com.zs.service.SourceImportSer;
public class SendToZmListener implements ServletContextListener{

	private SendToZmThread sendToZmThread;
	private SourceImportSer sourceImportSer;
	
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();  
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(  
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);   
        //建立对应的service当spring上下文初始化之后  ,使用spring框架中已经初始化的memberService  
        sourceImportSer=(SourceImportSer)context.getBean("sourceImportSer");
        sendToZmThread=new SendToZmThread(sourceImportSer);
		new Thread(sendToZmThread).start();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		sendToZmThread=null;
	}
	
	private class SendToZmThread implements Runnable{
		private SourceImportSer sourceImportSer;
		private Calendar calendar;
		private boolean hasPushedOnDay=false;//今天是否推送过的标志
		private final int SEND_TIME_HOUR=14;


		public SendToZmThread(SourceImportSer sourceImportSer) {
			super();
			this.sourceImportSer = sourceImportSer;
		}

		public void run() {
			while(true){
				try {
					//定时间点推送
					calendar=Calendar.getInstance();
					if (calendar.get(Calendar.HOUR_OF_DAY)==SEND_TIME_HOUR && hasPushedOnDay==false) {
						sourceImportSer.sendToZm2();
						hasPushedOnDay=true;
						System.out.println("我走了一次");
					}else{
						if (calendar.get(Calendar.HOUR_OF_DAY)!=SEND_TIME_HOUR && hasPushedOnDay==true) {
							hasPushedOnDay=false;
							System.out.println("我改了一次");
						}
						Thread.sleep(10000);
//						System.out.println("我在正常的循环");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


	

}
