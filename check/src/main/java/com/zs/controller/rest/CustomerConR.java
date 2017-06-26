package com.zs.controller.rest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.zs.entity.Customer;
import com.zs.entity.personalStyle;
import com.zs.entity.CustomerKey;
import com.zs.entity.ModuleLine;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.CustomerSer;
import com.zs.service.ModuleLineSer;
import com.zs.service.PersonalStyleSer;
import com.zs.tools.BatchString;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/customer")
public class CustomerConR extends BaseRestController<Customer,String>{

	@Resource
	private CustomerSer customerSer;
	@Resource
	private PersonalStyleSer personalStyleSer;
	@Resource
	private ModuleLineSer moduleLineSer;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				if(accept.getStr1()!=null){
					accept.setStr1(BatchString.batchstr(accept.getStr1()));
				}
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
				CustomerKey ck = new CustomerKey();
				String [] s = id.split("-");
				ck.setCteBarCode(s[0]);
				ck.setHistoryCount(new BigDecimal(s[1]));
				return new Result<Integer>(SUCCESS, Code.SUCCESS, customerSer.delete(ck));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<Integer>(ERROR, Code.ERROR, -1);
			}
		}
		return new Result<Integer>(ERROR, Code.ERROR, null);
	}

	@RequestMapping(value="/excelExport",method=RequestMethod.GET)
	@Override
	public Result<String> excelExport(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		if (accept!=null) {
			try {
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, customerSer.exportData(accept,req));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "数据装载失败");
			}
		}
		return null;
	}

	@RequestMapping(value="/import",method=RequestMethod.POST)
	@Override
	public Result<String> excelImport(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		if (!file.isEmpty()) {
			try {
				List<String[]> list=ExcelImport.getDataFromExcel2(file.getOriginalFilename(), file.getInputStream());
				StaffUser user = (StaffUser) req.getSession().getAttribute("user");
				String errs = customerSer.importData(list,user.getStuNum());
				if(errs.equals("")){
					return new Result<String>(SUCCESS,  Code.SUCCESS, "导入成功");
				}else{
					return new Result<String>(ERROR,  Code.ERROR, errs);
				}
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
			accept.setInt1(0);
			return customerSer.queryFenye(accept);
		}
		return null;
	}

	@RequestMapping(value="/style/{id}",method=RequestMethod.GET)
	public Result<String> personalStyle(@PathVariable("id") String id , HttpServletRequest req, HttpServletResponse resp){
		String moduleName ="";
		if(id.equals("1")){
			moduleName="大客户信息";
		}else if(id.equals("2")){
			moduleName="运单信息查询";
		}if(id.equals("3")){
			moduleName="运单状态查询";
		}
		String str="";
		StaffUser user = (StaffUser) req.getSession().getAttribute("user");
		List<ModuleLine> mls = moduleLineSer.queryStyle(moduleName);
		String dss[] = new String[mls.size()];
		for (int i = 0; i < dss.length; i++) {
			if(mls.get(i).getFormatter()!=null){
				dss[i]="{field:\""+mls.get(i).getLineField()+"\",title:\""+mls.get(i).getTitle()+"\",width:"+mls.get(i).getLineWidth()+",sortable:"+mls.get(i).getSortable()+",editor:"+mls.get(i).getEditor()+",formatter:"+mls.get(i).getFormatter()+"},";
			}else{
				dss[i]="{field:\""+mls.get(i).getLineField()+"\",title:\""+mls.get(i).getTitle()+"\",width:"+mls.get(i).getLineWidth()+",sortable:"+mls.get(i).getSortable()+",editor:"+mls.get(i).getEditor()+"},";
			}
		} 
		if(user!=null){
			EasyUIAccept accept = new EasyUIAccept();
			accept.setStr1(moduleName);
			accept.setStr2(user.getStuNum());
			accept.setStr3("1");//1代表启用
			List<personalStyle> pss = personalStyleSer.queryStyle(accept);
			if(pss.size()>0){
				if(!pss.get(0).getOrderStyle().equals("")&&pss.get(0).getOrderStyle()!=null){
					String [] ss = pss.get(0).getOrderStyle().split(",");
					for (int i = 0; i < ss.length; i++) {
						for (int j = 0; j < dss.length; j++) {
							if(Integer.parseInt(ss[i])==j){
								str=str+dss[j];
							}
						}
					}
				}
			}else{
				for (int i = 0; i < dss.length; i++) {
					str=str+dss[i];
				}
			}
		}else{
			for (int i = 0; i < dss.length; i++) {
				str=str+dss[i];
			}
		}
		str=str.substring(0,str.length()-1);
		return new Result<String>(SUCCESS,  Code.SUCCESS, str);
	}
}
