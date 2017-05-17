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

	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll2(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return sourceImportFailSer.queryFenye(accept);
			} catch (Exception e) {
				return null;
			}
		}
		return null;
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

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteFalse(@PathVariable("id") String id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null&&!id.equals("")){
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceImportFailSer.delete(id));
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteTrue(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<Integer> doDeleteAll( HttpServletRequest req, HttpServletResponse resp) {
		try {
			StaffUser user=(StaffUser) req.getSession().getAttribute("user");
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceImportFailSer.deleteAll(user.getStuNum()));
		} catch (Exception e) {
			return new Result<Integer>(ERROR, Code.ERROR, -1);
		}
	}
	
	@RequestMapping(value="/exportExcel",method=RequestMethod.GET)
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, sourceImportFailSer.ExportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
		}
		return null;
	}
	
	
	@Override
	public Result<String> excelImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	
}
