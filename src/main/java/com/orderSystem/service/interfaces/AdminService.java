package com.orderSystem.service.interfaces;

import com.orderSystem.entiry.Admin;

public interface AdminService {
	
	/**
	 * �û���¼
	 * @param name �˺�
	 * @param password ����
	 * @return Admin
	 */
	Admin login(String username,String password);
}
