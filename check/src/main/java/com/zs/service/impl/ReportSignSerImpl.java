package com.zs.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.CustomerMapper;
import com.zs.dao.TimeLimitMapper;
import com.zs.dao.reportSignNewMapper;
import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;
import com.zs.entity.ReportData;
import com.zs.entity.TimeLimit;
import com.zs.entity.TimeLimitExample;
import com.zs.entity.reportSignNew;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.ReportSignBean;
import com.zs.service.ReportSignSer;
import com.zs.tools.DateTimeHelper;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

@Service("reportSignSer")
public class ReportSignSerImpl implements ReportSignSer{

	@Resource
	private reportSignNewMapper reportSignNewMapper;
	@Resource
	private TimeLimitMapper timeLimitMapper;
	@Resource
	private CustomerMapper customerMapper;
	
	//省份的签收率
	public List<ReportSignBean> obtainOfProvince(EasyUIAccept accept) {
		if(accept.getDate1()!=null){
			accept.setDate1(DateTimeHelper.getstartdate8(accept.getDate1()));
		}
		if(accept.getDate2()!=null){
			accept.setDate2(DateTimeHelper.getstartdate8(accept.getDate2()));
		}
		DecimalFormat  df  = new DecimalFormat("######0.00");
		List<reportSignNew> rsns = reportSignNewMapper.sumidentify(accept);
		List<ReportSignBean> lists = new ArrayList<ReportSignBean>();
		for (int i = 0; i < rsns.size(); i++) {
			TimeLimitExample tle = new TimeLimitExample();
			tle.createCriteria().andEndProvinceEqualTo(rsns.get(i).getIdentify());
			List<TimeLimit> tls = timeLimitMapper.selectByExample(tle);
			String beginprovince ="深圳";
			String hourcost ="";
			if(tls.size()>0){
				beginprovince = tls.get(0).getBeginProvince();
				hourcost =	tls.get(0).getHourCost().toString();	
			}
			int succCount =Trans.toStringBig(rsns.get(i).getSuccCount());
			int allCount =Trans.toStringBig(rsns.get(i).getAllCount());
			int timeoutCount =Trans.toStringBig(rsns.get(i).getTimeOutCount());
			
			double succRate =0.0;
			if(allCount>0){
				succRate = (double)succCount/allCount*100.00;
			}
			double timeoutRate =0.0;
			if(succCount>0){
				timeoutRate = (double)timeoutCount/succCount*100.00;
			}
			double nottimeoutRate =0.0;
			if(timeoutRate>0){
				nottimeoutRate = 100-timeoutRate;
			}
			ReportSignBean rsb = new ReportSignBean(beginprovince, rsns.get(i).getIdentify(),hourcost ,"",df.format(succRate)+"%", df.format(timeoutRate)+"%",df.format(nottimeoutRate)+"%");
			lists.add(rsb);
		}
		return lists;
	}
	
	//获取签收率，按客户
	public List<ReportSignBean> obtainOfCtm(EasyUIAccept accept) {
		if(accept.getDate1()!=null){
			accept.setDate1(DateTimeHelper.getstartdate8(accept.getDate1()));
		}
		if(accept.getDate2()!=null){
			accept.setDate2(DateTimeHelper.getstartdate8(accept.getDate2()));
		}
		DecimalFormat  df  = new DecimalFormat("######0.00");
		List<reportSignNew> rsns = reportSignNewMapper.sumidentify(accept);
		List<ReportSignBean> lists = new ArrayList<ReportSignBean>();
		for (int i = 0; i < rsns.size(); i++) {
			CustomerKey ctkey = new CustomerKey();
			ctkey.setHistoryCount(new BigDecimal(0));
			ctkey.setCteBarCode(rsns.get(i).getIdentify());
			Customer ct = customerMapper.selectByPrimaryKey(ctkey);
			String beginprovince ="深圳";
			String hourcost ="";
			String largeArea ="";
			if(ct!=null){
				hourcost =	ct.getCteName();	
				largeArea = ct.getLargeArea();
			}
			int succCount =Trans.toStringBig(rsns.get(i).getSuccCount());
			int allCount =Trans.toStringBig(rsns.get(i).getAllCount());
			int timeoutCount =Trans.toStringBig(rsns.get(i).getTimeOutCount());
			
			double succRate =0.0;
			if(allCount>0){
				succRate = (double)succCount/allCount*100.00;
			}
			double timeoutRate =0.0;
			if(succCount>0){
				timeoutRate = (double)timeoutCount/succCount*100.00;
			}
			double nottimeoutRate =0.0;
			if(timeoutRate>0){
				nottimeoutRate = 100-timeoutRate;
			}
			ReportSignBean rsb = new ReportSignBean(beginprovince, rsns.get(i).getIdentify(),hourcost,largeArea,df.format(succRate)+"%" , df.format(timeoutRate)+"%",df.format(nottimeoutRate)+"%");
			lists.add(rsb);
		}
		return lists;
	}

