package com.zs.dao;

import com.zs.entity.ReportMonth;
import com.zs.entity.ReportMonthExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportMonthMapper {
    int countByExample(ReportMonthExample example);

    int deleteByExample(ReportMonthExample example);

    int insert(ReportMonth record);

    int insertSelective(ReportMonth record);

    List<ReportMonth> selectByExample(ReportMonthExample example);

    int updateByExampleSelective(@Param("record") ReportMonth record, @Param("example") ReportMonthExample example);

    int updateByExample(@Param("record") ReportMonth record, @Param("example") ReportMonthExample example);
    //----------
    List<ReportMonth> query(EasyUIAccept accept);
    
    void callproduce(EasyUIAccept accept); 
}