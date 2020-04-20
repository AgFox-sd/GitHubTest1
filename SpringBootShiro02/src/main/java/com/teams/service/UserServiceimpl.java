package com.teams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teams.mapper.UserMapper;
import com.teams.pojo.User;


@Service
public class UserServiceimpl implements UserService{

	@Autowired
	UserMapper mapper;
	
	@Override
	public User findByname(String username) {
		// TODO Auto-generated method stub
		return mapper.findByname(username);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return mapper.findById(id);
	}

}
