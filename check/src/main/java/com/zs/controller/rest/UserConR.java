package com.zs.controller.rest;

import java.io.IOException;
import java.util.Date;
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

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.UserSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/user")
public class UserConR extends BaseRestController<StaffUser,String>{

	@Resource
	private UserSer userSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return userSer.queryFenye(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
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
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, userSer.add(obj));
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Override
	public Result<Integer> doUpdate(StaffUser obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, userSer.update(obj));
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteFalse(@PathVariable("id")String id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null&&!id.equals("")){
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, userSer.delete(id));
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
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

	@RequestMapping("/file")
	@Override
	public Result<String> excelImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		if (!file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			try {
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list.get(i).length; j++) {
						System.out.print(list.get(i)[j]+" ");
					}
					System.out.println();
					StaffUser staffUser=new StaffUser();
					staffUser.setStuNum(list.get(i)[1].toString());
					staffUser.setStuName(list.get(i)[0].toString());
					staffUser.setPass("123456");
					userSer.add(staffUser);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
