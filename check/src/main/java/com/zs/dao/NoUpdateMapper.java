package com.zs.dao;

import com.zs.entity.NoUpdate;
import com.zs.entity.NoUpdateExample;
import com.zs.entity.NoUpdateKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoUpdateMapper {
    int countByExample(NoUpdateExample example);

    int deleteByExample(NoUpdateExample example);

    int deleteByPrimaryKey(NoUpdateKey key);

    int insert(NoUpdate record);

    int insertSelective(NoUpdate record);

    List<NoUpdate> selectByExample(NoUpdateExample example);

    NoUpdate selectByPrimaryKey(NoUpdateKey key);

    int updateByExampleSelective(@Param("record") NoUpdate record, @Param("example") NoUpdateExample example);

    int updateByExample(@Param("record") NoUpdate record, @Param("example") NoUpdateExample example);

    int updateByPrimaryKeySelective(NoUpdate record);

    int updateByPrimaryKey(NoUpdate record);
    //------------------------------
    NoUpdate selectByNumberOfTp(@Param("number") String number);
    NoUpdate selectByNumberOfZm(@Param("number") String number);
}