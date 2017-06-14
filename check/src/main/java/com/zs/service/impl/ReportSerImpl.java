package com.zs.service.impl;



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zs.dao.ReportDataMapper;
import com.zs.entity.ReportData;
import com.zs.entity.other.EasyUIAccept;
import com.zs.service.ReportSer;
import com.zs.tools.DateTimeHelper;


@Service("reportSer")
public class ReportSerImpl implements ReportSer{

	@Resource
	private ReportDataMapper reportDataMapper;

	public List query(EasyUIAccept accept) {
		if(accept!=null){
			accept.setDate2(DateTimeHelper.getstartdate8(accept.getDate1()));
		}
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

	public void callproduce(EasyUIAccept accept){
		if(accept!=null){
			if(accept.getDate1()!=null){
				accept.setDate3(DateTimeHelper.getstartdate8(accept.getDate1()));
				accept.setDate4(DateTimeHelper.getenddate8(accept.getDate1()));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				System.out.println(accept.getDate3().toLocaleString());
				System.out.println(accept.getDate4().toLocaleString());
				System.out.println(sdf.format(accept.getDate3()));
				reportDataMapper.callproduce(accept);
			}
		}
	}
}
