package com.orderSystem.service.interfaces;

import java.util.List;

import com.orderSystem.entiry.Product;

public interface ProductService {
	
	List<Product> listProduct();
	
	//添加商品
	int addProduct(Product product);
	
	//删除商品
	int deleteProduct(Product product);
	
	//根据商品ID查询
	Product findById(int pid);
	
	//更新商品
	int updateProduct(Product product);
	
	//根据商品名称查询
	List<Product> findByName(String pname);
	
	 /**列出最新的10条商品
     * @return list
     */
    List<Product> frontlistNew();
    
    
    /**列出最热的10条商品
     * @return list
     */
    List<Product> frontlistHot();
	
}
