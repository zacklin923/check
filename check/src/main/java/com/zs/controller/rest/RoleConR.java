package com.zs.controller.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zs.entity.StaffRole;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.RoleSer;
import com.zs.tools.ColumnName;

@RestController
@RequestMapping("/api/role")
public class RoleConR extends BaseRestController<StaffRole>{

	@Resource
	private RoleSer roleSer;
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return roleSer.queryFenye(accept);
		}
		return null;
	}

	@Override
	public Result<StaffRole> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	@Override
	public Result<Integer> doAdd(StaffRole obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, roleSer.add(obj));
		}
		return new Result<Integer>(SUCCESS,  Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Override
	public Result<Integer> doUpdate(StaffRole obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, roleSer.update(obj));
		}
		return new Result<Integer>(SUCCESS,  Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteFalse(@PathVariable("id")String id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null&&!id.equals("")){
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, roleSer.delete(id));
		}
		return new Result<Integer>(SUCCESS,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteTrue(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<StaffRole> queryAll(){
		return roleSer.queryAll();
	}
	
}
