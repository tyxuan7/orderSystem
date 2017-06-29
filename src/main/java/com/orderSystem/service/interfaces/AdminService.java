package com.orderSystem.service.interfaces;

import com.orderSystem.entiry.Admin;

public interface AdminService {
	
	/**
	 * ÓÃ»§µÇÂ¼
	 * @param name ÕËºÅ
	 * @param password ÃÜÂë
	 * @return Admin
	 */
	Admin login(String username,String password);
}
