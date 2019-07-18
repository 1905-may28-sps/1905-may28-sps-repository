package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //makes this class a controller -- can handle HTTP requests 
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping
	//@RequestMapping(method=RequestMethod.GET, value="/hello")
	@ResponseBody
	public String helloWorld() {
		return "Hello!!!! Welcome to Spring MVC!";
	}
	
	@RequestMapping(value="/{myName}")
	@ResponseBody
	public String greetUser(@PathVariable String myName) {
		return "<h1>Welcome, " + myName  + "!</h1>";
	}
	
	

}
