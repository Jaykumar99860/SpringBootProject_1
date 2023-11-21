package com.example.ProjectJK_1123_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ProjectJK_1123_2.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	
	public String getAllUsers() {
		userRepository.save(new User(1,"Jay","Bangalore"));
		userRepository.save( new User(2, "Amit", "Bangalore"));
		List<User> lsuser = userRepository.findAll();
		return String.valueOf(lsuser.get(0));
	}
}
