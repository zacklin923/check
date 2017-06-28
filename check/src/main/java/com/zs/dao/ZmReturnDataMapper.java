package com.zs.dao;

import com.zs.entity.ReportSign;
import com.zs.entity.ZmReturnData;
import com.zs.entity.ZmReturnDataExample;
import com.zs.entity.other.EasyUIAccept;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZmReturnDataMapper {
    int countByExample(ZmReturnDataExample example);

    int deleteByExample(ZmReturnDataExample example);

    int deleteByPrimaryKey(String courierNumber);

    int insert(ZmReturnData record);

    int insertSelective(ZmReturnData record);

    List<ZmReturnData> selectByExample(ZmReturnDataExample example);

    ZmReturnData selectByPrimaryKey(String courierNumber);

    int updateByExampleSelective(@Param("record") ZmReturnData record, @Param("example") ZmReturnDataExample example);

    int updateByExample(@Param("record") ZmReturnData record, @Param("example") ZmReturnDataExample example);

    int updateByPrimaryKeySelective(ZmReturnData record);

    int updateByPrimaryKey(ZmReturnData record);
	//-----运单信息查询------------------------
    List<ZmReturnData> queryFenyeOfZm(EasyUIAccept accept);
    int getCountOfZm(EasyUIAccept accept);
    List<ZmReturnData> querySendToZm2(@Param("date")Date date);
    List<ZmReturnData> queryByNumberOfZm(EasyUIAccept accept);
    //-----运单状态查询------------------------
    List<ZmReturnData> queryFenyeOfTp(EasyUIAccept accept);
    int getCountOfTp(EasyUIAccept accept);
    List<ZmReturnData> queryByNumberOfTp(EasyUIAccept accept);
    //------签收报表--------------------------
    //生成某一天，某一个客户，某一个省份的签收报表，客户、省份没有则为改天所有
    List<ReportSign> queryReportSign(@Param("date") String date,@Param("ctmBarCode")String ctmBarCode,@Param("province")String province);
    int queryReportSignSucc(String date,String barCode,String ctmName,String province);
    int queryReportSignSuccTimeout(String date,String barCode,String ctmName,String province);
    int queryReportSignWait(String date,String barCode,String ctmName,String province);
    
}