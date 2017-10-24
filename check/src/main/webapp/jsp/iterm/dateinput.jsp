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
<title>数据导入</title>
</head>
<body class="easyui-layout">
<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
$(function(){
	$('#dg').datagrid();
}); 
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
	}
}
function save(){
	var obj=formToJson($("#fm"));
	if($("#fm").form('validate')){
		pullRequestCommon({
			urlc:"/check/api/sourimport",
			type:"PUT",
			jobj:obj,
			success:function(data){
				$('#dg').datagrid('reload');
				$("#dlg").dialog("close");
			}
		});
	}
}
function deleteAll(){
	$.messager.confirm(
		"操作提示",
		"您确定要删除吗？",
		function(data){
			if(data){
				var checkedItems = $('#dg').datagrid('getChecked');
				var aid ="";
				$.each(checkedItems, function(index, item){
					if(item.courierNumber!=null){
						aid+=item.courierNumber+",";
					}
				}); 
				if(aid!=null){
					pullRequestCommon({
						urlc:"/check/api/sourimport/delete",
						type:"DELETE",
						jobj:{str1:aid},
						success:function(data){
							$('#dg').datagrid('reload');
						}
					});
				}
				
			}
		}
	);
}

function deleteAllData(){
	$.messager.confirm(
		"操作提示",
		"您确定要删除所有数据吗？",
		function(data){
			if(data){
				pullRequestCommon({
					urlc:"/check/api/sourimport",
					type:"DELETE",
					success:function(data){
						$('#dg').datagrid('reload');
					}
				});
			}
		}
	);
}



function upload(){
	$("#fileImport").dialog("close");
	show_hint([]);
	pullRequestFile({
		urlf:"/check/api/sourimport/import",
		fid:"fmfile",
		superSuccess:function(data){
			hiden_hint();
			var json;
			if(isJson(data)){
				json=data;
			}else{
				json = eval('('+data+')');
			}
			if(json){
				var r;
				if(json.result=='success'){
					r='导入成功';
				}else{
					r='导入失败';
				}
				$.messager.alert('导入结果通知', '结果：'+r+'<br>状态码：'+json.code+'<br>状态参数详情：'+json.data, 'info');
			}else{
				$.messager.alert('导入结果通知', '未知错误', 'error');
			}
		}
	});
}
function search_toolbar1(){
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/sourimport",
		dataf:formToJson($("#search")),
		success:function(data){
			
		}
	});
	
}
</script>

<style>
.panel-body {border-color: #E6E6E6; border:none;}
#menulist{height:30px;}
#mypanel{
border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="height:87px;overflow: hidden">

		<div class="layout-header" style="position: relative">
			<div class="layout-title">
				<h3><a>深圳韵达有限公司</a></h3>
			</div>
			<div class="self_title">
				<a href="">数据导入</a>
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
                <a onclick="updateObj()"><span class="iterm2"></span>编辑数据</a>
                <a onclick="deleteAll()"><span class="iterm3"></span>批量删除</a>
                <a onclick="deleteAllData()"><span class="iterm4"></span>删除所有</a>
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询</a>
             </div>   
			</div>
		</div>
	</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:3px;box-sizing: content-box;overflow:hidden;" >
			
                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="center">
                            <ul>
                                <li>  <label for=""">导入人</label>
                                    <input type="text" style="margin-left: 10px" name="str7" >
                                </li>

                                <li> <label for="" >商家ID</label>
                                    <input type="text" style="margin-left: 10px"name="str8"></li>

                                <li><label for="">客户名</label>
                                    <input type="text" name ="str5">
                                </li>
                               
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                                <li><label for="">订单编号</label>
                                    <input type="text" name ="str6"   style="margin-left: 35px" >
                                </li>
                                <li><label for="">导入开始日期</label>
                                   <input style="height:23px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<%=DateTimeHelper.getBeginOfNow().toString1()%>"/>
                                </li>
                                <li><label for="">导入结束日期</label>
                                    <input style="height:23px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="<%=DateTimeHelper.getEndOfNow().toString1()%>"/>
                                </li>
                            </ul>
                        </div>
                        <div class="textarea" >
                            <div><p for="">客户条码</p>
                                <textarea name ="str4" cols="200" rows="20"></textarea>
                            </div>
                            <div style="margin-left: 10px"><p for="" >快递编号</p>
                                <textarea name="str3" cols="200" rows="20"></textarea>
                            </div>
                        </div>
                          
                </form>
                <div>
                	<a onclick="search_toolbar1()"  id="my_search" style="top: 70px;">查询</a>
                </div>
             </div> 
            
		</div>
		 <div style="height:10px;background:white;"></div>
        </div>
      <table id="dg" border="true" 
		method="get" toolbar="#toolsbars"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		checkOnSelect="false" selectOnCheck="false"
		pageSize="100" pageList="[100,500,1000]">
	<thead>
		<tr>
			<th field="ck" checkbox="true"></th>
			<th field="stuName" width="60">导入人</th>
			<th field="createDate" width="100" sortable="true">创建日期</th>
			<th field="ctmName" width="60" sortable="true">客户名</th>
			<th field="ctmBarCode" width="80" sortable="true">客户条码</th>
			<th field="courierNumber" width="120" sortable="true">快递单号</th>
			<th field="oneCode" width="80" sortable="true">一段码</th>
			<th field="isPushed" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(value=='0'){
							return '否';
                      }else if(value=='1'){
                      		return '是';
                      }
               }">是否已上传</th>
			<th field="orderNumber" width="150" sortable="true">订单编号</th>
			<th field="address" width="300" sortable="true">地址</th>
			<th field="addressee" width="60" sortable="true">收件人</th>
			<th field="phone" width="120" sortable="true">联系方式</th>
			<th field="shopNumber" width="120" sortable="true">商家ID</th>
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
			<th field="numberType" width="60" sortable="true">类型</th>
			<th field="createTime" width="150" sortable="true">导入时间</th>
			<th field="province" width="80" sortable="true">省份</th>
		</tr>
	</thead>
</table>
		<div id="dlg" class="easyui-dialog" style="width:600px;height:660px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">导入数据编辑</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<div class="fitem">
			<label>创建时间:</label>
			<input name="createDate" type="date" required="true">
		</div>
		<div class="fitem">
			<label>客户名:</label>
			<input name="ctmName" required="true">
		</div>
		<div class="fitem">
			<label>客户条码:</label>
			<input name="ctmBarCode" required="true">
		</div>
		<div class="fitem">
			<label>快递单号:</label>
			<input name="courierNumber" required="true">
		</div>
		<div class="fitem">
			<label>地址:</label>
			<input name="address"  required="true">
		</div>
		<div class="fitem">
			<label>订单编号:</label>
			<input name="orderNumber"  required="true">
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
			<label>商家ID:</label>
			<input name="shopNumber" required="true">
		</div>
		<div class="fitem">
			<label>快递公司:</label>
			<input name="courierCompany" required="true">
		</div>
		<div class="fitem">
			<label>物品价值:</label>
			<input name="goodsCost" required="true">
		</div>
		<div class="fitem">
			<label>物品:</label>
			<input name="goods" required="true">
		</div>
		<div class="fitem">
			<label>客户类型:</label>
			<input name="numberType" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
	<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
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
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:50%;height:60%;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true" resizable="true">
</div>
</body>
</html>