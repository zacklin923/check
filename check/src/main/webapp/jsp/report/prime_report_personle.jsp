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
<title>成本收集导入</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>

<table id="dg" border="true" title="快件信息>导入数据"
		url="<%=path %>/api/primeCodeImport/personle"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		singleSelect="true" fit="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true">
	<thead>
		<tr>
			<th rowspan="2" field="stuNum" width="60">处理人</th>
			<th align="center" field="ctmdName" colspan="2" width="180" >截单</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >查件</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >留言</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >跟单</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >理赔处理</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >客诉处理</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >签收表</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >退件处理</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >审单</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >导单</th>
			<th rowspan="2" field="c21" width="60" sortable="true">日出货量</th>
		</tr>
		<tr>
			<th field="c1" width="100" sortable="true">处理量（票）</th>
			<th field="c2" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c3" width="100" sortable="true">处理量（票）</th>
			<th field="c4" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c5" width="100" sortable="true">处理量（票）</th>
			<th field="c6" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c7" width="100" sortable="true">处理量（票）</th>
			<th field="c8" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c9" width="100" sortable="true">处理量（票）</th>
			<th field="c10" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c11" width="100" sortable="true">处理量（票）</th>
			<th field="c12" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c13" width="100" sortable="true">处理量（票）</th>
			<th field="c14" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c15" width="100" sortable="true">处理量（票）</th>
			<th field="c16" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c17" width="100" sortable="true">处理量（票）</th>
			<th field="c18" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="c19" width="100" sortable="true">处理量（票）</th>
			<th field="c20" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = (value%3600)/60;
                      	var s = (value%3600)%60;
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator">
		<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
	</div>
	<br class="clear"/>
	<hr class="hr-geay">
	<form id="search">
   		<div class="searchBar-input">
   			<div>
	    		导入开始日期：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfNow().toString2()%>"/>
    		</div>
    		<div>
    			导入结束日期：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString2()%>"/>
    		</div>
    		<input type="hidden" name="_header" value="${licence }"/>
   		</div>
   		<div class="searchBar-input">
   			<div>
	    		导入人：<input name ="str1" />
    		</div>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
	<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
	<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">导出</a>
	<div class="pull-away"></div>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:500px;height:300px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true">
</div>

</body>
</html>