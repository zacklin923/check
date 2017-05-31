package com.zs.dao;

import com.zs.entity.VersionUpdate;
import com.zs.entity.VersionUpdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VersionUpdateMapper {
    int countByExample(VersionUpdateExample example);

    int deleteByExample(VersionUpdateExample example);

    int deleteByPrimaryKey(String verNum);

    int insert(VersionUpdate record);

    int insertSelective(VersionUpdate record);

    List<VersionUpdate> selectByExample(VersionUpdateExample example);

    VersionUpdate selectByPrimaryKey(String verNum);

    int updateByExampleSelective(@Param("record") VersionUpdate record, @Param("example") VersionUpdateExample example);

    int updateByExample(@Param("record") VersionUpdate record, @Param("example") VersionUpdateExample example);

    int updateByPrimaryKeySelective(VersionUpdate record);

    int updateByPrimaryKey(VersionUpdate record);
}