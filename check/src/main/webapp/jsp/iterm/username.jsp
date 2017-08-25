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
<title>用户管理</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
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
var url;
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
		url="<%=path %>/api/user/"+row.stuNum;
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
	var uNum=row.stuNum;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path %>/api/user/"+uNum,
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
function obc(){
	var str=$("#obcNums").val();
	var arr=str.split(",");
	$("#numOption").datagrid("uncheckAll");
	$.each(arr, function(index, item){
		$("#numOption").datagrid("selectRecord",item);
	});
	$("#obc").dialog("open");
}

function obcSave(){
	var arr=$("#numOption").datagrid("getChecked");
	console.log(arr);
	var str="";
	$.each(arr, function(index, item){
		str=str+","+item.cteBarCode;
		
		
	});
	str=str.substr(1,str.length-1);
    $("#obcNums").val(str);
    $("#obc").dialog("close");
}
</script>

<style>
.panel-body {border-color: #E6E6E6; border:none;}
	#menulist{height:30px;}
	#mypanel{border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="height:87px;overflow: hidden">

		<div class="layout-header" style="position: relative">
			<div class="layout-title">
				<h3><a>深圳韵达有限公司</a></h3>
			</div>
			<div class="self_title">
				<a href="">用户管理</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="addObj()"><span class="iterm1"></span>添加用户</a>
                <a onclick="updateObj()"><span class="iterm2"></span>编辑用户</a>
                <a onclick="deleteObj()"><span class="iterm3"></span>删除用户</a>
                <a onclick="search_toolbar()"><span class="iterm5"></span>查询</a>
                <a onclick="search_toolbar1()"><span class="iterm4"></span>统计</a>
                <a onclick="search_toolbar1()"><span class="iterm6"></span>导出</a>
			</div>
			</div>
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px;box-sizing: content-box;overflow:hidden;" data-options="border:false" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  <label for=""">账号</label>
                                    <input type="text" style="margin-left: 22px"   name ="str1" >
                                </li>
                                <li><label for="">用户名</label>
                                    <input type="text" name ="str2">
                                </li>
                               
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">创建时间开始</label>
                                    <input style="height:23px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd'})"/>
                                </li>
                                <li><label for="">创建时间结束</label>
                                    <input style="height:23px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd'})"/>
                                </li>
                            </ul>
                        </div>
                </form>
             </div>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
      <table id="dg" border="true"
		url="<%=path %>/api/user"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="true" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="stuNum" width="100" sortable="true">账号</th>
			<th field="pass" width="100">密码</th>
			<th field="stuName" width="100" sortable="true">用户名</th>
			<th field="ownCteName" width="500">条码</th>
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
			<label>用户名:</label>
			<input name="stuName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>条码:</label>
			<input id="obcNums" name="ownBarCode" class="easyui-validatebox">
			<a class="easyui-linkbutton" onclick="obc()">浏览...</a>
		</div>
		<div class="fitem">
			<label>角色:</label>
			<select name="stuRole" id="roleId">
			</select>
		</div>
		<div class="fitem">
			<label>备注:</label>
			<input name="note" >
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

<div id="obc-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="obcSave()">确定</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#obc').dialog('close')">取消</a>
</div>

<div id="obc" class="easyui-dialog" style="width:600px;height:500px;"
		closed="true" buttons="#obc-buttons" modal="true" title="条码选择">
	<table id="numOption" class="easyui-datagrid" border="false"
		url="<%=path %>/api/customer/all"
		method="get" idField="cteBarCode"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="false"
		rownumbers="true" fitColumns="true" 
		singleSelect="false" fit="true">
		<thead>
			<tr>
				<th field="ck" checkbox="true"></th>
				<th field="cteBarCode" width="100" sortable="true">客户条码</th>
				<th field="cteName" width="100" sortable="true">客户名称</th>
			</tr>
		</thead>
	</table>	
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:50%;height:50%;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/user.jsp" cache="true" resizable="true">
</div>
</body>
</html>