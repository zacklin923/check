package com.zs.controller.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zs.entity.StaffUser;
import com.zs.entity.VersionUpdate;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.VersionSer;

@RestController
@RequestMapping("/api/version")
public class VersionConR extends BaseRestController<VersionUpdate, String>{

	@Resource
	private VersionSer versionSer;
	
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<VersionUpdate> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(VersionUpdate obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(VersionUpdate obj, HttpServletRequest req, HttpServletResponse resp) {
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

	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/last")
	public VersionUpdate last(HttpServletRequest req, HttpServletResponse resp){
		StaffUser user=(StaffUser) req.getSession().getAttribute("user");
		if (user!=null) {
			VersionUpdate vu=versionSer.last();
			if (vu!=null){
				if(vu.getVerStuNums()!=null && !(","+vu.getVerStuNums()+",").contains(","+user.getStuNum()+",")){//不包含，即该用户没有看
					return vu;
				}else if(vu.getVerStuNums()==null){
					return vu;
				}
			}
		}
		return null;
	}
	
	@RequestMapping("/last/read")
	public VersionUpdate lastRead(HttpServletRequest req, HttpServletResponse resp){
		StaffUser user=(StaffUser) req.getSession().getAttribute("user");
		if (user!=null) {
			versionSer.read(user.getStuNum());
		}
		return null;
	}

}
