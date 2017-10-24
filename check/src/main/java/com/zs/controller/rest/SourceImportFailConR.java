package com.zs.controller.rest;


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
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.SourceImportFailSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ManagerId;

@RestController
@RequestMapping("/api/sourimportfail")
public class SourceImportFailConR extends BaseRestController<SourceImportFailed,String>{

	@Resource
	private SourceImportFailSer sourceImportFailSer;
	private Gson g = new Gson();

	@RequestMapping(value="",method=RequestMethod.GET)
	public Result<EasyUIPage> doQuery(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return new Result<EasyUIPage>(SUCCESS,Code.SUCCESS,sourceImportFailSer.queryFenye(accept));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
		}
	}

	@Override
	public Result<SourceImportFailed> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(SourceImportFailed obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(SourceImportFailed obj, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public Result<String> doDeleteFalse(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		if(data!=null&&!data.equals("")){
			try {
				EasyUIAccept accept = new Gson().fromJson(data,EasyUIAccept.class);
				if(accept!=null){
					if(accept.getStr1()!=null&&!accept.getStr1().equals("")){
						String str  = accept.getStr1().substring(0, accept.getStr1().length()-1);
						str = str.replace(",", "','");
						str = "'"+str+"'";
						sourceImportFailSer.delete(str);
						return new Result<String>(SUCCESS, Code.SUCCESS,"" );
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, e.getMessage());
			}
		}
		return new Result<String>(ERROR,  Code.ERROR, "删除多条失败");
	}

	@Override
	public Result<Integer> doDeleteTrue(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<String> doDeleteAll(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			if(uid!=null&&!uid.equals("")){
				sourceImportFailSer.deleteAll(uid);
				return new Result<String>(SUCCESS,  Code.SUCCESS, "已删除当前登陆者导入的信息");
			}else{
				return new Result<String>(ERROR, Code.ERROR, "不支持删除所有人数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR, Code.ERROR, "删除所有数据失败");
		}
	}
	
	@RequestMapping(value="/exportExcel",method=RequestMethod.GET)
	public Result<String> excelExport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class);
			System.out.println(accept);
			return new Result<String>(SUCCESS,  Code.SUCCESS, sourceImportFailSer.ExportData(accept,req));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
		}
	}
	
	
	@Override
	public Result<String> excelImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
