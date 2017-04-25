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
<title>客户管理</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
var url;
function newUser(){
	$("#dlg").dialog("open").dialog("setTitle","新建用户");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${licence }");
	url="/quota/api/users";
}

function editUser(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","编辑用户");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${licence }");
		url="/quota/api/users/"+row.uNum;
	}
}
function saveUser(){
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
function destoryUser(){
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
		url:"/quota/api/users/excelExport",
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
</script>
<table id="dg" class="easyui-datagrid" border="true"
		url="<%=path %>/api/customer"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="barCode" width="100" sortable="true">条码</th>
			<th field="cteName" width="100">站点名字</th>
			<th field="barCodeParent" width="100" sortable="true">所属分部</th>
			<th field="barCodeParentName" width="100">所属分部名字</th>
			<th field="scliceArea" width="150">所属区部</th>
			<th field="largeArea" width="200" sortable="true">所属大区</th>
			<th field="createTime" width="200" sortable="true">创建时间</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destoryUser()">删除用户</a>
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
	    		账号：<input name ="str1" />
    		</div>
    		<div>
    			用户名：<input name ="str2" />
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
	<div class="ftitle">用户信息</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<div class="fitem">
			<label>账号:</label>
			<input name="uNum" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>密码:</label>
			<input name="uPass" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>同户名:</label>
			<input name="uName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>职位:</label>
			<input name="uJob" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>部门:</label>
			<input id="csId" name="csId" class="easyui-combotree"/>
		</div>
		<div class="fitem">
			<label>角色:</label>
			<select name="rId" id="roleId">
			</select>
		</div>
		<div class="fitem">
			<label>邮箱:</label>
			<input name="uMail" class="easyui-validatebox" validType="email" required="true">
		</div>
		<div class="fitem">
			<label>在职情况:</label>
			<select name="uState">
				<option value="在职">在职</option>
				<option value="离职">离职</option>
			</select>
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>