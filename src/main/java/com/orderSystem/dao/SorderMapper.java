package com.orderSystem.dao;

import com.orderSystem.entiry.Sorder;
import com.orderSystem.entiry.SorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SorderMapper {
    long countByExample(SorderExample example);

    int deleteByExample(SorderExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Sorder record);

    int insertSelective(Sorder record);

    List<Sorder> selectByExample(SorderExample example);

    Sorder selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Sorder record, @Param("example") SorderExample example);

    int updateByExample(@Param("record") Sorder record, @Param("example") SorderExample example);

    int updateByPrimaryKeySelective(Sorder record);

    int updateByPrimaryKey(Sorder record);
}