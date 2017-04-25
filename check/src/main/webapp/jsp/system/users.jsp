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
<title>用户管理</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:"GET",
		url:"<%=path %>/api/role/all",
		data:"",
		success:function(data){
			str="";
			for(var i = 0; i < data.length; i++) {
				str=str+"<option value='"+data[i].strId+"'>"+data[i].strName+"</option>"
			}
			$("#roleId").html(str);
		}
	});
});  
	
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${user.licence }");
	url="<%=path %>/api/user";
}

function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
		url="<%=path %>/api/user/"+row.stpId;
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
				var json = eval('('+data+')');
				if(json.result=='success'){
					$('#dg').datagrid('reload');
					$("#dlg").dialog("close");					
				}else{
					alert("错误:"+json.code);
				}
			}else{
				alert("错误");
			}
		}
	});
}
function deleteObj(){
	var row=$("#dg").datagrid("getSelected");
	var uNum=row.strId;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path %>/api/user"+uNum,
						type:"delete",
						success:function(data){
							if(data.result=='success'){
								$('#dg').datagrid('reload');
							}else{
								alert("错误:"+data.code);
							}
						}
					});
				}
			}
		);
	}
}
function obc(){
	$("#obc").dialog("open");
	$.ajax({
		type:"GET",
		url:"<%=path %>/api/customer/all",
		data:"",
		success:function(data){
			console.log(data);
			str="";
			for(var i = 0; i < data.length; i++) {
				str=str+"<div style='width:82px;height:20px;float:left;border:1px solid #B1B3B8;margin:5px;font-size:18px;text-align:center;'>"
				+data[i].barCode+"</div>"
			}
			$("#numOption").html(str);
		}
	});
}

function obcSave(){
}
</script>
<table id="dg" class="easyui-datagrid" border="true"
		url="<%=path %>/api/user"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="stuNum" width="100" sortable="true">账号</th>
			<th field="pass" width="100">密码</th>
			<th field="stuName" width="100" sortable="true">用户名</th>
			<th field="ownBarCode" width="100">条码</th>
			<th field="stuRoleName" data-options="
				formatter:function(value,row,index){
                             if(row.role){
						return row.role.strName;
                          }
                      }" width="100">角色</th>
			<th field="note" width="150">备注</th>
			<th field="createTime" width="200" sortable="true">创建时间</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addObj()">添加用户</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑用户</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除用户</a>
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
			<input name="stuNum" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>密码:</label>
			<input name="pass" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>同户名:</label>
			<input name="stuName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>条码:</label>
			<input name="ownBarCode" class="easyui-validatebox" required="true" onclick="obc()">
		</div>
		<div class="fitem">
			<label>角色:</label>
			<select name="stuRole" id="roleId">
			</select>
		</div>
		<div class="fitem">
			<label>备注:</label>
			<input name="note" class="easyui-validatebox" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

<div id="obc-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="obcSave()">确定</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#obc').dialog('close')">取消</a>
</div>

<div id="obc" class="easyui-dialog" style="width:600px;height:500px;padding:10px 10px"
		closed="true" buttons="#obc-buttons" modal="true" title="条码选择">
		<div id="numOption" style="width:570px;height:380px;">
		</div>
</div>

</body>
</html>