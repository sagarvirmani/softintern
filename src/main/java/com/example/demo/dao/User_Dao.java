package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import com.example.demo.model.user_bean;


@Repository
public class User_Dao {
	
	
	@Autowired 
	DataSource dataSource;
	
	 @Autowired  
	 JdbcTemplate jdbc;  
	 
	 public int insertuserValues(user_bean user) {
		 try {
			int userid = 0;
			SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource).withTableName("users")
					.usingGeneratedKeyColumns("userid");
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("email", user.getEmail());
			parameters.put("password", user.getPassword());
			parameters.put("first_name", user.getFirst_name());
			parameters.put("last_name", user.getLast_name());
			
			Number id = insert.executeAndReturnKey(parameters);
			userid = id.intValue();
			
			return userid;
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.toString());
			 return 0;
		 }
		}
	 
	 public List<user_bean> isuserValid(user_bean ub)
	 {

		    String sql = "SELECT * FROM users where email='"+ub.getEmail()+"' and password='"+ub.getPassword()+"'";

		    List<user_bean> users = jdbc.query(sql,new BeanPropertyRowMapper(user_bean.class));
		    return users;
	 }
	 
	 public int userAlreadyExist(user_bean ub)
		{
			Integer count = this.jdbc.queryForObject("select count(*) from users where email=?", new Object[]{ub.getEmail()},Integer.class);
			return count;
		}
	 

}
