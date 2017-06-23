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
<title>运单信息查询</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
$(function(){
	stylesheet();
});
function stylesheet(){
	$.ajax({
		url:"<%=path%>/api/customer/style/2",
		type:"GET",
		success:function(data){
			var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				console.log(json.data);
				var str = json.data;
				s="[["+str+"]]";
				options={};
				options.columns = eval(s)
				$('#dg').datagrid(options);   
			}else{
				alert("错误:"+json.code);
			}
		}
	});
}
var url;
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		var logt = (new Date(""+row.returnDate)).getTime();
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${licence }");
		url="<%=path%>/api/sourceZm/"+row.courierNumber+","+logt;
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
function selectAll(){
	var a = $('#exportdiv input');
	if(a[0].checked){
		for(var i = 0;i<a.length;i++){
			if(a[i].type == "checkbox") a[i].checked = false;
		}
	}else{
		for(var i = 0;i<a.length;i++){
			if(a[i].type == "checkbox") a[i].checked = true;
		}
	}
}
function negated(){
	$("#exportdiv input:checkbox").each(function () {  
        this.checked = !this.checked;  
     }) 
}
function excel_export(){
	var r=document.getElementsByName("exportline")
	var str = "";
	for(var i=0;i<r.length;i++){
        if(r[i].checked){
        	str = str + r[i].nextSibling.nodeValue+",";
      }
    };
	$("#exportvalue").val(str);
	$("#search").form("submit",{
		url:"<%=path%>/api/sourceZm/exportExceltest",
		onSubmit: function(){   
		},   
	    success:function(data){   
	    	var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json.result=='success'){
				var d = eval('('+data+')');
				$("#exportdiv").dialog("close");
				window.location.href=d.data;
			}else{
				alert("错误:"+json.data);
			}
	    } 
	});
}

var a="${isLoading}";
var a1="${isLoading}";
function checkIsUal(){
	console.log("a:"+a);
	if(a=="" || a=="false"){
		hiden_hint();
	}else{
		show_hint([]);
		$.ajax({
			url:"<%=path%>/api/sourceZm/isLoading",
			success:function(data){
				a=data;
			}
		});
		setTimeout("checkIsUal()",2000);
	}
	if((a1=="true")&&(a=="" || a=="false")){
		$('#dg').datagrid('reload');
		alert("请到导入数据错误处查看是否有错误数据")
	}
}

