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
<title>成本收集导入</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
function updateObj(){
	var date1 = $("#d4311").val();
	var date2 = $("#d4312").val();
	console.log((new Date(date1)).getTime());
	console.log((new Date(date2)).getTime());
	var timediffer =  eval((new Date(date2)).getTime()-(new Date(date1)).getTime());
	if(timediffer<86400000){
		var row=$("#dg").datagrid("getSelected");
		console.log(row);
		row.hourJd=numberbyhour(row.hourJd);
		row.hourCj=numberbyhour(row.hourCj);
		row.hourLy=numberbyhour(row.hourLy);
		row.hourGd=numberbyhour(row.hourGd);
		row.hourLpcl=numberbyhour(row.hourLpcl);
		row.hourKscl=numberbyhour(row.hourKscl);
		row.hourQsb=numberbyhour(row.hourQsb);
		row.hourTjcl=numberbyhour(row.hourTjcl);
		row.hourSd=numberbyhour(row.hourSd);
		row.hourDd=numberbyhour(row.hourDd);
		if(row){
			$("#dlg").dialog("open").dialog("setTitle","修改");
			$("#fm").form("load",row);
			$("#fm input[name='_method']").val("put");
			$("#fm input[name='_header']").val("${user.licence }");
		}
	}else{
		alert("时间间隔大于一天，以下为统计数据不能修改");
	}
}
function save(){
	$("#hjd").val(hourbynumber($("#hjd").val()));
	$("#hcj").val(hourbynumber($("#hcj").val()));
	$("#hly").val(hourbynumber($("#hly").val()));
	$("#hgd").val(hourbynumber($("#hgd").val()));
	$("#hlpcl").val(hourbynumber($("#hlpcl").val()));
	$("#hkscl").val(hourbynumber($("#hkscl").val()));
	$("#hqsb").val(hourbynumber($("#hqsb").val()));
	$("#htjcl").val(hourbynumber($("#htjcl").val()));
	$("#hsd").val(hourbynumber($("#hsd").val()));
	$("#hdd").val(hourbynumber($("#hdd").val()));
	console.log($("#fm").serializeArray())
	$("#fm").form("submit",{
		url:"<%=path %>/api/primeCodeImport/aa",		
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
	var date1 = $("#d4311").val();
	var date2 = $("#d4312").val();
	console.log((new Date(date1)).getTime());
	console.log((new Date(date2)).getTime());
	var timediffer =  eval((new Date(date2)).getTime()-(new Date(date1)).getTime());
	if(timediffer<86400000){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					show_hint([]);
					var checkedItems = $('#dg').datagrid('getChecked');
					$.each(checkedItems, function(index, item){
						console.log(item.id);
						if(item.id!=null){
							$.ajax({
								url:"<%=path %>/api/primeCodeImport/"+item.id,
								type:"delete",
								success:function(data){
									var json;
									if(isJson(data)){
										json=data;
									}else{
										json = eval('('+data+')');
									}
									if(json.result=='success'){
										hiden_hint();
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
	}else{
		alert("时间间隔大于一天，以下为统计数据不能删除");
	}
}

function deleteAllData(){
	$.messager.confirm(
		"操作提示",
		"您确定要删除所有数据吗？",
		function(data){
			if(data){
				$.ajax({
					url:"<%=path %>/api/primeCodeImport",
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
			url:"<%=path%>/api/primeCodeImport/isLoading",
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
		url:"<%=path %>/api/primeCodeImport/import",		
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
		isDgInit=true;
		$('#dg').datagrid('load', json);
	}
}
function export_excel(){
	$("#search").form("submit",{
		url:"<%=path%>/api/primeCodeImport/exportExceltest",
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
				var d = eval('('+data+')');
				window.location.href="<%=path%>/"+d.data;
			}else{
				alert("错误:"+json.data);
			}
	    } 
	});
}

function numberbyhour(num){
	var str ='';
  	var mm = '';
  	var ss = '';
  	var h = parseInt(num/3600);
  	var m = (num%3600)/60;
  	var s = (num%3600)%60;
  	if(m<10){
  		mm='0'+m;
  	}else{
  		mm=m;
  	}
  	if(s<10){
  		ss='0'+s;
  	}else{
  		ss=s;
  	}
  	str = h + ':' +mm+':'+ss;
		return str;
}

function hourbynumber(str){
	var s = str.split(':');
	for(var i ; i<s.length ;i++){
		console.log(s[i]);
	}
	var num=eval(s[0]*3600+s[1]*60 +s[2]*1);
	return num;
}
</script>
<table id="dg" border="true"
		url="<%=path %>/api/primeCodeImport"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		singleSelect="true" fit="true"
		striped="true" pagination="false"
		rownumbers="true" fitColumns="false" 
		singleSelect="false" fit="true"
		checkOnSelect="false" selectOnCheck="false">
	<thead>
		<tr>
			<th rowspan="2" field="ck" checkbox="true"></th>
			<th rowspan="2" field="ctmName" width="60">客户名称</th>
			<th rowspan="2" field="ctmBarCode" width="60" sortable="true">条码</th>
			<th rowspan="2" field="ctmType" width="80" sortable="true">客户类型</th>
			<th rowspan="2" field="largeArea" width="80" sortable="true">所属大区</th>
			<th align="center" field="ctmdName" colspan="2" width="180" >截单</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >查件</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >留言</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >跟单</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >理赔处理</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >客诉处理</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >签收表</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >退件处理</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >审单</th>
			<th align="center" field="ctmNdame" colspan="2" width="180" >导单</th>
			<th rowspan="2" field="dayCount" width="60" sortable="true">日出货量</th>
			<th rowspan="2" field="stuNum" width="60" sortable="true">登记人</th>
			<!-- 
			<th rowspan="2" field="createTime" width="150" sortable="true">导入时间</th>
			 -->
			<th rowspan="2" field="id" hidden="true">id</th>
		</tr>
		<tr>
			<th field="countJd" width="100" sortable="true">处理量（票）</th>
			<th field="hourJd" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countCj" width="100" sortable="true">处理量（票）</th>
			<th field="hourCj" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countLy" width="100" sortable="true">处理量（票）</th>
			<th field="hourLy" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countGd" width="100" sortable="true">处理量（票）</th>
			<th field="hourGd" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countLpcl" width="100" sortable="true">处理量（票）</th>
			<th field="hourLpcl" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countKscl" width="100" sortable="true">处理量（票）</th>
			<th field="hourKscl" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countQsb" width="100" sortable="true">处理量（票）</th>
			<th field="hourQsb" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countTjcl" width="100" sortable="true">处理量（票）</th>
			<th field="hourTjcl" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countSd" width="100" sortable="true">处理量（票）</th>
			<th field="hourSd" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
			<th field="countDd" width="100" sortable="true">处理量（票）</th>
			<th field="hourDd" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      	var str ='';
                      	var mm = '';
                      	var ss = '';
                      	var h = parseInt(value/3600);
                      	var m = parseInt((value%3600)/60);
                      	var s = parseInt((value%3600)%60);
                      	if(m<10){
                      		mm='0'+m;
                      	}else{
                      		mm=m;
                      	}
                      	if(s<10){
                      		ss='0'+s;
                      	}else{
                      		ss=s;
                      	}
                      	str = h + ':' +mm+':'+ss;
							return str;
               }">用时（H）</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="快件信息>成本导入收集" data-options="collapsible:true">
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
		</div>
		<div class="btn-separator">
			<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		客户条码：<textarea name ="str3" style="height:85px;width:100px;"></textarea>
	   			</div>
	   		</div>
	   		<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		导入人员：<textarea name ="str4" style="height:85px;width:100px;"></textarea>
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
	    			客户名称：<input name ="str5" />
	    		</div>
	    		<div>
		    		客户类型：<input name ="str6" />
	    		</div>
	    		<input type="hidden" name="_header" value="${licence }"/>
	   		</div>
	   		<div class="searchBar-input1">
	   			<div>
		    		大区：<input name ="str7" />
	    		</div>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar1()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="export_excel()">导出</a>
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
		<input type="hidden" name="id"/>
		<div class="fitem">
			<label>客户名称:</label>
			<input name="ctmName" required="true">
		</div>
		<div class="fitem">
			<label>客户条码:</label>
			<input name="ctmBarCode" required="true">
		</div>
		<div class="fitem">
			<label>客户类型:</label>
			<input name="ctmType" required="true">
		</div>
		<div class="fitem">
			<label>所属大区:</label>
			<input name="largeArea"  required="true">
		</div>
		<div class="fitem">
			<div>截单</div>
			<label>处理量（票）:</label>
			<input name="countJd"  required="true">
			<label>用时（H）:</label>
			<input id="hjd" name="hourJd" required="true">
		</div>
		<div class="fitem">
			<div>查件</div>
			<label>处理量（票）:</label>
			<input name="countCj"  required="true">
			<label>用时（H）:</label>
			<input id="hcj" name="hourCj" required="true">
		</div>
		<div class="fitem">
			<div>留言</div>
			<label>处理量（票）:</label>
			<input name="countLy"  required="true">
			<label>用时（H）:</label>
			<input id="hly" name="hourLy" required="true">
		</div>
		<div class="fitem">
			<div>跟单</div>
			<label>处理量（票）:</label>
			<input name="countGd"  required="true">
			<label>用时（H）:</label>
			<input id="hgd" name="hourGd" required="true">
		</div>
		<div class="fitem">
			<div>理赔处理</div>
			<label>处理量（票）:</label>
			<input name="countLpcl"  required="true">
			<label>用时（H）:</label>
			<input id="hlpcl" name="hourLpcl" required="true">
		</div>
		<div class="fitem">
			<div>客诉处理</div>
			<label>处理量（票）:</label>
			<input name="countKscl"  required="true">
			<label>用时（H）:</label>
			<input id="hkscl" name="hourKscl" required="true">
		</div>
		<div class="fitem">
			<div>签收表</div>
			<label>处理量（票）:</label>
			<input name="countQsb"  required="true">
			<label>用时（H）:</label>
			<input id="hqsb" name="hourQsb" required="true">
		</div><div class="fitem">
			<div>退件处理</div>
			<label>处理量（票）:</label>
			<input name="countTjcl"  required="true">
			<label>用时（H）:</label>
			<input id="htjcl" name="hourTjcl" required="true">
		</div>
		<div class="fitem">
			<div>审单</div>
			<label>处理量（票）:</label>
			<input name="countSd"  required="true">
			<label>用时（H）:</label>
			<input id="hsd" name="hourSd" required="true">
		</div>
		<div class="fitem">
			<div>导单</div>
			<label>处理量（票）:</label>
			<input name="countDd"  required="true">
			<label>用时（H）:</label>
			<input id="hdd" name="hourDd" required="true">
		</div>
		<div class="fitem">
			<label>日出货量:</label>
			<input name="dayCount" required="true">
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
			<a href="<%=path%>/file/成本导入模板.xlsx" style="display:block;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;">下载</a>
		</div></br></br></br>
		<form id="fmfile"  enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;"/>
		</form>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:500px;height:300px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true">
</div>

</body>
</html>