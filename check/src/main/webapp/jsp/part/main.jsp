<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
<frameset rows="100px,0px,*" frameborder="no" bordercolor="#E6E6E6" style="border-style: solid">
	<frame name="top" src="<%=path%>/jsp/part/top.jsp" noresize="noresize" scrolling="no"/>
	<frame name="top_center" src="<%=path%>/  left_center.jsp" noresize="noresize" scrolling="no"/>
	<frameset cols="250px,0px,*">
		<frame name="left" src="<%=path%>/jsp/part/left.jsp" noresize="noresize" scrolling="no"/>
		<frame name="left_center" src="<%=path%>/jsp/part/left_center.jsp" noresize="noresize" scrolling="no" marginwidth="0"/>
		<frameset rows="*,50px">
			<frame name="right" src="<%=path%>/jsp/part/welcom.jsp" noresize="noresize"/>
			<frame name="bottom" src="<%=path%>/jsp/part/bottom.jsp" noresize="noresize"/>
		</frameset> 
	</frameset>
</frameset>
</html>
