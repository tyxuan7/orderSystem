package com.orderSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orderSystem.entiry.Forder;
import com.orderSystem.service.interfaces.ForderService;

//��̨��������
@Controller
@RequestMapping(value="/order")
public class BKOrderController {
	
	@Autowired
	private ForderService forderservice;
	
	//��̨�����������б�
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listProduct(Model model){
		List<Forder>list = forderservice.selectList();
		
		model.addAttribute("list", list);
		System.out.println(list);
		return "order/list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Forder forder,Model model){
		
		try {
			forderservice.deleteByPrimaryKey(forder.getFid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("msg", "ɾ��ʧ��");
			
			return "sys/error.jsp";
		}
		
		List<Forder> list = forderservice.selectList();
		model.addAttribute("list",list);
		
		System.out.println(list);
		
		return "order/list";
	}
}
