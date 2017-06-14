package com.zs.dao;

import com.zs.entity.ReportData;
import com.zs.entity.ReportDataExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportDataMapper {
    int countByExample(ReportDataExample example);

    int deleteByExample(ReportDataExample example);

    int insert(ReportData record);

    int insertSelective(ReportData record);

    List<ReportData> selectByExample(ReportDataExample example);

    int updateByExampleSelective(@Param("record") ReportData record, @Param("example") ReportDataExample example);

    int updateByExample(@Param("record") ReportData record, @Param("example") ReportDataExample example);
	//----------
    List<ReportData> query(EasyUIAccept accept);
    
    void callproduce(EasyUIAccept accept);  
}