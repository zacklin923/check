package com.zs.dao;

import com.zs.entity.ModuleLine;
import com.zs.entity.ModuleLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModuleLineMapper {
    int countByExample(ModuleLineExample example);

    int deleteByExample(ModuleLineExample example);

    int deleteByPrimaryKey(String id);

    int insert(ModuleLine record);

    int insertSelective(ModuleLine record);

    List<ModuleLine> selectByExample(ModuleLineExample example);

    ModuleLine selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ModuleLine record, @Param("example") ModuleLineExample example);

    int updateByExample(@Param("record") ModuleLine record, @Param("example") ModuleLineExample example);

    int updateByPrimaryKeySelective(ModuleLine record);

    int updateByPrimaryKey(ModuleLine record);
	 //-----
    List<ModuleLine> queryTable(@Param("tbn")String tbn);
}