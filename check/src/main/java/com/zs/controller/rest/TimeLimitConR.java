package com.zs.controller.rest;

import java.math.BigDecimal;
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
import com.zs.entity.TimeLimit;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.TimeLimitSer;
import com.zs.tools.ColumnName;

@RestController
@RequestMapping("/api/timeLimit")
public class TimeLimitConR extends BaseRestController<TimeLimit,BigDecimal>{

	@Resource
	private TimeLimitSer timeLimitSer;
	private Gson g = new Gson();
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Result<EasyUIPage> doQuery(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<EasyUIPage>(SUCCESS,Code.SUCCESS,timeLimitSer.queryFenye(accept));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
			}
	}

	@Override
	public Result<TimeLimit> doGet(BigDecimal id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public Result<String> doAdd(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				TimeLimit obj = g.fromJson(data, TimeLimit.class);
				timeLimitSer.add(obj);
				return new Result<String>(SUCCESS,  Code.SUCCESS,"添加成功" );
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "添加失败");
			}
	}

	@RequestMapping(value="",method=RequestMethod.PUT)
	public Result<String> doUpdate(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				TimeLimit obj = g.fromJson(data, TimeLimit.class);
				timeLimitSer.update(obj);
				return new Result<String>(SUCCESS,  Code.SUCCESS, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "修改失败");
			}
	}

	@Override
	public Result<Integer> doDeleteFalse(BigDecimal id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<String> doDeleteTrue(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				if(accept.getId()!=null&&!accept.getId().equals("")){
					timeLimitSer.delete(new BigDecimal(accept.getId()));
					return new Result<String>(SUCCESS,  Code.SUCCESS, "删除成功");
				}else{
					return new Result<String>(ERROR, Code.ERROR, "主键为空");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "删除失败");
			}
	}

	@RequestMapping(value="/excelExport",method=RequestMethod.GET)
	public Result<String> excelExport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
//				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, timeLimitSer.exportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
	}

	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(TimeLimit obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(TimeLimit obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteTrue(BigDecimal id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}



}
