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
<title>成本收集汇总</title>
</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
	function export_excel(){
		$("#search").form("submit",{
			url:"<%=path%>/api/primeCodeImport/exportExcelCollect",
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
				<a href="">成本收集汇总</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="export_excel()"><span class="iterm4"></span>导出</a>
                <a onclick="search_toolbar()"><span class="iterm5"></span>查询</a>
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
                        <div class="right">
                            <ul>
                                <li><label for="">导入开始时间</label>
                                    <input style="height:23px;" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfNow().toString2()%>"/>
                                </li>
                                <li><label for="">导入结束时间</label>
                                    <input style="height:23px;" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString2()%>"/>
                                </li>
                            </ul>
                        </div>
                        
                </form>
             </div>
             <a onclick="search_toolbar()"  id="my_search" style="top: 40px; left:15%;">查询</a>
		</div>
		<div style="height: 10px;background:white;"></div>
        </div>
    <table id="dg" border="true"
		url="<%=path %>/api/primeCodeImport/collect"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		fitColumns="true" singleSelect="true"
		rownumbers="true" 
		singleSelect="true" fit="true"
		showFooter="true">
	<thead>
		<tr>
			<th rowspan="2" field="ctmType" width="80" >客户类型</th>
			<th rowspan="2" field="ctmCount" width="60" >客户数量</th>
			<th rowspan="2" field="countAll" width="60" >出货量</th>
			<th rowspan="2" field="perWork" width="80" >上班人数</th>
			<th rowspan="2" field="perEfficiency" width="80" sortable="true">人均效能</th>
			<th align="center" field="ctmdName" colspan="3" width="180" >留言处理</th>
			<th align="center" field="ctmNdame" colspan="3" width="180" >其他异常处理</th>
			<th align="center" field="ctmNdame" colspan="4" width="180" >其他异常具体情况</th>
			<th rowspan="2" field="bbzz" width="60" sortable="true">报表制作</th>
			<th rowspan="2" field="zdNum" width="60" sortable="true">制单（票）</th>
		</tr>
		<tr>
			<th field="lyNum" width="100" sortable="true">处理量（票）</th>
			<th field="lyPer" width="100" sortable="true">处理人数</th>
			<th field="lyEfficiency" width="100" sortable="true">人均处理量</th>
			<th field="otherNum" width="100" sortable="true">处理量（票）</th>
			<th field="otherPer" width="100" sortable="true">处理人数</th>
			<th field="otherEfficiency" width="100" sortable="true">人均处理量</th>
			<th field="jdNum" width="100" sortable="true">截单（票）</th>
			<th field="cjNum" width="100" sortable="true">查件（票）</th>
			<th field="gdNum" width="100" sortable="true">跟单（票）</th>
			<th field="kslpNum" width="100" sortable="true">客诉理赔（票）</th>
		</tr>
	</thead>
</table>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:500px;height:300px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true">
</div>
</body>
</html>