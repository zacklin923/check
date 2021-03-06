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
<title>时效控制管理</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/framework/autoComplete/jquery.autocomplete.css"></link>
<script type="text/javascript" src="<%=path %>/framework/autoComplete/jquery.autocomplete.js"></script>
<script type="text/javascript">
var url;
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${user.licence }");
	$("#fm input[name='beginProvince']").val("深圳");
	url="<%=path%>/api/timeLimit";
}
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
		url="<%=path%>/api/timeLimit/"+row.orderNumber;
	}
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
function deleteObj(){
	var row=$("#dg").datagrid("getSelected");
	var id=row.orderNumber;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path%>/api/timeLimit/"+id,
						type:"delete",
						success:function(data){
							var json;
							if(isJson(data)){
								json=data;
							}else{
								json = eval('('+data+')');
							}
							if(json.result=='success'){
								$('#dg').datagrid('reload');
							}else{
								alert("错误:"+json.code);
							}
						}
					});
				}
			}
		);
	}
}
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/timeLimit/excelExport",
		method:"get",
		onSubmit: function(){   
			show_hint([]);
	    },   
	    success:function(data){
	    	hiden_hint();
	    	if(data){
	    		var json=null;
				if(isJson(data)){
					json=data;
				}else{
					try {
						json = eval('('+data+')');
					} catch (e) {
						alert(data);
					}
				}
				if(json!=null){
					if(json.result=='success'){
						window.location.href=json.data;
					}else{
						alert("错误:"+json.data+" "+json.data);
					}
				}else{
					alert("错误:json解析错误");
				}
	    	}else{
	    		alert("错误:网络错误");
	    	}
	    } 
	});
}
$(function(){
	var ep=$("#fm input[name='endProvince']");	
	ep.AutoComplete({
	    "data": "<%=path%>/api/provinceCode/province"+ep.val(),
	    "ajaxDataType": "json",
	    "width": "auto",
	    "onerror": function(msg){alert(msg);}
	});
});
</script>
<table id="dg" border="true" 
		url="<%=path %>/api/timeLimit"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="orderNumber" width="100" sortable="true">编号</th>
			<th field="beginProvince" width="150">始发中转站</th>
			<th field="endProvince" width="200" sortable="true">到达省份</th>
			<th field="hourCost" width="100" sortable="true" data-options="
				formatter:function(value,row,index){
                    if(row.hourCost){
						return row.hourCost.toFixed(2);
                    }
             	}">小时</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="基础信息维护>时效控制信息管理" data-options="collapsible:true">
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
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addObj()">添加时效</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑时效</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除时效</a>
		</div>
		<div class="btn-separator">
			<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-input">
	    		<div>
		    		始发中转站：<input name ="str1" />
	    		</div>
	    		<div>
		    		到达省份：<input name ="str2" />
	    		</div>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
		<div class="pull-away"></div>
	</div>
</div>

<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">时效控制信息</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<input type="hidden" name="orderNumber"/>
		<div class="fitem">
			<label>始发中转站:</label>
			<input name="beginProvince" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>到达省份:</label>
			<input name="endProvince" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>小时:</label>
			<input name="hourCost" class="easyui-validatebox" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:50%;height:100%;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/province.jsp" cache="true" resizable="true">
</div>
</body>
</html>