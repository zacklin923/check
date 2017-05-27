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

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.SourceZmSer;
import com.zs.tools.ColumnName;
import com.zs.tools.DateTimeHelper;
import com.zs.tools.ExcelImport;
import com.zs.tools.ManagerId;

@RestController
@RequestMapping("/api/sourceZm")
public class SourceZmConR extends BaseRestController<SourceZm, String[]>{

	@Resource
	private SourceZmSer sourceZmSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(accept);
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return sourceZmSer.queryFenye(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public Result<SourceZm> doGet(String[] id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	@Override
	public Result<Integer> doAdd(SourceZm obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceZmSer.add(obj));
			} catch (Exception e) {
				return new Result<Integer>(ERROR,  Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doUpdate(SourceZm obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result<Integer> doUpdate(@PathVariable("id") String[] id, SourceZm obj, HttpServletRequest req, HttpServletResponse resp){
		StaffUser user=(StaffUser) req.getSession().getAttribute("user");
		try {
			if(obj!=null){
				obj.setCourierNumber(id[0]);
				obj.setReturnDate(new Date(Long.valueOf(id[1])));
				try {
					//-------判断下省份到底改了没-------------
					SourceZm sourceZm=sourceZmSer.get(new SourceZmKey(id[0], new Date(Long.valueOf(id[1]))));
					if ((sourceZm.getProvince()!=null && obj.getProvince()!=null && sourceZm.getProvince().equals(obj.getProvince()))
							|| (sourceZm.getProvince()==null && obj.getProvince()==null)) {
						obj.setProvince(null);
					}
					return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceZmSer.update(obj,user.getStuNum()));
				} catch (Exception e) {
					e.printStackTrace();
					return new Result<Integer>(ERROR, Code.ERROR, -1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteFalse(String[] id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteTrue(@PathVariable("id") String[] id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null && !id[0].equals("") && !id[1].equals("")){
			try {
				SourceZmKey szk = new SourceZmKey(id[0],new Date(Long.valueOf(id[1])));
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceZmSer.delete(szk));
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}
	
	
	@RequestMapping(value="/exportExcel",method=RequestMethod.GET)
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, sourceZmSer.ExportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
		}
		return null;
	}

	@RequestMapping(value="/import",method=RequestMethod.POST)
	@Override
	public Result<String> excelImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("isLoading", true);
		StaffUser user=(StaffUser) req.getSession().getAttribute("user");
		String s ="";
		if (!file.isEmpty()) {
			try {
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				s = s + sourceZmSer.importData(list,user.getStuNum());
				if(s.equals("")){
					req.getSession().setAttribute("isLoading", false);
					return new Result<String>(SUCCESS,  Code.SUCCESS, s);
				}
			} catch (IOException e) {
				req.getSession().setAttribute("isLoading", false);
				return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
			}
		}
		req.getSession().setAttribute("isLoading", false);
		return new Result<String>(ERROR,  Code.ERROR, s);
	}

	/**
	 * 是：有异常
	 * 否：无异常
	 * @return
	 */
	@RequestMapping(value="/isLoading",method=RequestMethod.GET)
	private boolean isUnusual(HttpServletRequest req){
		Object isUal=req.getSession().getAttribute("isLoading");
		if (isUal==null) {
		}else{
			if ((Boolean)isUal) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping(value="/{number}/history",method=RequestMethod.GET)
	public List<SourceThirdParty> queryHistory(@PathVariable("number") String number,EasyUIAccept accept) {
		if (number!=null && accept!=null) {
			try {
				accept.setStr1(number);
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return sourceZmSer.queryHistory(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

}
