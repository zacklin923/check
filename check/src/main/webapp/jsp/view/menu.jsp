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
<body>

<a href="<%=path%>/cw/biguser">biguser.jsp</a>
<a href="<%=path%>/cw/collect">biguser.jsp</a>
<a href="<%=path%>/cw/collectree">biguser.jsp</a>


</body>
</html>