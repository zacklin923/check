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
<title>月报表</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
$(function(){
	stylesheet();
});
function stylesheet(){
	$('#search').form("submit",{
		url:"<%=path%>/api/reportMonth/style",
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
				s="[["+str+"]]";
				options={};
				options.columns = eval(s)
				$('#dg').datagrid(options);   
			}else{
				alert("错误:"+json.code);
			}
		}
	});
}
function refrence(){
	show_hint([]);
	$('#search').form("submit",{
		url:"<%=path %>/api/reportMonth/1",
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
	});
}
function save(){
	$("#fm").form("submit",{
		url:url,		
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

function search_toolbar1(){
	stylesheet();
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		isDgInit=true;
		$('#dg').datagrid('load', json);
	}
}
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/reportMonth/exportExceltest",
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
</script>
<style>
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
				<a href="">月报表</a>
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
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px;box-sizing: content-box;overflow:hidden;" data-options="border:false" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  <label for=""">条码</label>
                                    <input type="text" style="margin-left: 30px"   name ="str1"  >
                                </li>
                                <li><label for="">名称</label>
                                    <input type="text"style="margin-left: 30px" name ="str2" >
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
                                <li><label for="">开始月份</label>
                                    <input id="syear" style="width:50px;" min="2015" name="int2" type="number" value="<%=DateTimeHelper.getyear()%>"/>&nbsp;年&nbsp;<input id="smonth" style="width:40px;" name="int3" min="1" max="12" type="number" value="1"/>&nbsp;月
                                </li>
                                <li><label for="">结束月份</label>
                                    <input id="eyear" style="width:50px;" min="2015" name="int4" type="number" value="<%=DateTimeHelper.getyear()%>"/>&nbsp;年&nbsp;<input id="emonth" style="width:40px;" name="int5" min="1" max="12" type="number" value="<%=DateTimeHelper.getmonth()%>"/>&nbsp;月
                            </ul>
                        </div>
                </form>
             </div>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
       <table id="dg" border="true"
		url="<%=path %>/api/reportMonth"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		fitColumns="true" singleSelect="true"
		rownumbers="true" 
		singleSelect="true" fit="true"
		showFooter="true">
		</table>
</body>
</html>