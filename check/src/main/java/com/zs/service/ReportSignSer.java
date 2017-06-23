package com.zs.service;

import java.util.Date;
import java.util.List;

import com.zs.entity.ReportSign;
import com.zs.entity.ReportSignKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.ReportSignBean;

public interface ReportSignSer extends BaseServiceExcel<ReportSign, ReportSignKey>{
	
	
	public void obtainReportSign(String date,String ctmBarCode,String province);
	public void obtainReportSignUpdate();
	
	public List<ReportSignBean> obtainOfCtmAndProvince(EasyUIAccept accept);
	public List<ReportSignBean> obtainOfCtm(EasyUIAccept accept);
	public List<ReportSignBean> obtainOfSum(EasyUIAccept accept);
}
