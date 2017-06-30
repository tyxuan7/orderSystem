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
	//后台新增商品
	//添加商品不带上传文件
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String toAddProduct(){
		
		return "product/add";
	}
	//后台新增商品
	//添加商品带上传文件
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String AddProduct(Product product,@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException{
			
			System.out.println(product);
			//获取文件 存储位置
			
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			
			File pathFile = new File(realPath);
			
			//pathFile.exists()仅当此抽象路径名表示的文件或目录存在时
			if(!pathFile.exists()){
				//文件夹不存在 创建文件
				pathFile.mkdirs();
			}
			
			System.out.println("文件类型"+file.getContentType());
			System.out.println("文件名称"+file.getOriginalFilename());
			System.out.println("文件大小"+file.getSize());
			System.out.println(".................................................");
			
			//将文件copy上传到服务器
			//file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
			
			IPTimeStamp ip = new IPTimeStamp();
			
			System.out.println(ip);
			//commons-io包下的FilenameUtils  获取文件名字的静态方法
			//获取文件的后缀:"+FilenameUtils.getExtension
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			
			String newfilename = ip.getTimeStamp()+ "." + ext;
			//保存文件
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
					new File(realPath,newfilename));

			//获取modelandview对象
			
			product.setPic(newfilename);
			
			productservice.addProduct(product);
			
			return "redirect:list";
	}
	
	//后台
	//删除商品
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteProduct(Product product){
		
		productservice.deleteProduct(product);
		
		return "redirect:list";
	}
	//后台
	//编辑不带上传文件
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String toedit(Product product,ModelMap map){
		
		Product pro = productservice.findById(product.getPid());
		
		map.addAttribute("product", pro);
		
		return "product/edit";
	}
	//后台
	//编辑带上传文件
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(Product product,@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IOException{
		
			Product oldproduct = productservice.findById(product.getPid());
			
			//获取文件 file.getOriginalFilename()获取上传时的文件名
			if(file.getOriginalFilename()!=null && file.getOriginalFilename().equals("")){
				//获取文件绝对路径
				String realPath = request.getSession().getServletContext()
								  .getRealPath("/upload");
				
				File oldfile = new File(realPath + "/" + oldproduct.getPic());
				
				oldfile.delete();
				
				File pathFile = new File(realPath);
				//pathFile.exists()仅当此抽象路径名表示的文件或目录存在时
				if(!pathFile.exists()){
					//文件夹不存 创建文件
					pathFile.mkdirs();
				}
				
				System.out.println("文件类型："+file.getContentType());
				System.out.println("文件名称："+file.getOriginalFilename());
				System.out.println("文件大小:"+file.getSize());
				System.out.println(".................................................");
				//将文件copy上传到服务器
				//file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
				IPTimeStamp ip = new IPTimeStamp();
				//commons-io包下的FilenameUtils  获取文件名字的静态方法
				//获取文件的后缀:"+FilenameUtils.getExtension
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());
				
				String newfilename = ip.getIPTimeRand() + "." + ext;
				
				//保存文件  需要抛出异常
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath,newfilename));
			
				//获取modelandview对象
				
				product.setPic(newfilename);												
			
			}
			
			if(file.getOriginalFilename()==null || "".equals(file.getOriginalFilename())){
				
				product.setPic(productservice.findById(product.getPid()).getPic());
			}
			
			productservice.updateProduct(product);
			
		return "redirect:list";
	}
	
	
	//商品名查询
	@RequestMapping(value="/find",method=RequestMethod.POST)
	public String findByPname(@Param("pname") String pname,Model model){
		
		System.out.println(pname+"---------------------");
		
		List<Product> li = productservice.findByName(pname);
		
		model.addAttribute("list", li);
		return "product/list";
	}
	
	//前台 商品首页
	@RequestMapping(value="/frontlist",method=RequestMethod.GET)
	public String frontlist(Model model){
		
		//最新商品
		List<Product> listnew = productservice.frontlistNew();
		
		//最热商品
		List<Product> listhot = productservice.frontlistHot();
		
		model.addAttribute("listnew", listnew);
		model.addAttribute("listhot", listhot);
		
		return "forward:/index.jsp";
	}
	
	//前台 商品详情页
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Product product,Model model){
		
		Product pro = productservice.findById(product.getPid());
		
		model.addAttribute("pro", pro);
		
		return "forword:/detail.jsp";
	}
}
