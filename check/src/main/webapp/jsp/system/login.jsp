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
<title>登录</title>
<style type="text/css">
#hint{
	color: red;
}
.input_lable{
	margin-left: 36px;
	position: absolute;
	font-size: 15px;
	margin-top: 26px;
}
</style>
</head>
<body>
<jsp:include page="/jsp/part/common.jsp"/>
<link rel="stylesheet" type="text/css" href="<%=path %>/framework/css/login.css">
<script type="text/javascript">
function login(){
	$("#hint").html("");//清空提示信息
	var f=$('#ff');
	var json=formToJson(f);
	console.log(json);
	$.ajax({
		url:"<%=path%>/api/login",
		type:"get",
		data:json,
		success:function(data){
			console.log(data);
			if(data.result=="success"){
				console.log("登录成功");
				window.location.href="<%=path%>/jsp/part/main.jsp";
			}else{
				alert(data.data);
				console.log(data.code);
			}
			$("#errorMsg").html(data.data);
		}
	});
}
</script>

<div id="top">
        <div id="line" style="width: 2px;height: 48px;background: #a0a0a0 ;"></div>
        <span id="apptitle" class="apptitle" style="font-size: 32px; color: #666666;">大客户查件系统</span>
    </div>
    <div id="main">
        <div id="main_form">
            <form id="ff">
                 <div style="margin-top: 24px;margin-bottom: 22px;">
                    <label name="name" class="tabs-title">账户登录</label>
                 </div>
                 <div id="main_user">
					<span class="input_lable">用户名</span>
                    <input name="unum" placeholder="请输入用户名" class="name">
                 </div>
                 <div id="main_pswd">
                 	<span class="input_lable" style="margin-top: 82px;margin-left: -294px;">密码</span>
                    <input name="upass" placeholder="请输入密码" class="name" type="password">
                 </div>
                 <div id="errorMsg"></div>
                 <input name="submit" class="btn" type="button" value="登录" onclick="login()">
            </form>
        </div>
    </div>
    <div id="copyright">
        <lable class="copyright_l">
        	深圳韵达速递有限公司 | 信息与流程管理部-开发组提供技术支持
       </lable>
    </div>

</body>
</html>