package com.zs.dao;

import com.zs.entity.SourceImportFailed;
import com.zs.entity.SourceImportFailedExample;
import com.zs.entity.other.EasyUIAccept;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceImportFailedMapper {
    int countByExample(SourceImportFailedExample example);

    int deleteByExample(SourceImportFailedExample example);

    int deleteByPrimaryKey(BigDecimal sifId);

    int insert(SourceImportFailed record);

    int insertSelective(SourceImportFailed record);

    List<SourceImportFailed> selectByExample(SourceImportFailedExample example);

    SourceImportFailed selectByPrimaryKey(BigDecimal sifId);

    int updateByExampleSelective(@Param("record") SourceImportFailed record, @Param("example") SourceImportFailedExample example);

    int updateByExample(@Param("record") SourceImportFailed record, @Param("example") SourceImportFailedExample example);

    int updateByPrimaryKeySelective(SourceImportFailed record);

    int updateByPrimaryKey(SourceImportFailed record);
    
  //-----------------------------
    List<SourceImportFailed> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
    
    int deleteAll(@Param("stuNum") String stuNum);
}