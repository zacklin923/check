<%@page import="com.zs.tools.DateTimeHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看日志</title>

</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>

<style>
.panel-body {border-color: #E6E6E6; border:none;}
	#menulist{height:30px;}
	#mypanel{border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="height:87px;overflow: hidden">

		<div class="layout-header" style="position: relative">
			<div class="layout-title">
				<h3><a>深圳韵达有限公司</a></h3>
			</div>
			<div class="self_title">
				<a href="">查看日志</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a ><span class="iterm6"></span>统计</a>
                <a onclick="$('#exportdiv').dialog('open');"><span class="iterm7"></span>导出</a>
                <a onclick="search_toolbar()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px;box-sizing: content-box;overflow:hidden;" data-options="border:false" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                             

                                <li><label for="">操作用户</label>
                                    <input type="text" name ="str12">
                                </li>
                                <li> <label for="" name ="str9">操作类型</label>
                                    <input type="text" name ="str9" >
                                </li>
                                 <li> <label for="" name ="str9">操作单号</label>
                                    <input type="text" name ="str9" >
                                </li>
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">操作开始时间</label>
                                    <input style="height:23px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfNow().toString2()%>"/>
                                </li>
                                <li><label for="">操作结束时间</label>
                                    <input style="height:23px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString2()%>"/>
                                </li>

                                <li> <label for="">操作表名</label>
                                    &nbsp;<select class="my_select"  name ="int1"  id=""  style="color: #6B6B6B;font-weight: 300;margin-left:29px">
                                    <option value="" style="color: #6B6B6B;font-weight: 300;">--请选择--</option>
                                    <option value="1" style="color: #6B6B6B;font-weight: 300;">--运单信息状态表--</option>
                                    <option value="0" style="color: #6B6B6B;font-weight: 300;">--数据导入--</option>
                                    </select>
                                </li>
                            </ul>
                        </div>
                      
                        
                </form>
             </div>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
      <table id="dg" border="true" 
		url="<%=path %>/api/checklog"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="true" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="userNumber" width="100">操作用户</th>
			<th field="cretetime" width="200">操作时间</th>
			<th field="type" width="100" sortable="true">操作类型</th>
			<th field="tablename" data-options="
				formatter:function(value,row,index){
                             if(value =='zm_return_data'){
								return '运单信息状态表';
                          }else if(value =='source_import'){
								return '导入数据';
                          }else{
                          	return value;
                          }
                      }" width="150">操作表名</th>
			<th field="logisticcode" width="120" sortable="true">操作单号</th>
			<th field="olddata" width="1000">原数据</th>
			
		</tr>
	</thead>
</table>
		
</body>
</html>