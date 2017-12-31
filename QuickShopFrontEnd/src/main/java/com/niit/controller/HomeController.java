 	package com.niit.controller;
	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home()
	{
		return "landing";
	}
	
//	@RequestMapping("/category")
//	public String cat()
//	{
//		return "category";
//	}
	
	@RequestMapping("/index")
	public String log()
	{
		return "login";
	}
	
	@RequestMapping("/product")
	public String product()
	{
		return "product";
	}
	
//	@RequestMapping("/signup")
//	public String sign()
//	{
//		return "signup";
//	}
	

	@RequestMapping("/supplier")
	public String supp()
	{
		return "supplier";
	}
	
}
