package com.zs.controller.rest;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.PrimeCodeReport;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.CheckLogSer;
import com.zs.service.PrimeCodeImportSer;
import com.zs.tools.BatchString;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;


@RestController
@RequestMapping("/api/primeCodeImport")
public class PrimeCodeImportConR{

	@Resource
	PrimeCodeImportSer primeCodeImportSer;
	@Resource
	private CheckLogSer	checkLogSer;
	private Gson g = new Gson();
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Result<EasyUIPage> doQuery(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				//处理批量查询推过来的字符串
				if(accept.getStr3()!=null){
					accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
				}
				if(accept.getStr4()!=null){
					accept.setStr4(BatchString.oldbatchstr(accept.getStr4()));
				}
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<EasyUIPage>("success",Code.SUCCESS,primeCodeImportSer.queryFenye(accept));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<EasyUIPage>("error",Code.ERROR,null);
			}
	}


	@RequestMapping(value="",method=RequestMethod.PUT)
	public Result<String> doUpdate(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				PrimeCodeReport obj = g.fromJson(data, PrimeCodeReport.class);
//				PrimeCodeReport ols = primeCodeImportSer.get(obj.getId()+"");
				Integer i = primeCodeImportSer.update(obj);
//				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
//				CheckLog clog = new CheckLog(null, obj.getId()+"", null, "prime_code_import",new Gson().toJson(ols) , null,user.getStuNum() , "修改单条");
//				checkLogSer.add(clog);
				return new Result<String>("success",  Code.SUCCESS, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error",  Code.ERROR, "修改失败");
			}
	}


	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<String> doDeleteTrue(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				primeCodeImportSer.delete(accept.getId());
//				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
//				CheckLog clog = new CheckLog(null, accept.getId(), null, "prime_code_import",new Gson().toJson(ols) , null,user.getStuNum() , "删除单条");
//				checkLogSer.add(clog);
				return new Result<String>("success",  Code.SUCCESS, "删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "删除失败");
			}
	}
	
	@RequestMapping(value="/exportExceltest",method=RequestMethod.GET)
	public Result<String> excelExport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				//处理批量查询推过来的字符串
				System.out.println(accept);
				if(accept.getStr3()!=null){
					accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
				}
				if(accept.getStr4()!=null){
					accept.setStr4(BatchString.oldbatchstr(accept.getStr4()));
				}
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>("success",  Code.SUCCESS, primeCodeImportSer.exportDataImport(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "数据装载失败");
			}
	}
	
	@RequestMapping(value="/exportExcelCollect",method=RequestMethod.GET)
	public Result<String> excelExportCollect(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>("success",  Code.SUCCESS, primeCodeImportSer.exportDataCollect(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "数据装载失败");
			}
	}
	
	@RequestMapping(value="/exportExcelPersonle",method=RequestMethod.GET)
	public Result<String> excelExportPersonle(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				//处理批量查询推过来的字符串
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				if(accept.getStr1()!=null){
					accept.setStr1(BatchString.oldbatchstr(accept.getStr1()));
				}
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>("success",  Code.SUCCESS, primeCodeImportSer.exportDataPersonle(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>("error", Code.ERROR, "数据装载失败");
			}
	}

	@RequestMapping(value="/import",method=RequestMethod.POST)
	public Result<String> excelImport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		String s ="";
		String filename =data.substring(data.lastIndexOf("\\"));
		try {
			File file = new File(data);
			InputStream ins = new FileInputStream(file);
			List<String[]> list = ExcelImport.getDataFromExcel2(filename, ins);
			s=primeCodeImportSer.importData(list,uid);
			return new Result<String>("success",  Code.SUCCESS, s);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>("success",  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
		} 
	}

	
	
	@RequestMapping(value="/collect",method=RequestMethod.GET)
	public Result<EasyUIPage> queryCollect(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				return new Result<EasyUIPage>("success",Code.SUCCESS,primeCodeImportSer.queryCollect(accept));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<EasyUIPage>("error",Code.ERROR,null);
			}

	}
	
	@RequestMapping(value="/personle",method=RequestMethod.GET)
	public Result<EasyUIPage> queryPer(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
				if(accept.getStr1()!=null){
					accept.setStr1(BatchString.oldbatchstr(accept.getStr1()));
				}
				return new Result<EasyUIPage>("success",Code.SUCCESS,primeCodeImportSer.querPer(accept));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<EasyUIPage>("error",Code.ERROR,null);
			}
	}


}
