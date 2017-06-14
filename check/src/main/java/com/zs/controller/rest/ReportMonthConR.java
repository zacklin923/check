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
				//这里还有问题
//				reportMonthSer.callproduce(accept);
				return new Result<String>("success", Code.SUCCESS, "成功刷新所选时间段的数据");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "刷新失败");
			}
		}
		return null;
	}


	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
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
		str = str + "{field:'countAll',title:'6月',width:40,align:'right'},";
		str=str.substring(0, str.length()-1);
		return new Result<String>("success", Code.SUCCESS, str);
	}

}
