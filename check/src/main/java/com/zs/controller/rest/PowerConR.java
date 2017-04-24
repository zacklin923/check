package com.zs.controller.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.StaffPower;
import com.zs.entity.StaffRole;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.PowerSer;
import com.zs.tools.ColumnName;

@RestController
@RequestMapping("/api/power")
public class PowerConR extends BaseRestController<StaffPower>{

	@Resource
	private PowerSer powerSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return powerSer.queryFenye(accept);
		}
		return null;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public EasyUIPage doQuery(HttpServletRequest req, HttpServletResponse resp) {
		return powerSer.queryFenye();
	}
	

	@Override
	public Result<StaffPower> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	@Override
	public Result<Integer> doAdd(StaffPower obj, HttpServletRequest req, HttpServletResponse resp) {
		if (obj!=null) {
			return new Result<Integer>(SUCCESS, Code.SUCCESS, powerSer.add(obj));
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Override
	public Result<Integer> doUpdate(StaffPower obj, HttpServletRequest req, HttpServletResponse resp) {
		if (obj!=null) {
			return new Result<Integer>(SUCCESS, Code.SUCCESS, powerSer.update(obj));
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteTrue(@PathVariable("id")String id, HttpServletRequest req, HttpServletResponse resp) {
		if (id!=null) {
			return new Result<Integer>(SUCCESS, Code.SUCCESS, powerSer.delete(id));
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

}
