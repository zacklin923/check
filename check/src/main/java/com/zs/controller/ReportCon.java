package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportDate")
public class ReportCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/report/report_date";
	}

}
