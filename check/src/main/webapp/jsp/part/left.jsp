<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/framework/jquery-easyui/themes/black/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/framework/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/framework/jquery-easyui/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/framework/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/framework/jquery-easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="<%=path %>/framework/js/myjs.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/framework/css/mycss.css">

	<style type="text/css">
	a{
		color: #FFAAFF;
	}
	
	</style>
	
	<script type="text/javascript">
	$(function(){
		//$('#tt').tree('collapseAll');
	});
	</script>
	
  </head>
  
<body style="padding: 0px;">

<div class="easyui-accordion" style="width:100%;"
		data-options="fillSpace:true,fit: true,animate: true,selected:false">
	<div title="快件信息" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
	        <li><span><a href="<%=path %>/import" target="right">数据源导入</a></span></li>
       		<li><span><a href="<%=path %>/import/err" target="right">数据源导入错误</a></span></li>
	        <li><span><a href="<%=path %>/timeLimit" target="right">时效控制信息管理</a></span></li>
	        <li><span><a href="<%=path %>/sourceZm" target="right">哲盟返回数据</a></span></li>
	        <li><span><a href="<%=path %>/sourceTp" target="right">哲盟返回第三方数据</a></span></li>
        </ul>
	</div>
	<div title="系统管理[测试]" data-options="iconCls:'icon-system'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
       		<li><span><a href="<%=path %>/user" target="right">用户管理</a></span></li>
       		<li><span><a href="<%=path %>/role" target="right">角色管理</a></span></li>
	        <li><span><a href="<%=path %>/power" target="right">权限管理</a></span></li>
        </ul>
	</div>
	<div title="帮助" data-options="iconCls:'icon-help'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
       		<li><span><a href="<%=path %>/jsp/part/error_code.jsp" target="right">错误码说明</a></span></li>
       		<li><span><a href="<%=path %>/jsp/help/sourceImport.jsp" target="right">导入数据说明</a></span></li>
       		<li><span><a href="<%=path %>/jsp/help/sourceZm.jsp" target="right">哲盟返回数据和第三方数据说明</a></span></li>
       		<li><span><a href="<%=path %>/jsp/help/user.jsp" target="right">用户管理说明</a></span></li>
       		<li><span><a href="<%=path %>/jsp/help/role.jsp" target="right">角色管理说明</a></span></li>
        </ul>
	</div>
	<div title="测试" data-options="iconCls:'icon-cancel'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
       		<li><span><a href="<%=path %>/jsp/test/test.jsp" target="right">快速测试</a></span></li>
        </ul>
	</div>
	
</div>

</body>
</html>
