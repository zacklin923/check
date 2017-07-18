package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

@Service("primeCodeImportSer")
public class PrimeCodeImportSerImpl implements PrimeCodeImportSer{

	@Resource
	private StaffUserMapper userMapper;
	@Resource
	private PrimeCodeReportMapper primeCodeReportMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			List list;
			PrimeCodeReport pcr = new PrimeCodeReport(new BigDecimal(0),"","","","总计",new BigDecimal(0),
					new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),
					new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),
					new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),
					new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),new BigDecimal(0),"",null,null);
			pcr.setLargeArea("总计");
			if((accept.getDate2().getTime()-accept.getDate1().getTime())>(1000*60*60*24)){
				list=primeCodeReportMapper.queryCount(accept);
				for (int i = 0; i < list.size(); i++) {
					PrimeCodeReport si = (PrimeCodeReport) list.get(i);
					if(si.getStuNum()!=null && !si.getStuNum().equals("")){
						StaffUser suer = userMapper.selectByPrimaryKey(si.getStuNum());
						si.setStuNum(suer.getStuName());
					}else{
						si.setStuNum("");
					}
					pcr.setCountJd(pcr.getCountJd().add(si.getCountJd()));
					pcr.setHourJd(pcr.getHourJd().add(si.getHourJd()));
					pcr.setCountCj(pcr.getCountCj().add(si.getCountCj()));
					pcr.setHourCj(pcr.getHourCj().add(si.getHourCj()));
					pcr.setCountLy(pcr.getCountLy().add(si.getCountLy()));
					pcr.setHourLy(pcr.getHourLy().add(si.getHourLy()));
					pcr.setCountGd(pcr.getCountGd().add(si.getCountGd()));
					pcr.setHourGd(pcr.getHourGd().add(si.getHourGd()));
					pcr.setCountLpcl(pcr.getCountLpcl().add(si.getCountLpcl()));
					pcr.setHourLpcl(pcr.getHourLpcl().add(si.getHourLpcl()));
					pcr.setCountKscl(pcr.getCountKscl().add(si.getCountKscl()));
					pcr.setHourKscl(pcr.getHourKscl().add(si.getHourKscl()));
					pcr.setCountQsb(pcr.getCountQsb().add(si.getCountQsb()));
					pcr.setHourQsb(pcr.getHourQsb().add(si.getHourQsb()));
					pcr.setCountTjcl(pcr.getCountTjcl().add(si.getCountTjcl()));
					pcr.setHourTjcl(pcr.getHourTjcl().add(si.getHourTjcl()));
					pcr.setCountSd(pcr.getCountSd().add(si.getCountSd()));
					pcr.setHourSd(pcr.getHourSd().add(si.getHourSd()));
					pcr.setCountDd(pcr.getCountDd().add(si.getCountDd()));
					pcr.setHourDd(pcr.getHourDd().add(si.getHourDd()));
					pcr.setDayCount(pcr.getDayCount().add(si.getDayCount()));
				}
			}else{
				list=primeCodeReportMapper.queryFenye(accept);
				for (int i = 0; i < list.size(); i++) {
					PrimeCodeReport si = (PrimeCodeReport) list.get(i);
					if(si.getStuNum()!=null && !si.getStuNum().equals("")){
						StaffUser suer = userMapper.selectByPrimaryKey(si.getStuNum());
						si.setStuNum(suer.getStuName());
					}else{
						si.setStuNum("");
					}
					pcr.setCountJd(pcr.getCountJd().add(si.getCountJd()));
					pcr.setHourJd(pcr.getHourJd().add(si.getHourJd()));
					pcr.setCountCj(pcr.getCountCj().add(si.getCountCj()));
					pcr.setHourCj(pcr.getHourCj().add(si.getHourCj()));
					pcr.setCountLy(pcr.getCountLy().add(si.getCountLy()));
					pcr.setHourLy(pcr.getHourLy().add(si.getHourLy()));
					pcr.setCountGd(pcr.getCountGd().add(si.getCountGd()));
					pcr.setHourGd(pcr.getHourGd().add(si.getHourGd()));
					pcr.setCountLpcl(pcr.getCountLpcl().add(si.getCountLpcl()));
					pcr.setHourLpcl(pcr.getHourLpcl().add(si.getHourLpcl()));
					pcr.setCountKscl(pcr.getCountKscl().add(si.getCountKscl()));
					pcr.setHourKscl(pcr.getHourKscl().add(si.getHourKscl()));
					pcr.setCountQsb(pcr.getCountQsb().add(si.getCountQsb()));
					pcr.setHourQsb(pcr.getHourQsb().add(si.getHourQsb()));
					pcr.setCountTjcl(pcr.getCountTjcl().add(si.getCountTjcl()));
					pcr.setHourTjcl(pcr.getHourTjcl().add(si.getHourTjcl()));
					pcr.setCountSd(pcr.getCountSd().add(si.getCountSd()));
					pcr.setHourSd(pcr.getHourSd().add(si.getHourSd()));
					pcr.setCountDd(pcr.getCountDd().add(si.getCountDd()));
					pcr.setHourDd(pcr.getHourDd().add(si.getHourDd()));
					pcr.setDayCount(pcr.getDayCount().add(si.getDayCount()));
				}
			}
			list.add(pcr);
			return new EasyUIPage(20, list);
		}
		return null;
	}

	public Integer add(PrimeCodeReport obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(PrimeCodeReport obj) {
		return primeCodeReportMapper.updateByPrimaryKeySelective(obj);
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
						BigDecimal b1 = Trans.toBigDecimal0(list.get(i)[4]);
						BigDecimal b2 = Trans.toBigDecimal0(list.get(i)[6]);
						BigDecimal b3  = Trans.toBigDecimal0(list.get(i)[8]);
						BigDecimal b4  = Trans.toBigDecimal0(list.get(i)[10]);
						BigDecimal b5  = Trans.toBigDecimal0(list.get(i)[12]);
						BigDecimal b6  = Trans.toBigDecimal0(list.get(i)[14]);
						BigDecimal b7  = Trans.toBigDecimal0(list.get(i)[16]);
						BigDecimal b8  = Trans.toBigDecimal0(list.get(i)[18]);
						BigDecimal b9  = Trans.toBigDecimal0(list.get(i)[20]);
						BigDecimal b10 = Trans.toBigDecimal0(list.get(i)[22]);
						BigDecimal b11 = Trans.toBigDecimal0(list.get(i)[24]);
						PrimeCodeReport pcr = new PrimeCodeReport(
								null,list.get(i)[0],list.get(i)[1].trim().replace(",", ""),list.get(i)[2],list.get(i)[3],
								b1,Trans.TimeForBig(tt1),b2,Trans.TimeForBig(tt2),b3,Trans.TimeForBig(tt3),
								b4,Trans.TimeForBig(tt4),b5,Trans.TimeForBig(tt5),b6,Trans.TimeForBig(tt6),
								b7,Trans.TimeForBig(tt7),b8,Trans.TimeForBig(tt8),b9,Trans.TimeForBig(tt9),
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
			return "导入成功，共导入"+(list.size()-2)+"条数据，全部成功";
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
				if(orm.getC3()>0){
					orme.setC6(orm.getC3()-lrp.getC2());
				}else{
					orm.setC6(0);
				}
				Double d1=0.0;
				Double d2=0.0;
				Double d3=0.0;
				if(orm.getC3()!=0&&orm.getC3()!=0){
					d1 = (double) (orm.getC2()/orm.getC3());
				}else{
					d1=0.0;
				}
				if(lrp.getC1()!=0&&lrp.getC2()!=0){
					d2 = (double) (lrp.getC1()/lrp.getC2());
				}else{
					d2=0.0;
				}
				int allExcep = orme.getC1()+orme.getC2()+orme.getC3()+orme.getC4()+orme.getC5();
				if(allExcep!=0&&orme.getC6()!=0){
					d3 = (double) (allExcep/orme.getC6());
				}else{
					d3=0.0;
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
		System.out.println(accept);
		List list = primeCodeReportMapper.getPerReport(accept);
		PerResultMap prmall = new PerResultMap("总计",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
		for (int i = 0; i < list.size(); i++) {
			PerResultMap prm = (PerResultMap) list.get(i);
			String str = "";
			if(prm.getStuNum()!=null){
				StaffUser user =  userMapper.selectByPrimaryKey(prm.getStuNum());
				str = user.getStuName();
			}
			prm.setStuNum(str);
			prmall.setC1(prmall.getC1()+prm.getC1());
			prmall.setC2(prmall.getC2()+prm.getC2());
			prmall.setC3(prmall.getC3()+prm.getC3());
			prmall.setC4(prmall.getC4()+prm.getC4());
			prmall.setC5(prmall.getC5()+prm.getC5());
			prmall.setC6(prmall.getC6()+prm.getC6());
			prmall.setC7(prmall.getC7()+prm.getC7());
			prmall.setC8(prmall.getC8()+prm.getC8());
			prmall.setC9(prmall.getC9()+prm.getC9());
			prmall.setC10(prmall.getC10()+prm.getC10());
			prmall.setC11(prmall.getC11()+prm.getC11());
			prmall.setC12(prmall.getC12()+prm.getC12());
			prmall.setC13(prmall.getC13()+prm.getC13());
			prmall.setC14(prmall.getC14()+prm.getC14());
			prmall.setC15(prmall.getC15()+prm.getC15());
			prmall.setC16(prmall.getC16()+prm.getC16());
			prmall.setC17(prmall.getC17()+prm.getC17());
			prmall.setC18(prmall.getC18()+prm.getC18());
			prmall.setC19(prmall.getC19()+prm.getC19());
			prmall.setC20(prmall.getC20()+prm.getC20());
			prmall.setC21(prmall.getC21()+prm.getC21());
		}
		list.add(prmall);
		return new EasyUIPage(20, list);
	}

	public String exportDataImport(EasyUIAccept accept, HttpServletRequest req) {
		String[][] obj = {{"","","","","截单","","查件","","留言","","跟单","","理赔处理","","客诉处理","","签收表","","退件处理","","审单","","导单","","","",""},
						 {"客户名称","条码","客户类型","所属大区","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","日出货量（票）","登记人","导入时间"}};
		List list=primeCodeReportMapper.queryFenye(accept);
		String[][] objs = new String[list.size()][obj[1].length];
		for (int i = 0; i < list.size(); i++) {
			PrimeCodeReport si = (PrimeCodeReport) list.get(i);
			if(si.getStuNum()!=null && !si.getStuNum().equals("")){
				StaffUser suer = userMapper.selectByPrimaryKey(si.getStuNum());
				si.setStuNum(suer.getStuName());
			}else{
				si.setStuNum("");
			}
			objs[i][0]=si.getCtmName();
			objs[i][1]=si.getCtmBarCode();
			objs[i][2]=si.getCtmType();
			objs[i][3]=si.getLargeArea();
			objs[i][4]=Trans.toStringBig(si.getCountJd()).toString();
			objs[i][5]=Trans.BigDecimalForHours(si.getHourJd());
			objs[i][6]=Trans.toStringBig(si.getCountCj()).toString();
			objs[i][7]=Trans.BigDecimalForHours(si.getHourCj());
			objs[i][8]=Trans.toStringBig(si.getCountLy()).toString();
			objs[i][9]=Trans.BigDecimalForHours(si.getHourLy());
			objs[i][10]=Trans.toStringBig(si.getCountGd()).toString();
			objs[i][11]=Trans.BigDecimalForHours(si.getHourGd());
			objs[i][12]=Trans.toStringBig(si.getCountLpcl()).toString();
			objs[i][13]=Trans.BigDecimalForHours(si.getHourLpcl());
			objs[i][14]=Trans.toStringBig(si.getCountKscl()).toString();
			objs[i][15]=Trans.BigDecimalForHours(si.getHourKscl());
			objs[i][16]=Trans.toStringBig(si.getCountQsb()).toString();
			objs[i][17]=Trans.BigDecimalForHours(si.getHourQsb());
			objs[i][18]=Trans.toStringBig(si.getCountTjcl()).toString();
			objs[i][19]=Trans.BigDecimalForHours(si.getHourTjcl());
			objs[i][20]=Trans.toStringBig(si.getCountSd()).toString();
			objs[i][21]=Trans.BigDecimalForHours(si.getHourSd());
			objs[i][22]=Trans.toStringBig(si.getCountDd()).toString();
			objs[i][23]=Trans.BigDecimalForHours(si.getHourDd());
			objs[i][24]=Trans.toStringBig(si.getDayCount()).toString();
			objs[i][25]=si.getStuNum();
			objs[i][26]=Trans.TimestampTransToString(si.getCreateTime());
		}
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/成本导入收集.xls";
		ExcelExport.OutExcel2line(obj, objs, basePath+path,"成本导入收集");
		return path;
	}

	public String exportDataCollect(EasyUIAccept accept, HttpServletRequest request) {
		EasyUIPage eup = queryCollect(accept);
		String[][] obj = {{"","","","","","留言处理","","","其他异常处理","","","其他异常具体情况","","","","",""},
				 		 {"客户类型","客户数量","出货量","上班人数","人均效能","处理量（票）","处理人数","人均处理量","处理量（票）","处理人数","人均处理量","截单（票）","查件（票）","跟单（票）","客诉理赔（票）","报表制作","制单（票）"}};
		String[][] objs = new String[ eup.getRows().size()][obj[1].length];
		for (int i = 0; i < eup.getRows().size(); i++) {
			PrimeCodeCollect pcc =(PrimeCodeCollect) eup.getRows().get(i);
			objs[i][0]=pcc.getCtmType();
			objs[i][1]=pcc.getCtmCount()+"";
			objs[i][2]=pcc.getCountAll()+"";
			objs[i][3]=pcc.getPerWork()+"";
			objs[i][4]=pcc.getPerEfficiency()+"";
			objs[i][5]=pcc.getLyNum()+"";
			objs[i][6]=pcc.getLyPer()+"";
			objs[i][7]=pcc.getLyEfficiency()+"";
			objs[i][8]=pcc.getOtherNum()+"";
			objs[i][9]=pcc.getOtherPer()+"";
			objs[i][10]=pcc.getOtherEfficiency()+"";
			objs[i][11]=pcc.getJdNum()+"";
			objs[i][12]=pcc.getCjNum()+"";
			objs[i][13]=pcc.getGdNum()+"";
			objs[i][14]=pcc.getKslpNum()+"";
			objs[i][15]=pcc.getBbzz()+"";
			objs[i][16]=pcc.getZdNum()+"";
		}
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String path ="file/成本收集汇总.xls";
		ExcelExport.OutExcel2line(obj, objs, basePath+path,"成本收集汇总");
		return path;
	}

	public String exportDataPersonle(EasyUIAccept accept, HttpServletRequest request) {
		System.out.println(accept);
		List list = primeCodeReportMapper.getPerReport(accept);
		System.out.println(accept);
		String[][] obj = {{"","截单","","查件","","留言","","跟单","","理赔处理","","客诉处理","","签收表","","退件处理","","审单","","导单",""},
				 {"处理人","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","处理量（票）","用时","日出货量"}};
		String[][] objs = new String[list.size()][obj[1].length];
		for (int i = 0; i < list.size(); i++) {
			PerResultMap prm = (PerResultMap) list.get(i);
			String str = "";
			if(prm.getStuNum()!=null){
				StaffUser user =  userMapper.selectByPrimaryKey(prm.getStuNum());
				str = user.getStuName();
			}
			prm.setStuNum(str);
			objs[i][0]=prm.getStuNum();
			objs[i][1]=prm.getC1()+"";
			objs[i][2]=Trans.intForHours(prm.getC2());
			objs[i][3]=prm.getC3()+"";
			objs[i][4]=Trans.intForHours(prm.getC4());
			objs[i][5]=prm.getC5()+"";
			objs[i][6]=Trans.intForHours(prm.getC6());
			objs[i][7]=prm.getC7()+"";
			objs[i][8]=Trans.intForHours(prm.getC8());
			objs[i][9]=prm.getC9()+"";
			objs[i][10]=Trans.intForHours(prm.getC10());
			objs[i][11]=prm.getC11()+"";;
			objs[i][12]=Trans.intForHours(prm.getC12());
			objs[i][13]=prm.getC13()+"";;
			objs[i][14]=Trans.intForHours(prm.getC14());
			objs[i][15]=prm.getC15()+"";;
			objs[i][16]=Trans.intForHours(prm.getC16());
			objs[i][17]=prm.getC17()+"";;
			objs[i][18]=Trans.intForHours(prm.getC18());
			objs[i][19]=prm.getC19()+"";;
			objs[i][20]=Trans.intForHours(prm.getC20());
			objs[i][21]=prm.getC21()+"";;
		}
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String path ="file/成本收集按人汇总.xls";
		ExcelExport.OutExcel2line(obj, objs, basePath+path,"成本收集按人汇总");
		return path;
	}


}
