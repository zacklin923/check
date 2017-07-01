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
<title>日报表</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
$(function(){
	stylesheet_1();
});
function stylesheet_1(){
	$('#search').form("submit",{
		url:"<%=path%>/api/reportDate/style",
		method:"GET",
		success:function(data){
			var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				var str = json.data;
				var str1 = str.split("_");
				s="[["+str1[0]+"],["+str1[1]+"]]";
				options={};
				options.columns = eval(s)
				$('#dg').datagrid(options);   
			}else{
				alert("错误:"+json.code);
			}
		}
	});
}
function refrence(){
	$('#search').form("submit",{
		url:"<%=path %>/api/reportDate/1",
		method:"GET",
		onSubmit: function(){   
		}, 
		success:function(data){
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					alert(json.data);
					search_toolbar1();
				}else{
					alert("错误:"+json.data);
				}
			}else{
				alert("错误:网络错误");
			}
		}
	});
}
function save(){
	$("#fm").form("submit",{
		url:url,		
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					$('#dg').datagrid('reload');
					$("#dlg").dialog("close");
				}else{
					alert("错误:"+json.code);
				}
			}else{
				alert("错误:网络错误");
			}
		}
	});
}

function search_toolbar1(){
	stylesheet();
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		isDgInit=true;
		$('#dg').datagrid('load', json);
	}
}
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/reportDate/exportExceltest",
		onSubmit: function(){   
		}, 
	    success:function(data){   
	    	var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				var d = eval('('+data+')');
				window.location.href=d.data;
			}else{
				alert("错误:"+json.data);
			}
	    } 
	});
	
}
</script>
<table id="dg" border="true"
		url="<%=path %>/api/reportDate"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		fitColumns="true" singleSelect="true"
		rownumbers="true" 
		singleSelect="true" fit="true"
		showFooter="true">
</table>

<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="报表>日报表" data-options="collapsible:true">
		<script>
		    $("#myPanel").panel({
		    	onCollapse:function() {
		    		$('#dg').datagrid('resize');
		        },
		    	onExpand:function() {
		    		$('#dg').datagrid('resize');
		        }
		    });
		</script>
		<div class="btn-separator-none">
			<a class="easyui-linkbutton" iconCls="icon-hgh-refresh" plain="true" onclick="refrence()">重新生成</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-input">
	    		<div>
		    		数据日期：<input name="date1" class="Wdate" type="text" onFocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" value="<%=DateTimeHelper.getolddate().toString4()%>"/>
	    		</div>
	   		</div>
	   		<div class="searchBar-input">
	    		<div>
	    			条码：<input name ="str1" />
	    		</div>
	    		<div>
	    			名称：<input name ="str2" />
	    		</div>
	    		<input type="hidden" name="_header" value="${licence }"/>
	   		</div>
	   		<div class="searchBar-input">
	   			<div style="float:left;margin-left:30px;font-size:14px;">
	    			统计方式:<input style="width:15px;height:15px;" name="int1" type="radio" value="4"/>大区
	    			<input style="width:15px;height:15px;" name="int1" type="radio" value="3"/>区部</br>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    			<input style="width:15px;height:15px;" name="int1" type="radio" value="2"/>分部
	    			<input style="width:15px;height:15px;" name="int1" type="radio" value="1" checked="checked"/>条码
	    		</div>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar1()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
		<div class="pull-away"></div>
	</div>
</div>
</body>
</html>