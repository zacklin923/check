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

</head>
<body>

<link rel="stylesheet" href="<%=path%>/jsp/iterm/css/login.css">
<script type="text/javascript" src="<%=path%>/framework/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript">
function login(){
	var f=$('#ff');
	var json=formToJson(f);
	$.ajax({
		url:"<%=path%>/api/login",
		type:"get",
		data:json,
		success:function(data){
			console.log(data);
			if(data.result=="success"){
				console.log("登录成功");
				window.location.href="<%=path%>/jsp/iterm/index.jsp";
			}else{
				alert(data.data);
				console.log(data.code);
			}
		}
	});
}
function formToJson(formObj){
	   var o={};
	   var a=formObj.serializeArray();
	   $.each(a, function() {
	       if(this.value){
	           if (o[this.name]) {
	               if (!o[this.name].push) {
	                   o[this.name]=[ o[this.name] ];
	               }
	                   o[this.name].push(this.value || null);
	           }else {
	               if($("[name="+this.name+"]:checkbox",formObj).length){
	                   o[this.name]=[this.value];
	               }else{
	                   o[this.name]=this.value || null;
	               }
	           }
	       }
	   });
	   return o;
	}
	function remberPasword(){
		var mypasword = $("#mypassword").val();
		$("#password").click(function(){
			window.localStorage.setIterm("密码","mypassword")
		})
	}
</script>

<div id="wrapper">
<div id="header">
    <div id="header-line" style="position:relative">
    </div>
    <div style="font-size:28px;position:absolute;left:650px;top:35px;">深圳韵达企业管理系统</div>
    <div id="inner">
        <div id="logo">
        </div>
    </div>
</div>
<div id="banner" style="background-image:url('<%=path %>/jsp/iterm/images/banner6.png')">
    <div id="body">
        <div id="split">
            <span></span>
        </div>
        <div id="boxoutline">
        </div>
        <div id="box">
            <form style="margin: 0; padding: 0;"id="ff">
                <ul id="userlogin">
                    <li>
                        <label class="caption">
                            用户名
                        </label>
                        <input name="unum" style="background-color:lightgray;" id="usercode"  class="text __field __multi-language" type="text" ></li>
                    <li>
                        <label class="caption">
                            密码
                        </label>

                        <input  name="upass" id="mypassword"  class="text __field" type="password"></li>

                    <li>
                        <button id="login_btn" name="btnLogin"  type="button" class="primary" onclick="login()";>登　录</button>
                       	
                       	
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <div class="clear">
    </div>
</div>
<div id="footer">
    <center>
        <a href="http://www.yundaex.com/" target="_blank">关于我们</a> | <a href="http://www.yundaex.com" target="_blank">关于产品</a> | <a href="http://www.yundaex.com" target="_blank">联系我们</a>
    </center>
    <center><p><a href="http://www.yundaex.com" target="_blank">深圳韵达速递</a> </p>
    </center>
</div>
</div>

</body>
</html>