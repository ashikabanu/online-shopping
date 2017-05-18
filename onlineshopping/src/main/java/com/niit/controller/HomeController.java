package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController 
{
	
	
@RequestMapping("/hi")
	
	public ModelAndView helloworld1()
	{
		ModelAndView mv=new ModelAndView("HelloPage");
		mv.addObject("msg","This is My Home Page");
		return mv;
		
	}
}