package com.springannotationconfig.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author: wj
 * @version:  v1
 * @date:2017年12月26日 上午10:17:10
 * @description:
 */
@Controller
public class MvcController {
	
	@RequestMapping("/in")
	public String index(){
		System.out.println("0000000000000000000000");
		return "index";
	}
}