	//计算签收率，总量 
	public List<ReportSignBean> obtainOfSum(EasyUIAccept accept) {
		if(accept.getDate1()!=null){
			accept.setDate1(DateTimeHelper.getstartdate8(accept.getDate1()));
		}
		if(accept.getDate2()!=null){
			accept.setDate2(DateTimeHelper.getstartdate8(accept.getDate2()));
		}
		accept.setInt1(1);
		DecimalFormat  df  = new DecimalFormat("######0.00");
		List<reportSignNew> rsns = reportSignNewMapper.sumall(accept);
		List<ReportSignBean> lists = new ArrayList<ReportSignBean>();
		for (int i = 0; i < rsns.size(); i++) {
			String beginprovince ="深圳";
			String hourcost ="总量";
			int succCount =Trans.toStringBig(rsns.get(i).getSuccCount());
			int allCount =Trans.toStringBig(rsns.get(i).getAllCount());
			int timeoutCount =Trans.toStringBig(rsns.get(i).getTimeOutCount());
			double succRate =0.0;
			if(allCount>0){
				succRate = (double)succCount/allCount*100.00;
			}
			double timeoutRate =0.0;
			if(succCount>0){
				timeoutRate = (double)timeoutCount/succCount*100.00;
			}
			double nottimeoutRate =0.0;
			if(timeoutRate>0){
				nottimeoutRate = 100-timeoutRate;
			}
			ReportSignBean rsb = new ReportSignBean(beginprovince, "",hourcost,"",df.format(succRate)+"%" , df.format(timeoutRate)+"%",df.format(nottimeoutRate)+"%");
			lists.add(rsb);
		}
		return lists;
	}
	
	//重新生成
	public String obtainReportSign(EasyUIAccept accept) {
		if(accept.getDate2()!=null&&accept.getDate1()!=null){
			int a = accept.getDate2().getDate()-accept.getDate1().getDate();
//			System.out.println(a);
			for (int i = 0; i <= a; i++) {
				if(i==0){
					accept.setDate1(new Date(DateTimeHelper.getstartdate8(accept.getDate1()).getTime()));
				}else{
					accept.setDate1(new Date(DateTimeHelper.getstartdate8(accept.getDate1()).getTime()+86400000));
				}
//				System.out.println(accept.getDate1());
				if(accept.getInt1().equals(1)){
					reportSignNewMapper.callcode(accept);
				}else if(accept.getInt1().equals(2)){
					reportSignNewMapper.callprovince(accept);
				}else{
					reportSignNewMapper.callcode(accept);
					reportSignNewMapper.callprovince(accept);
				}
			}
			return "成功刷新所选时间段";
			
		}else if(accept.getDate1()!=null){
			accept.setDate1(DateTimeHelper.getstartdate8(accept.getDate1()));
			if(accept.getInt1().equals(1)){
				reportSignNewMapper.callcode(accept);
			}else if(accept.getInt1().equals(2)){
				reportSignNewMapper.callprovince(accept);
			}else{
				reportSignNewMapper.callcode(accept);
				reportSignNewMapper.callprovince(accept);
			}
			return "成功刷新所选时间段";
		}else if(accept.getDate2()!=null){
			accept.setDate1(DateTimeHelper.getstartdate8(accept.getDate2()));
			if(accept.getInt1().equals(1)){
				reportSignNewMapper.callcode(accept);
			}else if(accept.getInt1().equals(2)){
				reportSignNewMapper.callprovince(accept);
			}else{
				reportSignNewMapper.callcode(accept);
				reportSignNewMapper.callprovince(accept);
			}
			return "成功刷新所选时间段";
		}
		return "请选择时间";
	}


	public String exportData(EasyUIAccept accept,HttpServletRequest req) {
		if(accept.getInt1().equals(1)){
			System.out.println(accept);
			List<ReportSignBean> rsbs = obtainOfCtm(accept);
			String [] obj1 ={"出发地","客户条码","客户名称","所属大区","签收率","超时签收率","未超时签收率"};
			String[][] objs = new String [rsbs.size()][obj1.length];
			for (int i = 0; i < objs.length; i++) {
				objs[i][0]=rsbs.get(i).getBeginArea();
				objs[i][1]=rsbs.get(i).getIdentify();
				objs[i][2]=rsbs.get(i).getIdentifyDescribe();
				objs[i][3]=rsbs.get(i).getLargeArea();
				objs[i][4]=rsbs.get(i).getSignRate();
				objs[i][5]=rsbs.get(i).getTimeOutRate();
				objs[i][6]=rsbs.get(i).getNotTimeOUtRate();
			}
			String basePath = req.getSession().getServletContext().getRealPath("/");
			String path ="file/签收率报表.xls";
			ExcelExport.OutExcel1(obj1, objs, basePath+path);
			return path;
		}else if(accept.getInt1().equals(2)){
			List<ReportSignBean> rsbs =obtainOfProvince(accept);
			String [] obj2 ={"出发地","省份","时效","签收率","超时签收率","未超时签收率"};
			String[][] objs = new String [rsbs.size()][obj2.length];
			for (int i = 0; i < objs.length; i++) {
				objs[i][0]=rsbs.get(i).getBeginArea();
				objs[i][1]=rsbs.get(i).getIdentify();
				objs[i][2]=rsbs.get(i).getIdentifyDescribe();
				objs[i][3]=rsbs.get(i).getSignRate();
				objs[i][4]=rsbs.get(i).getTimeOutRate();
				objs[i][5]=rsbs.get(i).getNotTimeOUtRate();
			}
			String basePath = req.getSession().getServletContext().getRealPath("/");
			String path ="file/签收率报表.xls";
			ExcelExport.OutExcel1(obj2, objs, basePath+path);
			return path;
		}
		return null;
	}

	

}
