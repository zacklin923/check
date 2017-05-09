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
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.SourceTpSer;
import com.zs.service.SourceZmSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;
import com.zs.tools.ManagerId;

@RestController
@RequestMapping("/api/sourceTp")
public class SourceTpConR extends BaseRestController<SourceThirdParty, String[]>{

	@Resource
	private SourceTpSer sourceTpSer;
	@Resource
	private SourceZmSer sourceZmSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return sourceTpSer.queryFenye(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public Result<SourceThirdParty> doGet(String[] id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(SourceThirdParty obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result<Integer> doUpdate(@PathVariable("id") String[] id,SourceThirdParty obj, HttpServletRequest req, HttpServletResponse resp) {
		try {
			if(obj!=null){
				obj.setCourierNumber(id[0]);
				obj.setReturnDate(new Date(Long.valueOf(id[1])));
				try {
					SourceZm sz = new SourceZm(obj.getCourierNumber(), obj.getReturnDate(), obj.getProvince(),obj.getAddress(), obj.getShopNumber(),obj.getAddressee(),obj.getPhone(), obj.getGoods(), obj.getGoodsCost(), obj.getOrderNumber());
					sourceZmSer.update(sz);
					return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceTpSer.update(obj));
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

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@Override
	public Result<Integer> doDeleteFalse(@PathVariable("id") String[] id, HttpServletRequest req, HttpServletResponse resp) {
		if(id!=null && !id[0].equals("") && !id[1].equals("")){
			try {
				SourceThirdPartyKey stpk = new SourceThirdPartyKey(id[0],new Date(Long.valueOf(id[1])));
				return new Result<Integer>(SUCCESS,  Code.SUCCESS, sourceTpSer.delete(stpk));
			} catch (Exception e) {
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doDeleteTrue(String[] id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/exportExcel",method=RequestMethod.GET)
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setStr1(ManagerId.isSeeAll(req));
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, sourceTpSer.ExportData(accept,req));
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
		String s ="";
		if (!file.isEmpty()) {
			try {
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				s = s + sourceTpSer.importData(list);
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

	@Override
	public Result<Integer> doUpdate(SourceThirdParty obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value="/history/{number}",method=RequestMethod.GET)
	public List<SourceThirdParty> queryHistory(@PathVariable("number") String number,EasyUIAccept accept) {
		if (number!=null && accept!=null) {
			try {
				accept.setStr1(number);
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return sourceTpSer.queryHistory(accept);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
}
