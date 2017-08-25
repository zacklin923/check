package com.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cw")
public class CwCon {
	@RequestMapping("/menu")
	public String gotoMenu(){
		return "/view/menu";
	}
	
	
	@RequestMapping("/biguser")
	public String cw1(){
		return "/view/biguser";
	}
	@RequestMapping("/collect")
	public String cw2(){
		return "/view/collect";
	}
	@RequestMapping("/collectree")
	public String cw3(){
		return "/view/collectree";
	}
	
	public String cw4(){
		return "/view/biguser";
	}
	
	public String cw5(){
		return "/view/biguser";
	}
	
	
	public String cw6(){
		return "/view/biguser";
	}
	
	
	public String cw7(){
		return "/view/biguser";
	}
	
	public String cw8(){
		return "/view/biguser";
	}
	
	public String cw9(){
		return "/view/biguser";
	}
	
	public String cw10(){
		return "/view/biguser";
	}
	
	public String cw11(){
		return "/view/biguser";
	}
	
	public String cw12(){
		return "/view/biguser";
	}
	
}
