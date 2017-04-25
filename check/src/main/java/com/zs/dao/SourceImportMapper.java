package com.zs.dao;

import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceImportMapper {
    int countByExample(SourceImportExample example);

    int deleteByExample(SourceImportExample example);

    int deleteByPrimaryKey(BigDecimal courierNumber);

    int insert(SourceImport record);

    int insertSelective(SourceImport record);

    List<SourceImport> selectByExample(SourceImportExample example);

    SourceImport selectByPrimaryKey(BigDecimal courierNumber);

    int updateByExampleSelective(@Param("record") SourceImport record, @Param("example") SourceImportExample example);

    int updateByExample(@Param("record") SourceImport record, @Param("example") SourceImportExample example);

    int updateByPrimaryKeySelective(SourceImport record);

    int updateByPrimaryKey(SourceImport record);
}