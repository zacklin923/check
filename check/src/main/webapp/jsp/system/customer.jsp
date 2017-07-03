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
<title>客户管理</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
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
						window.location.href=json.data;
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
<table id="dg" border="true"
		url="<%=path %>/api/customer"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="基础信息维护>客户信息" data-options="collapsible:true">
		<script>
		    $("#myPanel").panel({
		    	onCollapse:function() {
		    		$('#dg').datagrid('resize');
		        },
		    	onExpand:function() {
		    		$('#dg').datagrid('resize');
		        }
		    });
		</script>
		<div class="btn-separator-none">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#fileImport').dialog('open')">导入数据</a>
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addObj()">添加客户</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑客户</a>
			<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteObj()">删除客户</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
	   		<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		客户条码：<textarea name ="str1" style="height:85px;width:100px;"></textarea>
	   			</div>
	   		</div>
	   		<div class="searchBar-input1">
	    		<div style="float:left;margin-left:30px;">
	    			历史记录:<input style="width:15px;height:15px;" name="int1" type="radio" value="1"/>是<input style="width:15px;height:15px;" name="int1" type="radio" value="0" checked="checked"/>否
	    		</div>
	    		<div>
	    			客户名称：<input name ="str2" />
	    		</div>
	    		<div>
	    			维护(中端)：<input name ="str3" />
	    		</div>
	    		<div>
	    			维护(前端)：<input name ="str4" />
	    		</div>
	    		<input type="hidden" name="_header" value="${licence }"/>
	   		</div>
	   		<div class="searchBar-input1">
	   			<div>
	    			维护(后端)：<input name ="str5" />
	    		</div>
	    		<div>
	    			客户类型：<input name ="str6" />
	    		</div>
	    		<div>
	    			大区：<input name ="str7" />
	    		</div>
	    		<div>
	    			区部：<input name ="str8" />
	    		</div>
	   		</div>
	   		<div class="searchBar-input1">
	   			<div>
	    			分部：<input name ="str9" />
	    		</div>
	    		<div>
	    			业务负责人：<input name ="str10" />
	    		</div>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar1()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="$('#mbedit').dialog('open')">编辑模板</a>
		<div class="pull-away"></div>
	</div>
</div>
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
			<input name="dailyDelivery"  required="true">
		</div>
		<div class="fitem">
			<label>寄递货物详情:</label>
			<input name="goodsDetail"  required="true">
		</div>
		<div class="fitem">
			<label>提货方式:</label>
			<input name="carry_goods_type"  required="true">
		</div>
		<div class="fitem">
			<label>集包点:</label>
			<input name="packet_point"  required="true">
		</div>
		<div class="fitem">
			<label>退件:</label>
			<input name="return_piece"  required="true">
		</div>
		<div class="fitem">
			<label>物料:</label>
			<input name="matter"  required="true">
		</div>
		<div class="fitem">
			<label>投诉返利:</label>
			<input name="complain_rebate"  required="true">
		</div>
		<div class="fitem">
			<label>操作罚款:</label>
			<input name="option_fine"  required="true">
		</div>
		<div class="fitem">
			<label>费用理赔:</label>
			<input name="fee_compensate"  required="true">
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