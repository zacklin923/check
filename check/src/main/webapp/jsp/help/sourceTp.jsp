<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	哲盟返回第三方的数据规则如下：
	<ol type="1" start="1">
		<li>哲盟返回第三方数据后接收，收到后会按照哲盟返回表将其他信息补全，然后插入数据库。</li>
		<li>如果接收到的数据在哲盟返回第三方表中已存在，那么会尝试修改，修改只修改接收到的信息，其他信息不会改变。</li>
	</ol>
	<br>
	可修改的字段如下：
	<br>
	<table border="1" cellpadding="4" cellspacing="0">
		<tr>
			<td>省份</td>
			<td>地址</td>
			<td>配送状态</td>
			<td>收件人</td>
			<td>异常原因</td>
			<td>是否超时</td>
			<td>订单编号</td>
			<td>客户店铺</td>
			<td>联系方式</td>
			<td>物品</td>
			<td>物品价值</td>
			<td>费用</td>
		</tr>
	</table>
	
	<br>
	注意事项：
	<ol type="1" start="1">
		<li>如果用户修改了配送状态，那么这个快递单号的配送状态将不会被哲盟返回的数据更新掉。</li>
		<li><font style="background-color: #FFCACF;color: #000;">粉底黑字代表用户已经修改过配送状态。</font></li>
		<li>双击可以打开历史记录。</li>
	</ol>
	
	
</body>
</html>