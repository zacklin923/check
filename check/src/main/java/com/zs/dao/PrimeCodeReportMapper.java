package com.zs.dao;

import com.zs.entity.PrimeCodeReport;
import com.zs.entity.PrimeCodeReportExample;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.OtherResultMap;
import com.zs.entity.other.PerResultMap;
import com.zs.entity.other.PrimeCodeCollect;
import com.zs.entity.other.lyResultMap;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrimeCodeReportMapper {
    int countByExample(PrimeCodeReportExample example);

    int deleteByExample(PrimeCodeReportExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(PrimeCodeReport record);

    int insertSelective(PrimeCodeReport record);

    List<PrimeCodeReport> selectByExample(PrimeCodeReportExample example);

    PrimeCodeReport selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") PrimeCodeReport record, @Param("example") PrimeCodeReportExample example);

    int updateByExample(@Param("record") PrimeCodeReport record, @Param("example") PrimeCodeReportExample example);

    int updateByPrimaryKeySelective(PrimeCodeReport record);

    int updateByPrimaryKey(PrimeCodeReport record);
    
    //-------
    List<PrimeCodeReport> queryFenye(EasyUIAccept accept);
	
    List<PrimeCodeReport> queryCount(EasyUIAccept accept);

    int getCount(EasyUIAccept accept);
    
    lyResultMap getLy(EasyUIAccept accept);
    
    OtherResultMap getOthers(EasyUIAccept accept);
    
    OtherResultMap getOtherExcptions(EasyUIAccept accept);
    
    List<PerResultMap> getPerReport (EasyUIAccept accept);
    
}