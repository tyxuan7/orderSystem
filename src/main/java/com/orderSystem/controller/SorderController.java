package com.orderSystem.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orderSystem.entiry.Forder;
import com.orderSystem.entiry.Product;
import com.orderSystem.entiry.Sorder;
import com.orderSystem.service.interfaces.ForderService;
import com.orderSystem.service.interfaces.ProductService;
import com.orderSystem.service.interfaces.SorderService;

@Controller
@RequestMapping("/sorder")
public class SorderController {
	
	@Autowired
	private SorderService sorderService;
	@Autowired
	private ProductService productservice;
	@Autowired
	private ForderService forderservice;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addSorder(Product product,HttpSession session){
		
		System.out.println("-------addCar()" + product.getNumber());
		
		//1:通过 product.id获取当前的商品数据
		Product findproduct = productservice.findById(product.getPid());
		
		findproduct.setNumber(product.getNumber());
		
		//2:判断当前session是否有购物车，如果没有则创建
		if(session.getAttribute("forder")==null){
			
			//创建购物车，存到session中
			session.setAttribute("forder",new Forder(new HashSet<Sorder>()));
		}
		Forder forder = (Forder) session.getAttribute("forder");
		//3:把商品信息转化为sorder,并且添加到购物车中(判断购物车是否重复)
		forder = sorderService.addSorder(forder, findproduct);
		forder.setTotal(forderservice.cluTotal(forder));
		
		System.out.println(forder);
		
		return "redirect:/car.jsp";
	}
	
	//删除购物车订单
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteSorder(Product product,HttpSession session){
		
		Forder forder = (Forder) session.getAttribute("forder");
		
		Set<Sorder> set = forder.getSorderSet();
		
		//迭代器while循环
		Iterator<Sorder> iterator = set.iterator();
		while(iterator.hasNext()){
			Sorder sorder = iterator.next();
			if(sorder.getProduct().getPid()==product.getPid()){
				
				iterator.remove();
				forder.setTotal(forder.getTotal()-sorder.getPrice()*sorder.getNumber());
			}
		}
		if(set.size()<=0){
			session.removeAttribute("forder");
		}
		return "redirect:/car.jsp";
	}
	
	@RequestMapping(value="/clear",method=RequestMethod.GET)
	public String clearSorder(Product product,HttpSession session){
		
		Forder forder = (Forder) session.getAttribute("forder");
		
		Set<Sorder> set = forder.getSorderSet();
		
		set.clear();
		//0d 就是0
		forder.setTotal(0d);
		
		session.removeAttribute("forder");
		
		return "redirect:/car.jsp";
	}
	
	//后台订单详情
	@RequestMapping(value="/listbyfid",method=RequestMethod.GET)
	public String listSorder(Forder forder,Model model){
		
		List<Sorder> byfidlistSorder = sorderService.listSorderByfid(forder.getFid());
		
		model.addAttribute("listSorder", byfidlistSorder);
		
		return "sorder/list";
	}
}
