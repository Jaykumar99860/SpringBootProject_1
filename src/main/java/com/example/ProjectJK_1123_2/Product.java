package com.example.ProjectJK_1123_2;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "ProductData")
public class Product {
	
	public Product() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Product_Code", length = 50)
	private String code;
	
	@Column(name = "Product_Name", length = 100)
	private String name;
	
	Product(Long id, String code, String address){
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public Long getId() { return id; }
	
	public String getCode() { return code; }
	
	public String getName() { return name; }

}
