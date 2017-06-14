package com.zs.service.impl;



import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zs.dao.ReportMonthMapper;
import com.zs.entity.other.EasyUIAccept;
import com.zs.service.ReportMonthSer;
import com.zs.tools.DateTimeHelper;


@Service("reportMonthSer")
public class ReportMonthSerImpl implements ReportMonthSer{

	@Resource
	private ReportMonthMapper reportMonthMapper;

	public List query(EasyUIAccept accept) {
		if(accept!=null){
			accept.setDate2(accept.getDate1());
			accept.setDate3(DateTimeHelper.getenddate8(accept.getDate1()));
		}
		List list = reportMonthMapper.query(accept);
		return list;
	}

	//暂时出现问题
	public void callproduce(EasyUIAccept accept){
		if(accept!=null){
			if(accept.getDate1()!=null){
				accept.setDate3(DateTimeHelper.getstartdate8(accept.getDate1()));
				accept.setDate4(DateTimeHelper.getenddate8(accept.getDate1()));
				System.out.println(accept.getDate3());
				System.out.println(accept.getDate4());
				reportMonthMapper.callproduce(accept);
			}
		}
	}
}
