package com.zs.dao;

import com.zs.entity.StaffPower;
import com.zs.entity.StaffPowerExample;
import com.zs.entity.StaffRole;
import com.zs.entity.other.EasyUIAccept;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffPowerMapper {
    int countByExample(StaffPowerExample example);

    int deleteByExample(StaffPowerExample example);

    int deleteByPrimaryKey(BigDecimal stpId);

    int insert(StaffPower record);

    int insertSelective(StaffPower record);

    List<StaffPower> selectByExample(StaffPowerExample example);

    StaffPower selectByPrimaryKey(BigDecimal stpId);

    int updateByExampleSelective(@Param("record") StaffPower record, @Param("example") StaffPowerExample example);

    int updateByExample(@Param("record") StaffPower record, @Param("example") StaffPowerExample example);

    int updateByPrimaryKeySelective(StaffPower record);

    int updateByPrimaryKey(StaffPower record);
    //-----------------------------
    List<StaffPower> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
}