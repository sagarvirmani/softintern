package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Internships_dao;
import com.example.demo.model.internships_bean;

@Service
public class Internships_Service {
	
	@Autowired Internships_dao interndao;
	
	public Map<String,Object> getallIntern()
	{
		Map<String,Object> map=new HashMap<String,Object>();
		List<internships_bean> list=interndao.getAllIntern();
		if(list.size()==0)
		{
			map.put("status", "failed");
			map.put("message","list empty");
			map.put("internships",list);
		}
		else
		{
			map.put("status", "success");
			map.put("message","list");
			map.put("internships",list);
		}
		return map;
	}
	
	public Map<String,Object> getInternBycity(String city)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		List<internships_bean> list=interndao.getInternbycity(city);
		if(list.size()==0)
		{
			map.put("status", "failed");
			map.put("message","list empty");
			map.put("internships",list);
		}
		else
		{
			map.put("status", "success");
			map.put("message","list");
			map.put("internships",list);
		}
		return map;
	}

}
