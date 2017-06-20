package com.zs.controller.rest;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.CheckLog;
import com.zs.entity.PrimeCodeReport;
import com.zs.entity.SourceImport;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.PrimeCodeCollect;
import com.zs.entity.other.Result;
import com.zs.service.CheckLogSer;
import com.zs.service.PrimeCodeImportSer;
import com.zs.tools.BatchString;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;


@RestController
@RequestMapping("/api/primeCodeImport")
public class PrimeCodeImportConR extends BaseRestController<PrimeCodeReport,String>{

	@Resource
	PrimeCodeImportSer primeCodeImportSer;
	@Resource
	private CheckLogSer	checkLogSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				//处理批量查询推过来的字符串
				if(accept.getStr3()!=null){
					accept.setStr3(BatchString.batchstr(accept.getStr3()));
				}
				if(accept.getStr4()!=null){
					accept.setStr4(BatchString.batchstr(accept.getStr4()));
				}
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return primeCodeImportSer.queryFenye(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public Result<PrimeCodeReport> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(PrimeCodeReport obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(PrimeCodeReport obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteTrue(@PathVariable("id") String id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null&&!id.equals("")){
			try {
				PrimeCodeReport ols = primeCodeImportSer.get(id);
				Integer i = primeCodeImportSer.delete(id);
				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
				CheckLog clog = new CheckLog(null, id, null, "prime_code_import",new Gson().toJson(ols) , null,user.getStuNum() , "删除单条");
				checkLogSer.add(clog);
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, i);
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/import",method=RequestMethod.POST)
	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("isLoading", true);
		String s ="";
		if (!file.isEmpty()) {
			try {
				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				s=primeCodeImportSer.importData(list,user.getStuNum());
				req.getSession().setAttribute("isLoading", false);
				return new Result<String>(SUCCESS,  Code.SUCCESS, s);
			} catch (IOException e) {
				req.getSession().setAttribute("isLoading", false);
				return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
			}
		}
		req.getSession().setAttribute("isLoading", false);
		return new Result<String>(ERROR,  Code.ERROR, s);
	}

	/**
	 * 是：有异常
	 * 否：无异常
	 * @return
	 */
	@RequestMapping(value="/isLoading",method=RequestMethod.GET)
	private boolean isUnusual(HttpServletRequest req){
		Object isUal=req.getSession().getAttribute("isLoading");
		if (isUal==null) {
		}else{
			if ((Boolean)isUal) {
				return true;
			}
		}
		return false;
	}
	
	
	@RequestMapping(value="/collect",method=RequestMethod.GET)
	public EasyUIPage queryCollect(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				return primeCodeImportSer.queryCollect(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/personle",method=RequestMethod.GET)
	public EasyUIPage queryPer(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				return primeCodeImportSer.querPer(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}


}
