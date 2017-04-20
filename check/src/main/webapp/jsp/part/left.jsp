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

<div class="easyui-accordion" style="width:100%;" data-options="fillSpace:true,fit: true,animate: true,selected:false">
	<div title="快件信息" data-options="iconCls:'icon-add'" style="overflow:auto;padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
	        <li><span><a href="<%=path %>/user" target="right">用户管理</a></span></li>
	        <li><span><a href="<%=path %>/user" target="right">客户查询</a></span></li>
        </ul>
	</div>
	<div title="故障报修登记" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
       		<li><span><a href="<%=path %>/daManager!queryOfFenye?cz=yes" target="right">故障报修管理</a></span></li>
       		<li><span><a href="<%=path %>/count!queryOfFenye?cz=yes" target="right">故障报修统计</a></span></li>
       		<li><span><a href="<%=path %>/handle!queryOfFenye?cz=yes" target="right">故障报修处理</a></span></li>
       		<li><span><a href="<%=path %>/auditing!queryOfFenye?cz=yes" target="right">故障报修转发审核</a></span></li>
        </ul>
	</div>
	<div title="数据统计报表" data-options="iconCls:'icon-large-shapes'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
        <li><span>信息与流程管理部</span>
        	<ul>
        		<li>
        			<span><a href="<%=path %>/quotaGroup!queryOfFenye?cz=yes" target="right">日统计报表式样</a></span>
        		</li>
        		<li>
        			<span><a href="<%=path %>/quotaGroupWeek!queryOfFenye?cz=yes" target="right">周月年统计报表</a></span>
        		</li>
        		<li>
        			<span><a href="<%=path %>/licence!licence?u_num=yd-4221&p_id=2" target="right">接口测试</a></span>
        		</li>
        	</ul>
        </li>
        </ul>
	</div>
	<div title="系统管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
      		<li><span><a href="<%=path %>/users!queryOfFenye?cz=yes" target="right">用户管理</a></span></li>
      		<li><span><a href="<%=path %>/role!queryOfFenye?cz=yes" target="right">角色管理</a></span></li>
        	<li><span>个人中心</span>
	        	<ul>
					<li><span><a href="<%=path %>/resetPass!queryInfo" target="right">个人信息</a></span></li>
					<li><span><a href="<%=path %>/resetPass!query" target="right">修改密码</a></span></li>
			        <li><span><a href="<%=path %>/timeline!query?cz=yes" target="right">操作日志</a></span></li>
					<li><span><a href="<%=path %>/information!query" target="right">任务提醒</a></span></li>
					<li><span><a href="<%=path %>/jobLog!gotoJob" target="right">工作日志</a></span></li>
	        	</ul>
	        </li>
        </ul>
	</div>
	
	<div title="通讯录" data-options="iconCls:'icon-print'" style="padding:10px;">
		<ul id="tt" class="easyui-tree" data-options="animate:true,lines:true">
	        <li><span>原通讯录设计</span>
	        	<ul>
			        <li><span><a href="<%=path %>/section!gotoAdd" target="right">添加</a></span></li>
			        <li><span>移动</span></li>
			        <li><span><a href="<%=path%>/index!contacts" target="right">查看</a></span></li>
	        	</ul>
	        </li>
	        <li><span>现通讯录设计</span>
	        	<ul>
	        		<li><span><a href="<%=path %>/cs!gotoAdd" target="right">添加</a></span></li>
			        <li><span><a href="<%=path%>/cs!query" target="right">查看</a></span></li>
	        	</ul>
	        </li>
	    </ul>
	</div>
	
	
	
	
</div>

</body>
</html>
