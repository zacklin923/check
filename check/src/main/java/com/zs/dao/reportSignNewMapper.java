package com.zs.dao;

import com.zs.entity.reportSignNew;
import com.zs.entity.reportSignNewExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface reportSignNewMapper {
    int countByExample(reportSignNewExample example);

    int deleteByExample(reportSignNewExample example);

    int insert(reportSignNew record);

    int insertSelective(reportSignNew record);

    List<reportSignNew> selectByExample(reportSignNewExample example);

    int updateByExampleSelective(@Param("record") reportSignNew record, @Param("example") reportSignNewExample example);

    int updateByExample(@Param("record") reportSignNew record, @Param("example") reportSignNewExample example);
    
    List<reportSignNew> sumidentify(EasyUIAccept accept);
    
    List<reportSignNew> sumall(EasyUIAccept accept);
    
    void callcode(EasyUIAccept accept);
    
    void callprovince(EasyUIAccept accept);
}