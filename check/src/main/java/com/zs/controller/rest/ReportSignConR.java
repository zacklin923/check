package com.zs.controller.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.ReportSign;
import com.zs.entity.ReportSignKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.ReportSignBean;
import com.zs.entity.other.Result;
import com.zs.service.ReportSignSer;
import com.zs.service.ZmReturnDataSer;
import com.zs.tools.ColumnName;

@RestController
public class ReportSignConR extends BaseRestController<ReportSign, ReportSignKey>{

	private Logger log=Logger.getLogger(getClass());
	@Resource
	private ReportSignSer reportSignSer;
	
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="/api/reportSign",method=RequestMethod.GET)
	public List<ReportSignBean> query(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp){
		List<ReportSignBean> list=null;
		if (accept!=null && accept.getInt1()!=null) {
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			switch (accept.getInt1()) {
			case 1://客户+省份
				list=reportSignSer.obtainOfCtmAndProvince(accept);
				break;
			case 2://客户
				list=reportSignSer.obtainOfCtm(accept);
				break;
			case 3://总
				list=reportSignSer.obtainOfSum(accept);
				break;
			default://默认走客户+省份
				list=reportSignSer.obtainOfCtmAndProvince(accept);
				break;
			}
		}
		return list;
	}
	
	@Override
	public Result<ReportSign> doGet(ReportSignKey id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(ReportSign obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(ReportSign obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteFalse(ReportSignKey id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteTrue(ReportSignKey id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/api/reportSign/excelExport",method=RequestMethod.GET)
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, reportSignSer.exportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
		}
		return null;
	}

	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/api/reportSign/regenerate",method=RequestMethod.POST)
	public Result<String> regenerate(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp){
		if (accept!=null) {
			try {
				Date d1=new Date();
				String str="";
				if (accept.getDate1()!=null && accept.getDate2()!=null) {
					long days=(accept.getDate2().getTime()-accept.getDate1().getTime())/(1000*3600*24);
					Calendar calendar=Calendar.getInstance();
					calendar.setTime(accept.getDate1());
					calendar.set(Calendar.HOUR, 0);
					calendar.set(Calendar.MINUTE, 0);
					calendar.set(Calendar.SECOND, 0);
					calendar.set(Calendar.MILLISECOND, 0);
					System.out.println(calendar.getTime().toLocaleString());
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					for (int i = 0; i <= days; i++) {
						calendar.add(Calendar.DATE, i);
						String date=sdf.format(calendar.getTime());
						str=str+date+",";
						reportSignSer.obtainReportSign(date, null, null);
					}
				}
				Date d2=new Date();
				String s="重新计算["+str+"]这些天的数据，耗时["+(d2.getTime()-d1.getTime())+"ms。]";
				return new Result<String>(SUCCESS, Code.SUCCESS, s);
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "-1");
			}
		}
		return new Result<String>(ERROR, Code.ERROR, null);
	}
	
	
}
