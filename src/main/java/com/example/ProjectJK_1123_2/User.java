package com.example.ProjectJK_1123_2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "UserData")
public class User {
	
	public User() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userId;
	
	@Column(name = "UserName", length = 50)
	String userName;
	
	@Column(name = "Address", length = 100)
	String userAddress;
	
	User(int id, String name, String address){
		this.userId = id;
		this.userName = name;
		this.userAddress = address;
	}
	
	public int getUserId() { return userId; }
	
	public String getUserName() { return userName; }
	
	public String getUserAddress() { return userAddress; }

}
