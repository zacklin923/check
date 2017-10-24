package com.zs.dao;

import com.zs.entity.ItCommonUser;
import com.zs.entity.ItCommonUserExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItCommonUserMapper {
    int countByExample(ItCommonUserExample example);

    int deleteByExample(ItCommonUserExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(ItCommonUser record);

    int insertSelective(ItCommonUser record);

    List<ItCommonUser> selectByExample(ItCommonUserExample example);

    ItCommonUser selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") ItCommonUser record, @Param("example") ItCommonUserExample example);

    int updateByExample(@Param("record") ItCommonUser record, @Param("example") ItCommonUserExample example);

    int updateByPrimaryKeySelective(ItCommonUser record);

    int updateByPrimaryKey(ItCommonUser record);
}