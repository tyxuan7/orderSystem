package com.orderSystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orderSystem.entiry.Forder;
import com.orderSystem.service.interfaces.ForderService;

//提交订单页面
@Controller
@RequestMapping("/forder")
public class ForderController {
	
	@Autowired
	private ForderService forderMapper;
	
	//提交订单编辑页面
	
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public String toorder(){
		
		return "redirect:/order.jsp";
	}
	
	//提交订单成功页面
	
	public String order(Forder forder,HttpSession session,HttpServletRequest request){
		
		//插入订单
		Forder sessionforder = (Forder) session.getAttribute("forder");
		
		int count = 0;
			try {
				count = forderMapper.insertOrder(forder, sessionforder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", "商品数量不足");
				
				return "forward:/msg.jsp";
			}
			
			System.out.println(forder.getFid());
			
			System.out.println(count+"--------------");
			
			request.setAttribute("msg", "提交订单成功");
			
			request.removeAttribute("forder");
			
			session.removeAttribute("forder");
			
			
		return "forward:/msg.jsp";
	}
	
	
}
