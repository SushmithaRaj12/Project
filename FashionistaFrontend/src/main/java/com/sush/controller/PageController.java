package com.sush.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController
{
	
	@RequestMapping("/")
	public String indexPage()
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String homePage()
	{
		return "index";
	}
	
	@RequestMapping("/login")
	public String ShowLoginPage()
	{
		return "Login";
		
	}
	@RequestMapping("/register")
	public String ShowRegisterPage()
	{
		return "Register";
		
	}
	@RequestMapping("/contactus")
	public String ShowContactUsPage()
	{
		return "ContactUs";
		
	}
	@RequestMapping("/aboutus")
	public String ShowAboutUsPage()
	{
		return "AboutUs";
		
	}
	
	
}
