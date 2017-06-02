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
<title>日志表</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">

</script>
<table id="dg" border="true" title="系统管理>查看日志"
		url="<%=path %>/api/checklog"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="userNumber" width="100">操作用户</th>
			<th field="cretetime" width="200">操作时间</th>
			<th field="type" width="100" sortable="true">操作类型</th>
			<th field="tablename" data-options="
				formatter:function(value,row,index){
                             if(value =='source_third_party'){
								return '运单状态查询';
                          }else if(value =='source_zm'){
								return '运单信息查询';
                          }else if(value =='source_import'){
								return '导入数据';
                          }
                      }" width="200">操作表名</th>
			<th field="logisticcode" width="150" sortable="true">操作单号</th>
			<th field="idDate" width="100">时间</th>
			<th field="olddata" width="800">原数据</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<hr class="hr-geay">
	<form id="search">
		<div class="searchBar-input">
    		<div>
	    		操作时间开始：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd'})" />
    		</div>
    		<div>
    			操作时间结束：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd'})"/>
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		操作用户：<input name ="str1" />
    		</div>
    		<div>
    			操作类型：<input name ="str2" />
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		操作表名：<select name ="str3" style="width:170px;">
	    					<option value ="">请选择。。。</option>
	    					<option value ="source_zm">运单信息查询</option>
	    					<option value ="source_third_party">运单状态查询</option>
	    					<option value ="source_import">数据导入</option>
	    				</select>
    		</div>
    		<div>
    			操作单号：<input name ="str4" />
    		</div>
    		<input type="hidden" name="_header" value="${licence }"/>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
	<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
	<div class="pull-away"></div>
</div>
</body>
</html>