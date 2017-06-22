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
<title>签收报表</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/timeLimit/excelExport",
		method:"get",
		onSubmit: function(){   
	        // do some check   
	        // return false to prevent submit;   
	    },   
	    success:function(data){   
			if(data!=null){
		    	var d = eval('('+data+')');
		    	window.location.href=d.data;
			}
	    } 
	});
}
function obtain(){
	alert("您还没有选择发货日期");
}
function search_toolbar_1(){
	var ratioSign1=$("#dg").datagrid("getColumnOption","ratioSign1");
	var ratioTimeout1=$("#dg").datagrid("getColumnOption","ratioTimeout1");
	var ratioSign2=$("#dg").datagrid("getColumnOption","ratioSign2");
	var ratioTimeout2=$("#dg").datagrid("getColumnOption","ratioTimeout2");
	var ratioSign3=$("#dg").datagrid("getColumnOption","ratioSign3");
	var ratioTimeout3=$("#dg").datagrid("getColumnOption","ratioTimeout3");
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		if(json.int1=="1"){
			$("#dg").datagrid("hideColumn","ratioSign2");
			$("#dg").datagrid("hideColumn","ratioTimeout2");
			$("#dg").datagrid("hideColumn","ratioSign3");
			$("#dg").datagrid("hideColumn","ratioTimeout3");
			$("#dg").datagrid("showColumn","ratioSign1");
			$("#dg").datagrid("showColumn","ratioTimeout1");
			$("#dg").datagrid("showColumn","province");
			$("#dg").datagrid("showColumn","costHour");
			$("#dg").datagrid("showColumn","ctmBarCode");
			$("#dg").datagrid("showColumn","ctmName");
		}else if(json.int1=="2"){
			$("#dg").datagrid("hideColumn","ratioSign1");
			$("#dg").datagrid("hideColumn","ratioTimeout1");
			$("#dg").datagrid("hideColumn","ratioSign3");
			$("#dg").datagrid("hideColumn","ratioTimeout3");
			$("#dg").datagrid("hideColumn","province");
			$("#dg").datagrid("hideColumn","costHour");
			$("#dg").datagrid("showColumn","ratioSign2");
			$("#dg").datagrid("showColumn","ratioTimeout2");
			$("#dg").datagrid("showColumn","ctmBarCode");
			$("#dg").datagrid("showColumn","ctmName");
		}else if(json.int1=="3"){
			$("#dg").datagrid("hideColumn","ratioSign1");
			$("#dg").datagrid("hideColumn","ratioTimeout1");
			$("#dg").datagrid("hideColumn","ratioSign2");
			$("#dg").datagrid("hideColumn","ratioTimeout2");
			$("#dg").datagrid("hideColumn","province");
			$("#dg").datagrid("hideColumn","costHour");
			$("#dg").datagrid("hideColumn","ctmBarCode");
			$("#dg").datagrid("hideColumn","ctmName");
			$("#dg").datagrid("showColumn","ratioSign3");
			$("#dg").datagrid("showColumn","ratioTimeout3");
		}
	}
	search_toolbar();
}
</script>
<table id="dg" border="true" title="报表>签收报表"
		url="<%=path %>/api/reportSign"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="false"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true">
	<thead>
		<tr>
			<th field="beginCity" width="100">出发</th>
			<th field="ctmName" width="150">客户</th>
			<th field="ctmBarCode" width="200">客户条码</th>
			<th field="province" width="200">目的地</th>
			<th field="costHour" width="200">时效</th>
			<th field="ratioSign1" width="200" data-options="
				formatter:function(value,row,index){
                    if(row.ratioSign){
						return (row.ratioSign*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户各省签收率</th>
			<th field="ratioTimeout1" width="200" data-options="
				formatter:function(value,row,index){
                    if(row.ratioTimeout){
						return (row.ratioTimeout*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户各省超时率</th>
			<th field="ratioSign2" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioSign){
						return (row.ratioSign*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户签收率</th>
			<th field="ratioTimeout2" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioTimeout){
						return (row.ratioTimeout*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户超时率</th>
			<th field="ratioSign3" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioSign){
						return (row.ratioSign*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">总签收率</th>
			<th field="ratioTimeout3" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioTimeout){
						return (row.ratioTimeout*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">总超时率</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obtain()">重新生成</a>
	</div>
	<div class="btn-separator">
		<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
	</div>
	<br class="clear"/>
	<hr class="hr-geay">
	<form id="search">
   		<div class="searchBar-input">
    		<div>
	    		发货日期开始：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd'})" value="<%=DateTimeHelper.getBeginOfOld().toString3()%>"/>
    		</div>
    		<div>
	    		发货日期结束：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd'})" value="<%=DateTimeHelper.getEndOfOld().toString3()%>"/>
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		客户名称：<input name="str1"/> 
    		</div>
    		<div>
	    		客户条码：<input name="str2"/>
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		<input style="width:15px;height:15px;" name="int1" type="radio" value="1" checked="checked"/>按客户省份汇总</br>
    			<input style="width:15px;height:15px;" name="int1" type="radio" value="2"/>按客户汇总
    			<input style="width:15px;height:15px;" name="int1" type="radio" value="3"/>总签收率
    		</div>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar_1()">查询</a>
	<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()" disabled="true">导出</a>
	<div class="pull-away"></div>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:1000px;height:600px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/province.jsp" cache="true">
</div>
</body>
</html>