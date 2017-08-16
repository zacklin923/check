package com.zs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.ReportSignBean;

public interface ReportSignSer{
	public String exportData(EasyUIAccept accept,HttpServletRequest req);
	public String obtainReportSign(EasyUIAccept accept);
	public List<ReportSignBean> obtainOfProvince(EasyUIAccept accept);
	public List<ReportSignBean> obtainOfCtm(EasyUIAccept accept);
	public List<ReportSignBean> obtainOfSum(EasyUIAccept accept);
}
