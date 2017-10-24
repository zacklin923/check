package com.zs.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
import com.zs.entity.CheckLog;
import com.zs.entity.SourceImport;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.CheckLogSer;
import com.zs.service.SourceImportSer;
import com.zs.tools.BatchString;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/sourimport")
public class SourceImportConR extends BaseRestController<SourceImport,String>{

	@Resource
	private SourceImportSer sourceImportSer;
	@Resource
	private CheckLogSer	checkLogSer;
	private Gson g = new Gson();
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Result<EasyUIPage> doQuery(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			if(accept.getStr3()!=null&&!accept.getStr3().equals("")){
				accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
			}
			if(accept.getStr4()!=null&&!accept.getStr4().equals("")){
				accept.setStr4(BatchString.oldbatchstr(accept.getStr4()));
			}
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return new Result<EasyUIPage>(SUCCESS,Code.SUCCESS,sourceImportSer.queryFenye(accept));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
		}
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

	@RequestMapping(value="",method=RequestMethod.PUT)
	public Result<String> doUpdate(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				SourceImport obj = new Gson().fromJson(data, SourceImport.class);
				if(obj!=null){
					sourceImportSer.update(obj);
					//暂且先把大客户自带的日志表去掉
//					SourceImport ols = sourceImportSer.get(obj.getCourierNumber());
//					StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
//					CheckLog clog = new CheckLog(null, obj.getCourierNumber(), null, "source_import",new Gson().toJson(ols) , null,user.getStuNum() , "修改");
//					checkLogSer.add(clog);
					return new Result<String>(SUCCESS,  Code.SUCCESS, "");
				}else{
					return new Result<String>(ERROR,  Code.ERROR, null);
				}
			} catch (Exception e) {
				return new Result<String>(ERROR, Code.ERROR, "数据存储失败");
		}
	}

	
	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public Result<String> doDeleteTrue(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		if(data!=null&&!data.equals("")){
			try {
				EasyUIAccept accept = new Gson().fromJson(data,EasyUIAccept.class);
				if(accept!=null){
					if(accept.getStr1()!=null&&!accept.getStr1().equals("")){
						String str  = accept.getStr1().substring(0, accept.getStr1().length()-1);
						str = str.replace(",", "','");
						str = "'"+str+"'";
						sourceImportSer.delete(str);
						return new Result<String>(SUCCESS, Code.SUCCESS,"" );
					}
				}
//				SourceImport ols = sourceImportSer.get(id);
//				Integer i = sourceImportSer.delete(id);
//				StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
//				CheckLog clog = new CheckLog(null, id, null, "source_import",new Gson().toJson(ols) , null,user.getStuNum() , "删除单条");
//				checkLogSer.add(clog);
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, e.getMessage());
			}
		}
		return new Result<String>(ERROR, Code.ERROR, "对象为null");
	}

	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<String> doDeleteAll(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			if(uid!=null&&!uid.equals("")){
				sourceImportSer.deleteAll(uid);
	//			StaffUser user =  (StaffUser) req.getSession().getAttribute("user");
	//			CheckLog clog = new CheckLog(null, null, null, "source_import","删除了创建时间前的今天数据", null,user.getStuNum() , "删除今天数据");
	//			checkLogSer.add(clog);
				return new Result<String>(SUCCESS,  Code.SUCCESS, "已删除当前登陆者导入的信息");
			}else{
				return new Result<String>(ERROR, Code.ERROR, "不支持删除所有人数据");
			}
		} catch (Exception e) {
			return new Result<String>(ERROR, Code.ERROR, "删除所有数据失败");
		}
	}
	
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@RequestMapping(value="/import",method=RequestMethod.POST)
	public Result<String> excelImport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		String s ="";
		String filename =data.substring(data.lastIndexOf("\\"));
		try {
			File file = new File(data);
			InputStream ins = new FileInputStream(file);
			List<String[]> list = ExcelImport.getDataFromExcel2(filename, ins);
			s=sourceImportSer.importData(list,uid);
			return new Result<String>(SUCCESS,  Code.SUCCESS, s);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
		} 
	}
	
	/**
	 * 是：有异常
	 * 否：无异常
	 * @return
	 */
//	@RequestMapping(value="/isLoading",method=RequestMethod.GET)
//	private boolean isUnusual(HttpServletRequest req){
//		Object isUal=req.getSession().getAttribute("isLoading");
//		if (isUal==null) {
//		}else{
//			if ((Boolean)isUal) {
//				return true;
//			}
//		}
//		return false;
//	}

	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(SourceImport obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteTrue(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
