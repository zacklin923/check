package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/import")
public class SourceImportCon extends BaseController{

	@RequestMapping("/file")
	@Override
	public String gotoQuery() {
		return "/importdata/import";
	}

}
