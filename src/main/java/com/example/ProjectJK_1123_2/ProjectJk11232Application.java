package com.example.ProjectJK_1123_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjectJk11232Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectJk11232Application.class, args);
		System.out.println("Hi, Welcome to this project");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
