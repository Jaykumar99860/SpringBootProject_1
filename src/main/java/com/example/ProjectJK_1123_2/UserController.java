package com.example.ProjectJK_1123_2;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class UserController {
@Autowired
UserService userservice;

@Autowired
UserRepository userRepository;
	
	
	
@RequestMapping("/")
public String welcome() {
	return "Hi, Welcome to my Project";
}

@RequestMapping(value="/getUsers",method=RequestMethod.GET, produces = "application/json")
public String getUsers() {
	return userservice.getAllUsers();
}

@RequestMapping(value="/addUsers", method=RequestMethod.PUT)
public String addUser(@RequestBody  User user) {
	userRepository.save(user);
	return "User Data saved";
}

}
