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
<title>月报表</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
$(function(){
	stylesheet();
});
function stylesheet(){
	$('#search').form("submit",{
		url:"<%=path%>/api/reportMonth/style",
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
				s="[["+str+"]]";
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
	show_hint([]);
	$('#search').form("submit",{
		url:"<%=path %>/api/reportMonth/1",
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
					hiden_hint();
					alert(json.data);
					search_toolbar1();
				}else{
					hiden_hint();
					alert("错误:"+json.data);
				}
			}else{
				hiden_hint();
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
		url:"<%=path%>/api/reportMonth/exportExceltest",
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
		url="<%=path %>/api/reportMonth"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		fitColumns="true" singleSelect="true"
		rownumbers="true" 
		singleSelect="true" fit="true"
		showFooter="true">
</table>

<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="报表>月报表" data-options="collapsible:true">
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
		    		开始月份<input id="syear" style="width:50px;" min="2015" name="int2" type="number" value="<%=DateTimeHelper.getyear()%>"/>&nbsp;年&nbsp;<input id="smonth" style="width:40px;" name="int3" min="1" max="12" type="number" value="1"/>&nbsp;月
	    		</div>
	    		<div>
		    		结束月份<input id="eyear" style="width:50px;" min="2015" name="int4" type="number" value="<%=DateTimeHelper.getyear()%>"/>&nbsp;年&nbsp;<input id="emonth" style="width:40px;" name="int5" min="1" max="12" type="number" value="<%=DateTimeHelper.getmonth()%>"/>&nbsp;月
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
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
		<div class="pull-away"></div>
	</div>
</div>
</body>
</html>