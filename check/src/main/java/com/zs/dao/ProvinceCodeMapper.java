package com.zs.dao;

import com.zs.entity.Customer;
import com.zs.entity.ProvinceCode;
import com.zs.entity.ProvinceCodeExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceCodeMapper {
    int countByExample(ProvinceCodeExample example);

    int deleteByExample(ProvinceCodeExample example);

    int deleteByPrimaryKey(String provinceCode);

    int insert(ProvinceCode record);

    int insertSelective(ProvinceCode record);

    List<ProvinceCode> selectByExample(ProvinceCodeExample example);

    ProvinceCode selectByPrimaryKey(String provinceCode);

    int updateByExampleSelective(@Param("record") ProvinceCode record, @Param("example") ProvinceCodeExample example);

    int updateByExample(@Param("record") ProvinceCode record, @Param("example") ProvinceCodeExample example);

    int updateByPrimaryKeySelective(ProvinceCode record);

    int updateByPrimaryKey(ProvinceCode record);
    
    //-----------------------
    List<ProvinceCode> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
    
    List<String> selectProvince(@Param("pro") String pro);
    
}