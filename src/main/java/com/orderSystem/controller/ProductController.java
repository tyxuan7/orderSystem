package com.orderSystem.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.orderSystem.entiry.Product;
import com.orderSystem.service.interfaces.ProductService;
import com.orderSystem.util.IPTimeStamp;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listProduct(Model model){
		
		List<Product> list = productservice.listProduct();
		model.addAttribute("list", list);
		
		return "product/list";
	}
	//��̨������Ʒ
	//�����Ʒ�����ϴ��ļ�
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddProduct(){
		
		return "product/add";
	}
	//��̨������Ʒ
	//�����Ʒ���ϴ��ļ�
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddProduct(Product product,@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException{
			
			System.out.println(product);
			//��ȡ�ļ� �洢λ��
			
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			
			File pathFile = new File(realPath);
			
			//pathFile.exists()�����˳���·������ʾ���ļ���Ŀ¼����ʱ
			if(!pathFile.exists()){
				//�ļ��в����� �����ļ�
				pathFile.mkdirs();
			}
			
			System.out.println("�ļ�����"+file.getContentType());
			System.out.println("�ļ�����"+file.getOriginalFilename());
			System.out.println("�ļ���С"+file.getSize());
			System.out.println(".................................................");
			
			//���ļ�copy�ϴ���������
			//file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
			
			IPTimeStamp ip = new IPTimeStamp();
			
			System.out.println(ip);
			//commons-io���µ�FilenameUtils  ��ȡ�ļ����ֵľ�̬����
			//��ȡ�ļ��ĺ�׺:"+FilenameUtils.getExtension
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			
			String newfilename = ip.getTimeStamp()+ "." + ext;
			//�����ļ�
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
					new File(realPath,newfilename));

			//��ȡmodelandview����
			
			product.setPic(newfilename);
			
			productservice.addProduct(product);
			
			return "redirect:list";
	}
	
	//��̨
	//ɾ����Ʒ
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteProduct(Product product){
		
		productservice.deleteProduct(product);
		
		return "redirect:list";
	}
	//��̨
	//�༭�����ϴ��ļ�
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String toedit(Product product,ModelMap map){
		
		Product pro = productservice.findById(product.getPid());
		
		map.addAttribute("product", pro);
		
		return "product/edit";
	}
	//��̨
	//�༭���ϴ��ļ�
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Product product,@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException{
		
			Product oldproduct = productservice.findById(product.getPid());
			
			//��ȡ�ļ� file.getOriginalFilename()��ȡ�ϴ�ʱ���ļ���
			if(file.getOriginalFilename()!=null && file.getOriginalFilename().equals("")){
				//��ȡ�ļ�����·��
				String realPath = request.getSession().getServletContext()
								  .getRealPath("/upload");
				
				File oldfile = new File(realPath + "/" + oldproduct.getPic());
				
				oldfile.delete();
				
				File pathFile = new File(realPath);
				//pathFile.exists()�����˳���·������ʾ���ļ���Ŀ¼����ʱ
				if(!pathFile.exists()){
					//�ļ��в��� �����ļ�
					pathFile.mkdirs();
				}
				
				System.out.println("�ļ����ͣ�"+file.getContentType());
				System.out.println("�ļ����ƣ�"+file.getOriginalFilename());
				System.out.println("�ļ���С:"+file.getSize());
				System.out.println(".................................................");
				//���ļ�copy�ϴ���������
				//file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
				IPTimeStamp ip = new IPTimeStamp();
				//commons-io���µ�FilenameUtils  ��ȡ�ļ����ֵľ�̬����
				//��ȡ�ļ��ĺ�׺:"+FilenameUtils.getExtension
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());
				
				String newfilename = ip.getIPTimeRand() + "." + ext;
				
				//�����ļ�  ��Ҫ�׳��쳣
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,newfilename));
			
				//��ȡmodelandview����
				
				product.setPic(newfilename);												
			
			}
			
			if(file.getOriginalFilename()==null || "".equals(file.getOriginalFilename())){
				
				product.setPic(productservice.findById(product.getPid()).getPic());
			}
			
			productservice.updateProduct(product);
			
		return "redirect:list";
	}
	
	
	//��Ʒ����ѯ
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public String findByPname(@Param("pname") String pname,Model model){
		
		System.out.println(pname+"---------------------");
		
		List<Product> li = productservice.findByName(pname);
		
		model.addAttribute("list", li);
		return "product/list";
	}
	
	//ǰ̨ ��Ʒ��ҳ
	@RequestMapping(value="/frontlist",method=RequestMethod.GET)
	public String frontlist(Model model){
		
		//������Ʒ
		List<Product> listnew = productservice.frontlistNew();
		
		//������Ʒ
		List<Product> listhot = productservice.frontlistHot();
		
		model.addAttribute("listnew", listnew);
		model.addAttribute("listhot", listhot);
		
		return "forward:/index.jsp";
	}
	
	//ǰ̨ ��Ʒ����ҳ
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Product product,Model model){
		
		Product pro = productservice.findById(product.getPid());
		
		model.addAttribute("pro", pro);
		
		return "forword:/detail.jsp";
	}
}
