package com.teams.mapper;

import com.teams.pojo.User;

public interface UserMapper {

	 User findByname(String username);
	 
	 User findById(int  id);
	
}
