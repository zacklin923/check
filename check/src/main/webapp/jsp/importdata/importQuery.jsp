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
function save(){
	$("#fm").form("submit",{
		url:"<%=path %>/api/import",		
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
</script>
<table id="dg" class="easyui-datagrid" border="true"
		url="<%=path %>/api/import"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="createDate" width="100" sortable="true">创建时间</th>
			<th field="ctmName" width="60" >客户名</th>
			<th field="ctmBarCode" width="80">客户条码</th>
			<th field="courierNumber" width="120">快递单号</th>
			<th field="address" width="400">地址</th>
			<th field="orderNumber" width="160" sortable="true">订单编号</th>
			<th field="addressee" width="60" >收件人</th>
			<th field="phone" width="120" >联系方式</th>
			<th field="shopNumber" width="150" >商家ID</th>
			<th field="courierCompany" width="60" >快递公司</th>
			<th field="goodsCost" width="60" sortable="true">物品价值</th>
			<th field="goods" width="60" >物品</th>
			<th field="numberType" width="60">类型</th>
			<th field="createTime" width="150" sortable="true">导入时间</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#dlg').dialog('open')">导入数据</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑数据</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除数据</a>
	</div>
	<br class="clear"/>
	<hr class="hr-geay">
	<form id="search">
		<div class="searchBar-input">
    		<div>
	    		导入时间开始：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd'})" />
    		</div>
    		<div>
    			导入时间结束：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd'})"/>
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		客户名：<input name ="str1" />
    		</div>
    		<div>
    			客户条码：<input name ="str2" />
    		</div>
    		<input type="hidden" name="_header" value="${licence }"/>
   		</div>
   		<div class="searchBar-input">
   			<div>
	    		快递单号：<input name ="str3" />
    		</div>
    		<div>
    			订单编号：<input name ="str4" />
    		</div>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
	<a class="easyui-linkbutton" iconCls="icon-search">统计</a>
	<a class="easyui-linkbutton" iconCls="icon-search">导出</a>
	<div class="pull-away"></div>
</div>
<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true" title="数据源导入">
		<form id="fm"  enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="button" value="提交" onclick="save()"/>
		</form>
</div>
</body>
</html>