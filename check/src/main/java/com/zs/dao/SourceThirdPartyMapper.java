package com.zs.dao;

import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyExample;
import com.zs.entity.SourceThirdPartyKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SourceThirdPartyMapper {
    int countByExample(SourceThirdPartyExample example);

    int deleteByExample(SourceThirdPartyExample example);

    int deleteByPrimaryKey(SourceThirdPartyKey key);

    int insert(SourceThirdParty record);

    int insertSelective(SourceThirdParty record);

    List<SourceThirdParty> selectByExample(SourceThirdPartyExample example);

    SourceThirdParty selectByPrimaryKey(SourceThirdPartyKey key);

    int updateByExampleSelective(@Param("record") SourceThirdParty record, @Param("example") SourceThirdPartyExample example);

    int updateByExample(@Param("record") SourceThirdParty record, @Param("example") SourceThirdPartyExample example);

    int updateByPrimaryKeySelective(SourceThirdParty record);

    int updateByPrimaryKey(SourceThirdParty record);
}