package com.example.demo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.internships_bean;


@Repository
public class Internships_dao {
	
	@Autowired 
	DataSource dataSource;
	
	 @Autowired  
	 JdbcTemplate jdbc;  
	 
	 
	 public List<internships_bean> getAllIntern()
	 {
		 String sql="select * from internships";
		 List<internships_bean> intern = jdbc.query(sql,new BeanPropertyRowMapper(internships_bean.class));
		 return intern;
	 }
	 
	 
	 public List<internships_bean> getInternbycity(String city)
	 {
		 String sql="select * from internships where city=?";
		 List<internships_bean> intern = jdbc.query(sql,new BeanPropertyRowMapper(internships_bean.class),city);
		 return intern;
	 }

}
