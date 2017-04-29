package com.zs.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接收哲盟返回数据
 * @author 张顺
 * 2017-4-28
 */
@RestController
@RequestMapping("/api/receive")
public class ReceiveFromZmConR {

	/*接收哲盟返回数据*/
	@RequestMapping(value="/zm",method=RequestMethod.POST)
	public void receiveResultFromZm() {
		
	}
	
	/*接收第三方返回数据*/
	@RequestMapping(value="/tp",method=RequestMethod.POST)
	public void receiveResultFromTP() {
		
	}
	
}
