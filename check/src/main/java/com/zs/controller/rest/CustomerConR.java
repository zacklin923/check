package com.zs.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
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
	
	private Gson g = new Gson();
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public Result<EasyUIPage> doQuery(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			if(accept.getStr1()!=null){
				accept.setStr1(BatchString.oldbatchstr(accept.getStr1()));
			}
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			return new Result<EasyUIPage>(SUCCESS,Code.SUCCESS,customerSer.queryFenye(accept));
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
		}
	}

	@Override
	public Result<Customer> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public Result<String> doAdd(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			Customer obj = g.fromJson(data, Customer.class);
			customerSer.add(obj);
			return new Result<String>(SUCCESS, Code.SUCCESS, "添加成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR, Code.ERROR, "添加失败");
		}
	}

	@RequestMapping(value="",method=RequestMethod.PUT)
	public Result<String> doUpdate(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
		try {
			Customer obj = g.fromJson(data, Customer.class);
			customerSer.update(obj);
			return new Result<String>(SUCCESS, Code.SUCCESS, "修改成功");
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
				CustomerKey ck = new CustomerKey();
				String [] s = accept.getId().split("-");
				ck.setCteBarCode(s[0]);
				ck.setHistoryCount(new BigDecimal(s[1]));
				customerSer.delete(ck);
				return new Result<String>(SUCCESS, Code.SUCCESS,"删除成功" );
			} catch (Exception e) {
				e.printStackTrace();
				return new Result<String>(ERROR, Code.ERROR, "删除失败");
			}
	}

	@RequestMapping(value="/excelExport",method=RequestMethod.GET)
	public Result<String> excelExport(String uid,String data, HttpServletRequest req, HttpServletResponse resp) {
			try {
				EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
				if(accept.getStr1()!=null){
					accept.setStr1(BatchString.oldbatchstr(accept.getStr1()));
				}
				accept.setSort(ColumnName.transToUnderline(accept.getSort()));
				return new Result<String>(SUCCESS,  Code.SUCCESS, customerSer.exportData(accept,req));
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
			s=customerSer.importData(list,uid);
			return new Result<String>(SUCCESS,  Code.SUCCESS, s);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<String>(ERROR,  Code.ERROR, "数据导入失败，请检查数据格式后重新导入");
		} 
	}
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Result<EasyUIPage>  quertAll(String uid,String data){
		try{
		EasyUIAccept accept = g.fromJson(data, EasyUIAccept.class); 
			accept.setSort(ColumnName.transToUnderline(accept.getSort()));
			accept.setInt1(0);
			return  new Result<EasyUIPage>(SUCCESS,Code.SUCCESS,customerSer.queryFenye(accept));
		}catch (Exception e) {
			e.printStackTrace();
			return new Result<EasyUIPage>(ERROR,Code.ERROR,null);
		}
		
	}

	@RequestMapping(value="/style",method=RequestMethod.GET)
	public Result<String> personalStyle(String uid,String data, HttpServletRequest req, HttpServletResponse resp){
		System.out.println(data);
		EasyUIAccept accept1 = g.fromJson(data, EasyUIAccept.class); 
		System.out.println(accept1);
		String moduleName ="";
		if(accept1.getId().equals("1")){
			moduleName="大客户信息";
		}else if(accept1.getId().equals("2")){
			moduleName="运单信息查询";
		}if(accept1.getId().equals("3")){
			moduleName="运单状态查询";
		}
		String str="";
		List<ModuleLine> mls = moduleLineSer.queryStyle(moduleName);
		String dss[] = new String[mls.size()];
		for (int i = 0; i < dss.length; i++) {
			if(mls.get(i).getFormatter()!=null){
				dss[i]="{field:\""+mls.get(i).getLineField()+"\",title:\""+mls.get(i).getTitle()+"\",width:"+mls.get(i).getLineWidth()+",sortable:"+mls.get(i).getSortable()+",editor:"+mls.get(i).getEditor()+",formatter:"+mls.get(i).getFormatter()+"},";
			}else{
				dss[i]="{field:\""+mls.get(i).getLineField()+"\",title:\""+mls.get(i).getTitle()+"\",width:"+mls.get(i).getLineWidth()+",sortable:"+mls.get(i).getSortable()+",editor:"+mls.get(i).getEditor()+"},";
			}
		} 
		if(uid!=null&&!uid.equals("")){
			EasyUIAccept accept = new EasyUIAccept();
			accept.setStr1(moduleName);
			accept.setStr2(uid);
			accept.setStr3("1");//1代表启用
			List<personalStyle> pss = personalStyleSer.queryStyle(accept);
			if(pss.size()>0){
				if(pss.get(0).getOrderStyle()!=null){
					if(!pss.get(0).getOrderStyle().equals("")){
						String [] ss = pss.get(0).getOrderStyle().split(",");
						for (int i = 0; i < ss.length; i++) {
							for (int j = 0; j < dss.length; j++) {
								if(Integer.parseInt(ss[i])==j){
									str=str+dss[j];
								}
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

	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doAdd(Customer obj, HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<Integer> doUpdate(Customer obj, HttpServletRequest req, HttpServletResponse resp) {
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
