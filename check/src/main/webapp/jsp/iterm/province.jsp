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
<title>一段码省份对照表</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
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
						window.location.href="<%=path%>/"+d.data;
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
				<a href="">一段码省份对照表</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="addObj()"><span class="iterm1"></span>添加数据</a>
                <a onclick="updateObj()"><span class="iterm2"></span>编辑数据</a>
                <a onclick="deleteObj()"><span class="iterm3"></span>删除出具</a>
                <a onclick="search_toolbar()"><span class="iterm5"></span>查询</a>
                <a onclick="excel_export()"><span class="iterm4"></span>导出</a>
                <a onclick="accept()"><span class="iterm6"></span>保存</a>
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
                                <li>  <label for=""">一段码</label>
                                    <input type="text"  style="margin-left:22px" name ="str2" >
                                </li>
                                <li><label for="">省份名称</label>
                                    <input type="text" name ="str1">
                                </li>
                                  
                               
                            </ul>
                        </div>
                       
                </form>
             </div>
             <a onclick="search_toolbar()"  id="my_search" style="top:40px;margin-left:300px;">查询</a>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
<table id="dg" border="true" 
		url="<%=path %>/api/provinceCode"
		method="get" toolbar="#toolsbars"
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