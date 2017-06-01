package com.zs.dao;

import com.zs.entity.CheckLog;
import com.zs.entity.CheckLogExample;
import com.zs.entity.other.EasyUIAccept;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckLogMapper {
    int countByExample(CheckLogExample example);

    int deleteByExample(CheckLogExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(CheckLog record);

    int insertSelective(CheckLog record);

    List<CheckLog> selectByExample(CheckLogExample example);

    CheckLog selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") CheckLog record, @Param("example") CheckLogExample example);

    int updateByExample(@Param("record") CheckLog record, @Param("example") CheckLogExample example);

    int updateByPrimaryKeySelective(CheckLog record);

    int updateByPrimaryKey(CheckLog record);
  //-----------------------------
    List<CheckLog> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
}