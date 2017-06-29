package com.orderSystem.service.interfaces;

import java.util.List;

import com.orderSystem.entiry.Forder;
import com.orderSystem.entiry.Product;
import com.orderSystem.entiry.Sorder;

public interface SorderService {
	
	//���㹺���ܼ۸�
	public Forder addSorder(Forder forder,Product product);
	
	//��Ʒת���ɶ�����
	public Sorder productToSorder(Product product);
	
	/** ͨ������id��ѯ������
	 * @param fid
	 * @return
	 */
	public List<Sorder> listSorderByfid(int fid);
}
