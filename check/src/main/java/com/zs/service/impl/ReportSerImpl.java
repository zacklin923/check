package com.zs.service.impl;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zs.dao.ReportDataMapper;
import com.zs.entity.ReportData;
import com.zs.entity.other.EasyUIAccept;
import com.zs.service.ReportSer;
import com.zs.tools.DateTimeHelper;
import com.zs.tools.ExcelExport;


@Service("reportSer")
public class ReportSerImpl implements ReportSer{

	@Resource
	private ReportDataMapper reportDataMapper;

	public List query(EasyUIAccept accept) {
		if(accept!=null){
			accept.setDate1(DateTimeHelper.getstartdate8(accept.getDate1()));
			accept.setDate2(DateTimeHelper.getstartdate8(accept.getDate2()));
			List list = reportDataMapper.query(accept);
			ReportData lastrd = new ReportData();
			if(lastrd.getCountAll()==null){
				lastrd.setCountAll(new BigDecimal(0));
			}
			if(lastrd.getElectronicSheet()==null){
				lastrd.setElectronicSheet(new BigDecimal(0));
			}
			if(lastrd.getGenericSheet()==null){
				lastrd.setGenericSheet(new BigDecimal(0));
			}
			if(lastrd.getOtherSheet()==null){
				lastrd.setOtherSheet(new BigDecimal(0));
			}
			for (int i = 0; i < list.size(); i++) {
				ReportData rd =  (ReportData) list.get(i);
				if(rd.getElectronicSheet()==null){
					rd.setElectronicSheet(new BigDecimal(0));
				}
				if(rd.getGenericSheet()==null){
					rd.setGenericSheet(new BigDecimal(0));
				}
				if(rd.getOtherSheet()==null){
					rd.setOtherSheet(new BigDecimal(0));
				}
				if(rd.getCountAll()==null){
					rd.setCountAll(new BigDecimal(0));
				}
				rd.setCountAll(new BigDecimal(Integer.parseInt(rd.getElectronicSheet()+"")+Integer.parseInt(rd.getGenericSheet()+"")+Integer.parseInt(rd.getOtherSheet()+"")));
				lastrd.setCountAll(new BigDecimal(Integer.parseInt(rd.getCountAll()+"")+Integer.parseInt(lastrd.getCountAll()+"")));
				lastrd.setElectronicSheet(new BigDecimal(Integer.parseInt(rd.getElectronicSheet()+"")+Integer.parseInt(lastrd.getElectronicSheet()+"")));
				lastrd.setGenericSheet(new BigDecimal(Integer.parseInt(rd.getGenericSheet()+"")+Integer.parseInt(lastrd.getGenericSheet()+"")));
				lastrd.setOtherSheet(new BigDecimal(Integer.parseInt(rd.getOtherSheet()+"")+Integer.parseInt(lastrd.getOtherSheet()+"")));
				if(accept.getInt1()==1||accept.getInt1()==2){
					lastrd.setFenBu("总计");
				}else if(accept.getInt1()==3){
					lastrd.setSliceArea("总计");
				}else if(accept.getInt1()==4){
					lastrd.setLargeArea("总计");
				}
			}
			list.add(lastrd);
			return list;
			}
		return null;
	}

	public void callproduce(EasyUIAccept accept){
		if(accept!=null){
			int count=0;
			if(accept.getDate2()!=null){
				count =(int) ((accept.getDate2().getTime()-accept.getDate1().getTime())/86400000);
			}
			if(accept.getDate1()!=null){
				Date d = new Date(accept.getDate1().getTime());
				for(int i= 0; i<=count;i++){
					Date dd = new Date(d.getTime()+86400000*i);
					accept.setDate3(DateTimeHelper.getstartdate8(dd));
					accept.setDate4(DateTimeHelper.getenddate8(dd));
					reportDataMapper.callproduce(accept);
				}
			}
		}
	}

	public String exportData(EasyUIAccept accept, HttpServletRequest req) {
		System.out.println(accept);
		List lists =  query(accept);
		String [] obj ={"客户名称","客户条码","客户类型","大区","区部","分部","总计","普件面单","电子面单","其他快递"};
		String[][] objs = new String [lists.size()][obj.length];
		for (int i = 0; i < objs.length; i++) {
			ReportData rd =  (ReportData) lists.get(i);
			objs[i][0]=rd.getCtmName();
			objs[i][1]=rd.getCtmBarCode();
			objs[i][2]=rd.getCustomType();
			objs[i][3]=rd.getLargeArea();
			objs[i][4]=rd.getSliceArea();
			objs[i][5]=rd.getFenBu();
			objs[i][6]=rd.getCountAll().toString();
			objs[i][7]=rd.getElectronicSheet().toString();
			objs[i][8]=rd.getGenericSheet().toString();
			objs[i][9]=rd.getOtherSheet().toString();
		}
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/日统计报表.xls";
		ExcelExport.OutExcel1(obj, objs, basePath+path);
		return path;
	}
}
