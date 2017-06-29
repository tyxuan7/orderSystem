package com.orderSystem.service.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orderSystem.dao.ForderMapper;
import com.orderSystem.dao.ProductMapper;
import com.orderSystem.dao.SorderMapper;
import com.orderSystem.entiry.Forder;
import com.orderSystem.entiry.Product;
import com.orderSystem.entiry.Sorder;
import com.orderSystem.service.interfaces.ForderService;

@Service
public class ForderSeriviceImpl implements ForderService {

	@Autowired
	private ForderMapper fordermapper;
	
	@Autowired
	private SorderMapper sordermapper;
	
	@Autowired
	private ProductMapper productmapper;
	
	//计算订单价格
	@Override
	public Double cluTotal(Forder forder) {
		// TODO Auto-generated method stub
		double tal = 0.0;
		for(Sorder tmep : forder.getSorderSet()){
			
			tal +=tmep.getPrice()*tmep.getNumber();
		}
		return tal;
	}

	@Transactional
	@Override
	public int insertOrder(Forder forder, Forder sessionforder)
			throws Exception {
		// 插入订单
		int count = fordermapper.insert(forder);
		
		//判断
		if(count <= 0){
			throw new Exception("订单插入异常");
		}else{
			int fid = forder.getFid();
			
			Set<Sorder> sorderSet = sessionforder.getSorderSet();
			
			for(Sorder sorder : sorderSet){
				
				sorder.setFid(fid);
			}
			
			//插入订单项
			for(Sorder sorder : sorderSet){
				
				count = sordermapper.insert(sorder);
				
				if(count <= 0){
					throw new Exception("插入订单异常");
				}
			}
			
			Set<Product> productSet = new HashSet<Product>();
			
			for(Sorder sorder : sorderSet){
				productSet.add(sorder.getProduct());
			}
			
			//更新商品数量
			count = productmapper.subProductNumber(productSet);
			
			if(count <= 0){
				throw new Exception("商品库存不足");
			}
		}
		return count;
	}

	@Override
	public List<Forder> selectList() {
		// TODO Auto-generated method stub
		return fordermapper.selectList();
	}

	@Transactional
	@Override
	public int deleteByPrimaryKey(int fid) throws Exception {
		// TODO Auto-generated method stub
		int count = sordermapper.deleteByFid(fid);
		
		if(count <= 0){
			throw new Exception("删除失败");
		}
		count = fordermapper.deleteByPrimaryKey(fid);
		if(count <= 0){
			throw new Exception("删除失败");
		}
		return count;
	}

}
