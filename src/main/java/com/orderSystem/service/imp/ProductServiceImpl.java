package com.orderSystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderSystem.dao.ProductMapper;
import com.orderSystem.entiry.Product;
import com.orderSystem.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	

	@Override
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		return productMapper.listProduct();
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.insert(product);
	}

	@Override
	public int deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.deleteByPrimaryKey(product.getPid());
	}

	@Override
	public Product findById(int pid) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(pid);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productMapper.updateByPrimaryKey(product);
	}

	@Override
	public List<Product> findByName(String pname) {
		// TODO Auto-generated method stub
		return productMapper.findByPname(pname);
	}

	@Override
	public List<Product> frontlistNew() {
		// TODO Auto-generated method stub
		return productMapper.frontlistNew();
	}

	@Override
	public List<Product> frontlistHot() {
		// TODO Auto-generated method stub
		return productMapper.frontlistHot();
	}

}
