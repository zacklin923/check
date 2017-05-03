<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	权限总共有以下几类（一类不代表一个）
	<ol type="1" start="1">
		<li>页面跳转：负责页面的跳转，没有将无法进入页面。</li>
		<li>api分页查看：负责数据表格的数据以及查询栏位的功能，没有将看不到数据。</li>
		<li>api单条查看：用于查看单条数据，一般不用于本模块，往往在其他模块使用，没有别的模块将可能出现问题。</li>
		<li>api添加：用于添加数据，没有将不能添加。</li>
		<li>api修改：用于添加数据，没有将不能修改。</li>
		<li>api删除：用于添加数据，没有将不能删除。</li>
		<li>api数据导入：负责将Excel表格的数据导入，没有将不能导入。</li>
		<li>api数据导出：负责将数据表格的数据导出成Excel，没有将不能导出。</li>
		<li>api数据上传(特殊)：用于数据上传，没有将不能上传，但上传功能不是每个模块都有的功能。</li>
	</ol>
</body>
</html>