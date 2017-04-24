package com.zs.controller.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		log.info("aaaaaaaa");
		if (accept!=null) {
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
		}
		return roleSer.queryFenye(accept);
	}

	@Override
	public Result<StaffRole> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	@Override
	public Result<Integer> doAdd(StaffRole obj, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("---进入添加方法");
		log.info(obj.getStrName());
		log.info(obj.getPowers());
		log.info(obj.getStrDesc());
		return new Result<Integer>(ERROR,  Code.ERROR, 1);
	}

	@Override
	public Result<Integer> doUpdate(StaffRole obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
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
