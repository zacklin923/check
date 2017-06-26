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
<title>省份码</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
var url;
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${user.licence }");
	url="<%=path %>/api/provinceCode";
}
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${licence }");
		url="<%=path%>/api/provinceCode/"+row.provinceCode;
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
					alert("错误:"+json.code+"  "+json.data);
				}
			}else{
				alert("错误:网络错误");
			}
		}
	});
}
function deleteObj(){
	var row=$("#dg").datagrid("getSelected");
	var id=row.provinceCode;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path%>/api/provinceCode/"+id,
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
		url:"<%=path%>/api/provinceCode/excelExport",
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
function accept(){
	if (endEditing()){
		var rows=$('#dg').datagrid('getChanges');
		for (var i = 0; i < rows.length; i++) {
			var row=rows[i];
			row._method="put";
			row._header="${licence}";
			$('#dg').datagrid('loading');
			$.ajax({
				url:"<%=path%>/api/provinceCode/"+row.provinceCode,
				type:"post",
				data:row,
				dataType:"json",
				success:function(data){
					$('#dg').datagrid('loaded');
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
							alert("错误:"+json.code+"  "+json.data);
						}
					}else{
						alert("错误:网络错误");
					}
				}
			});
		}
	}
}
</script>
<table id="dg" border="true" 
		url="<%=path %>/api/provinceCode"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]"
		data-options="
				onClickCell: onClickCell
			">
	<thead>
		<tr>
			<th field="provinceCode" width="100" sortable="true">一段码</th>
			<th field="province" width="200" sortable="true" editor="text">省份名称</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="基础信息维护>一段码省份对照表" data-options="collapsible:true">
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
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addObj()">添加数据</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑数据</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除数据</a>
			<a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
		</div>
		<div class="btn-separator">
			<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-input">
	    		<div>
		    		省份名称：<input name ="str1" />
	    		</div>
	    		<div>
	    			一段码：<input name ="str2" />
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
	<div class="ftitle">省份码</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<div class="fitem">
			<label>一段码:</label>
			<input name="provinceCode" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>省份:</label>
			<input name="province" class="easyui-validatebox" required="true">
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