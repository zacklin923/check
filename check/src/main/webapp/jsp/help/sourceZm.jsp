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
	可修改的字段如下：
	<br>
	<table border="1" cellpadding="4" cellspacing="0">
		<tr>
			<td>客户店铺</td>
			<td>省份</td>
			<td>地址</td>
			<td>收件人</td>
			<td>联系方式</td>
			<td>物品价值</td>
			<td>订单编号</td>
		</tr>
	</table>
	<br>
	注意事项：
	<ol type="1" start="1">
		<li>如果用户修改了省份，那么这个快递单号的省份将不会被哲盟返回的数据更新掉。</li>
		<li><font style="background-color: #FFCACF;color: #000;">粉底黑字代表用户已经修改过省份。</font></li>
		<li>条件查询里的按日期查询，开始时间为你要查的日期，结束时间为你要查的日期的后一天，比如我要查15号，那么开始为15，结束为16，假如我要查15到19号的，那么开始为15，结束为20。</li>
	</ol>
</body>
</html>