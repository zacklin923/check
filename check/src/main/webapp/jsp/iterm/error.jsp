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
<title>错误数据</title>

</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>
<script type="text/javascript">
function deleteAll(){
	$.messager.confirm(
		"操作提示",
		"您确定要删除吗？",
		function(data){
			if(data){
				var checkedItems = $('#dg').datagrid('getChecked');
				$.each(checkedItems, function(index, item){
					if(item.sifId!=null){
						$.ajax({
							url:"<%=path %>/api/sourimportfail/"+item.sifId,
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
									console.log("错误:"+json.code);
								}
							}
						});
					}
				}); 
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
					$.ajax({
						url:"<%=path %>/api/sourimportfail",
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
								alert("错误:"+json.code+"  "+json.data);
							}
						}
					});
				}
			}
		);
}
function excel_export(){
	show_hint([]);
	$("#search").form("submit",{
		url:"<%=path%>/api/sourimportfail/exportExcel",
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
				hiden_hint();
				var d = eval('('+data+')');
				window.location.href="<%=path %>/"+d.data;
			}else{
				hiden_hint();
				alert("错误:"+json.data);
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
				<h3><a href="index.html">深圳韵达有限公司</a></h3>
			</div>
			<div class="self_title">
				<a href="">错误数据</a>    
			</div>
			<div class="layout-help" style="position: absolute;">
				<a onclick="$('#dlg_help').dialog('open')">帮助</a>
			</div>
            <div class="self-tool-btn" style="margin-top:50px;">
                <span class="myself_btn">收缩</span>	
            </div>
			<div id="menulist">
			<div>
                <a onclick="deleteAll()"><span class="iterm1"></span>批量删除 </a>
                <a onclick="deleteAllData()"><span class="iterm2"></span>删除所有</a>
                <a onclick="excel_export()"><span class="iterm3"></span>导出</a>
                <a onclick="search_toolbar()"><span class="iterm5"></span>查询</a>
			</div>
			</div>
		</div>
	</div>
	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:10px; box-sizing: content-box;overflow:hidden;" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="left">
                            
                               <ul>
                                 <li><label for="">导入时间开始</label>
                                  	<input style="height:23px" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd'})" />
                                </li>
                                <li><label for="">导入时间结束</label>
                                    <input style="height:23px" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd'})" />
                                </li>

                                
                            </ul>
                            
                        </div>
                        <div class="center">
                            <ul>
                            	
                                <li>  <label for=""">导入人</label>
                                    <input type="text" style="margin-left: 21px" name="str3" >
                                </li>
                                <li>
                                <li> <label for="" >失败类型</label>
                                    &nbsp;<select class="my_select"  name ="str2"  id=""  style="font-weight:300;color: #6B6B6B;margin-left:5px;">
                                    <option value="" style="color: #6B6B6B;font-weight: 300;">--请选择--</option>
                                    <option value="重复快递单号" style="color: #6B6B6B;font-weight: 300;">重复快递单号</option>
                                    <option value="数据必填项为空" style="color: #6B6B6B;font-weight: 300;">数据必填项为空</option>
                                    <option value="数据类型转换错误" style="color: #6B6B6B;font-weight: 300;">数据类型转换错误</option>
                                    <option value="快递单号不符合规范" style="color: #6B6B6B;font-weight: 300;">快递单号不符合规范</option>
                                    <option value="客户条码不存在" style="color: #6B6B6B;font-weight: 300;">客户条码不存在</option>
                                    </select>
                                </li>
                            </ul>
                        </div>
                        <input type="hidden" name="_header" value="${licence }"/>
                </form>
                
             </div>
             <a onclick="search_toolbar()"  id="my_search" style="top: 48px;left:30%;">查询</a>
		</div>
		 <div style="height:10px;background:white;"></div>
        </div>
      <table id="dg" border="true"
		url="<%=path %>/api/sourimportfail"
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
			<th field="createTime" width="150" sortable="true">导入时间</th>
			<th field="failType" width="100" sortable="true">失败类型</th>
            <th field="stuNum" width="70" sortable="true"  data-options="
				formatter:function(value,row,index){
                             if(row.user){
						return row.user.stuName;
                          }
                      }">导入人</th>
			<th field="createDate" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.createDate;
                          }
                      }" width="100">创建时间</th>
			<th field="ctmName" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.ctmName;
                          }
                      }" width="80">客户名</th>
			<th field="ctmBarCode" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.ctmBarCode;
                          }
                      }" width="80">客户条码</th>
			<th field="courierNumber" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.courierNumber;
                          }
                      }" width="120">快递单号</th>
			<th field="address" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.address;
                          }
                      }" width="150">地址</th>
			<th field="orderNumber" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.orderNumber;
                          }
                      }" width="150">订单编号</th>
			<th field="addressee" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.addressee;
                          }
                      }" width="100">收件人</th>
			<th field="phone" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.phone;
                          }
                      }" width="100">联系方式</th>
			<th field="shopNumber" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.shopNumber;
                          }
                      }" width="90">商家ID</th>
			<th field="courierCompany" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.courierCompany;
                          }
                      }" width="60">快递公司</th>
			<th field="goodsCost" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.goodsCost;
                          }
                      }" width="60">物品价值</th>
			<th field="goods" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.goods;
                          }
                      }" width="60">物品</th>
			<th field="numberType" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.numberType;
                          }
                      }" width="60">类型</th>
            <th field="oneCode" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.oneCode;
                          }
                      }" width="60">一段码</th>
            <th field="province" data-options="
				formatter:function(value,row,index){
                             if(row.sourceImport){
						return row.sourceImport.province;
                          }
                      }" width="60">省份</th>
		</tr>
	</thead>
</table>
		<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons" modal="true">
		<div class="ftitle">数据修改</div>
			<hr>
			<form id="fm" method="post" >
				<input type="hidden" name="_method" value="post"/>
				<input type="hidden" name="_header" value="${licence }"/>
				<input type="hidden" name="courierNumber"/>
				<div class="fitem">
					<label>异常原因:</label>
					<input name="abnormalCause" required="true">
				</div>
				<div class="fitem">
					<label>省份:</label>
					<input name="province" required="true">
				</div>
				<div class="fitem">
					<label>地址:</label>
					<input name="address" required="true">
				</div>
				<div class="fitem">
					<label>配送状态:</label>
					<select name="deliveryState">
						<option value="配送成功">配送成功</option>
		    			<option value="配送失败">配送失败</option>
		    			<option value="配送异常">配送异常</option>
		    			<option value="配送中">配送中</option>
		    			<option value="退回件">退回件</option>
					</select>
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
					<label>费用:</label>
					<input name="fee"  required="true">
				</div>
				<div class="fitem">
					<label>订单编号:</label>
					<input name="orderNumber" required="true">
			</form>
		</div>
		
		<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:50%;height:60%;padding:10px 20px"
		closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceImport.jsp" cache="true" resizable="true">
</div>
		
</body>
</html>