package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/primeReport")
public class PrimeCodeReportCon extends BaseController{

	@RequestMapping("/Import")
	@Override
	public String gotoQuery() {
		return "/report/prime_report_import";
	}
	
	@RequestMapping("/collect")
	public String gotoQuery1() {
		return "/report/prime_report_collect";
	}
	
	@RequestMapping("/personle")
	public String gotoQuery2() {
		return "/report/prime_report_personle";
	}

}
