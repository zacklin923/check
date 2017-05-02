<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	哲盟返回的数据规则如下：
	<ol type="1" start="1">
		<li>哲盟返回数据先接收，收到后会按照导入表将其他信息补全，然后插入数据库。</li>
		<li>如果接收到的数据在哲盟返回表中已存在，那么会尝试修改，修改只修改接收到的信息，其他信息不会改变。</li>
	</ol>
	哲盟返回第三方的数据规则如下：
	<ol type="1" start="1">
		<li>哲盟返回第三方数据后接收，收到后会按照哲盟返回表将其他信息补全，然后插入数据库。</li>
		<li>如果接收到的数据在哲盟返回第三方表中已存在，那么会尝试修改，修改只修改接收到的信息，其他信息不会改变。</li>
	</ol>
</body>
</html>