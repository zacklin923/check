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
			<th field="sendTime" width="150" sortable="true">发货时间</th>
			<th field="ctmName" width="50" >客户名</th>
			<th field="ctmBarCode" width="70">客户条码</th>
			<th field="province" width="50">省份</th>
			<th field="courierNumber" width="115">快递单号</th>
			<th field="address" width="330">地址</th>
			<th field="orderNumber" width="160" sortable="true">订单编号</th>
			<th field="addressee" width="60" >收件人</th>
			<th field="phone" width="110" >联系方式</th>
			<th field="shopNumber" width="150" >商家ID</th>
			<th field="weight" width="50" sortable="true">重量</th>
			<th field="courierCompany" width="60" >快递公司</th>
			<th field="fee" width="50" sortable="true">金额</th>
			<th field="goods" width="50" >物品</th>
			<th field="numberType" width="50">类型</th>
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
		<form action="<%=path %>/api/import" enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="submit"/>
		</form>
</div>
</body>
</html>