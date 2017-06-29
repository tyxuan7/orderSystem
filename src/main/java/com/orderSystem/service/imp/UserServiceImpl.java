package com.orderSystem.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderSystem.dao.UserMapper;
import com.orderSystem.entiry.User;
import com.orderSystem.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper usermapper;
	
	@Override
	public int regist(User user) {
		// TODO Auto-generated method stub
		return usermapper.insert(user);
	}

	@Override
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		return usermapper.checkUsername(username);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return usermapper.login(user);
	}

}
