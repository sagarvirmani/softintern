package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.User_Dao;
import com.example.demo.model.user_bean;

@Service
public class User_Service {
	
	@Autowired User_Dao userdao;
	
	public Map<String,Object> userSignup(user_bean ub)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		if(userdao.userAlreadyExist(ub)==0)
		{
			int val=userdao.insertuserValues(ub);
			if(val!=0)
			{
				map.put("status", "success");
				map.put("message","user account created");
				ub.setUserid(val);
				map.put("user", ub);
			}
			else
			{
				map.put("status", "failed");
				map.put("message","user account not created");
			}
		}
		else
		{
			map.put("status", "failed");
			map.put("message","user already exist");	
		}
		return map;
		
	}
	public Map<String,Object> isuservalid(user_bean ub)
	{
		Map<String,Object> map=new HashMap<String,Object>();
		List<user_bean> userlist=userdao.isuserValid(ub);
		if(userlist.size()!=0)
		{
			map.put("status", "success");
			map.put("message","user valid");
			
			map.put("user", userlist.get(0));
		}
		else
		{
			map.put("status", "failed");
			map.put("message","user not valid");
		}
		return map;
		
	}

}
