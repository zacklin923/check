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
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${user.licence }");
	url="<%=path %>/api/role";
	purl ="<%=path %>/api/power/all";
	obtain(purl,"");
}

function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
		url="<%=path %>/api/role/"+row.stpId;
		purl ="<%=path %>/api/power/all";
		obtain(purl,row.powers);
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
	var uNum=row.strId;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path %>/api/role/"+uNum,
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

function obtain(url,power){
	$.ajax({
		type:"get",
		url:url,
		success: function(data){
			var arr = new Array();
			arr = power.split(",");
			var str="";
			var str2="";
			for(var i = 0; i < data.rows.length; i++) {
				for(var j = 0; j < arr.length; j++) {
					if(data.rows[i].stpId==arr[j]){
						str=str+"<input style='height:15px;' checked='checked'  name='powers' type='checkbox' value='"+data.rows[i].stpId+"' />";
						str2 = "a";
					}
				}
				if(str2==""){
					str=str+"<input style='height:15px;' name='powers' type='checkbox' value='"+data.rows[i].stpId+"' />";
				}
				str=str+"<span>"+data.rows[i].stpId+"."+data.rows[i].stpName+"</span></br>";
				str2="";
			}
			$("#permission").html(str);
		}
	});
}
function selectAll(){
	var a = $('#permission>input');
	if(a[0].checked){
		for(var i = 0;i<a.length;i++){
			if(a[i].type == "checkbox") a[i].checked = false;
		}
	}else{
		for(var i = 0;i<a.length;i++){
			if(a[i].type == "checkbox") a[i].checked = true;
		}
	}
}
function negated(){
	$("#permission input:checkbox").each(function () {  
        this.checked = !this.checked;  
     }) 
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
			<th field="strId" width="80" style="display: none;">角色名</th>
			<th field="strName" width="100" sortable="true">角色名</th>
			<th field="strDesc" width="100">角色描述</th>
			<th field="powers" width="300">权限id序列</th>
			<th field="createTime" width="200">创建时间</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addObj()">添加角色</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑角色</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除角色</a>
	</div>
	<div class="btn-separator">
		<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
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
		<input type="hidden" name="strId">
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
	<a class="easyui-linkbutton"  onclick="selectAll()">全选/全不选</a>
	<a class="easyui-linkbutton"  onclick="negated()">反 选</a>
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>