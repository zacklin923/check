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
<title>角色管理</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
<!-- 
$(function(){  
    $("#csId").combotree({  
            url:'/check/api/users/cs', 
            method:'get'
        });  
    });  
	$.ajax({
		type:"GET",
		url:"/check/api/users/role",
		data:"",
		success:function(data){
			str="";
			for(var i = 0; i < data.length; i++) {
				str=str+"<option value='"+data[i].rId+"'>"+data[i].rName+"</option>"
			}
			$("#roleId").html(str);
		}
	});
var url;
-->
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${user.licence }");
	url="<%=path %>/api/role";
	obtain(url);
}

function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
		url="<%=path %>/api/users/"+row.uNum;
	}
}
function save(){
	console.log($("#fm").serializeArray());
	$("#fm").form("submit",{
		url:url,		
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			console.log("提交:"+data);
			$('#dg').datagrid('reload');
		}
	});
}
function deleteObj(){
	var row=$("#dg").datagrid("getSelected");
	var uNum=row.uNum;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"/quota/api/users/"+uNum,
						type:"delete",
						success:function(data){
							console.log(data);
							$('#dg').datagrid('reload');
						}
					});
				}
			}
		);
	}
}
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path %>/api/users/excelExport",
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

function obtain(url){
	$.ajax({
		type:"get",
		url:url,
		success: function(data){
			console.log(data);
			str="";
			for(var i = 0; i < data.length; i++) {
				if(data[i].rp=="succ"){
					str=str+"<input style='height:15px;' checked='checked'  name='per"+data[i].pId+"' type='checkbox' value='"+data[i].pId+"' />";
				}else{
					str=str+"<input style='height:15px;' name='per"+data[i].pId+"' type='checkbox' value='"+data[i].pId+"' />";
				}
				str=str+"<span>"+data[i].pId+"."+data[i].pName+"</span></br>";
			}
			$("#permission").html(str);
		}
	});
}
</script>
<table id="dg" class="easyui-datagrid" border="true" title="快件信息>角色管理"
		url="<%=path %>/api/role"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="strName" width="100" sortable="true">角色名</th>
			<th field="strDesc" width="100">角色描述</th>
			<th field="powers" width="100" sortable="true">权限id序列</th>
			<th field="createTime" width="100">创建时间</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addObj()">添加角色</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑角色</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除角色</a>
	</div>
	<br class="clear"/>
	<hr class="hr-geay">
	<form id="search">
		<div class="searchBar-input">
    		<div>
	    		创建时间开始：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd'})" />
    		</div>
    		<div>
    			创建时间结束：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd'})"/>
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		角色名：<input name ="str1" />
    		</div>
    		<input type="hidden" name="_header" value="${licence }"/>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
	<a class="easyui-linkbutton" iconCls="icon-search">统计</a>
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
	<div class="pull-away"></div>
</div>

<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">角色信息</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${user.licence }"/>
		<div class="fitem">
			<label>角色名:</label>
			<input name="strName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>角色描述:</label>
			<input name="strDesc" class="easyui-validatebox" required="true">
		</div>
		<div id="permission">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>