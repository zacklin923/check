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
<title>数据源导入</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
	}
}
function save(){
	$("#fm").form("submit",{
		url:"<%=path %>/api/sourimport/aa",		
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
function deleteAll(){
	$.messager.confirm(
		"操作提示",
		"您确定要删除吗？",
		function(data){
			if(data){
				var checkedItems = $('#dg').datagrid('getChecked');
				$.each(checkedItems, function(index, item){
					if(item.courierNumber!=null){
						$.ajax({
							url:"<%=path %>/api/sourimport/"+item.courierNumber,
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
					url:"<%=path %>/api/sourimport",
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
var a="${isLoading}";
var a1="${isLoading}";
function checkIsUal(){
	console.log("a:"+a);
	if(a=="" || a=="false"){
		hiden_hint();
	}else{
		show_hint([]);
		$.ajax({
			url:"<%=path%>/api/sourimport/isLoading",
			success:function(data){
				a=data;
			}
		});
		setTimeout("checkIsUal()",2000);
	}
	if((a1=="true")&&(a=="" || a=="false")){
		$('#dg').datagrid('reload');
		alert("请到导入数据错误处查看是否有错误数据")
	}
}
$(function(){
	checkIsUal();
});


function upload(){
	$("#fileImport").dialog("close");
	show_hint([]);
	$("#fmfile").form("submit",{
		url:"<%=path %>/api/sourimport/import",		
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			console.log(data);
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					hiden_hint();
					$('#dg').datagrid('reload');
					alert(json.data);
					$("#fileImport").dialog("close");					
				}else{
					hiden_hint();
					$("#fileImport").dialog("close");	
					alert("错误:"+json.code+"错误原因："+json.data);
					$('#dg').datagrid('reload');
				}
			}else{
				hiden_hint();
				alert("错误:网络错误");
			}
		}
	});
}
function pushData(){
	show_hint([]);
	$.ajax({
		url:"<%=path %>/api/sourimport/push",
		type:"get",
		success:function(data){
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					hiden_hint();
					$('#dg').datagrid('reload');
					alert("成功。"+json.data);
				}else{
					hiden_hint();
					alert("错误:"+json.code);
					$('#dg').datagrid('reload');
				}
			}else{
				hiden_hint();
				alert("错误:网络错误");
			}
		}
	});
}

function search_toolbar1(){
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		var reg=new RegExp("\r\n","g");
		if(json.str3!=null){
			var str3 = json.str3.replace(reg,",");
			json.str3=str3;
			console.log(str3);
		}
		if(json.str4!=null){
			var str4 = json.str4.replace(reg,",");
			json.str4=str4;
			console.log(str4);
		}
		console.log(json.date1);
		console.log(json.date2);
		$('#dg').datagrid('load', json);
	}
}
</script>
<table id="dg" border="true" 
		url="<%=path %>/api/sourimport"
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
			<th field="stuName" width="60">导入人</th>
			<th field="createDate" width="100" sortable="true">创建日期</th>
			<th field="ctmName" width="60" sortable="true">客户名</th>
			<th field="ctmBarCode" width="80" sortable="true">客户条码</th>
			<th field="courierNumber" width="120" sortable="true">快递单号</th>
			<th field="oneCode" width="80" sortable="true">一段码</th>
			<th field="isPushed" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(value=='0'){
							return '否';
                      }else if(value=='1'){
                      		return '是';
                      }
               }">是否已上传</th>
			<th field="orderNumber" width="150" sortable="true">订单编号</th>
			<th field="address" width="300" sortable="true">地址</th>
			<th field="addressee" width="60" sortable="true">收件人</th>
			<th field="phone" width="120" sortable="true">联系方式</th>
			<th field="shopNumber" width="120" sortable="true">商家ID</th>
			<th field="courierCompany" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(value=='11'){
							return '韵达实物';
                      }else if(value=='22'){
                      		return '韵达刷单';
                      }else if(value=='33'){
                      		return '圆通';
                      }else if(value=='44'){
                      		return '顺丰';
                      }else if(value=='55'){
                      		return 'EMS';
                      }else if(value=='66'){
                      		return '邮政小包';
                      }
               }">快递公司</th>
			<th field="goodsCost" width="80" sortable="true">物品价值</th>
			<th field="goods" width="60" sortable="true">物品</th>
			<th field="numberType" width="60" sortable="true">类型</th>
			<th field="createTime" width="150" sortable="true">导入时间</th>
			<th field="province" width="80" sortable="true">省份</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="快件信息>导入数据" data-options="collapsible:true">
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
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#fileImport').dialog('open')">导入数据</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑数据</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAll()">批量删除</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteAllData()">删除所有数据</a>
		</div>
		<!-- 
		<div class="btn-separator">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="pushData()" disabled="true">上传数据</a>
		</div>
		 -->
		<div class="btn-separator">
			<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		快递单号：<textarea name ="str3" style="height:85px;width:100px;"></textarea>
	   			</div>
	   		</div>
	   		<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		客户条码：<textarea name ="str4" style="height:85px;width:100px;"></textarea>
	   			</div>
	   		</div>
	   		<div class="searchBar-input1">
	   			<div>
		    		导入开始日期：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfNow().toString2()%>"/>
	    		</div>
	    		<div>
	    			导入结束日期：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString2()%>"/>
	    		</div>
	   			<div>
	    			订单编号：<input name ="str6" />
	    		</div>
	    		<div>
		    		客户名：<input name ="str5" />
	    		</div>
	    		<input type="hidden" name="_header" value="${licence }"/>
	   		</div>
	   		<div class="searchBar-input1">
	   			<div>
		    		导入人：<input name ="str7" />
	    		</div>
	    		<div>
		    		商家ID：<input name ="str8" />
	    		</div>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar1()">查询</a>
		<!-- 
		<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
		<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">导出</a>
		 -->
		<div class="pull-away"></div>
	</div>
</div>
<div id="dlg" class="easyui-dialog" style="width:600px;height:660px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">导入数据编辑</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<div class="fitem">
			<label>创建时间:</label>
			<input name="createDate" required="true">
		</div>
		<div class="fitem">
			<label>客户名:</label>
			<input name="ctmName" required="true">
		</div>
		<div class="fitem">
			<label>客户条码:</label>
			<input name="ctmBarCode" required="true">
		</div>
		<div class="fitem">
			<label>快递单号:</label>
			<input name="courierNumber" required="true">
		</div>
		<div class="fitem">
			<label>地址:</label>
			<input name="address"  required="true">
		</div>
		<div class="fitem">
			<label>订单编号:</label>
			<input name="orderNumber"  required="true">
		</div>
		<div class="fitem">
			<label>收件人:</label>
			<input name="addressee" required="true">
		</div>
		<div class="fitem">
			<label>联系方式:</label>
			<input name="phone"  required="true">
		</div>
		<div class="fitem">
			<label>商家ID:</label>
			<input name="shopNumber" required="true">
		</div>
		<div class="fitem">
			<label>快递公司:</label>
			<input name="courierCompany" required="true">
		</div>
		<div class="fitem">
			<label>物品价值:</label>
			<input name="goodsCost" required="true">
		</div>
		<div class="fitem">
			<label>物品:</label>
			<input name="goods" required="true">
		</div>
		<div class="fitem">
			<label>客户类型:</label>
			<input name="numberType" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<div id="fileImport" class="easyui-dialog" style="width:350px;height:200px;padding:10px 20px"
		closed="true" modal="true" title="数据源导入">
		<div style="height:25px;line-height:25px;">数据导入模板
			<a href="<%=path%>/file/数据源导入模板.xlsx" style="display:block;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;">下载</a>
		</div></br></br></br>
		<form id="fmfile"  enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;"/>
		</form>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:50%;height:100%;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true" resizable="true">
</div>

</body>
</html>