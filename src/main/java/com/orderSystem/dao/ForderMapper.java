package com.orderSystem.dao;

import com.orderSystem.entiry.Forder;
import com.orderSystem.entiry.ForderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForderMapper {
    long countByExample(ForderExample example);

    int deleteByExample(ForderExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Forder record);

    int insertSelective(Forder record);

    List<Forder> selectByExample(ForderExample example);

    Forder selectByPrimaryKey(Integer fid);

    int updateByExampleSelective(@Param("record") Forder record, @Param("example") ForderExample example);

    int updateByExample(@Param("record") Forder record, @Param("example") ForderExample example);

    int updateByPrimaryKeySelective(Forder record);

    int updateByPrimaryKey(Forder record);
}