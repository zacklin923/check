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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zs.entity.CheckLog;
import com.zs.entity.SourceImport;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.CheckLogSer;
import com.zs.service.SourceImportSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;
import com.zs.tools.ManagerId;

@RestController
@RequestMapping("/api/sourimport")
public class SourceImportConR extends BaseRestController<SourceImport,String>{

	@Resource
	private SourceImportSer sourceImportSer;
	@Resource
	private CheckLogSer	checkLogSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
//				accept.setStr1(ManagerId.isSeeAll2(req));
				if(accept.getStr3()!=null&&!accept.getStr3().equals("")){
					String [] ss = accept.getStr3().trim().split(",");
					String str="";
					for (int i = 0; i < ss.length; i++) {
						String strt=ss[i].trim();
						if(!strt.equals("")&&strt!=null){
							if(i!=ss.length-1){
								str=str+"'"+strt+"'"+",";
							}else{
								str=str+"'"+strt+"'";
							}
						}
					}
					if(str!=null&&!str.equals(",")){
						accept.setStr3(str);
					}
				}
				if(accept.getStr4()!=null&&!accept.getStr4().equals("")){
					String [] ss4 = accept.getStr4().trim().split(",");
					String str4="";
					for (int i = 0; i < ss4.length; i++) {
						String strt4=ss4[i].trim();
						if(!strt4.equals("")&&strt4!=null){
							if(i!=ss4.length-1){
								str4=str4+"'"+strt4+"'"+",";
							}else{
								str4=str4+"'"+strt4+"'";
							}
						}
					}
					if(str4!=null&&!str4.equals(",")){
						accept.setStr4(str4);
					}
				}
				accept.setDate1(ManagerId.getNow());
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return sourceImportSer.queryFenye(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public Result<SourceImport> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(SourceImport obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result<Integer> doUpdate(SourceImport obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			try {
				SourceImport ols = sourceImportSer.get(obj.getCourierNumber());
				Integer iu = sourceImportSer.update(obj);
				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
				CheckLog clog = new CheckLog(null, obj.getCourierNumber(), null, "source_import",new Gson().toJson(ols) , null,user.getStuNum() , "修改");
				checkLogSer.add(clog);
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, iu);
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
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
				SourceImport ols = sourceImportSer.get(id);
				Integer i = sourceImportSer.delete(id);
				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
				CheckLog clog = new CheckLog(null, id, null, "source_import",new Gson().toJson(ols) , null,user.getStuNum() , "删除单条");
				checkLogSer.add(clog);
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, i);
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<Integer> doDeleteAll( HttpServletRequest req, HttpServletResponse resp) {
		try {
			StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
			Integer i  = sourceImportSer.deleteAll(user.getStuNum());
			CheckLog clog = new CheckLog(null, null, null, "source_import","删除了创建时间前的今天数据", null,user.getStuNum() , "删除今天数据");
			checkLogSer.add(clog);
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, i);
		} catch (Exception e) {
			return new Result<Integer>(ERROR, Code.ERROR, -1);
		}
	}
	
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@RequestMapping(value="/import",method=RequestMethod.POST)
	@Override
	public Result<String> excelImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("isLoading", true);
		String s ="";
		if (!file.isEmpty()) {
			try {
				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				s=sourceImportSer.importData(list,user.getStuNum());
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

	@RequestMapping(value="/push",method=RequestMethod.GET)
	public Result<String> doPushToZm(HttpServletRequest req, HttpServletResponse resp) {
		try {
			StaffUser user=(StaffUser) req.getSession().getAttribute("user");
			return new Result<String>(SUCCESS, Code.SUCCESS, sourceImportSer.sendToZm(user.getStuNum()));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR, Code.ERROR, "-1");
		}
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
	
}
