package com.zs.controller.rest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.entity.StaffUser;
import com.zs.entity.other.Result;
import com.zs.service.UserSer;

@RestController
@RequestMapping("/api")
public class LoginAndOutConR{

	private Logger log=Logger.getLogger(getClass());
	@Resource
	private UserSer userSer;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Result<String> login(String unum,String upass,HttpServletRequest request) {
		Result<String> result=null;
		if (unum!=null && upass!=null && !unum.trim().equals("") && !upass.trim().equals("")) {
			StaffUser user=userSer.selectFromLogin(unum);
			log.info(user);
			if (user==null ) {
				result=new Result<String>(BaseRestController.ERROR, Code.LOGIN_USER_NO, "账号不存在");
			}else {
				if (user.getPass().equals(upass)) {
				    //---------存一下在session相关信息--------------
					user.setLicence("111");
					request.getSession().setAttribute("user", user);//待定
					result=new Result<String>(BaseRestController.SUCCESS, Code.SUCCESS, "登录成功");
				}else {
					result=new Result<String>(BaseRestController.ERROR, Code.LOGIN_PASS_ERROR, "密码错误");
				}
			}
		}else {
			result=new Result<String>(BaseRestController.ERROR, Code.LOGIN_INFO_NO, "账号或密码信息不全");
		}
		return result;
	}

	
}
