package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zmReturnData")
public class ZmReturnDataCon extends BaseController{

	@Override
	public String gotoQuery() {
		return null;
	}
	
	@RequestMapping("/zm")
	public String gotoQueryZm() {
		return "/dkh/sourceZm";
	}

	@RequestMapping("/tp")
	public String gotoQueryTp() {
		return "/dkh/sourceTp";
	}

}
