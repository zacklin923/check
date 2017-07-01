package com.zs.dao;

import com.zs.entity.KdniaoReturn;
import com.zs.entity.KdniaoReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KdniaoReturnMapper {
    int countByExample(KdniaoReturnExample example);

    int deleteByExample(KdniaoReturnExample example);

    int insert(KdniaoReturn record);

    int insertSelective(KdniaoReturn record);

    List<KdniaoReturn> selectByExample(KdniaoReturnExample example);

    int updateByExampleSelective(@Param("record") KdniaoReturn record, @Param("example") KdniaoReturnExample example);

    int updateByExample(@Param("record") KdniaoReturn record, @Param("example") KdniaoReturnExample example);
}