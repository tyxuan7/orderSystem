package com.orderSystem.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderSystem.dao.SorderMapper;
import com.orderSystem.entiry.Forder;
import com.orderSystem.entiry.Product;
import com.orderSystem.entiry.Sorder;
import com.orderSystem.service.interfaces.SorderService;

@Service
public class SorderSeriviceImpl implements SorderService {

	@Autowired
	private SorderMapper sorderMapper;
	
	@Override
	public Forder addSorder(Forder forder, Product product) {
		// TODO Auto-generated method stub
		boolean isHave = false;
		
		Sorder sorder = productToSorder(product);
		//判断当前购物项是否重复，如果重复则添加数量即可
		for(Sorder old : forder.getSorderSet()){
			if(old.getProduct().getPid().equals(sorder.getProduct().getPid())){
				
				old.setName(old.getName() + sorder.getName());
				old.setPrice(sorder.getPrice());
				isHave = true;
				break;
			}
		}
		//说明当前购物项  在购物车中是不是存在
		if(!isHave){
			forder.getSorderSet().add(sorder);
		}
		return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		// TODO Auto-generated method stub
		Sorder sorder = new Sorder();
		sorder.setName(product.getPname());
		sorder.setNumber(product.getNumber());
		sorder.setPrice(product.getCprice());
		sorder.setProduct(product);
		sorder.setPid(product.getPid());
		
		return sorder;
	}

	@Override
	public List<Sorder> listSorderByfid(int fid) {
		// TODO Auto-generated method stub
		List<Sorder> list = sorderMapper.listSorderByfid(fid);
		return list;
	}

}
