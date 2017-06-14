package com.zs.controller.rest;

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

import com.zs.entity.ModuleLine;
import com.zs.entity.StaffUser;
import com.zs.entity.personalStyle;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.ModuleLineSer;
import com.zs.service.PersonalStyleSer;
import com.zs.service.UserSer;
import com.zs.tools.ColumnName;
import com.zs.tools.ExcelImport;

@RestController
@RequestMapping("/api/module")
public class ModuleLineConR extends BaseRestController<ModuleLine,String>{

	@Resource
	private ModuleLineSer moduleLineSer;
	@Resource
	private PersonalStyleSer personalStyleSer;
	
	@Override
	public EasyUIPage doQuery(EasyUIAccept accept, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@Override
	public Result<ModuleLine> doGet(String id, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	
	@Override
	public Result<Integer> doAdd(ModuleLine obj, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Result<String> doUpdate(@PathVariable("id")String id,ModuleLine obj, HttpServletRequest req, HttpServletResponse resp) {
		if(!id.equals("")){
			StaffUser user = (StaffUser) req.getSession().getAttribute("user");
			if(user!=null){
				String [] ss = id.split("_");
				EasyUIAccept accept = new EasyUIAccept();
				accept.setStr1(ss[1]);
				accept.setStr2(user.getStuNum());
				accept.setStr3("1");
				List<personalStyle> psls = personalStyleSer.queryStyle(accept);
				List<ModuleLine> lsls = moduleLineSer.queryStyle(ss[1]);
				//判断所有的都没有填，返回默认格式
				if(ss[0].equals("")){
					for (int i = 0; i < psls.size(); i++) {
						personalStyle ps = psls.get(i);
						ps.setState("0");
						personalStyleSer.update(ps);
					}
					
					String ostr= "";
					for (int i = 0; i < lsls.size(); i++) {
						if(i==lsls.size()-1){
							ostr=ostr+i;
						}else{
							ostr=ostr+i+",";
						}
					}
					personalStyle newps = new personalStyle(null, ss[1], user.getStuNum(), ostr, null, "1");
					personalStyleSer.add(newps);
				}else{
					String[] oss = ss[0].split(",");
					for (int i = 0; i < oss.length; i++) {
						for (int j = i+1; j < oss.length; j++) {
							if(oss[i].equals(oss[j])){
								return new Result<String>(ERROR,  Code.ERROR, "填写的顺序有相同的数值");
							}
						}
					}
					//截取对应的数据
					String [] tbnums = oss[oss.length-1].split("a");
					String str = "";
					String str1="";
					for (int i = 0; i < oss.length-1; i++) {
						for (int j = 0; j < tbnums.length; j++) {
							if(Integer.parseInt(oss[j])==i){
								str= str+tbnums[j]+",";
							}
						}
					}
					if(!str.equals("")){
						str1 = str.substring(0,str.length()-1);
					}
					//将顺序写入表中，如表中有就变为不用，添加一条新的
					for (int i = 0; i < psls.size(); i++) {
						personalStyle ps = psls.get(i);
						ps.setState("0");
						personalStyleSer.update(ps);
					}
					personalStyle newps = new personalStyle(null, ss[1], user.getStuNum(), str1, null, "1");
					personalStyleSer.add(newps);
				}
				return new Result<String>(SUCCESS,  Code.SUCCESS, null);
			}else{
				return new Result<String>(ERROR,  Code.ERROR, "您没有登陆系统，不能进行此项操作");
			}
		}
		return new Result<String>(ERROR,  Code.ERROR, null);
	}

	@Override
	public Result<Integer> doUpdate(ModuleLine obj, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	@Override
	public Result<Integer> doDeleteFalse(@PathVariable("id")String id, HttpServletRequest req, HttpServletResponse resp) {
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
	public Result<String> excelImport(@RequestParam MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}
	

}
