package com.zs.dao;

import com.zs.entity.StaffUser;
import com.zs.entity.StaffUserExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffUserMapper {
    int countByExample(StaffUserExample example);

    int deleteByExample(StaffUserExample example);

    int deleteByPrimaryKey(String stuNum);

    int insert(StaffUser record);

    int insertSelective(StaffUser record);

    List<StaffUser> selectByExample(StaffUserExample example);

    StaffUser selectByPrimaryKey(String stuNum);

    int updateByExampleSelective(@Param("record") StaffUser record, @Param("example") StaffUserExample example);

    int updateByExample(@Param("record") StaffUser record, @Param("example") StaffUserExample example);

    int updateByPrimaryKeySelective(StaffUser record);

    int updateByPrimaryKey(StaffUser record);
	//-----------------------------
    List<StaffUser> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
}