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
		
		//1:ͨ�� product.id��ȡ��ǰ����Ʒ����
		Product findproduct = productservice.findById(product.getPid());
		
		findproduct.setNumber(product.getNumber());
		
		//2:�жϵ�ǰsession�Ƿ��й��ﳵ�����û���򴴽�
		if(session.getAttribute("forder")==null){
			
			//�������ﳵ���浽session��
			session.setAttribute("forder",new Forder(new HashSet<Sorder>()));
		}
		Forder forder = (Forder) session.getAttribute("forder");
		//3:����Ʒ��Ϣת��Ϊsorder,������ӵ����ﳵ��(�жϹ��ﳵ�Ƿ��ظ�)
		forder = sorderService.addSorder(forder, findproduct);
		forder.setTotal(forderservice.cluTotal(forder));
		
		System.out.println(forder);
		
		return "redirect:/car.jsp";
	}
	
	//ɾ�����ﳵ����
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteSorder(Product product,HttpSession session){
		
		Forder forder = (Forder) session.getAttribute("forder");
		
		Set<Sorder> set = forder.getSorderSet();
		
		//������whileѭ��
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
		//0d ����0
		forder.setTotal(0d);
		
		session.removeAttribute("forder");
		
		return "redirect:/car.jsp";
	}
	
	//��̨��������
	@RequestMapping(value="/listbyfid",method=RequestMethod.GET)
	public String listSorder(Forder forder,Model model){
		
		List<Sorder> byfidlistSorder = sorderService.listSorderByfid(forder.getFid());
		
		model.addAttribute("listSorder", byfidlistSorder);
		
		return "sorder/list";
	}
}
