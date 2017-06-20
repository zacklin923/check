package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.PrimeCodeReportMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.PrimeCodeReport;
import com.zs.entity.SourceImport;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.OtherResultMap;
import com.zs.entity.other.PerResultMap;
import com.zs.entity.other.PrimeCodeCollect;
import com.zs.entity.other.lyResultMap;
import com.zs.service.PrimeCodeImportSer;
import com.zs.tools.Trans;

@Service("primeCodeImportSer")
public class PrimeCodeImportSerImpl implements PrimeCodeImportSer{

	@Resource
	private StaffUserMapper userMapper;
	@Resource
	private PrimeCodeReportMapper primeCodeReportMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=primeCodeReportMapper.queryFenye(accept);
			int rows=primeCodeReportMapper.getCount(accept);
			for (int i = 0; i < list.size(); i++) {
				PrimeCodeReport si = (PrimeCodeReport) list.get(i);
				if(si.getStuNum()!=null && !si.getStuNum().equals("")){
					StaffUser suer = userMapper.selectByPrimaryKey(si.getStuNum());
					si.setStuNum(suer.getStuName());
				}else{
					si.setStuNum("");
				}
			}
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(PrimeCodeReport obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(PrimeCodeReport obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		return primeCodeReportMapper.deleteByPrimaryKey(new BigDecimal(id));
	}

	public PrimeCodeReport get(String id) {
		return primeCodeReportMapper.selectByPrimaryKey(new BigDecimal(id));
	}

	public String importData(List<String[]> list, String stuNum) {
		List<String> lists = new ArrayList<String>();
		for (int i = 2; i < list.size(); i++) {
			if(list.get(i)[1].trim().replace(",", "").length()!=6){
				lists.add((i+1)+"行条码"); 
			}else {
				Timestamp tt1 = Trans.toTimestamp(list.get(i)[5]);
				Timestamp tt2 = Trans.toTimestamp(list.get(i)[7]);
				Timestamp tt3 = Trans.toTimestamp(list.get(i)[9]);
				Timestamp tt4 = Trans.toTimestamp(list.get(i)[11]);
				Timestamp tt5 = Trans.toTimestamp(list.get(i)[13]);
				Timestamp tt6 = Trans.toTimestamp(list.get(i)[15]);
				Timestamp tt7 = Trans.toTimestamp(list.get(i)[17]);
				Timestamp tt8 = Trans.toTimestamp(list.get(i)[19]);
				Timestamp tt9 = Trans.toTimestamp(list.get(i)[21]);
				Timestamp tt10 = Trans.toTimestamp(list.get(i)[23]);
				if(tt1==null||tt2==null||tt3==null||tt4==null||tt5==null||tt6==null
					||tt7==null||tt8==null||tt9==null||tt10==null){
					lists.add((i+1)+"行用时"); 
				}else{
					try{             
						BigDecimal b1 = Trans.toBigDecimal(list.get(i)[4]);
						BigDecimal b2 = Trans.toBigDecimal(list.get(i)[6]);
						BigDecimal b3  = Trans.toBigDecimal(list.get(i)[8]);
						BigDecimal b4  = Trans.toBigDecimal(list.get(i)[10]);
						BigDecimal b5  = Trans.toBigDecimal(list.get(i)[12]);
						BigDecimal b6  = Trans.toBigDecimal(list.get(i)[14]);
						BigDecimal b7  = Trans.toBigDecimal(list.get(i)[16]);
						BigDecimal b8  = Trans.toBigDecimal(list.get(i)[18]);
						BigDecimal b9  = Trans.toBigDecimal(list.get(i)[20]);
						BigDecimal b10 = Trans.toBigDecimal(list.get(i)[22]);
						BigDecimal b11 = Trans.toBigDecimal(list.get(i)[24]);
						PrimeCodeReport pcr = new PrimeCodeReport(
								null,list.get(i)[0],list.get(i)[1].trim().replace(",", ""),list.get(i)[2],list.get(i)[3],
								b1,Trans.TimeForBig(tt1),b2,Trans.TimeForBig(tt2),b3,Trans.TimeForBig(tt3),
								b4,Trans.TimeForBig(tt4),b5,Trans.TimeForBig(tt5),b6,Trans.TimeForBig(tt6),
								b7,Trans.TimeForBig(tt4),b8,Trans.TimeForBig(tt8),b9,Trans.TimeForBig(tt9),
								b10,Trans.TimeForBig(tt10),b11,stuNum,new Date(),null);
						primeCodeReportMapper.insertSelective(pcr);
					}catch (Exception e) {
						lists.add((i+1)+"行处理量"); 
					}
				}
			}
		}
		if(lists.size()==(list.size()-2)){
			return "导入的数据基本全错,请检查格式，建议重新导入";
		}else if(lists.size()>0){
			return new Gson().toJson(lists);
		}else{
			return "导入成功，共导入"+list.size()+"条数据，全部成功";
		}
	}

	public int deleteAll(String userNum) {
		return 0;
	}

	public EasyUIPage queryCollect(EasyUIAccept accept) {
		if (accept!=null) {
			List list= new ArrayList<PrimeCodeCollect>();
			String str = "";
			for (int i = 0; i <2; i++) {
				if(i==0){
					str="快递";
					accept.setStr1("('快递','快运')");
				}else if(i==1){
					str="仓储";
					accept.setStr1("('仓储')");
				}
				OtherResultMap orm = primeCodeReportMapper.getOthers(accept);
				lyResultMap lrp = primeCodeReportMapper.getLy(accept);
				OtherResultMap orme = primeCodeReportMapper.getOtherExcptions(accept);
				Double d1=0.0;
				Double d2=0.0;
				Double d3=0.0;
				if(orm.getC3()!=0){
					d1 = (double) (orm.getC2()/orm.getC3());
				}
				if(orm.getC3()!=0){
					d2 = (double) (lrp.getC1()/lrp.getC2());
				}
				int allExcep = orme.getC1()+orme.getC2()+orme.getC3()+orme.getC4()+orme.getC5();
				if(orm.getC3()!=0){
					d3 = (double) (allExcep/orme.getC6());
				}
				PrimeCodeCollect pcc = new PrimeCodeCollect(str,orm.getC1(),orm.getC2(),orm.getC3(),d1,lrp.getC1(),lrp.getC2(),d2,allExcep,orme.getC6(),d3,orme.getC1(),orme.getC2(),orme.getC3(),(orme.getC4()+orme.getC5()),(orm.getC4()+orm.getC5()),(orm.getC6()+orm.getC7()));
				list.add(pcc);
				orm=null;
				lrp=null;
				orme=null;
				pcc=null;
			}
			return new EasyUIPage(20, list);
		}
		return null;
	}

	public EasyUIPage querPer(EasyUIAccept accept) {
		List list = primeCodeReportMapper.getPerReport(accept);
		for (int i = 0; i < list.size(); i++) {
			PerResultMap prm = (PerResultMap) list.get(i);
			String str = "";
			if(prm.getStuNum()!=null){
				StaffUser user =  userMapper.selectByPrimaryKey(prm.getStuNum());
				str = user.getStuName();
			}
			prm.setStuNum(str);
		}
		return new EasyUIPage(20, list);
	}


}
