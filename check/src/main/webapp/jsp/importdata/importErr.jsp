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
<title>数据源导入错误</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
function deleteAll(){
	$.messager.confirm(
		"操作提示",
		"您确定要删除吗？",
		function(data){
			if(data){
				var checkedItems = $('#dg').datagrid('getChecked');
				$.each(checkedItems, function(index, item){
					if(item.sifId!=null){
						$.ajax({
							url:"<%=path %>/api/sourimportfail/"+item.sifId,
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
									console.log("错误:"+json.code);
								}
							}
						});
					}
				}); 
			}
		}
	);
}
</script>
<table id="dg" class="easyui-datagrid" border="true"
		url="<%=path %>/api/sourimportfail"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		checkOnSelect="false" selectOnCheck="false"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="ck" checkbox="true"></th>
			<th field="createTime" width="150" sortable="true">时间</th>
			<th field="failType" width="100" >失败类型</th>
			<th field="createDate" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.createDate;
                          }
                      }" width="100">创建时间</th>
			<th field="ctmName" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.ctmName;
                          }
                      }" width="80">客户名</th>
			<th field="ctmBarCode" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.ctmBarCode;
                          }
                      }" width="80">客户条码</th>
			<th field="courierNumber" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.courierNumber;
                          }
                      }" width="120">快递单号</th>
			<th field="address" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.address;
                          }
                      }" width="150">地址</th>
			<th field="orderNumber" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.orderNumber;
                          }
                      }" width="150">订单编号</th>
			<th field="addressee" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.addressee;
                          }
                      }" width="100">收件人</th>
			<th field="phone" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.phone;
                          }
                      }" width="100">联系方式</th>
			<th field="shopNumber" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.shopNumber;
                          }
                      }" width="100">商家ID</th>
			<th field="courierCompany" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.courierCompany;
                          }
                      }" width="100">快递公司</th>
			<th field="goodsCost" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.goodsCost;
                          }
                      }" width="100">物品价值</th>
			<th field="goods" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.goods;
                          }
                      }" width="100">物品</th>
			<th field="numberType" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.numberType;
                          }
                      }" width="100">类型</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#fileImport').dialog('open')">导入数据</a>
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
	    		失败类型：<select name ="str2">
			    			<option value="">请选择。。。</option>
			    			<option value="重复快递单号">重复快递单号</option>
			    			<option value="数据必填项为空">数据必填项为空</option>
			    	   </select>
    		</div>
    		<input type="hidden" name="_header" value="${licence }"/>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAll()">批量删除</a>
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
	<div class="pull-away"></div>
</div>
</body>
</html>