package com.zs.dao;

import com.zs.entity.KdniaoLogisticcode;
import com.zs.entity.KdniaoLogisticcodeExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KdniaoLogisticcodeMapper {
    int countByExample(KdniaoLogisticcodeExample example);

    int deleteByExample(KdniaoLogisticcodeExample example);

    int deleteByPrimaryKey(String logisticcode);

    int insert(KdniaoLogisticcode record);

    int insertSelective(KdniaoLogisticcode record);

    List<KdniaoLogisticcode> selectByExample(KdniaoLogisticcodeExample example);

    KdniaoLogisticcode selectByPrimaryKey(String logisticcode);

    int updateByExampleSelective(@Param("record") KdniaoLogisticcode record, @Param("example") KdniaoLogisticcodeExample example);

    int updateByExample(@Param("record") KdniaoLogisticcode record, @Param("example") KdniaoLogisticcodeExample example);

    int updateByPrimaryKeySelective(KdniaoLogisticcode record);

    int updateByPrimaryKey(KdniaoLogisticcode record);
    
    List<String> query9000logisticcode();
    
    void UpdateLogisticcode(EasyUIAccept accept);
}