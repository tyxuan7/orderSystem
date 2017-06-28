package com.orderSystem.dao;

import com.orderSystem.entiry.User;
import com.orderSystem.entiry.UserExample;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**����û���
     * @return list
     */
    int checkUsername(String username);
    
    /**��½
     * @return int
     */
    
    User login(User user);
}