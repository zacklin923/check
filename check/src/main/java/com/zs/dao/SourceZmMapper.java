package com.zs.dao;

import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceZmMapper {
    int countByExample(SourceZmExample example);

    int deleteByExample(SourceZmExample example);

    int deleteByPrimaryKey(BigDecimal courierNumber);

    int insert(SourceZm record);

    int insertSelective(SourceZm record);

    List<SourceZm> selectByExample(SourceZmExample example);

    SourceZm selectByPrimaryKey(BigDecimal courierNumber);

    int updateByExampleSelective(@Param("record") SourceZm record, @Param("example") SourceZmExample example);

    int updateByExample(@Param("record") SourceZm record, @Param("example") SourceZmExample example);

    int updateByPrimaryKeySelective(SourceZm record);

    int updateByPrimaryKey(SourceZm record);
}