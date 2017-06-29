package com.orderSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orderSystem.entiry.Admin;
import com.orderSystem.service.interfaces.AdminService;

@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(HttpSession session){
		
		if(session.getAttribute("adminusername")==null){
			
			session.setAttribute("msg","�û���û�е�¼");
			
			return "login";
		}
		
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String tologin(){
		
		return "login";
	}
	
	//��¼
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Admin admin,HttpSession session){
		
		Admin existadmin = adminService.login(admin.getUsername(), admin.getPassword());
		
		session.setAttribute("adminusername", existadmin.getUsername());
		
		session.removeAttribute("msg");
		
		//��¼���ض���
		return "redirect:/admin/";
	}
	
	//�˳�
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(Admin admin,HttpSession session){
		
		session.removeAttribute("adminusername");
		
		return "rediret:/admin/login";
	}
	
}
