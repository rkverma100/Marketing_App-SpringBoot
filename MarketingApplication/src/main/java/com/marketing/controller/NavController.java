package com.marketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/create_customer")
	public String create() {
		return "create_customer";
	}
	
	@GetMapping("/view_customer")
	public String getAll() {
		return "viewcustomer";
	}
	@GetMapping("/view_one")
	public String get() {
		return "view_one";
	}
	
	@GetMapping("/deletecustomer")
	public String deletion() {
		return "deletecustomer";
	}
	@GetMapping("/update")
	public String updation() {
		return "update";
	}

}
