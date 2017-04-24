package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/system/users";
	}

}
