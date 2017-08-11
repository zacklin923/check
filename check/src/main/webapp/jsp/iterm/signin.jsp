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
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/timeLimit/excelExport",
		method:"get",
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
					var d = eval('('+data+')');
					window.location.href="<%=path%>/"+d.data;
				}else{
					alert("错误:"+json.data);
				}
			}
	    } 
	});
}
function obtain(){
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		if(json.date1 && json.date2){
			$.ajax({
				url:"<%=path%>/api/reportSign/regenerate",
				method:"post",
				data:json,
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
							alert(json.data);
						}else{
							alert("错误:"+json.code+" "+json.data);
						}
					}else{
						alert("错误:网络错误");
					}
				}
			});
		}else{
			alert("请选择你要重新计算的发货日期范围");
		}
	}
	
}
function search_toolbar_1(){
	var ratioSign1=$("#dg").datagrid("getColumnOption","ratioSign1");
	var ratioTimeout1=$("#dg").datagrid("getColumnOption","ratioTimeout1");
	var ratioSign2=$("#dg").datagrid("getColumnOption","ratioSign2");
	var ratioTimeout2=$("#dg").datagrid("getColumnOption","ratioTimeout2");
	var ratioSign3=$("#dg").datagrid("getColumnOption","ratioSign3");
	var ratioTimeout3=$("#dg").datagrid("getColumnOption","ratioTimeout3");
	var f=$('#search');
	if(f.form('validate')){
		isDgInit=true;
		var json=formToJson(f);
		if(json.int1=="1"){
			$("#dg").datagrid("hideColumn","ratioSign2");
			$("#dg").datagrid("hideColumn","ratioTimeout2");
			$("#dg").datagrid("hideColumn","ratioSign3");
			$("#dg").datagrid("hideColumn","ratioTimeout3");
			$("#dg").datagrid("showColumn","ratioSign1");
			$("#dg").datagrid("showColumn","ratioTimeout1");
			$("#dg").datagrid("showColumn","province");
			$("#dg").datagrid("showColumn","costHour");
			$("#dg").datagrid("showColumn","ctmBarCode");
			$("#dg").datagrid("showColumn","ctmName");
		}else if(json.int1=="2"){
			$("#dg").datagrid("hideColumn","ratioSign1");
			$("#dg").datagrid("hideColumn","ratioTimeout1");
			$("#dg").datagrid("hideColumn","ratioSign3");
			$("#dg").datagrid("hideColumn","ratioTimeout3");
			$("#dg").datagrid("hideColumn","province");
			$("#dg").datagrid("hideColumn","costHour");
			$("#dg").datagrid("showColumn","ratioSign2");
			$("#dg").datagrid("showColumn","ratioTimeout2");
			$("#dg").datagrid("showColumn","ctmBarCode");
			$("#dg").datagrid("showColumn","ctmName");
		}else if(json.int1=="3"){
			$("#dg").datagrid("hideColumn","ratioSign1");
			$("#dg").datagrid("hideColumn","ratioTimeout1");
			$("#dg").datagrid("hideColumn","ratioSign2");
			$("#dg").datagrid("hideColumn","ratioTimeout2");
			$("#dg").datagrid("hideColumn","province");
			$("#dg").datagrid("hideColumn","costHour");
			$("#dg").datagrid("hideColumn","ctmBarCode");
			$("#dg").datagrid("hideColumn","ctmName");
			$("#dg").datagrid("showColumn","ratioSign3");
			$("#dg").datagrid("showColumn","ratioTimeout3");
		}
	}
	search_toolbar();
}
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/reportSign/excelExport",
		method:"get",
		onSubmit: function(){   
			show_hint([]);
	    },   
	    success:function(data){
	    	hiden_hint();
	    	if(data){
	    		var json=null;
				if(isJson(data)){
					json=data;
				}else{
					try {
						json = eval('('+data+')');
					} catch (e) {
						alert(data);
					}
				}
				if(json!=null){
					if(json.result=='success'){
						window.location.href="<%=path%>/"+json.data;
					}else{
						alert("错误:"+json.data+" "+json.data);
					}
				}else{
					alert("错误:json解析错误");
				}
	    	}else{
	    		alert("错误:网络错误");
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

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px;box-sizing: content-box;overflow:hidden;" data-options="border:false" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  <label for=""">客户条码</label>
                                    <input type="text" style="margin-left: 10px"   name ="str2" >
                                </li>
                                <li><label for="">客户名称</label>
                                    <input type="text" name ="str1">
                                </li>
	                             <li>
	                             	<div style="height:10px;"></div>
					    			<input style="width:15px;height:15px;font-weight:300" name="int1" type="radio" value="4" checked="checked"><span style="color:#6B6B6B">按客户省份汇总</span>
					    			<input style="width:15px;height:15px;" name="int1" type="radio" value="3"><span style="color:#6B6B6B">按客户汇总</span>
					    			<input style="width:15px;height:15px;" name="int1" type="radio" value="2"><span style="color:#6B6B6B">总签收率</span>
			    					
                                </li>
                               
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">发货日期开始</label>
                                    <input style="height:23px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})"/value="2017-08-01">
                                </li>
                                <li><label for="">发货日期结束</label>
                                    <input style="height:23px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})"/value="2017-08-02">
                                </li>
                            </ul>
                        </div>
                </form>
             </div>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
    <table id="dg" border="true"
		url="<%=path %>/api/reportSign"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="false"
		rownumbers="true" fitColumns="true" 
		singleSelect="true" fit="false">
	<thead>
		<tr>
			<th field="beginCity" width="100" sortable="true">出发</th>
			<th field="ctmName" width="150" sortable="true">客户</th>
			<th field="ctmBarCode" width="200" sortable="true">客户条码</th>
			<th field="province" width="200" sortable="true">目的地</th>
			<th field="costHour" width="200" sortable="true">时效</th>
			<th field="ratioSign1" width="200" data-options="
				formatter:function(value,row,index){
                    if(row.ratioSign){
						return (row.ratioSign*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户各省签收率</th>
			<th field="ratioTimeout1" width="200" data-options="
				formatter:function(value,row,index){
                    if(row.ratioTimeout){
						return (row.ratioTimeout*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户各省超时率</th>
			<th field="ratioSign2" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioSign){
						return (row.ratioSign*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户签收率</th>
			<th field="ratioTimeout2" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioTimeout){
						return (row.ratioTimeout*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">客户超时率</th>
			<th field="ratioSign3" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioSign){
						return (row.ratioSign*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">总签收率</th>
			<th field="ratioTimeout3" width="200" hidden="true" data-options="
				formatter:function(value,row,index){
                    if(row.ratioTimeout){
						return (row.ratioTimeout*100).toFixed(2)+'%';
                    }else{
                    	return '0.00%';
                    }
             	}">总超时率</th>
		</tr>
	</thead>
</table>
</body>
</html>