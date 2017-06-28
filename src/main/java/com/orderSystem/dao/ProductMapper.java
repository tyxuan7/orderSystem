package com.orderSystem.dao;

import com.orderSystem.entiry.Product;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer pid);
 
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> listProduct();
    
    
    List<Product> findByPname(String pname);
    
    //ǰ̨ 
    
    /**�г����µ�10����Ʒ
     * @return list
     */
    List<Product> frontlistNew();
    
    
    /**�г����ȵ�10����Ʒ
     * @return list
     */
    List<Product> frontlistHot();
    
    
    /**������Ʒ������
     * @param set ��Ʒ�ļ���
     * @return int 
     */
    int subProductNumber(@Param("list") Set<Product> set);
}