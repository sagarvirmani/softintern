package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Internships_Service;

@RestController 
public class Internships_Controller {
	
	@Autowired Internships_Service internservice;
	
	@RequestMapping("getinternships")
	public Map<String,Object> getInterns()
	{
		Map<String,Object> map=internservice.getallIntern();
		return map;
		
	}
	@RequestMapping("intern_bycity")
	public Map<String,Object> getInternByCity(@RequestParam(name="city") String city )
	{
		Map<String,Object> map=internservice.getInternBycity(city);
		return map;
		
	}
	

}
