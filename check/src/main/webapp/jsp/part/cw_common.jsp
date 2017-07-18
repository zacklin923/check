<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%= path%>/framework/css/cw/index.css">
<link rel="stylesheet" href="<%= path%>/framework/css/cw/base.css">
<link rel="stylesheet" href="<%= path%>/framework/css/cw/look.css">
<link rel="stylesheet" href="<%= path%>/framework/css/cw/commen.css"/>
<link href="<%= path%>/framework/image/cw/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
<script type="text/javascript" src="<%= path%>/framework/js/base.js"></script>