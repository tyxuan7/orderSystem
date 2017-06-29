package com.orderSystem.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderSystem.dao.AdminMapper;
import com.orderSystem.entiry.Admin;
import com.orderSystem.service.interfaces.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminmapper;
	
	@Override
	public Admin login(String username, String password) {
		// TODO Auto-generated method stub
		Admin admin = adminmapper.findByAdmin(username, password);
		if(admin == null){
			throw new RuntimeException("用户名或密码不正确");
		}
		return admin;
	}

}
