package com.teams.service;

import com.teams.pojo.User;

public interface UserService {
	
		 User findByname(String username);
		 User findById(int  id);
}
