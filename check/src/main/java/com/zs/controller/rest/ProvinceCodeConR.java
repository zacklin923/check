package com.zs.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.ProvinceCode;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.ProvinceCodeSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/provinceCode")
public class ProvinceCodeConR extends BaseRestController<ProvinceCode, String>{

	@Resource
	private ProvinceCodeSer provinceCodeSer;
	private Logger log=Logger.getLogger(getClass());
	private Gson g = new Gson();
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Result<EasyUIPage> doQuery(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				System.out.println(accept);
				if(accept!=null){
					accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				}
				return new Result<EasyUIPage>(SUCCESS,Code.SUCCESS,provinceCodeSer.queryFenye(accept));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
			}
	}

	@Override
	public Result<ProvinceCode> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public Result<String> doAdd(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				ProvinceCode obj = g.fromJson(data, ProvinceCode.class);
				provinceCodeSer.add(obj);
				return new Result<String>(SUCCESS, Code.SUCCESS,"添加成功" );
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "添加失败");
			}
	}

	@RequestMapping(value="",method=RequestMethod.PUT)
	public Result<String> doUpdate(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				ProvinceCode obj = g.fromJson(data, ProvinceCode.class);
				provinceCodeSer.update(obj);
				return new Result<String>(SUCCESS, Code.SUCCESS,"修改成功" );
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "修改失败");
			}
	}

	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.DELETE)
	public Result<String> doDeleteTrue(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				provinceCodeSer.delete(accept.getId());
				return new Result<String>(SUCCESS, Code.SUCCESS, "删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "删除失败");
			}
	}
	@RequestMapping(value="/excelExport",method=RequestMethod.GET)
	public Result<String> excelExport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				if(accept!=null){
					accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				}
				return new Result<String>(SUCCESS,  Code.SUCCESS, provinceCodeSer.exportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
	}

	@RequestMapping(value="/import",method=RequestMethod.POST)
	public Result<String> excelImport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		String s ="";
		String filename =data.substring(data.lastIndexOf("\\"));
		try {
			File file = new File(data);
			InputStream ins = new FileInputStream(file);
			List<String[]> list = ExcelImport.getDataFromExcel2(filename, ins);
			s=provinceCodeSer.importData(list,uid);
			return new Result<String>(SUCCESS,  Code.SUCCESS, s);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
		} 
	}

	
	@RequestMapping(value="/province",method=RequestMethod.GET)
	public List<String> autoComplete(String keyword) {
		if (keyword!=null) {
			return provinceCodeSer.selectProvince(keyword);
		}
		return null;
	}

	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(ProvinceCode obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(ProvinceCode obj, HttpServletRequest req, HttpServletResponse resp) {
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
}