function dblclick(rowIndex, rowData){
	$("#dlg_history").dialog("open");
	if(rowData.courierNumber){
		$("#dg_history").datagrid({
			url:"<%=path%>/api/sourceZm/"+rowData.courierNumber+"/history",
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
				alert("错误:-1");
			}
		});
	}
}
$(function(){
	checkIsUal();
});
function upload(){
	$("#fileImport").dialog("close");
	show_hint([]);
	$("#fmfile").form("submit",{
		url:"<%=path %>/api/sourceZm/import",		
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
					$("#fileImport").dialog("close");					
				}else{
					hiden_hint();
					$("#fileImport").dialog("close");	
					alert("错误:"+json.code+"错误原因："+json.data);
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
		console.log(json.str3);
		if(json.str3!=null){
			var str3 = json.str3.replace(reg,",");
			json.str3=str3;
			console.log(str3);
		}
		if(json.str2!=null){
			var str2 = json.str2.replace(reg,",");
			json.str2=str2;
			console.log(str2);
		}
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
    str=str+str1+"_运单信息查询";
    $.ajax({
		url:"<%=path%>/api/module/"+str,
		type:"PUT",
		success:function(data){
			if(data){
				var json;
				if(isJson(data)){
					json=data;
				}else{
					json = eval('('+data+')');
				}
				if(json.result=='success'){
					$('#mbedit').dialog('close');
					stylesheet();
				}else{
					$('#mbedit').dialog('close');
					alert("错误:"+json.code+"错误原因："+json.data);
				}
			}else{
				hiden_hint();
				alert("错误:网络错误");
			}
		}
	});
}
</script>
<table id="dg" border="true"
		url="<%=path %>/api/sourceZm"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="100" pageList="[100,500,1000]" >
</table>
<div id="toolbar">
	<div id="myPanel" class="easyui-panel" style="width:100%;" title="快件信息>运单信息查询" data-options="collapsible:true">
		<script>
		    $("#myPanel").panel({
		    	onCollapse:function() {
		    		$('#dg').datagrid('resize');
		            console.log(12131231);
		        },
		    	onExpand:function() {
		    		$('#dg').datagrid('resize');
		            console.log(12131231);
		        }
		    });
		</script>
		<div class="btn-separator-none">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#fileImport').dialog('open')">导入数据</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateObj()">编辑数据</a>
		</div>
		<div class="btn-separator">
			<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
		</div>
		<br class="clear"/>
		<hr class="hr-geay">
		<form id="search">
			<input type="hidden" name="_header" value="${user.licence }"/>
			<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		快递单号：<textarea name ="str3" style="height:85px;width:100px;"></textarea>	
	   			</div>
	   		</div>
	   		<div class="searchBar-logistic">
		    	<div style="float:left;margin-left:5px;">	
		    		客户条码：<textarea name ="str2" style="height:85px;width:100px;"></textarea>	
	   			</div>
	   		</div>
			<div class="searchBar-input1">
	    		<div>
		    		发货开始日期：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfOld().toString2()%>"/>
	    		</div>
	    		<div>
	    			发货结束日期：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfOld().toString2()%>"/>
	    		</div>
	    		<div>
	    			订单编号：<input name ="str5" />
	    		</div>
	    		<div>
	    			状态：
	    			<select name="int1" style="width: 140px;">
	    				<option value="">--请选择发货状态--</option>
	    				<option value="1">已发货</option>
	    				<option value="0">未发货</option>
	    			</select>
	    		</div>
	   			<input type="hidden" name ="str6" id = "exportvalue"/>
	   		</div>
	   		<div class="searchBar-input1">
	    		<div>
		    		所属大区：<input name ="str4" />
	    		</div>
	    		<div>
		    		所属区部：<input name ="str7" />
	    		</div>
	    		<div>
		    		所属分部：<input name ="str8" />
	    		</div>
	    		<div>
		    		所属分拨点：<input name ="str9" />
	    		</div>
	   		</div>
	   		<div class="searchBar-input1">
	   			<div>
		    		省份：<input name ="str10" />
	    		</div>
	    		<div>
		    		客户店铺：<input name ="str11" />
	    		</div>
	    		<div>
		    		地址：<input name ="str12" />
	    		</div>
	   		</div>
	   	</form>
	   	<div class="clear"></div>
	   	<hr class="hr-geay">
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar1()">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
		<a class="easyui-linkbutton" iconCls="icon-search" onclick="$('#exportdiv').dialog('open');">导出</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="$('#mbedit').dialog('open')">编辑模板</a>
		<div class="pull-away"></div>
	</div>
</div>

<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">返回数据信息</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<div class="fitem">
			<label>省份:</label>
			<input name="province" required="true">
		</div>
		<div class="fitem">
			<label>地址:</label>
			<input name="address" required="true">
		</div>
		<div class="fitem">
			<label>客户店铺:</label>
			<input name="shopNumber"  required="true">
		</div>
		<div class="fitem">
			<label>收件人:</label>
			<input name="addressee" required="true">
		</div>
		<div class="fitem">
			<label>联系方式:</label>
			<input name="phone"  required="true">
		</div>
		<div class="fitem">
			<label>物品:</label>
			<input name="goods"  required="true">
		</div>
		<div class="fitem">
			<label>物品价值:</label>
			<input name="goodsCost"  required="true">
		</div>
		<div class="fitem">
			<label>订单编号:</label>
			<input name="orderNumber" required="true">
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
			<a href="<%=path%>/file/哲盟返回数据导入模板.xlsx" style="display:block;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;">下载</a>
		</div></br></br></br>
		<form id="fmfile"  enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;"/>
		</form>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:500px;height:300px;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceZm.jsp" cache="true">
</div>
<div id="dlg_history" title="快件信息>运单信息查询>历史数据" class="easyui-dialog" iconCls="icon-help" style="width:1400px;height:800px;"
		closed="true" modal="false" collapsible="true" cache="true">
	<table id="dg_history" border="false"
		method="get"
		loadMsg="数据加载中请稍后……"
		striped="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true">
		<thead>
			<tr>
			<th field="largeArea" width="80" sortable="true">所属大区</th>
			<th field="sliceArea" width="80" sortable="true">所属区部</th>
			<th field="fenbu" width="80" sortable="true">所属分部</th>
			<th field="fbdArea" width="100" sortable="true">所属分拨点</th>
			<th field="ctmBarCode" width="100" sortable="true">客户条码</th>
			<th field="ctmName" width="100" sortable="true">客户名称</th>
			<th field="courierNumber" width="120" sortable="true">快递单号</th>
			<th field="sendTime" width="150" sortable="true">发货日期</th>
			<th field="province" width="50" sortable="true">省份</th>
			<th field="address" width="150" sortable="true">地址</th>
			<th field="shopNumber" width="100" sortable="true">客户店铺</th>
			<th field="addressee" width="60" sortable="true">收件人</th>
			<th field="phone" width="100" sortable="true">联系方式</th>
			<th field="weight" width="60" sortable="true">重量</th>
			<th field="courierCompany" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(value=='11'){
							return '韵达实物';
                      }else if(value=='22'){
                      		return '韵达刷单';
                      }else if(value=='33'){
                      		return '圆通';
                      }else if(value=='44'){
                      		return '顺丰';
                      }else if(value=='55'){
                      		return 'EMS';
                      }else if(value=='66'){
                      		return '邮政小包';
                      }
               }">快递公司</th>
			<th field="goodsCost" width="80" sortable="true">物品价值</th>
			<th field="goods" width="60" sortable="true">物品</th>
			<th field="createDate" width="100" sortable="true">创建日期</th>
			<th field="courierState" width="60" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(value=='0'){
							return '未发货';
                      }else if(value=='1'){
                      		return '已发货';
                      }
               }">状态</th>
			<th field="returnDate" width="100" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(row.returnDate){
						return getDateByMs(new Date(row.returnDate),'/');
                          }
                      }">返回日期</th>
			<th field="orderNumber" width="160" sortable="true">订单编号</th>
			<th field="timeOut" width="160" sortable="true">超时时间</th>
			<th field="createTime" width="200" sortable="true">系统接收时间</th>
		</tr>
		</thead>
	</table>
