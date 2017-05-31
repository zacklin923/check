<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link rel="stylesheet" type="text/css" href="<%=path %>/framework/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/framework/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path %>/framework/jquery-easyui/demo/demo.css">
<script type="text/javascript" src="<%=path %>/framework/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/framework/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path %>/framework/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/framework/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path %>/framework/css/zs.css">
<script type="text/javascript" src="<%=path %>/framework/js/zs.js"></script>

<script type="text/javascript">
/*张顺，2017-2-25
 * ajax添加头信息
 * */
$.ajaxSetup({ 
	headers : {"licence":"${user.licence}"},
	error:function(XMLHttpRequest, textStatus, errorThrown){
		alert(textStatus+" : "+XMLHttpRequest.status+"  "+errorThrown);
	}
});
$(function(){
	var f=$('#search');
	var json;
	if(f.form('validate')){
		json=formToJson(f);
	}
	$("#dg").datagrid({
		queryParams:json,
		onLoadSuccess:function (data) {
			$(this).datagrid("fixRownumber");
		},
		loadFilter: function(data){
			var a=eval('('+"{'total':'0',rows:''}"+')');
			if (data){
				if(data.result){
					if(data.result=='error'){
						alert("错误:"+data.code+"  "+data.data);
						return a;
					}
				}else{
					return data;
				}
			}else{
				return a;
			}
		},
		onLoadError:function(){
			alert("错误：-1  \n您操作太快了。\n也可能是未知原因，请联系开发者检查原因：(IT部)张顺、黄光辉。\n也可能是您还未登录。");
		}
	});
});
</script>
<jsp:include page="/jsp/part/hintModal.jsp"></jsp:include>