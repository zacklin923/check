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
$(function(){
	$('#dg').datagrid();
}); 
var url;
var type;
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	url="/check/api/provinceCode";
	type="POST";
}
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		url="/check/api/provinceCode/"+row.provinceCode;
		type="PUT"
	}
}
function save(){
	$('#dg').datagrid('loading');
	var obj=formToJson($("#fm"));
	if($("#fm").form('validate')){
		pullRequestCommon({
			urlc:url,
			type:type,
			jobj:obj,
			success:function(data){
				$('#dg').datagrid('reload');
				$("#dlg").dialog("close");
			},
			error:function(data){
				alert(data);
			}
		});
	}
}
function deleteObj(){
	var row=$("#dg").datagrid("getSelected");
	var did=row.provinceCode;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					pullRequestCommon({
						urlc:"/check/api/provinceCode",
						type:"DELETE",
						jobj:{id:did},
						success:function(data){
							$('#dg').datagrid('reload');
						}
					});
				}
			}
		);
	}
}
function excel_export(){
	show_hint([]);
	pullRequestCommon({
		urlc:"/check/api/provinceCode/excelExport",
		type:"GET",
		jobj:formToJson($("#search")),
		success:function(data){
			console.log(data);
			hiden_hint();
    		window.location.href=URL_PATH+"/check/"+data;
		},
		error:function(data){
			alert(data);
			hiden_hint();
		}
	});
}
function accept(){
	if (endEditing()){
		var rows=$('#dg').datagrid('getChanges');
		var alretstr ="";
		var cout = 0;
		$('#dg').datagrid('loading');
		for (var i = 0; i < rows.length; i++) {
			var row=rows[i];
			rowisNullClear(row);
			console.log(row);
			pullRequestCommon({
				urlc:"/check/api/provinceCode",
				type:"PUT",
				jobj:row,
				async:false,
				success:function(data){
					cout = eval(cout+1);
				},
				error:function(data){
					alretstr = alretstr + data;
				}
			});
			
		}
		$('#dg').datagrid('loaded');
		alert("共保存了"+cout+"条     "+alretstr);
	}
}
function search_toolbar1(){
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/provinceCode",
		dataf:formToJson($("#search")),
		success:function(data){
		}
	});
}
</script>
<<!-- style>
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
                <a onclick="deleteObj()"><span class="iterm3"></span>删除数据</a>
                <a onclick="excel_export()"><span class="iterm4"></span>导出</a>
                <a onclick="accept()"><span class="iterm6"></span>保存</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px;box-sizing: content-box;overflow:hidden;" data-options="border:false" >
 -->
 <style>
.panel-body {border-color: #E6E6E6; border:none;}
  .datagrid-cell, .datagrid-cell-group, .datagrid-header-rownumber, .datagrid-cell-rownumber {

        padding: 4px;

    }


#mypanel{
border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="overflow: hidden">
    <div class="layout-header" style="position: relative">
        
        <div class="logo"></div>
        
        <div class="self_title">
            <a href="">一段码省份对照表</a>
        </div>
        <div class="my_help">
            <a  href="javascript:window.opener=null;window.open('','_self');window.close();">退出|
            </a><a onclick="$('#dlg_help').dialog('open')">帮助</a></div>
    </div>

</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
			<div id="menulist" style="padding-top: 10px;position:raletiver">
                <a onclick="addObj()"><span class="iterm1"></span>添加数据</a>
                <a onclick="updateObj()"><span class="iterm2"></span>编辑数据</a>
                <a onclick="deleteObj()"><span class="iterm3"></span>删除数据</a>
                <a onclick="excel_export()"><span class="iterm4"></span>导出数据</a>
                <a onclick="accept()"><span class="iterm6"></span>保存数据</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询数据</a>
                <span class="myself_btn">收缩</span>	
             </div>  
			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:2px;box-sizing: border-box;margin-top: 5px;width: 100%;margin: 0 auto;margin-top: 5px;" >
			
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
            <!--  <a onclick="search_toolbar1()"  id="my_search" style="top:40px;margin-left:300px;">查询</a>
            <a onclick="search_toolbar1()"  id="my_search" style="top:18px;margin-left:320px;"><span class="fSearchIcon"></span>查询</a> -->
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
<table id="dg" border="true" 
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="50" pageList="[50,100]"
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