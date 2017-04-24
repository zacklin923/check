package com.zs.interceptor;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.google.gson.Gson;
import com.zs.entity.StaffRole;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.Result;
import com.zs.service.UserSer;


/**2017-2-27，张顺
 * 权限拦截器，与IT_BDM对接，结果来自IT_BDM的权限拦截器
 * 2017-3-6，张顺
 * 时间轴拦截器也整合其中
 * @author it023
 */
public class RoleInter extends HandlerInterceptorAdapter{

	private Gson gson=new Gson();
	@Resource
	private UserSer userSer;
	private Logger log=Logger.getLogger(RoleInter.class);
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String url;
	String reqPamrs;
	private String method;
	HttpSession session;
	StaffUser user;
	StaffRole role;
	
	private void init(HttpServletRequest request, HttpServletResponse response){
		req=request;
		resp=response;
		String lId=request.getHeader("licence");
		method=req.getMethod();
		//获取其他信息
	    session = req.getSession();  
	    //获得url
	    url=req.getRequestURI();
	    reqPamrs = req.getQueryString();//后面的参数
    	//获取登录者信息
    	user =(StaffUser) session.getAttribute("user");
    	if (user!=null) {
    		role=user.getRole();
		}
	}
	
	/*权限*/
	/*时间轴*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		init(request, response);
		if (url.equals("/quota/projectIncome")) {
			return true;
		}else if (url.equals("/quota/jsp/test/data/treegrid2_data.json")) {
			return true;
		}else if (url.contains("/quota/api/projectIncome")) {
			return true;
		}
		return true;
	}

	
    private boolean isEqual(String someurl,String me) {
    	return url.equals("/quota"+someurl) && me.equals(method);
	}
    private boolean isContain(String someurl,String me) {
    	return url.contains("/quota"+someurl) && me.equals(method);
	}
    private String getId(String someurl) {
    	String ss[]=url.split(someurl);
    	if (ss.length>0) {
    		return ss[ss.length-1];
		}else {
			return null;
		}
    	
	}
    
    
	/**
	 * 权限判断+最后的跳转处理
	 * @return
	 */
	private boolean gotoHadle(String id,String pId){
		int re=0;
		if (re==100) {
			return true;
		}else {
			try {
				Result<String> result=new Result<String>("error", re, "权限验证不通过");
				log.error(gson.toJson(result));
				if (url.contains("/api")) {
					resp.setCharacterEncoding("utf-8");
					resp.getWriter().print(gson.toJson(result));
					resp.getWriter().flush();
					resp.getWriter().close();
				}else {
					resp.sendRedirect("/quota/jsp/part/noRole.jsp");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
}
