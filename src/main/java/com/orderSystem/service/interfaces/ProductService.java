package com.orderSystem.service.interfaces;

import java.util.List;

import com.orderSystem.entiry.Product;

public interface ProductService {
	
	List<Product> listProduct();
	
	//�����Ʒ
	int addProduct(Product product);
	
	//ɾ����Ʒ
	int deleteProduct(Product product);
	
	//������ƷID��ѯ
	Product findById(int pid);
	
	//������Ʒ
	int updateProduct(Product product);
	
	//������Ʒ���Ʋ�ѯ
	List<Product> findByName(String pname);
	
	 /**�г����µ�10����Ʒ
     * @return list
     */
    List<Product> frontlistNew();
    
    
    /**�г����ȵ�10����Ʒ
     * @return list
     */
    List<Product> frontlistHot();
	
}
