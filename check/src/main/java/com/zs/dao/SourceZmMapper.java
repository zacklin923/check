package com.zs.dao;

import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmExample;
import com.zs.entity.SourceZmKey;
import com.zs.entity.other.EasyUIAccept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceZmMapper {
    int countByExample(SourceZmExample example);

    int deleteByExample(SourceZmExample example);

    int deleteByPrimaryKey(SourceZmKey key);

    int insert(SourceZm record);

    int insertSelective(SourceZm record);

    List<SourceZm> selectByExample(SourceZmExample example);

    SourceZm selectByPrimaryKey(SourceZmKey key);

    int updateByExampleSelective(@Param("record") SourceZm record, @Param("example") SourceZmExample example);

    int updateByExample(@Param("record") SourceZm record, @Param("example") SourceZmExample example);

    int updateByPrimaryKeySelective(SourceZm record);

    int updateByPrimaryKey(SourceZm record);
	//-----------------------------
    List<SourceZm> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
}