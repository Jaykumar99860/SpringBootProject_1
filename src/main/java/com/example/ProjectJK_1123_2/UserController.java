package com.example.ProjectJK_1123_2;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class UserController {
@Autowired
UserService userservice;

@Autowired
UserRepository userRepository;

@Autowired
RestTemplate restTemplate;
	
	
	
@RequestMapping("/")
public String welcome() {
	return "Hi, Welcome to my Project";
}

@RequestMapping(value="/getUsers",method=RequestMethod.GET, produces = "application/json")
public String getUsers() {
	return userservice.getAllUsers();
}

@RequestMapping(value="/getUserProducts",method=RequestMethod.GET, produces = "application/json")
public String getUserProducts() {
	List<Product> ls = null;
	try {
		ls = (List<Product>) restTemplate.getForObject("http://localhost:8080/listproducts", Product.class);
	} catch (RestClientException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ls.get(0).getName();
}

@RequestMapping(value="/getUserProductsById",method=RequestMethod.GET, produces = "application/json")
public String getUserProductsById(@RequestParam("id") long id) {
	String result="";
	Product product = null;
	try {
		product =  restTemplate.getForObject("http://localhost:8080/getproductbyid?id="+String.valueOf(id), Product.class);
		ObjectMapper om = new ObjectMapper();
		result += om.writeValueAsString(product);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return result;
}

@RequestMapping(value="/getJDBCRecords",method =RequestMethod.GET)
public Map<Integer,String> getJDBCRecords(){
	return userservice.GetRecordsUsingJDBC();
}

@RequestMapping(value="/addUsers", method=RequestMethod.PUT)
public String addUser(@RequestBody  User user) {
	userRepository.save(user);
	return "User Data saved";
}

}
