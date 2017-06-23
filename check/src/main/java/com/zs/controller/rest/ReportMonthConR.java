package com.zs.controller.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.Result;
import com.zs.service.ReportMonthSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ManagerId;

@RestController
@RequestMapping("/api/reportMonth")
public class ReportMonthConR{

	@Resource
	private ReportMonthSer reportMonthSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if(accept!=null){
			List list = reportMonthSer.query(accept);
			return list;
		}
		return null;
	}

	@RequestMapping(value="/1",method=RequestMethod.GET)
	public Result<String> refrence(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp){
		if(accept!=null){
			try {
				System.out.println("成功进入");
				reportMonthSer.callproduce(accept);
				return new Result<String>("success", Code.SUCCESS, "成功刷新所选时间段的数据");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "刷新失败");
			}
		}
		return null;
	}

	@RequestMapping(value="/exportExceltest",method=RequestMethod.GET)
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>("success",  Code.SUCCESS, reportMonthSer.exportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "数据装载失败");
			}
		}
		return null;
	}

	@RequestMapping(value="/style",method=RequestMethod.GET)
	public Result<String> personalStyle(EasyUIAccept accept,HttpServletRequest req, HttpServletResponse resp){
		String str="";
		if(accept.getInt1()==1){
			   str= str+"{field:'ctmName',title:'客户名称',width:40},"
					   +"{field:'ctmBarCode',title:'客户条码',width:40},"
					   +"{field:'ctmType',title:'客户类型',width:40},"
					   +"{field:'largeArea',title:'大区',width:40},"
					   +"{field:'sliceArea',title:'区部',width:40},"
					   +"{field:'fenBu',title:'分部',width:40},"
					   +"{field:'countAll',title:'总计',width:40,align:'right'},";
		}else if(accept.getInt1()==2){
			   str= str+"{field:'ctmType',title:'客户类型',width:40},"
					   +"{field:'largeArea',title:'大区',width:40},"
					   +"{field:'sliceArea',title:'区部',width:40},"
					   +"{field:'fenBu',title:'分部',width:40},"
					   +"{field:'countAll',title:'总计',width:40,align:'right'},";
		}else if(accept.getInt1()==3){
			   str= str+"{field:'ctmType',title:'客户类型',width:40},"
					   +"{field:'largeArea',title:'大区',width:40},"
					   +"{field:'sliceArea',title:'区部',width:40},"
					   +"{field:'countAll',title:'总计',width:40,align:'right'},";
		}else if(accept.getInt1()==4){
			   str= str+"{field:'ctmType',title:'客户类型',width:40},"
					   +"{field:'largeArea',title:'大区',width:40},"
					   +"{field:'countAll',title:'总计',width:40,align:'right'},";
		}
		if(accept.getInt2().equals(accept.getInt4())){
			int ct = accept.getInt5()-accept.getInt3();
			for (int i = 0; i <= ct; i++) {
				accept.setStr3(accept.getInt2()+"-"+(accept.getInt3()+i));
				if(reportMonthSer.queryislive(accept)>0){
					str = str + "{field:'month"+(i+1)+"',title:'"+accept.getInt2()+"年"+(accept.getInt3()+i)+"月',width:40,align:'right'},";
				}
			}
		}
		str=str.substring(0, str.length()-1);
		return new Result<String>("success", Code.SUCCESS, str);
	}

}
