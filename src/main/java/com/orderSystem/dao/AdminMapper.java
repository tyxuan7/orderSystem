package com.orderSystem.dao;

import com.orderSystem.entiry.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
   

    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aid);
 
    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin findByAdmin(@Param("username") String username,@Param("password") String password);
}