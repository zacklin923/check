package com.zs.dao;

import com.zs.entity.ReportSign;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyExample;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.other.EasyUIAccept;

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
	//-----------------------------
    List<SourceThirdParty> queryFenye(EasyUIAccept accept);
	
    int getCount(EasyUIAccept accept);
    
    List<SourceThirdParty> queryByNumber(EasyUIAccept accept);
    //------签收报表--------------------------
    //生成某一天，某一个客户，某一个省份的签收报表，客户、省份没有则为改天所有
    List<ReportSign> queryReportSign(@Param("date") String date,@Param("ctmBarCode")String ctmBarCode,@Param("province")String province);
    
    int queryReportSignSucc(String date,String barCode,String ctmName,String province);
    int queryReportSignSuccTimeout(String date,String barCode,String ctmName,String province);
    int queryReportSignWait(String date,String barCode,String ctmName,String province);
}