package com.zs.controller.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.ReportSign;
import com.zs.entity.ReportSignKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.ReportSignBean;
import com.zs.entity.other.Result;
import com.zs.service.ReportSignSer;
import com.zs.tools.ColumnName;

@RestController
public class ReportSignConR {

	private Logger log=Logger.getLogger(getClass());
	@Resource
	private ReportSignSer reportSignSer;
	private Gson g = new Gson();

	@RequestMapping(value="/api/reportSign",method=RequestMethod.GET)
	public Result<List<ReportSignBean>> query(String uid,String data, HttpServletRequest req, HttpServletResponse resp){
		try {
			List<ReportSignBean> list=null; 
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
			if (accept!=null && accept.getInt1()!=null) {
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				switch (accept.getInt1()) {
				case 1://客户
					list=reportSignSer.obtainOfCtm(accept);
					break;
				case 2://省份
					list=reportSignSer.obtainOfProvince(accept);
					break;
				case 3://总
					list=reportSignSer.obtainOfSum(accept);
					break;
				default://默认走客户+省份
					list=reportSignSer.obtainOfProvince(accept);
					break;
				}
			}
			return new Result<List<ReportSignBean>>("success",Code.SUCCESS,list);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<List<ReportSignBean>>("error",Code.ERROR,null);
		}
	}
	
	@RequestMapping(value="/api/reportSign/regenerate",method=RequestMethod.POST)
	public Result<String> regenerate(String uid,String data, HttpServletRequest req, HttpServletResponse resp){
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
			return new Result<String>("success", Code.SUCCESS, reportSignSer.obtainReportSign(accept));
		}catch (Exception e) {
			e.printStackTrace();
			return new Result<String>("error", Code.ERROR, "刷新失败");
		}
	}
	
	@RequestMapping(value="/api/reportSign/excelExport",method=RequestMethod.GET)
	public Result<String> excelExport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>("success",  Code.SUCCESS, reportSignSer.exportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "数据装载失败");
			}
	}
	

	
	
}
