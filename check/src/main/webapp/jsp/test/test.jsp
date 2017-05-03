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
$(function(){
	show_hint([]);
});
/*
var j="{\"result\":\"success\",\"code\":0,\"data\":1}";
alert(isJson(j));
console.log(j);
var json = eval('('+j+')');
alert(isJson(json));
console.log(json);
*/
</script>
<form action="<%=path %>/api/user/file" enctype="multipart/form-data" method="post">
	上传到用户表
	<input type="file" name="file"/>
	<input type="submit"/>
</form>

<br>
<a href="<%=path%>/api/import/cs">测试推送数据到哲盟</a>

<form action="<%=path %>/api/import/132" method="POST">
	<input name="_method" value="PUT">
	<input type="submit"/>
</form>
<br>

<form action="<%=path%>/api/receive/zm" method="post">
测试接收哲盟返回数据
<input name="data" value=""/>
<input name="key" value="sz_zm_2017-4-26"/>
<input type="submit">
</form>


<form action="<%=path%>/api/receive/tp" method="post">
测试接收哲盟返回的第三方数据
<input name="data" value=""/>
<input name="key" value="sz_zm_2017-4-26"/>
<input type="submit">
</form>
</body>
</html>