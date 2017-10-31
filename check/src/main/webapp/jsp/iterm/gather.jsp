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
<title>成本导入收集</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid();
});
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
	pullRequestCommon({
		urlc:"/check/api/primeCodeImport",
		type:"PUT",
		jobj:formToJson($("#fm")),
		success:function(data){
			$('#dg').datagrid('reload');
			$("#dlg").dialog("close");
		},
		error:function(data){
			alert(data);
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
							pullRequestCommon({
								urlc:"/check/api/primeCodeImport",
								type:"DELETE",
								jobj:{id:item.id},
								success:function(data){
									hiden_hint();
									$('#dg').datagrid('reload');
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

<%-- function deleteAllData(){
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
} --%>

function upload(){
	$("#fileImport").dialog("close");
	show_hint([]);
	pullRequestFile({
		urlf:"/check/api/primeCodeImport/import",
		fid:"fmfile",
		success:function(data){
			hiden_hint();
			$('#dg').datagrid('reload');
			alert(json.data);
			$("#fileImport").dialog("close");
		},
		error:function(data){
			hiden_hint();
			$("#fileImport").dialog("close");	
			alert("错误:"+json.code+"错误原因："+json.data);
			$('#dg').datagrid('reload');
		}
	});
}

function search_toolbar1(){
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/primeCodeImport",
		dataf:formToJson($("#search")),
		success:function(data){
			
		}
	});
}
function export_excel(){
	show_hint([]);
	pullRequestCommon({
		urlc:"/check/api/primeCodeImport/exportExceltest",
		type:"GET",
		jobj:formToJson($("#search")),
		success:function(data){
			console.log(data);
			hiden_hint();
    		window.location.href=URL_PATH+"/check/"+data;
		},
		error:function(data){
			hiden_hint();
			console.log(data);
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

<!-- <style>
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
				<a href="">成本导入收集</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
               <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="$('#fileImport').dialog('open')"><span class="iterm1"></span>导入数据 </a>
                <a onclick="updateObj()"><span class="iterm2"></span>编辑数据</a>
                <a onclick="deleteAll()"><span class="iterm3"></span>批量删除</a>
                <a onclick="export_excel()"><span class="iterm4"></span>导出</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
		</div>
	</div> -->
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
        <div class="layout-title">
            <h4>深圳市韵达速递有限公司</h4>
        </div>
        <div class="self_title">
            <a href="">成本导入收集</a>
        </div>
        <div class="my_help"><a  href="../../../view/firstPage.html">返回首页</a>
            | <a  href="../../../view/index.html">退出登录 |
            </a><a onclick="$('#dlg_help').dialog('open')">帮助</a></div>
    </div>

</div>
	


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
			<div id="menulist" style="padding-top: 10px;position:raletiver">
		
                <a onclick="$('#fileImport').dialog('open')"><span class="iterm1"></span>导入数据 </a>
                <a onclick="updateObj()"><span class="iterm2"></span>编辑数据</a>
                <a onclick="deleteAll()"><span class="iterm3"></span>批量删除</a>
                <a onclick="export_excel()"><span class="iterm4"></span>导出</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
                <span class="myself_btn" style="position:absolute;right:5px;top:23px;">收缩</span>	
			
			</div>

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:2px;box-sizing: border-box;margin-top: 5px;width: 100%;margin: 0 auto;margin-top: 5px;" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  <label for=""">客户类型</label>
                                    <input type="text" style="margin-left: 10px"   name ="str6" >
                                </li>

                                <li><label for="">客户名称</label>
                                    <input type="text" name ="str5">
                                </li>
                                
                                <li> <label for="" >大区</label>
                                    <input type="text" style="margin-left: 35px" name ="str7"   ></li>
                                
                               
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">导入开始时间</label>
                                    <input style="height:27px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd HH:mm:ss'})"value="<%=DateTimeHelper.getBeginOfNow().toString1()%>"/>
                                </li>
                                <li><label for="">导入结束时间</label>
                                    <input style="height:27px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString1()%>"/>
                                </li>
                            </ul>
                        </div>
                        <div class="textarea" >
                            <div><p for="">客户条码</p>
                                <textarea name ="str3" cols="200" rows="20"></textarea>
                            </div>
                            <div style="margin-left: 30px"><p for="" >导入人员</p>
                                <textarea name="str4" cols="200" rows="20"></textarea>
                            </div>
                        </div>
                        
                </form>
             </div>
           <!-- <a onclick="search_toolbar1()"  id="my_search" style="top:21px;margin-left:910px;"><span class="fSearchIcon"></span>查询</a> -->
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
     <table id="dg" border="true"
		method="get" toolbar="#toolsbars"
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
		<div style="height:25px;line-height:25px;padding:5px 11px">数据导入模板
			<a href="<%=path%>/file/成本导入模板.xlsx" style="display:block;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;color:black;">下载</a>
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