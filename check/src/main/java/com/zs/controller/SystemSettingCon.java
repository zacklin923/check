package com.zs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/setting")
public class SystemSettingCon {

	@RequestMapping("/target")
	@ResponseBody
	public String steTarget(String tar,HttpServletRequest request) {
		request.getSession().setAttribute("target", tar);
		return "success";
	}
	
}
