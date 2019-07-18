package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Now, we take a look at @RestController
 * Which, as does @Controller, registers a class
 * as a controller (can handle HTTP requests)
 * One difference is that because @Controller can 
 * return view names, we must annotate every 
 * method that returns an actual HTTP response 
 * (and not a view name to then be resolved) 
 * with @ResponseBody, whereas, with @RestController
 * we do not
 */

@RestController
@RequestMapping("/user")
public class UserController {

}
