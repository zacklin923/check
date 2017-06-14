package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportMonth")
public class ReportMonthCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/report/report_month";
	}

}
