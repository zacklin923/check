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
<title>签收报表</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid();
});
function obtain(){
	show_hint([]);
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		if(json.date1 && json.date2){
			pullRequestCommon({
				urlc:"/check/api/reportSign/regenerate",
				type:"POST",
				jobj:json,
				success:function(data){
					hiden_hint();
					search_toolbar_1();
					alert(data);
				},
				error:function(data){
					hiden_hint();
				}
			});
		}else{
			hiden_hint();
			alert("请选择你要重新计算的发货日期范围");
		}
	}
	
}
function search_toolbar_1(){
	var f=$('#search');
	if(f.form('validate')){
		isDgInit=true;
		var json=formToJson(f);
		if(json.int1=="1"){
			$('#idenfy').text("客户条码");
			$('#idenfycal').text("客户名称");
			$('#quidenfy').text("客户条码");
			$("#dg").datagrid("showColumn","identify");
			$("#dg").datagrid("showColumn","beginArea");
			$("#dg").datagrid("showColumn","largeArea");
		}
		if(json.int1=="2"){
			$('#idenfy').text("省份");
			$('#idenfycal').text("时效");
			$('#quidenfy').text("省份");
			$("#dg").datagrid("showColumn","identify");
			$("#dg").datagrid("showColumn","beginArea");
			$("#dg").datagrid("hideColumn","largeArea");
		}
		if(json.int1=="3"){
			$('#idenfy').text("总量");
			$('#idenfycal').text("总量");
			$("#dg").datagrid("hideColumn","identify");
			$("#dg").datagrid("hideColumn","beginArea");
			$("#dg").datagrid("hideColumn","largeArea");
		}
	}
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/reportSign",
		dataf:json,
		success:function(data){
			
		}
	});
}
function excel_export(){
	show_hint([]);
	var f=$('#search');
	if(f.form('validate')){
		isDgInit=true;
		var json=formToJson(f);
		if(json.int1=="3"){
			alert("只有一条数据不用导出吧");
		}else{
			pullRequestCommon({
				urlc:"/check/api/reportSign/excelExport",
				type:"GET",
				jobj:json,
				success:function(data){
					console.log(data);
					hiden_hint();
		    		window.location.href=URL_PATH+"/check/"+data;
				},
				error:function(data){
					hiden_hint();
				}
			});
		}
	}
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
				<a href="">签收报表</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="obtain()"><span class="iterm1"></span>重新生成 </a>
                <a onclick="excel_export()"><span class="iterm2"></span>导出</a>
                <a><span class="iterm3"></span>统计</a>
                <a onclick="search_toolbar_1()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars"> -->
		<style>
.panel-body {border-color: #E6E6E6; border:none;}
  .datagrid-cell, .datagrid-cell-group, .datagrid-header-rownumber, .datagrid-cell-rownumber {

        padding: 4px;

    }


#mypanel{
border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="height:60px;overflow: hidden">
    <div class="layout-header" style="position: relative">
        <style>
            .logo {
                display: inline-block;
                width: 230px;
                height: 60px;
                background-image: url("images/logo12.jpg");
            }
        </style>
        <div class="logo"></div>
        <div class="layout-title" style="position: absolute;top: 28px;left: 250px;">
            <h4 style="color:white;font-size: 16px;font-weight: 600">深圳市韵达速递有限公司</h4>
        </div>
        <div class="self_title">
            <a href="">签收报表</a>
        </div>
        <div
            style="display: inline-block;width: 150px;height: 40px;position: absolute;top: 35px;right: 40px;color: #333333"><a style="color:#333;" href="../../firstPage.html">返回首页</a>
            | <a style="color:#333;" href="../../index.html">退出登录 |
            </a><a onclick="$('#dlg_help').dialog('open')" style="color:#333;">帮助</a></div>
    </div>

</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
			<div id="menulist" style="padding-top: 10px;position:raletiver">
				<a onclick="obtain()"><span class="iterm1"></span>重新生成 </a>
                <a onclick="excel_export()"><span class="iterm2"></span>导出</a>
                <a><span class="iterm3"></span>统计</a>
                <a onclick="search_toolbar_1()"><span class="iterm5"></span>查询</a>
			   <span class="myself_btn" style="position:absolute;right:5px;top:23px;">收缩</span>	
             </div> 

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:2px;box-sizing: border-box;margin-top: 5px;width: 100%;margin: 0 auto;margin-top: 5px;" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  
                                	<label id="quidenfy" for="">省份</label>
                                    <input type="text" style="margin-left: 10px" name ="str1" >
                                </li>
	                            <li>
	                             	<div style="height:10px;"></div>
					    			<input style="width:15px;height:15px;font-weight:300" name="int1" type="radio" value="2" checked="checked"><span style="color:#6B6B6B">按客户省份汇总</span>
					    			<input style="width:15px;height:15px;" name="int1" type="radio" value="1"><span style="color:#6B6B6B">按客户汇总</span>
					    			<input style="width:15px;height:15px;" name="int1" type="radio" value="3"><span style="color:#6B6B6B">总签收率</span>
                                </li>
                            </ul>
                        </div>
                        <div class="right" style="margin-left:40px;">
                            <ul>
                                <li><label for="">发货日期开始</label>
                                    <input style="height:27px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd'})"/value="<%=DateTimeHelper.getBeginOfOld().toString3()%>">
                                </li>
                                <li><label for="">发货日期结束</label>
                                    <input style="height:27px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd'})"/value="<%=DateTimeHelper.getEndOfOld().toString3()%>">
                                </li>
                            </ul>
                        </div>
                </form>
             </div>
          <!--    <a onclick="search_toolbar_1()" id="my_search" style="top: 38px;margin-left:615px;">查询</a> -->
          <a onclick="search_toolbar1()"  id="my_search" style="top:18px;margin-left:650px;"><span class="fSearchIcon"></span>查询</a>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
    <table id="dg" border="true"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="false"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="false">
	<thead>
		<tr>
			<th field="beginArea" width="100" sortable="true">出发地</th>
			<th field="identify" width="150" sortable="true"><span id="idenfy">省份</span></th>
			<th field="identifyDescribe" width="200"><span id="idenfycal">时效</span></th>
			<th field="largeArea" width="200" >所属大区</th>
			<th field="signRate" width="200" >签收率</th>
			<th field="timeOutRate" width="200" >超时签收率</th>
			<th field="notTimeOUtRate" width="200" >未超时签收率</th>
		</tr>
	</thead>
</table>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:1000px;height:600px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/province.jsp" cache="true">
</div>
</body>
</html>