package com.example.ProjectJK_1123_2;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProjectJK_1123_2.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}
	

