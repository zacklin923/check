package test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zs.entity.SourceZm;
import com.zs.entity.other.ReportSignBean;
import com.zs.service.ReportSignSer;
import com.zs.service.SourceZmSer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class ServiceTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private SourceZmSer sourceZmSer;
	@Resource
	private com.zs.service.SourceTpSer SourceTpSer;
	@Resource
	private ReportSignSer reportSignSer;
	
	Gson gson=new Gson();
	
	public void getLast() {
		SourceZm zm=sourceZmSer.last("6000014092181");
		System.out.println(zm);
	}
	
	public void testDate() throws ParseException {
		Date date=new SimpleDateFormat("yy/MM/dd HH:mm:ss").parse("1900/01/01 00:00:00");
		System.out.println(date.getTime());
		
		Date date2=new SimpleDateFormat("yy/MM/dd HH:mm:ss").parse("0001/01/01 00:00:00");
		System.out.println(date2.getTime());
	}
	
	public void testjson(){
		String str = "{\"largeArea\":\"中部大区\",\"sliceArea\":\"龙华区\",\"fenbu\":\"东环分部\",\"fbdArea\":\"广东深圳公司市场开发部分部\",\"ctmBarCode\":\"518941\",\"courierNumber\":\"3844850000245\",\"sendTime\":null,\"weight\":0}";
		SourceZm ss = new Gson().fromJson(str, SourceZm.class);
		System.out.println(ss.toString());
	}
	public void testString(){
//		String str ="15616161";
//		System.out.println(str.matches("[0-9]*"));
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date d1=calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		calendar.add(Calendar.MILLISECOND, -1);
		Date d2=calendar.getTime();
		System.out.println(d1.toLocaleString());
		System.out.println(d2.toLocaleString());
	}
	//测试取客户+省份签收率
	public void obtainOfCtmAndProvince() {
		List<ReportSignBean> list=reportSignSer.obtainOfCtmAndProvince(null);
		System.out.println(gson.toJson(list));
	}
	//测试生成签收报表数据
	@Test
	public void obtainReportSign() {
		reportSignSer.obtainReportSign("2017-06-01",null,null);
	}

}
