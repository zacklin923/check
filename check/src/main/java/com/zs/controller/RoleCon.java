package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/system/role";
	}

}
