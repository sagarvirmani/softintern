package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.user_bean;
import com.example.demo.service.User_Service;

@RestController
public class User_Controller {
	@Autowired User_Service userservice;
	
	
	@PostMapping("user_signup")
	public Map<String,Object> userSignup(@RequestBody user_bean ub)
	{
		Map<String,Object> map=userservice.userSignup(ub);
		return map;
	}
	@PostMapping("user_login")
	public Map<String,Object> userLogin(@RequestBody user_bean ub)
	{
		Map<String,Object> map=userservice.isuservalid(ub);
		return map;
	}
	
	
	@RequestMapping("/")
	public String firstcheck()
	{
		return "bgjshejkhbgtwv";
	}
	

}
