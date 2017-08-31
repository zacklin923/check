<%@page import="com.zs.tools.DateTimeHelper"%>
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
<title>大客户信息</title>

</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
function stylesheet(){
	var a;
	$.ajax({
		url:"<%=path%>/api/customer/style/1",
		type:"GET",
		async:false,
		success:function(data){
			var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				var str = json.data;
				s="[["+str+"]]";
				a=eval(s);
			}else{
				alert("错误:"+json.code);
			}
		}
	});
	return a;
}
var url;
function addObj(){
	$("#dlg").dialog("open").dialog("setTitle","新建");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${user.licence }");
	url="<%=path%>/api/customer";
}
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
		url="<%=path%>/api/customer/"+row.cteBarCode;
	}
}
function save(){
	$("#fm").form("submit",{
		url:url,		
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					$('#dg').datagrid('reload');
					$("#dlg").dialog("close");
				}else{
					alert("错误:"+json.code);
				}
			}else{
				alert("错误:网络错误");
			}
		}
	});
}
function deleteObj(){
	var row=$("#dg").datagrid("getSelected");
	var id=row.cteBarCode;
	var hisid = row.historyCount;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"<%=path%>/api/customer/"+id+"-"+hisid,
						type:"delete",
						success:function(data){
							var json;
							if(isJson(data)){
								json=data;
							}else{
								json = eval('('+data+')');
							}
							if(json.result=='success'){
								$('#dg').datagrid('reload');
							}else{
								alert("错误:"+json.code);
							}
						}
					});
				}
			}
		);
	}
}
function excel_export(){
	show_hint([]);
	$("#search").form("submit",{
		url:"<%=path%>/api/customer/excelExport",
		method:"get",
		onSubmit: function(){   
			show_hint([]);
	    },   
	    success:function(data){
	    	hiden_hint();
	    	if(data){
	    		var json=null;
				if(isJson(data)){
					json=data;
				}else{
					try {
						json = eval('('+data+')');
					} catch (e) {
						alert(data);
					}
				}
				if(json!=null){
					if(json.result=='success'){
						window.location.href="<%=path%>/"+json.data;
					}else{
						hiden_hint();
						alert("错误:"+json.data+" "+json.data);
					}
				}else{
					hiden_hint();
					alert("错误:json解析错误");
				}
	    	}else{
	    		hiden_hint();
	    		alert("错误:网络错误");
	    	}
	    } 
	});
}
function upload(){
	$("#fileImport").dialog("close");
	show_hint([]);
	$("#fmfile").form("submit",{
		url:"<%=path %>/api/customer/import",		
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			console.log(data);
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					hiden_hint();
					$('#dg').datagrid('reload');
					alert(json.data);
					$("#fileImport").dialog("close");					
				}else{
					hiden_hint();
					$("#fileImport").dialog("close");	
					alert("错误:"+json.code+"错误原因："+json.data);
					$('#dg').datagrid('reload');
				}
			}else{
				hiden_hint();
				alert("错误:网络错误");
			}
		}
	});
}
function search_toolbar1(){
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		var reg=new RegExp("\r\n","g");
		if(json.str1!=null){
			var str1 = json.str1.replace(reg,",");
			json.str1=str1;
			console.log(str1);
		}
		isDgInit=true;
		$('#dg').datagrid('load', json);
	}
}
function moduleEdit(){
	var r=document.getElementsByName("orderline")
	console.log(r);
	var str = "";
	var str1="";
	for(var i=0;i<r.length;i++){
		if(r[i].value){
        	str = str + r[i].value+",";
			str1=str1+i+"a";
        }
    };
    str=str+str1+"_大客户信息";
    $('#mbedit').dialog('close');
    $('#dg').datagrid('loading');
    $.ajax({
		url:"<%=path%>/api/module/"+str,
		type:"PUT",
		success:function(data){
			$('#dg').datagrid('loaded');
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					setColumns(stylesheet());
				}else{
					alert("错误:"+json.code+"错误原因："+json.data);
				}
			}else{
				alert("错误:网络错误");
			}
		}
	});
}
</script>
<style>
.panel-body {border-color: #E6E6E6; border:none;}
	#menulist{height:30px;}
	#mypanel{border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="height:87px;overflow: hidden">

		<div class="layout-header" style="position: relative">
			<div class="layout-title">
				<h3><a>深圳韵达有限公司</a></h3>
			</div>
			<div class="self_title">
				<a href="">大客户信息</a>
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="$('#fileImport').dialog('open')"><span class="iterm1"></span>导入数据 </a>
                <a onclick="addObj()"><span class="iterm2"></span>添加客户</a>
                <a onclick="updateObj()"><span class="iterm3"></span>编辑客户</a>
                <a onclick="deleteObj()"><span class="iterm4"></span>删除客户</a>
                <a  onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
                <a onclick="excel_export()"><span class="iterm7"></span>导出</a>
                <a onclick="$('#mbedit').dialog('open')"><span class="iterm6"></span>编辑模板</a>
			</div>
			</div>
			
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px;box-sizing: content-box;overflow:hidden;" data-options="border:false" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="left">
                            <ul>
                                <li> <label for="">客户名称</label>
                                    <input type="text" name ="str2" >
                                </li>
                                <li>  <label for="">维护中端</label>
                                    <input type="text" name ="str3">
                                </li>
                                <li> <label for="">维护前端</label>
                                    <input type="text" name ="str4" >
                                </li>
                                <li> <label for="">维护后端</label>
                                    <input type="text" name ="str5">
                                </li>
                            </ul>
                        </div>
                        <div class="center">
                            <ul>
                                <li>  <label for=""">客户类型</label>
                                    <input type="text" name ="str6" >
                                </li>

                                <li> <label for="" >大区</label>
                                    <input type="text" style="margin-left: 33px" name ="str7"   ></li>

                                <li><label for="">区部</label>
                                    <input type="text" style="margin-left: 33px" name ="str8">
                                </li>
                                <li> <label for="" name ="str9">分部</label>
                                    <input type="text" style="margin-left: 33px" name ="str9" >
                                </li>
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">业务负责人</label>
                                    <input type="text"  style="margin-left: 22px"  name ="str10">
                                </li>
                                <li><label for="">历史记录</label>
                                <input style="width:15px;height:15px;margin-left:32px" name="int1" type="radio" value="1"/><span style="color:#6B6B6B">是</span>&nbsp;&nbsp;<input style="width:15px;height:15px;" name="int1" type="radio" value="0" checked="checked"/><span style="color:#6B6B6B">否</span>
                                </li>
                                
                            </ul>
                        </div>
                        <div class="textarea" >
                            <div><p for="">客户条码</p>
                                <textarea name ="str1" cols="200" rows="20"></textarea>
                            </div>
                        </div>
                </form>
             </div>
              <a onclick="search_toolbar1()"  id="my_search" style="top: 99px;left:50%;">查询</a>
            </div>
		</div>
     <table id="dg" border="true"
		url="<%=path %>/api/customer"
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="200" pageList="[200,300]">
</table>
		<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">客户信息</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<input type="hidden" name="historyCount"/>
		<div class="fitem">
			<label>客户条码:</label>
			<input name="cteBarCode" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>客户名称:</label>
			<input name="cteName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>维护客服（中端）:</label>
			<input name="customServiceCenter"  required="true">
		</div>
		<div class="fitem">
			<label>维护客服（前端）:</label>
			<input name="customServiceTop"  required="true">
		</div>
		<div class="fitem">
			<label>维护客服（后端）:</label>
			<input name="customServiceLast"  required="true">
		</div>
		<div class="fitem">
			<label>客户类型:</label>
			<input name="customType"  required="true">
		</div>
		<div class="fitem">
			<label>大区:</label>
			<input name="largeArea"  required="true">
		</div>
		<div class="fitem">
			<label>区部:</label>
			<input name="sliceArea" required="true">
		</div>
		<div class="fitem">
			<label>分部:</label>
			<input name="fenbu"  required="true">
		</div>
		<div class="fitem">
			<label>开通时间:</label>
			<input name="openDate" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" >
		</div>
		<div class="fitem">
			<label>暂停时间:</label>
			<input name="outDate" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" >
		</div>
		<div class="fitem">
			<label>业务负责人:</label>
			<input name="business"  required="true">
		</div>
		<div class="fitem">
			<label>结算方式:</label>
			<input name="accountsType"  required="true">
		</div>
		<div class="fitem">
			<label>面单类型:</label>
			<input name="pageType"  required="true">
		</div>
		<div class="fitem">
			<label>日均发货量:</label>
			<input name="dailyDeliveryNew"  required="true">
		</div>
		<div class="fitem">
			<label>寄递货物详情:</label>
			<input name="goodsDetail"  required="true">
		</div>
		<div class="fitem">
			<label>提货方式:</label>
			<input name="carryGoodsType"  required="true">
		</div>
		<div class="fitem">
			<label>集包点:</label>
			<input name="packetPoint"  required="true">
		</div>
		<div class="fitem">
			<label>退件:</label>
			<input name="returnPiece"  required="true">
		</div>
		<div class="fitem">
			<label>物料:</label>
			<input name="matter"  required="true">
		</div>
		<div class="fitem">
			<label>投诉返利:</label>
			<input name="complainRebate"  required="true">
		</div>
		<div class="fitem">
			<label>操作罚款:</label>
			<input name="optionFine"  required="true">
		</div>
		<div class="fitem">
			<label>费用理赔:</label>
			<input name="feeCompensate"  required="true">
		</div>
		<div class="fitem">
			<label>备注:</label>
			<input name="note"  required="true">
		</div>
		<div class="fitem">
			<label>启用状态:</label>
			<select name="state">
				<option value="启用">启用</option>
				<option value="关闭">关闭</option>
			</select>
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<div id="fileImport" class="easyui-dialog" style="width:350px;height:200px;padding:10px 20px"
		closed="true" modal="true" title="数据源导入">
		<div style="height:25px;line-height:25px;">数据导入模板
			<a href="<%=path%>/file/大客户信息导入模板.xlsx" style="display:block;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;">下载</a>
		</div></br></br></br>
		<form id="fmfile"  enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;"/>
		</form>
</div>
<div id="mbedit"class="easyui-dialog" style="width:650px;height:400px;padding:10px 20px"
		closed="true" buttons="#mbedit-buttons" modal="true" title="模板编辑">
		<form id="moduleform" method="post">
			<span style="font-size:20px;color:red;">顺序从0开始，全不选代表为最原始的状态</span>
			<table>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>客户条码</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>客户名称</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>维护客服（中端）</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>维护客服（前端）</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>维护客服（后端）</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>客户类型</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>大区</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>区部</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>分部</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>开通时间</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>暂停时间</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>业务负责人</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>结算方式</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>面单类型</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>日均发货量</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>寄递货物详情</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>提货方式</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>集包点</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>退件</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>投诉返利</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>操作罚款</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>费用理赔</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>备注</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>启用状态</td>
				</tr>
			</table>
		</form>
</div>
<div id="mbedit-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="moduleEdit()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#mbedit').dialog('close')">取消</a>
</div>
</body>
</html>