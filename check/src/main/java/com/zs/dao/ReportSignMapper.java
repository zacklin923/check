package com.zs.dao;

import com.zs.entity.ReportSign;
import com.zs.entity.ReportSignExample;
import com.zs.entity.ReportSignKey;
import com.zs.entity.other.EasyUIAccept;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportSignMapper {
    int countByExample(ReportSignExample example);

    int deleteByExample(ReportSignExample example);

    int deleteByPrimaryKey(ReportSignKey key);

    int insert(ReportSign record);

    int insertSelective(ReportSign record);

    List<ReportSign> selectByExample(ReportSignExample example);

    ReportSign selectByPrimaryKey(ReportSignKey key);

    int updateByExampleSelective(@Param("record") ReportSign record, @Param("example") ReportSignExample example);

    int updateByExample(@Param("record") ReportSign record, @Param("example") ReportSignExample example);

    int updateByPrimaryKeySelective(ReportSign record);

    int updateByPrimaryKey(ReportSign record);
    //-----------------------------
    List<ReportSign> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
    
    int deleteByDate(@Param("date") String date,@Param("ctmBarCode")String ctmBarCode,@Param("province")String province);
    
}