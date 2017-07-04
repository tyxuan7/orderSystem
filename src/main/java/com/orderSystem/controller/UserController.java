package com.orderSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orderSystem.entiry.User;
import com.orderSystem.service.interfaces.UserService;
import com.orderSystem.vo.Reg;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	//调整注册页
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String toregist(){
		
		return "redirect:/regist.jsp";
	}
	//提交注册内容
	@RequestMapping(value="/reqist",method=RequestMethod.POST)
	public String regist(User user,HttpServletRequest request){
		
		int rows = userservice.regist(user);
		
		if(rows==1){
			
			request.getSession().setAttribute("username", user.getUsername());
			
			return "redirect:/product/forntlist";
		}
		
		request.setAttribute("msg", "注册失败");
		
		return "forward:/user/toregist";
	}
	
	//跳转登陆页
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String tologin(){
		
		return "redirect:/login.jsp";
	}
	
	//登陆请求
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,Model model,HttpServletRequest request){
		
		User exituser = userservice.login(user);
		
		if(exituser==null){
			
			model.addAttribute("msg","用户名或密码错误");
			
			return "forward:/login.jsp";
		}
		
		request.getSession()
				.setAttribute("frontuser", exituser.getUsername());
		request.getSession()
				.setAttribute("forderId", exituser.getUid());
		
		String path = (String) request.getSession().getAttribute("orderpath");
		
		if(path!=null){
			
			return "redirect:" + path;
		}
				
		return "redirect:/product/frontlist";
		
	}
	
	//注册前检查用户是否存在
	public @ResponseBody Reg checkusername(String username){
		
		int count = userservice.checkUserName(username);
		
		Reg reg = new Reg(200,"可以注册");
		
		if(count>0){
			
			reg.setCode(500);
			reg.setMsg("账号已经存在");
		}
		
		return reg;
	}
}
