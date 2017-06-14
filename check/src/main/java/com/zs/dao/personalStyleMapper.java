package com.zs.dao;

import com.zs.entity.personalStyle;
import com.zs.entity.personalStyleExample;
import com.zs.entity.other.EasyUIAccept;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface personalStyleMapper {
    int countByExample(personalStyleExample example);

    int deleteByExample(personalStyleExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(personalStyle record);

    int insertSelective(personalStyle record);

    List<personalStyle> selectByExample(personalStyleExample example);

    personalStyle selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") personalStyle record, @Param("example") personalStyleExample example);

    int updateByExample(@Param("record") personalStyle record, @Param("example") personalStyleExample example);

    int updateByPrimaryKeySelective(personalStyle record);

    int updateByPrimaryKey(personalStyle record);
    
    //---------
    List<personalStyle> querystyle(EasyUIAccept accept);
}