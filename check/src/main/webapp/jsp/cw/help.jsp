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
<title>省份码</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>

<link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon"/>

<style>
	body{
		background-color: #cccccc;
		padding-left: 10px;
	}
</style>
	<div>
		<h2>错误码:</h2>
		<ul>
			<li>-1:通用错误码</li>
			<li>1:没有证书</li>
			<li>2:证书超时</li>
			<li>11:密码错误</li>
			<li>12:该用户不存在</li>
			<li>13:输入的用户必要信息不全</li>
			<li>101:没有权限</li>
			<li>102:该用户没有分配角色</li>
			<li>103:该权限不存在</li>
			<li>104:该模块还没有设计权限</li>
			</ul>
	</div>
		<div>
		<h2>关于数据查看</h2>
		<ol>
		<dl>该页面显示的是[所有人][当天导入]的数据以及[以前未上传]的数据。上传数据</dl>
		<dl>上传的规则是：上传[所有人][今天和昨天导入]的[未上传]的数据。</dl>
		<dl>注：“[]”表示是重点。</dl>
		</ol>
	</div>
	<div>
		<h2>哲盟返回的数据规则如下：</h2>
		<ul>
			<li>哲盟返回数据先接收，收到后会按照导入表将其他信息补全，然后插入数据库。</li>
			<li>如果接收到的数据在哲盟返回表中已存在，那么会尝试修改，修改只修改接收到的信息，其他信息不会改变。可修改的字段如下：
			<ul>
				<li>客户店铺	省份	地址	收件人	联系方式	物品价值	订单编号</li>
			</ul>
			 </li>
		</ul>
		<h4 style="color: red;">注意事项：</h4>
		<ul>
		<li>如果用户修改了省份，那么这个快递单号的省份将不会被哲盟返回的数据更新掉。</li>
		<li>粉底黑字代表用户已经修改过省份</li>
		<li>件查询里的按日期查询，开始时间为你要查的日期，结束时间为你要查的日期的后一天，比如我要查15号，那么开始为15，结束为16，假如我要查15到19号的，那么开始为15，结束为20。
双击可以打开历史记录条。</li>
		</ul>
</div>
	<div>
	<h2>哲盟返回第三方的数据规则如下：</h2>
	<ul>
		<li>哲盟返回第三方数据后接收，收到后会按照哲盟返回表将其他信息补全，然后插入数据库。</li>
		<li>如果接收到的数据在哲盟返回第三方表中已存在，那么会尝试修改，修改只修改接收到的信息，其他信息不会改变。</li>
		<h4>可修改的字段如下：</h4>
		<p>
	省份	地址	配送状态	收件人	异常原因	是否超时	订单编号	客户店铺	联系方式	物品	物品价值	费用
</p>
	</ul>

<h3 style="color: red;">注意事项：</h3>
<ul>
	<li>如果用户修改了配送状态，那么这个快递单号的配送状态将不会被哲盟返回的数据更新掉。</li>
	<li>粉底黑字代表用户已经修改过配送状态。</li>
	<li>双击可以打开历史记录。</li>
</ul>
</div>
	<div>
	<h2>条码：如果多个条码必须以“，”隔开，设置之后，该用户在[哲盟返回数据]和[哲盟返回第三方数据]中就只能看到自己负责的条码了。
	角色：用于设置权限，每个角色拥有自己的权限，关于角色的操作，需要在[角色管理]里面操作</h2>
</div>
<br>
	<div>
	<h2>以下是所有标准省份名称（内容来源于百度百科</h2>）
	<h4>4个直辖市、5个自治区、2个特别行政区、23个省</h4>
	<ul>
		<li>【华北】北京市、天津市、河北省、山西省、内蒙古自治区</li>
		<li>【东北】辽宁省、吉林省、黑龙江省</li>
		<li>【华东】上海市、江苏省、浙江省、安徽省、福建省、江西省、山东省</li>
		<li>【中南】河南省、湖北省、湖南省、广东省、广西壮族自治区、海南省</li>
		<li>【西南】重庆市、四川省、贵州省、云南省、西藏自治区</li>
		<li>【西北】陕西省、甘肃省、青海省、宁夏回族自治区、新疆维吾尔自治区</li>
		<li>【港澳台】香港特别行政区、澳门特别行政区、台湾省</li>
	</ul>
</div>
<div>
	<h2>权限总共有以下几类（一类不代表一个）</h2>
	<ul>
		<li>页面跳转：负责页面的跳转，没有将无法进入页面。</li>
		<li>api分页查看：负责数据表格的数据以及查询栏位的功能，没有将看不到数据。</li>
		<li>api单条查看：用于查看单条数据，一般不用于本模块，往往在其他模块使用，没有别的模块将可能出现问题。</li>
		<li>api添加：用于添加数据，没有将不能添加。</li>
		<li>api修改：用于添加数据，没有将不能修改。</li>
		<li>api删除：用于添加数据，没有将不能删除。</li>
		<li>api数据导入：负责将Excel表格的数据导入，没有将不能导入。</li>
		<li>api数据导出：负责将数据表格的数据导出成Excel，没有将不能导出。</li>
	</ul>
</div>

</body>
</html>