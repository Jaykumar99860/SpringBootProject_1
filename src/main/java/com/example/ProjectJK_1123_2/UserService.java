package com.example.ProjectJK_1123_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.ProjectJK_1123_2.UserRepository;

@Service
public class UserService {
	
	public final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public String getAllUsers () {
		List<User> lsuser = userRepository.findAll();
		String result = "";
		try {
		ObjectMapper mapper = new ObjectMapper();
		for(User user : lsuser) {
			result+= mapper.writeValueAsString(user)+"\n";
		}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		 
		return result;
	}
	
	public Map<Integer, String> GetRecordsUsingJDBC() {
		Map<Integer, String> result = new HashMap<>();
		String jdbcURL = "jdbc:h2:mem:test";
		 
        Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL);			
	        System.out.println("Connected to H2 in-memory database.");		        
	        //String sql = "drop table students \n";		        
	        String sql = "Create table students (ID int , name varchar(50))";		         
	        Statement statement = connection.createStatement();		         
	        statement.execute(sql);		         
	        System.out.println("Created table students.");		         
	        sql = "Insert into students (ID, name) values (1, 'Jay Kumar') \n";
	        String sql2 = "Insert into students (ID, name) values (2, 'Chhtrasal Pandey') \n";
	        String sql3 = "Insert into students (ID, name) values (3, 'Amit Kumar')";
	        statement.addBatch(sql);
	        statement.addBatch(sql2);
	        statement.addBatch(sql3);
	        statement.executeBatch();
	        int rows = statement.executeUpdate(sql);		         
	        if (rows > 0) {
	            System.out.println("Inserted a new row.");
	        }		        
	        sql = "select * from students";		        
	        ResultSet rs = statement.executeQuery(sql);		        
	        while( rs.next()) {
	        	result.put(rs.getInt("ID"), rs.getString("name"));
	        }		        
	        connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
