package com.orderSystem.dao;

import com.orderSystem.entiry.Sorder;
import java.util.List;

public interface SorderMapper {
  int deleteByPrimaryKey(Integer sid);

    int insert(Sorder record);

    int insertSelective(Sorder record);

    Sorder selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Sorder record);

    int updateByPrimaryKey(Sorder record);
    
    int deleteByFid(int fid);
    
    /** 通过订单id查询订单项
   	 * @param fid
   	 * @return
   	 */
   	public List<Sorder> listSorderByfid(int fid);
}