</div>
<div id="exportdiv" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px"
		closed="true" buttons="#exportdiv-buttons" modal="true" title="导出选项">
		请选择你需要导出的列：
			<div><input type="checkbox" name="exportline" value="1"/>所属大区</div>
			<div><input type="checkbox" name="exportline" value="2"/>所属区部</div>
			<div><input type="checkbox" name="exportline" value="3"/>所属分部</div>
			<div><input type="checkbox" name="exportline" value="4"/>所属分拨点</div>
			<div><input type="checkbox" name="exportline" value="5"/>客户条码</div>
			<div><input type="checkbox" name="exportline" value="6"/>客户名称</div>
			<div><input type="checkbox" name="exportline" value="7"/>快递单号</div>
			<div><input type="checkbox" name="exportline" value="8"/>发货日期</div>
			<div><input type="checkbox" name="exportline" value="9"/>省份</div>
			<div><input type="checkbox" name="exportline" value="10"/>地址</div>
			<div><input type="checkbox" name="exportline" value="11"/>客户店铺</div>
			<div><input type="checkbox" name="exportline" value="12"/>收件人</div>
			<div><input type="checkbox" name="exportline" value="13"/>联系方式</div>
			<div><input type="checkbox" name="exportline" value="14"/>重量</div>
			<div><input type="checkbox" name="exportline" value="15"/>快递公司</div>
			<div><input type="checkbox" name="exportline" value="16"/>物品价值</div>
			<div><input type="checkbox" name="exportline" value="17"/>物品</div>
			<div><input type="checkbox" name="exportline" value="18"/>创建日期</div>
			<div><input type="checkbox" name="exportline" value="19"/>状态</div>
			<div><input type="checkbox" name="exportline" value="20"/>返回日期</div>
			<div><input type="checkbox" name="exportline" value="21"/>订单编号</div>
			<div><input type="checkbox" name="exportline" value="22"/>超时时间</div>
			<div><input type="checkbox" name="exportline" value="23"/>系统接收时间</div>
</div>
<div id="exportdiv-buttons">
	<a class="easyui-linkbutton"  onclick="selectAll()">全选/全不选</a>
	<a class="easyui-linkbutton"  onclick="negated()">反 选</a>
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="excel_export()">导出</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<div id="mbedit"class="easyui-dialog" style="width:650px;height:400px;padding:10px 20px"
		closed="true" buttons="#mbedit-buttons" modal="true" title="模板编辑">
		<form id="moduleform" method="post">
			<span style="font-size:20px;color:red;">顺序从0开始，全不选代表为最原始的状态</span>
			<table>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>所属大区</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>所属区部</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>所属分部</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>所属分拨点</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>客户条码</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>客户名称</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>快递单号</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>发货日期</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>省份</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>地址</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>客户店铺</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>收件人</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>联系方式</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>重量</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>快递公司</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>物品价值</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>物品</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>创建日期</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>状态</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>返回日期</td>
				</tr>
				<tr>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>订单编号</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>超时时间</td>
					<td><input style="width:50px;" name ="orderline" type="number" min="1" max="25"/>系统接收时间</td>
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