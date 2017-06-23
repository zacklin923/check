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
<title>成本收集汇总表</title>
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
</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<table id="dg" border="true"
		url="<%=path %>/api/primeCodeImport/collect"
		method="get" toolbar="#toolbar"
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
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="报表>成本收集汇总" data-options="collapsible:true">
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
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-input">
	   			<div>
		    		导入开始日期：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfNow().toString2()%>"/>
	    		</div>
	    		<div>
	    			导入结束日期：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString2()%>"/>
	    		</div>
	    		<input type="hidden" name="_header" value="${licence }"/>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="export_excel()">导出</a>
		<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
		<div class="pull-away"></div>
	</div>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:500px;height:300px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true">
</div>

</body>
</html>