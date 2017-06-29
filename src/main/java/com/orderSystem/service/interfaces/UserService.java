package com.orderSystem.service.interfaces;

import com.orderSystem.entiry.User;

public interface UserService {
	
	int regist(User user);
	
	int checkUserName(String username);
	
	User login(User user);
}
