package com.zs.service.impl;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zs.dao.ReportMonthMapper;
import com.zs.entity.ReportData;
import com.zs.entity.ReportMonth;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.ReportAllMonth;
import com.zs.service.ReportMonthSer;
import com.zs.tools.DateTimeHelper;


@Service("reportMonthSer")
public class ReportMonthSerImpl implements ReportMonthSer{

	@Resource
	private ReportMonthMapper reportMonthMapper;

	public List query(EasyUIAccept accept) {
		if(accept!=null){
			List<ReportAllMonth> listall = new ArrayList<ReportAllMonth>();
			if(accept.getInt2().equals(accept.getInt4())){
				int ct = accept.getInt5()-accept.getInt3();
				for (int i = 0; i <= ct; i++) {
					accept.setStr3(accept.getInt2()+"-"+(accept.getInt3()+i));
					List<ReportMonth> list = reportMonthMapper.query(accept);
					for (int j = 0; j < list.size(); j++) {
						ReportAllMonth ram = new ReportAllMonth();
							ram.setCtmBarCode(list.get(j).getCtmBarCode());
							ram.setCtmName(list.get(j).getCtmName());
							ram.setCtmType(list.get(j).getCtmType());
							ram.setFenBu(list.get(j).getFenBu());
							ram.setLargeArea(list.get(j).getLargeArea());
							ram.setSliceArea(list.get(j).getSliceArea());
							if(ram.getCtmBarCode()==null){
								ram.setCtmBarCode("");
							}
							if(ram.getCtmName()==null){
								ram.setCtmName("");
							}
							if(ram.getLargeArea()==null){
								ram.setLargeArea("");
							}
							if(ram.getSliceArea()==null){
								ram.setSliceArea("");
							}
							if(ram.getFenBu()==null){
								ram.setFenBu("");
							}
							if(i==0){
								ram.setMonth1(list.get(j).getCountAll());
								listall.add(ram);
								ram=null;
							}
							if(i==1){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth2(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth2(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth2(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth2(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth2(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==2){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth3(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth3(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth3(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth3(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth3(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==3){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth4(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth4(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth4(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth4(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth4(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==4){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth5(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth5(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth5(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth5(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth5(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==5){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth6(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth6(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth6(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth6(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth6(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==6){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth7(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth7(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth7(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth7(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth7(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==7){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth8(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth8(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth8(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth8(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth8(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==8){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth9(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth9(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth9(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth9(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth9(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==9){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth10(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth10(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth10(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth10(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth10(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==10){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth11(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth11(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth11(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth11(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth11(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
							if(i==11){
								int isli = 0;
								for (int k = 0; k < listall.size(); k++) {
									if(accept.getInt1().equals(1)){
										if(ram.getCtmBarCode().equals(listall.get(k).getCtmBarCode())){
											isli=1;
											listall.get(k).setMonth12(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(2)){
										if(ram.getFenBu().equals(listall.get(k).getFenBu())){
											isli=1;
											listall.get(k).setMonth12(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(3)){
										if(ram.getSliceArea().equals(listall.get(k).getSliceArea())){
											isli=1;
											listall.get(k).setMonth12(list.get(j).getCountAll());;
										}
									}else if(accept.getInt1().equals(4)){
										if(ram.getLargeArea().equals(listall.get(k).getLargeArea())){
											isli=1;
											listall.get(k).setMonth12(list.get(j).getCountAll());;
										}
									}
								}
								if(isli==0){
									ram.setMonth12(list.get(j).getCountAll());
									listall.add(ram);
									ram=null;
								}
							}
					}
				}
			}
			ReportAllMonth lastram = new ReportAllMonth();
			int ms1=0,ms2=0,ms3=0,ms4=0,ms5=0,ms6=0,ms7=0,ms8=0,ms9=0,ms10=0,ms11=0,ms12=0;
			for (int z = 0; z < listall.size(); z++) {
				int m1=0,m2=0,m3=0,m4=0,m5=0,m6=0,m7=0,m8=0,m9=0,m10=0,m11=0,m12=0;
				if(listall.get(z).getMonth1()!=null){
					m1=Integer.parseInt(listall.get(z).getMonth1()+"");
				}
				if(listall.get(z).getMonth2()!=null){
					m2=Integer.parseInt(listall.get(z).getMonth2()+"");
				}
				if(listall.get(z).getMonth3()!=null){
					m3=Integer.parseInt(listall.get(z).getMonth3()+"");
				}
				if(listall.get(z).getMonth4()!=null){
					m4=Integer.parseInt(listall.get(z).getMonth4()+"");
				}
				if(listall.get(z).getMonth5()!=null){
					m5=Integer.parseInt(listall.get(z).getMonth5()+"");
				}
				if(listall.get(z).getMonth6()!=null){
					m6=Integer.parseInt(listall.get(z).getMonth6()+"");
				}
				if(listall.get(z).getMonth7()!=null){
					m7=Integer.parseInt(listall.get(z).getMonth7()+"");
				}
				if(listall.get(z).getMonth8()!=null){
					m8=Integer.parseInt(listall.get(z).getMonth8()+"");
				}
				if(listall.get(z).getMonth9()!=null){
					m9=Integer.parseInt(listall.get(z).getMonth9()+"");
				}
				if(listall.get(z).getMonth10()!=null){
					m10=Integer.parseInt(listall.get(z).getMonth10()+"");
				}
				if(listall.get(z).getMonth11()!=null){
					m11=Integer.parseInt(listall.get(z).getMonth11()+"");
				}
				if(listall.get(z).getMonth12()!=null){
					m12=Integer.parseInt(listall.get(z).getMonth12()+"");
				}
				listall.get(z).setCountAll(new BigDecimal((m1+m2+m3+m4+m5+m6+m7+m8+m9+m10+m11+m12)));
				ms1=ms1+m1;
				ms2=ms2+m2;
				ms3=ms3+m3;
				ms4=ms4+m4;
				ms5=ms5+m5;
				ms6=ms6+m6;
				ms7=ms7+m7;
				ms8=ms8+m8;
				ms9=ms9+m9;
				ms10=ms10+m10;
				ms11=ms11+m11;
				ms12=ms12+m12;
				m1=0;m2=0;m3=0;m4=0;m5=0;m6=0;m7=0;m8=0;m9=0;m10=0;m11=0;m12=0;
			}
			lastram.setMonth1(new BigDecimal(ms1));
			lastram.setMonth2(new BigDecimal(ms2));
			lastram.setMonth3(new BigDecimal(ms3));
			lastram.setMonth4(new BigDecimal(ms4));
			lastram.setMonth5(new BigDecimal(ms5));
			lastram.setMonth6(new BigDecimal(ms6));
			lastram.setMonth7(new BigDecimal(ms7));
			lastram.setMonth8(new BigDecimal(ms8));
			lastram.setMonth9(new BigDecimal(ms9));
			lastram.setMonth10(new BigDecimal(ms10));
			lastram.setMonth11(new BigDecimal(ms11));
			lastram.setMonth12(new BigDecimal(ms12));
			listall.add(lastram);
			return listall;
		}
		return null;
	}

	public void callproduce(EasyUIAccept accept){
		System.out.println(accept);
		if(accept!=null){
			if(accept.getInt2().equals(accept.getInt4())){
				int ct = accept.getInt5()-accept.getInt3();
				for (int i = 0; i <= ct; i++) {
					accept.setStr3(accept.getInt2()+"-"+(accept.getInt3()+i));
					accept.setDate3(DateTimeHelper.getmonthStart(accept.getInt2(), (accept.getInt3()+i)));
					accept.setDate4(DateTimeHelper.getmonthStart(accept.getInt2(), (accept.getInt3()+1+i)));
					reportMonthMapper.callproduce(accept);
				}
			}
		}
			
	}
	
	public int queryislive(EasyUIAccept accept) {
		return reportMonthMapper.queryislive(accept);
	}
}
