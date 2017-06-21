package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportSignCon extends BaseController{

	@RequestMapping("/reportSign")
	@Override
	public String gotoQuery() {
		return "/report/report_sign";
	}

}
