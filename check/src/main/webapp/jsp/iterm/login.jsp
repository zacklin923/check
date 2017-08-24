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
<link rel="stylesheet" href="<%=path%>/jsp/iterm/css/base.css">

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

</script>

<style>
    #myform{
        width: 360px;
        height: 170px;
        /*background-color: red;*/
        padding-top: 10px;
        padding-right: 30px;
        padding-left: 30px;
        position: relative;
    }
    #myform input{
        width: 337px;
        height: 35px;
        margin-top: 10px;
        background-color: white;
        border: 1px solid lightgray;
        text-indent: 10px;
    }
    #myform button{
        width: 340px;
        height: 40px;

    }


</style>
<div id="wrapper">
    <div id="header">
        <div id="header-line" style="position:relative">
        </div>
        <div id="inner">
            <div id="logo">
            </div>
        </div>
    </div>
    <div id="banner" style="background-image:url('<%=path%>/jsp/iterm/images/banner7.jpg');">
        <div id="body">
            <div id="split">
                <span></span>
            </div>
            <div id="boxoutline">
                <h3 style="width: 400px;height: 60px;font-size: 18px;background-color:#dddddd;line-height: 60px;text-align: center;;border-radius: 5px;font-weight: 600">系统登录</h3>
                <div id="myform">
                    <form id="ff">
                        <span style="color:rgba(102,102,102,.84)">工号</span><span style="background-image: url('<%=path%>/jsp/iterm/images/user.gif');display: inline-block;width: 16px;height: 16px;position: absolute;top: 48px;right: 63px"></span>
                        <br>
                        <input type="text" name="unum">
                        <br>
                        <span style="padding-top: 8px;display: inline-block;color:rgba(102,102,102,.84)">密码</span><span style="background-image: url('<%=path%>/jsp/iterm/images/psd.gif');display: inline-block;width: 16px;height: 16px;background-color: red;position: absolute;top: 123px;right: 63px"></span>
                        <br>
                        <input  name="upass" type="password"  type="text">
                        <button name="btnLogin" type="button"   style="text-align: center;margin-top: 20px;background: #E1AB00;color: white;font-size: 14px" onclick="login()">登&nbsp;&nbsp;录</button>
                    </form>
                </div>

            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div id="footer">
        <center>
            <a href="http://www.yundaex.com/" target="_blank">关于我们</a> | <a href="http://www.yundaex.com" target="_blank">深圳韵达速递</a> | <a href="http://www.yundaex.com" target="_blank">联系我们</a>
        </center>
    </div>
</div>

</body>
</html>


<div id="fileImport" class="easyui-dialog" style="width:350px;height:200px;padding:10px 20px"
        closed="true" modal="true" title="数据源导入">
        <div style="height:25px;line-height:25px;">
            <span style="margin-left:15px;font-weight:900">数据导入模板</span>    
            <a href="<%=path%>/file/数据源导入模板.xlsx" style="display:inline-block;width:80px;height:25px;border:1px solid lightgray;line-height:25px;margin-left:100px;color:black;font-weight:300px;text-align:center;">下载</a>
        </div>
        </br>
        </br>
        </br>
        <form id="fmfile"  enctype="multipart/form-data" method="post">
            <input style="padd-left:0px" type="file" name="file"/>
            <input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;margin-right:25px;"/>
        </form>
</div>