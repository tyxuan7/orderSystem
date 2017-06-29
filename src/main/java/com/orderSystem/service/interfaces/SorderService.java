package com.orderSystem.service.interfaces;

import java.util.List;

import com.orderSystem.entiry.Forder;
import com.orderSystem.entiry.Product;
import com.orderSystem.entiry.Sorder;

public interface SorderService {
	
	//计算购物总价格
	public Forder addSorder(Forder forder,Product product);
	
	//商品转化成订单项
	public Sorder productToSorder(Product product);
	
	/** 通过订单id查询订单项
	 * @param fid
	 * @return
	 */
	public List<Sorder> listSorderByfid(int fid);
}
