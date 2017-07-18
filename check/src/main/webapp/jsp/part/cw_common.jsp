<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%= path%>/jsp/cw/css/index.css">
<link rel="stylesheet" href="<%= path%>/jsp/cw/css/base.css">
<link rel="stylesheet" href="<%= path%>/jsp/cw/css/look.css">
<link rel="stylesheet" href="<%= path%>/jsp/cw/css/commen.css"/>
<link href="<%= path%>/jsp/cw/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
<script type="text/javascript" src="<%= path%>/jsp/cw/js/base.js"></script>
<%
application.setAttribute("path", request.getContextPath());
%>