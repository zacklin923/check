<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
var j="['a','b']";
alert(isJson(j));
</script>
<form action="<%=path %>/api/user/file" enctype="multipart/form-data" method="post">
	<input type="file" name="file"/>
	<input type="submit"/>
</form>

<br>
<a href="<%=path%>/api/import/cs">测试推送数据到哲盟</a>

<form action="<%=path %>/api/import/132" method="POST">
	<input name="_method" value="PUT">
	<input type="submit"/>
</form>
</body>
</html>