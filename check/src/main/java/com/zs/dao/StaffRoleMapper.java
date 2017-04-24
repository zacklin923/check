package com.zs.dao;

import com.zs.entity.StaffRole;
import com.zs.entity.StaffRoleExample;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffRoleMapper {
    int countByExample(StaffRoleExample example);

    int deleteByExample(StaffRoleExample example);

    int deleteByPrimaryKey(BigDecimal strId);

    int insert(StaffRole record);

    int insertSelective(StaffRole record);

    List<StaffRole> selectByExample(StaffRoleExample example);

    StaffRole selectByPrimaryKey(BigDecimal strId);

    int updateByExampleSelective(@Param("record") StaffRole record, @Param("example") StaffRoleExample example);

    int updateByExample(@Param("record") StaffRole record, @Param("example") StaffRoleExample example);

    int updateByPrimaryKeySelective(StaffRole record);

    int updateByPrimaryKey(StaffRole record);
  //-----------------------------
    List<StaffRole> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
}