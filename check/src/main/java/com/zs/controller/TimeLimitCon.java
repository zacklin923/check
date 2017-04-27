package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeLimit")
public class TimeLimitCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/dkh/timeLimit";
	}

}
