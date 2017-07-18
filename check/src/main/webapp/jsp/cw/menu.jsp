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
<title>菜单</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>

<ul>
	<li><a href="<%=path%>/jsp/cw/biguser.jsp">biguser.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/collect.jsp">collect.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/collectree.jsp">collectree.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/collectwo.jsp">collectwo.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/day.jsp">day.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/erro.jsp">erro.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/gather.jsp">gather.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/help.jsp">help.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/index.jsp">index.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/log.jsp">log.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/login.jsp">login.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/look.jsp">look.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/messge.jsp">messge.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/mouth.jsp">mouth.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/province.jsp">province.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/signin.jsp">signin.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/statues.jsp">statues.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/timemessge.jsp">timemessge.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/username.jsp">username.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/username2.jsp">username2.jsp</a></li>
	<li><a href="<%=path%>/jsp/cw/username3.jsp">username3.jsp</a></li>
	
</ul>


</body>
</html>