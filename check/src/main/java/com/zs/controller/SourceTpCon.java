package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sourceTp")
public class SourceTpCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/dkh/sourceTp";
	}

}
