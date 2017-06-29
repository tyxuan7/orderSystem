package com.orderSystem.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orderSystem.entiry.Forder;

@Service
public interface ForderService {
	
	public Double cluTotal(Forder forder);
	
	public int insertOrder(Forder forder,Forder sessionforder) throws Exception;
	
	public List<Forder> selectList();
	
	public int deleteByPrimaryKey(int fid) throws Exception;
}
