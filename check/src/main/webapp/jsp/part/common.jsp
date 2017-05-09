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
	$("#dg").datagrid({
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
			alert("您操作的太快了！");
		}
	});
});
</script>
<jsp:include page="/jsp/part/hintModal.jsp"></jsp:include>