package com.zs.controller.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.UserSer;
import com.zs.tools.ColumnName;

@RestController
@RequestMapping("/api/user")
public class UserConR extends BaseRestController<StaffUser>{

	@Resource
	private UserSer userSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return userSer.queryFenye(accept);
		}
		return null;
	}

	@Override
	public Result<StaffUser> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@Override
	public Result<Integer> doAdd(StaffUser obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, userSer.add(obj));
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Override
	public Result<Integer> doUpdate(StaffUser obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, userSer.update(obj));
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteFalse(@PathVariable("id")String id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null&&!id.equals("")){
			return new Result<Integer>(SUCCESS,  Code.SUCCESS, userSer.delete(id));
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteTrue(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
