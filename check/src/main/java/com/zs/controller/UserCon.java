package com.zs.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zs.tools.ExcelImport;

@Controller
@RequestMapping("/user")
public class UserCon extends BaseController{

	@RequestMapping("")
	@Override
	public String gotoQuery() {
		return "/system/users";
	}

}
