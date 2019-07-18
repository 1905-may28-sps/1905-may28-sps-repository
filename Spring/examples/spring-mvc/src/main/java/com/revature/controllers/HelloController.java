package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //makes this class a controller -- can handle HTTP requests 
public class HelloController {
	
	@RequestMapping(method=RequestMethod.GET, value="/hello")
	@ResponseBody
	public String helloWorld() {
		return "Hello!!!! Welcome to Spring MVC!";
	}

}
