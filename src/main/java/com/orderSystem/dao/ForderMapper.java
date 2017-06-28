package com.orderSystem.dao;

import com.orderSystem.entiry.Forder;
import java.util.List;


public interface ForderMapper {
   
    int deleteByPrimaryKey(Integer fid);

    int insert(Forder record);

    int insertSelective(Forder record);

    Forder selectByPrimaryKey(Integer fid);
    
    List<Forder> selectList();

    int updateByPrimaryKeySelective(Forder record);

    int updateByPrimaryKey(Forder record);
}