package com.example.ProjectJK_1123_2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value="/listproducts",method =RequestMethod.GET )
	public List<Product> getProducts(){
		List<Product> lsproducts = productRepository.findAll();		 
		return lsproducts;
	}
	
	@RequestMapping(value="/getproductbyid",method =RequestMethod.GET )
	public Product getproductbyid(@RequestParam("id") long id){
		
		Optional<Product> product = productRepository.findById(id);		 
		return product.get();
	}
	
	@RequestMapping(value="/addproducts",method =RequestMethod.PUT )
	public String addProducts(@RequestBody Product pr){
		productRepository.save(pr);
		return "products saved";
	}
}
