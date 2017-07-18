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

<div class="loading-mask" style="display: none;">loading...</div>
<div id="wrapper">
    <div id="header">
        <div id="header-line">
        </div>
        <div id="inner">
            <div id="logo">
            </div>
        </div>
    </div>
    <div id="banner" style="background-image:url('images/banner.jpg')">
        <div id="body">
            <div id="split">
                <span></span>
            </div>
            <div id="boxoutline">
            </div>
            <div id="box">
                <form style="margin: 0; padding: 0;">
                    <ul id="userlogin">
                        <li>
                            <label class="caption">
                                账号
                            </label>
                            <input name="usercode" id="usercode" _lockvalue="false" datatype="text"
                                   class="text __field __multi-language" type="text" placeholder="用户名" pattern="">
                        </li>
                        <li>
                            <label class="caption">
                                <a href="#" tabindex="99">忘记密码</a> 密码</label>
                            <input name="password" id="password" _lockvalue="false" datatype="text" class="text __field"
                                   type="password" placeholder="密码">
                        </li>
                        <li class="btn">
                            <button id="btnLogin" name="btnLogin" hidefocus="true" type="button" class="primary"
                                    ref="index.html">登　录
                            </button>
                            <label for="remember">
                                <input id="remember" name="remember" datatype="boolean" type="checkbox" class="__field">
                                记住密码</label>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <!-- 底部栏 -->

    <div id="footer">
        <center>
            <a href="http://www.yundaex.com/" target="_blank">关于我们</a> | <a href="http://www.yundaex.com/ target="
                                                                            _blank">关于产品</a> | <a
                href="http://www.yundaex.com" target="_blank">联系我们</a>
        </center>
        <center><p>©1999-2016 <a href="http://www.yundaex.com/" target="_blank">韵达快递</a> 韵达速递（物流）有限公司</p>
        </center>
    </div>
</div>

</body>
</html>