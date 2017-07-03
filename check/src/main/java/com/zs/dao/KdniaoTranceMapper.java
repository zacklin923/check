package com.zs.dao;

import com.zs.entity.KdniaoTrance;
import com.zs.entity.KdniaoTranceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KdniaoTranceMapper {
    int countByExample(KdniaoTranceExample example);

    int deleteByExample(KdniaoTranceExample example);

    int insert(KdniaoTrance record);

    int insertSelective(KdniaoTrance record);

    List<KdniaoTrance> selectByExample(KdniaoTranceExample example);

    int updateByExampleSelective(@Param("record") KdniaoTrance record, @Param("example") KdniaoTranceExample example);

    int updateByExample(@Param("record") KdniaoTrance record, @Param("example") KdniaoTranceExample example);
}