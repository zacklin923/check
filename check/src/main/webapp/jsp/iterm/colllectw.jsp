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
<title>成本按导入人</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid();
});
function export_excel(){
	pullRequestCommon({
		urlc:"/check/api/primeCodeImport/exportExcelPersonle",
		type:"GET",
		jobj:formToJson($("#search")),
		success:function(data){
			console.log(data);
			hiden_hint();
    		window.location.href=URL_PATH+"/check/"+data;
		},
		error:function(data){
			alert(data);
		}
	});
	
}
function search_toolbar1(){
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/primeCodeImport/personle",
		dataf:formToJson($("#search")),
		success:function(data){
			
		}
	});
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
				<a href="">成本按导入人</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="export_excel1()"><span class="iterm4"></span>导出</a>
                <a onclick="search_toolbar()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
			
		</div>
	</div>
 -->
 <style>
.panel-body {border-color: #E6E6E6; border:none;}
  .datagrid-cell, .datagrid-cell-group, .datagrid-header-rownumber, .datagrid-cell-rownumber {

        padding: 4px;

    }


#mypanel{
border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="overflow: hidden;">
    <div class="layout-header" style="position: relative">
       
        <div class="logo"></div>
        
        <div class="self_title">
            <a href="">成本按导入人</a>
        </div>
       <div class="my_help">
           <a  href="javascript:window.opener=null;window.open('','_self');window.close();">关闭|
            </a><a onclick="$('#dlg_help').dialog('open')">帮助</a></div>
    </div>

</div>
 
<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
			<div id="menulist" style="padding-top: 5px;position:raletiver">
			
                <a onclick="export_excel()"><span class="iterm7"></span>导出数据</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询数据</a>
			   <span class="myself_btn">收缩</span>	
             </div>  
			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:2px;box-sizing: border-box;margin-top: 5px;width: 100%;margin: 0 auto;margin-top: 5px;" >
			
                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="right">
                            <ul>
                                <li><label for="">导入开始时间</label>
                                    <input style="height:27px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/value="<%=DateTimeHelper.getBeginOfNow().toString1()%>">
                                </li>
                                <li><label for="">导入结束时间</label>
                                    <input style="height:27px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/value="<%=DateTimeHelper.getEndOfNow().toString1()%>">
                                </li>
                            </ul>
                        </div>
                        <div class="textarea" >
                            <div><p for="">导入人</p>
                                <textarea name ="str1"  cols="200" rows="20"></textarea>
                            </div>
                        </div>
                        
                </form>
             </div>
             <!-- <a onclick="search_toolbar1()"  id="my_search" style="top:21px;margin-left:520px;"><span class="fSearchIcon"></span>查询</a> -->
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
    <table id="dg" border="true"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		singleSelect="true" fit="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true">
	<thead>
		<tr>
			<th rowspan="2" field="stuNum" width="60">处理人</th>
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
			<th rowspan="2" field="c21" width="60" sortable="true">日出货量</th>
		</tr>
		<tr>
			<th field="c1" width="100" sortable="true">处理量（票）</th>
			<th field="c2" width="80" sortable="true" data-options="
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
			<th field="c3" width="100" sortable="true">处理量（票）</th>
			<th field="c4" width="80" sortable="true" data-options="
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
			<th field="c5" width="100" sortable="true">处理量（票）</th>
			<th field="c6" width="80" sortable="true" data-options="
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
			<th field="c7" width="100" sortable="true">处理量（票）</th>
			<th field="c8" width="80" sortable="true" data-options="
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
			<th field="c9" width="100" sortable="true">处理量（票）</th>
			<th field="c10" width="80" sortable="true" data-options="
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
			<th field="c11" width="100" sortable="true">处理量（票）</th>
			<th field="c12" width="80" sortable="true" data-options="
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
			<th field="c13" width="100" sortable="true">处理量（票）</th>
			<th field="c14" width="80" sortable="true" data-options="
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
			<th field="c15" width="100" sortable="true">处理量（票）</th>
			<th field="c16" width="80" sortable="true" data-options="
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
			<th field="c17" width="100" sortable="true">处理量（票）</th>
			<th field="c18" width="80" sortable="true" data-options="
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
			<th field="c19" width="100" sortable="true">处理量（票）</th>
			<th field="c20" width="80" sortable="true" data-options="
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

<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:500px;height:300px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true">
</div>
</body>
</html>