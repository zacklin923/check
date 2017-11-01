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
<title>日报表</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
$(function(){
	stylesheet_1();
});
function stylesheet_1(){
	pullRequestCommon({
		urlc:"/check/api/reportDate/style",
		type:"GET",
		jobj:formToJson($("#search")),
		success:function(data){
			var str1 = data.split("_");
			s="[["+str1[0]+"],["+str1[1]+"]]";
			options={};
			options.columns = eval(s)
			$('#dg').datagrid(options);  
		}
	});
	<%-- $('#search').form("submit",{
		url:"<%=path%>/api/reportDate/style",
		method:"GET",
		success:function(data){
			var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				var str = json.data;
				var str1 = str.split("_");
				s="[["+str1[0]+"],["+str1[1]+"]]";
				options={};
				options.columns = eval(s)
				$('#dg').datagrid(options);   
			}else{
				alert("错误:"+json.code);
			}
		}
	}); --%>
}
function refrence(){
	show_hint([]);
	pullRequestCommon({
		urlc:"/check/api/reportDate/1",
		type:"GET",
		jobj:formToJson($("#search")),
		success:function(data){
			hiden_hint();
			alert(json.data);
			search_toolbar1();
		},
		error:function(data){
			hiden_hint();
		}
	});
	
	<%-- $('#search').form("submit",{
		url:"<%=path %>/api/reportDate/1",
		method:"GET",
		onSubmit: function(){   
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
					hiden_hint();
					alert(json.data);
					search_toolbar1();
				}else{
					hiden_hint();
					alert("错误:"+json.data);
				}
			}else{
				hiden_hint();
				alert("错误:网络错误");
			}
		}
	}); --%>
}

function search_toolbar1(){
	stylesheet_1();
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/reportDate",
		dataf:formToJson($("#search")),
		success:function(data){
			
		}
	});
}
function excel_export(){
	pullRequestCommon({
		urlc:"/check/api/reportDate/exportExceltest",
		type:"GET",
		jobj:formToJson($("#search")),
		success:function(data){
			console.log(data);
			hiden_hint();
    		window.location.href=URL_PATH+"/check/"+data;
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
				<a href="">日报表</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
               <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="refrence()"><span class="iterm1"></span>重新生成 </a>
                <a onclick="excel_export()"><span class="iterm2"></span>导出</a>
                <a onclick="deleteAll()"><span class="iterm3"></span>统计</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
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
	<div data-options="region:'north',split:false" style="overflow: hidden">
    <div class="layout-header" style="position: relative">
      
        <div class="logo"></div>
        <div class="self_title">
            <a href="">日报表</a>
        </div>
        <div class="my_help">
            <a href="javascript:window.opener=null;window.open('','_self');window.close();">退出|
            </a><a onclick="$('#dlg_help').dialog('open')">帮助</a></div>
    </div>

</div>

	
	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
		<div id="menulist" style="padding-top: 10px;position:raletiver">
			
                <a onclick="refrence()"><span class="iterm1"></span>重新生成 </a>
                <a onclick="excel_export()"><span class="iterm2"></span>导出数据</a>
                <a onclick="deleteAll()"><span class="iterm3"></span>统计数据</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询数据</a>
                <span class="myself_btn">收缩</span>
			
			</div>

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:2px;box-sizing: border-box;margin-top: 5px;width: 100%;margin: 0 auto;margin-top: 5px;" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  <label for=""">条码</label>
                                    <input type="text" style="margin-left: 10px"   name ="str1" >
                                </li>
                                <li><label for="">名称</label>
                                    <input type="text" name ="str2">
                                </li>
                                    <li><label for="">统计方式</label>  
			    			<input style="width:15px;height:15px;font-weight:300" name="int1" type="radio" value="4"><span style="color:#6B6B6B">大区</span>
			    			<input style="width:15px;height:15px;" name="int1" type="radio" value="3"><span style="color:#6B6B6B">区部</span>
			    			<input style="width:15px;height:15px;" name="int1" type="radio" value="2"><span style="color:#6B6B6B">分部</span>
			    			<input style="width:15px;height:15px;" name="int1" type="radio" value="1" checked="checked"><span style="color:#6B6B6B">条码</span>
                                </li>
                               
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">数据开始日期</label>
                                    <input style="height:27px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd'})" value="<%=DateTimeHelper.getolddate().toString3()%>"/>
                                </li>
                                <li><label for="">数据结束日期</label>
                                    <input style="height:27px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd'})" value="<%=DateTimeHelper.getolddate().toString3()%>"/>
                                </li>
                            </ul>
                        </div>
                </form>
             </div>
               <!-- <a onclick="search_toolbar1()"  id="my_search" style="top:66px;margin-left:650px;"><span class="fSearchIcon"></span>查询</a> -->
		</div>
        </div>
     <table id="dg" border="true"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		fitColumns="true" singleSelect="true"
		rownumbers="true" 
		singleSelect="true" fit="true"
		showFooter="true">
</table>

</body>
</html>