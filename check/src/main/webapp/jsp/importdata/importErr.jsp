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

function deleteAllData(){
	$.messager.confirm(
			"操作提示",
			"您确定要删除所有数据吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path %>/api/sourimportfail",
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
								alert("错误:"+json.code+"  "+json.data);
							}
						}
					});
				}
			}
		);
}
function excel_export(){
	show_hint([]);
	$("#search").form("submit",{
		url:"<%=path%>/api/sourimportfail/exportExcel",
		onSubmit: function(){   
		},   
	    success:function(data){   
	    	var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				hiden_hint();
				var d = eval('('+data+')');
				window.location.href="<%=path %>/"+d.data;
			}else{
				hiden_hint();
				alert("错误:"+json.data);
			}
	    } 
	});
}
</script>
<table id="dg" border="true"
		url="<%=path %>/api/sourimportfail"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		checkOnSelect="false" selectOnCheck="false"
		pageSize="100" pageList="[100,500,1000]">
	<thead>
		<tr>
			<th field="ck" checkbox="true"></th>
			<th field="createTime" width="150" sortable="true">导入时间</th>
			<th field="failType" width="100" sortable="true">失败类型</th>
            <th field="stuNum" width="70" sortable="true"  data-options="
				formatter:function(value,row,index){
                             if(row.user){
						return row.user.stuName;
                          }
                      }">导入人</th>
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
                      }" width="90">商家ID</th>
			<th field="courierCompany" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.courierCompany;
                          }
                      }" width="60">快递公司</th>
			<th field="goodsCost" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.goodsCost;
                          }
                      }" width="60">物品价值</th>
			<th field="goods" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.goods;
                          }
                      }" width="60">物品</th>
			<th field="numberType" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.numberType;
                          }
                      }" width="60">类型</th>
            <th field="oneCode" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.oneCode;
                          }
                      }" width="60">一段码</th>
            <th field="province" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.province;
                          }
                      }" width="60">省份</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="快件信息>错误数据" data-options="collapsible:true">
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
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAll()">批量删除</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAllData()">删除所有数据</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
			<input type="hidden" name="_header" value="${user.licence }"/>
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
		    		失败类型：<select name ="str2" style="width: 150px;">
				    			<option value="">--请选择--</option>
				    			<option value="重复快递单号">重复快递单号</option>
				    			<option value="数据必填项为空">数据必填项为空</option>
				    			<option value="数据类型转换错误">数据类型转换错误</option>
				    			<option value="快递单号不符合规范">快递单号不符合规范</option>
				    			<option value="客户条码不存在">客户条码不存在</option>
				    	   </select>
	    		</div>
	    		<div>
	    			导入人：<input name="str3"/>
	    		</div>
	   		</div>
	   		<input type="hidden" name="_header" value="${licence }"/>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
		<div class="pull-away"></div>
	</div>
</div>
</body>
</html>