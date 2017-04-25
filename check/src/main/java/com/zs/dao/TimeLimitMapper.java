package com.zs.dao;

import com.zs.entity.TimeLimit;
import com.zs.entity.TimeLimitExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeLimitMapper {
    int countByExample(TimeLimitExample example);

    int deleteByExample(TimeLimitExample example);

    int deleteByPrimaryKey(BigDecimal orderNumber);

    int insert(TimeLimit record);

    int insertSelective(TimeLimit record);

    List<TimeLimit> selectByExample(TimeLimitExample example);

    TimeLimit selectByPrimaryKey(BigDecimal orderNumber);

    int updateByExampleSelective(@Param("record") TimeLimit record, @Param("example") TimeLimitExample example);

    int updateByExample(@Param("record") TimeLimit record, @Param("example") TimeLimitExample example);

    int updateByPrimaryKeySelective(TimeLimit record);

    int updateByPrimaryKey(TimeLimit record);
}