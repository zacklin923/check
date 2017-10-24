package com.zs.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.zs.entity.ZmReturnData;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.CheckLogSer;
import com.zs.service.NoUpdateSer;
import com.zs.service.ZmReturnDataSer;
import com.zs.tools.BatchString;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/zmReturnData")
public class ZmReturnDataConR extends BaseRestController<ZmReturnData, String>{

	@Resource
	private ZmReturnDataSer zmReturnDataSer;
	@Resource
	private CheckLogSer	checkLogSer;
	@Resource
	private NoUpdateSer noUpdateSer;
	private Logger log=Logger.getLogger(getClass());
	private Gson g = new Gson();
	
	
	@Override
	@RequestMapping(value="",method=RequestMethod.POST)
	public Result<Integer> doAdd(ZmReturnData obj, HttpServletRequest req, HttpServletResponse resp) {
		if(obj!=null){
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, zmReturnDataSer.add(obj,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR,  Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}
	@RequestMapping(value="",method=RequestMethod.PUT)
	public Result<String> doUpdate(String uid,String data, HttpServletRequest req, HttpServletResponse resp){
		ZmReturnData obj = g.fromJson(data, ZmReturnData.class);
		try {
			if(obj!=null){
				zmReturnDataSer.update(obj,uid);
				return new Result<String>(SUCCESS,  Code.SUCCESS, "修改成功");
			}else{
				return new Result<String>(ERROR,  Code.ERROR,"修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR,  Code.ERROR, obj.getCourierNumber()+"修改失败");
		}
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteTrue(@PathVariable("id") String id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null && !id.trim().equals("")){
			try {
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, zmReturnDataSer.delete(id,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}
	/**
	 * 是：有异常
	 * 否：无异常
	 * @return
	 */
	@RequestMapping(value="/isLoading",method=RequestMethod.GET)
	public boolean isUnusual(HttpServletRequest req){
		Object isUal=req.getSession().getAttribute("isLoading");
		if (isUal==null) {
		}else{
			if ((Boolean)isUal) {
				return true;
			}
		}
		return false;
	}
	//---运单信息相关-------------------------------------
	@RequestMapping(value="/zm",method=RequestMethod.GET)
	public Result<EasyUIPage> doQueryOfZm(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			if(accept.getStr3()!=null){
				accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
			}
			if(accept.getStr2()!=null){
				accept.setStr2(BatchString.oldbatchstr(accept.getStr2()));
			}
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return new Result<EasyUIPage>(SUCCESS,  Code.SUCCESS, zmReturnDataSer.queryFenyeOfZm(accept,req));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
		}
	}
	@RequestMapping(value="/zm/exportExceltest",method=RequestMethod.GET)
	public Result<String> excelExporttestOfZm(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				if(accept.getStr3()!=null){
					accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
				}
				if(accept.getStr2()!=null){
					accept.setStr2(BatchString.oldbatchstr(accept.getStr2()));
				}
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, zmReturnDataSer.ExportDataOfZm(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
	}
	@RequestMapping(value="/zm/import",method=RequestMethod.POST)
	public Result<String> excelImportOfZm(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		String s ="";
		String filename =data.substring(data.lastIndexOf("\\"));
		try {
			File file = new File(data);
			InputStream ins = new FileInputStream(file);
			List<String[]> list = ExcelImport.getDataFromExcel2(filename, ins);
			s=zmReturnDataSer.importDatatestOfZm(list,uid);
			return new Result<String>(SUCCESS,  Code.SUCCESS, s);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
		} 
	}
	//---运单状态相关-------------------------------------
	@RequestMapping(value="/tp",method=RequestMethod.GET)
	public Result<EasyUIPage> doQueryOfTp(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			if(accept.getStr3()!=null){
				accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
			}
			if(accept.getStr4()!=null){
				accept.setStr4(BatchString.oldbatchstr(accept.getStr4()));
			}
			if(accept.getStr2()!=null){
				accept.setStr2(BatchString.batchstr(accept.getStr2()));
			}
			if(accept.getStr16()!=null){
				if(accept.getStr16().equals("0")){
					accept.setStr16(null);
				}
			}
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return new Result<EasyUIPage>(SUCCESS,  Code.SUCCESS, zmReturnDataSer.queryFenyeOfTp(accept,req));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
		}
	}
	@RequestMapping(value="/tp/exportExceltest",method=RequestMethod.GET)
	public Result<String> excelExporttestOfTp(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			if(accept.getStr2()!=null&&!accept.getStr2().equals("")){
				accept.setStr2(BatchString.batchstr(accept.getStr2()));
			}
			if(accept.getStr3()!=null&&!accept.getStr3().equals("")){
				accept.setStr3(BatchString.oldbatchstr(accept.getStr3()));
			}
			if(accept.getStr4()!=null&&!accept.getStr4().equals("")){
				accept.setStr4(BatchString.oldbatchstr(accept.getStr4()));
			}
			if(accept.getStr16()!=null){
				if(accept.getStr16().equals("0")){
					accept.setStr16(null);
				}
			}
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return new Result<String>(SUCCESS,  Code.SUCCESS, zmReturnDataSer.ExportDataOfTp(accept,req));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
		}
	}
	@RequestMapping(value="/tp/import",method=RequestMethod.POST)
	public Result<String> excelImportOfTp(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		String s ="";
		String filename =data.substring(data.lastIndexOf("\\"));
		try {
			File file = new File(data);
			InputStream ins = new FileInputStream(file);
			List<String[]> list = ExcelImport.getDataFromExcel2(filename, ins);
			s=zmReturnDataSer.importDataOfTp(list,uid);
			return new Result<String>(SUCCESS,  Code.SUCCESS, s);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
		} 
	}
	
	
	
	@RequestMapping(value="/tp/feeTimeImport",method=RequestMethod.POST)
	public Result<String> feeTimeImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		String s ="";
		if (!file.isEmpty()) {
			try {
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				s = s + zmReturnDataSer.feeTimeImport(list);
				if(!s.equals("")){
					return new Result<String>(SUCCESS,  Code.SUCCESS, s);
				}
			} catch (IOException e) {
				return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
			}
		}
		return new Result<String>(ERROR,  Code.ERROR, s);
	}
	
	
	@Deprecated
	@Override
	public Result<ZmReturnData> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	@Deprecated
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	@Deprecated
	@Override
	public Result<Integer> doDeleteFalse(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	@Deprecated
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	@Deprecated
	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	@Override
	public Result<Integer> doUpdate(ZmReturnData obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
