package com.zs.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.Customer;
import com.zs.entity.StaffRole;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.CustomerSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/customer")
public class CustomerConR extends BaseRestController<Customer,String>{

	@Resource
	private CustomerSer customerSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return customerSer.queryFenye(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public Result<Customer> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	@Override
	public Result<Integer> doAdd(Customer obj, HttpServletRequest req, HttpServletResponse resp) {
		if (obj!=null) {
			try {
				return new Result<Integer>(SUCCESS, Code.SUCCESS, customerSer.add(obj)); 
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@Override
	public Result<Integer> doUpdate(Customer obj, HttpServletRequest req, HttpServletResponse resp) {
		if (obj!=null) {
			try {
				return new Result<Integer>(SUCCESS, Code.SUCCESS, customerSer.update(obj));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteTrue(@PathVariable("id") String id, HttpServletRequest req, HttpServletResponse resp) {
		if (id!=null) {
			try {
				return new Result<Integer>(SUCCESS, Code.SUCCESS, customerSer.delete(id));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/import",method=RequestMethod.POST)
	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		if (!file.isEmpty()) {
			try {
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				customerSer.importData(list,null);
				return new Result<String>(SUCCESS,  Code.SUCCESS, null);
			} catch (IOException e) {
				return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
			}
		}
		return new Result<String>(ERROR,  Code.ERROR, null);
	}
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public EasyUIPage quertAll(EasyUIAccept accept){
		if (accept!=null) {
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return customerSer.queryFenye(accept);
		}
		return null;
	}

}
