package com.example.ProjectJK_1123_2;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
UserService userservice;
	
	
	
@RequestMapping("/")
public String welcome() {
	return "Hi, Welcome to my Project";
}

@RequestMapping(value="/getUsers",method=RequestMethod.GET)
public String getUsers() {
	return userservice.getAllUsers();
}
}
