package com.zs.controller.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.Result;
import com.zs.service.ModuleLineSer;
import com.zs.service.ReportSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ManagerId;

@RestController
@RequestMapping("/api/reportDate")
public class ReportDateConR{

	@Resource
	private ReportSer reportSer;
	@Resource
	private ModuleLineSer moduleLineSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if(accept!=null){
			List list = reportSer.query(accept);
			return list;
		}
		return null;
	}

	@RequestMapping(value="/1",method=RequestMethod.GET)
	public Result<String> refrence(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp){
		if(accept!=null){
			try {
				reportSer.callproduce(accept);
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
//				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>("success",  Code.SUCCESS, reportSer.exportData(accept,req));
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
			   str= str+"{field:'ctmName',title:'客户名称',rowspan:2,width:40},"
					   +"{field:'ctmBarCode',title:'客户条码',rowspan:2,width:40},"
					   +"{field:'customType',title:'客户类型',rowspan:2,width:40},"
					   +"{field:'largeArea',title:'大区',rowspan:2,width:40},"
					   +"{field:'sliceArea',title:'区部',rowspan:2,width:40},"
					   +"{field:'fenBu',title:'分部',rowspan:2,width:40},"
					   +"{field:'countAll',title:'总计',rowspan:2,width:40,align:'right'},";
		}else if(accept.getInt1()==2){
			   str= str+"{field:'customType',title:'客户类型',rowspan:2,width:40},"
					   +"{field:'largeArea',title:'大区',rowspan:2,width:40},"
					   +"{field:'sliceArea',title:'区部',rowspan:2,width:40},"
					   +"{field:'fenBu',title:'分部',rowspan:2,width:40},"
					   +"{field:'countAll',title:'总计',rowspan:2,width:40,align:'right'},";
		}else if(accept.getInt1()==3){
			   str= str+"{field:'customType',title:'客户类型',rowspan:2,width:40},"
					   +"{field:'largeArea',title:'大区',rowspan:2,width:40},"
					   +"{field:'sliceArea',title:'区部',rowspan:2,width:40},"
					   +"{field:'countAll',title:'总计',rowspan:2,width:40,align:'right'},";
		}else if(accept.getInt1()==4){
			   str= str+"{field:'customType',title:'客户类型',rowspan:2,width:40},"
					   +"{field:'largeArea',title:'大区',rowspan:2,width:40},"
					   +"{field:'countAll',title:'总计',rowspan:2,width:40,align:'right'},";
		}
		str=str +"{title:'面单统计',width:120,colspan:3},";
		str=str.substring(0, str.length()-1);
		str=str+"_";
		str = str + "{field:'electronicSheet',title:'普件面单',width:40,align:'right'},"
				  +"{field:'genericSheet',title:'电子面单',width:40,align:'right'},"
				  +"{field:'otherSheet',title:'其他快递',width:40,align:'right'},";
		str=str.substring(0, str.length()-1);
		return new Result<String>("success", Code.SUCCESS, str);
	}

}
