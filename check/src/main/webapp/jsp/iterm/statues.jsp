<%@page import="com.zs.tools.DateTimeHelper"%>
<%@page import="java.net.URLEncoder" %>
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
<title>运单状态查询</title>

</head>
<body class="easyui-layout">

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>

<script type="text/javascript">
$(function(){
	var sst=stylesheet();
	if(sst){
		setColumns(sst);
	}
});
function stylesheet(){
	var a;
	pullRequestCommon({
		urlc:"/check/api/customer/style",
		type:"GET",
		async:false,
		jobj:{id:3},
		success:function(data){
			var str = data;
			s="[["+str+"]]";
			a=eval(s);
		}
	});
	return a;
}
var url;
var type;
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		type="PUT";
		url="/check/api/zmReturnData";
	}
}
function save(){
	$('#dg').datagrid('loading');
	var obj=formToJson($("#fm"));
	if($("#fm").form('validate')){
		pullRequestCommon({
			urlc:url,
			type:type,
			jobj:obj,
			success:function(data){
				$('#dg').datagrid('reload');
				$("#dlg").dialog("close");
			}
		});
	}
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
	$("#exportdiv").dialog("close");
	show_hint([]);
	var r=document.getElementsByName("exportline")
	var str = "";
	for(var i=0;i<r.length;i++){
        if(r[i].checked){
        	str = str + r[i].nextSibling.nodeValue+",";
      }
    };
	$("#exportvalue").val(str);
	var r2=document.getElementsByName("strn2");
	var sr2 ="";
	for(var i = 0 ; i<r2.length;i++){
		if(r2[i].checked){
			sr2=sr2+r2[i].value+",";
		}
	}
	$("#statevalue").val(sr2);
	pullRequestCommon({
		urlc:"/check/api/zmReturnData/tp/exportExceltest",
		type:"GET",
		jobj:formToJsontest($("#search")),
		success:function(data){
			console.log(data);
			hiden_hint();
    		window.location.href=URL_PATH+"/check/"+data;
		}
	});
}
function upload(){
	$("#fileImport").dialog("close");
	show_hint([]);
	pullRequestFile({
		urlf:"/check/api/zmReturnData/tp/import",
		type:"GET",
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
				$('#dg').datagrid('reload');
			}else{
				$.messager.alert('导入结果通知', '未知错误', 'error');
				$('#dg').datagrid('reload');
			}
		}		
	});
}
function search_toolbar1(){
	var r2=document.getElementsByName("strn2");
	var sr2 ="";
	for(var i = 0 ; i<r2.length;i++){
		if(r2[i].checked){
			sr2=sr2+r2[i].value+",";
		}
	}
	$("#statevalue").val(sr2);
	var daf = formToJsontest($("#search"));
	pullRequestCommonDg({
		dgid:"dg",
		urlc:"/check/api/zmReturnData/tp",
		dataf:daf,
		success:function(data){
			
		}
	});
}
function formToJsontest(formObj){
   var o={};
   var a=formObj.serializeArray();
   $.each(a, function() {
	   if(this.name=='strn2'){
		   console.log(this.name);
		   this.value=null;
	   }
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

function moduleEdit(){
	var r=document.getElementsByName("orderline")
	var sstr = "";
	var str1="";
	for(var i=0;i<r.length;i++){
		if(r[i].value){
			sstr = sstr + r[i].value+",";
			str1=str1+i+"a";
        }
    };
    sstr=sstr+str1+"_运单状态查询";
	$("#mbedit").dialog("close");	
    $('#dg').datagrid('loading');
    pullRequestCommon({
    	urlc:"/check/api/module",
    	type:"PUT",
    	jobj:{str:sstr},
		success:function(data){
			$('#dg').datagrid('loaded');
			$('#mbedit').dialog('close');
			setColumns(stylesheet());
		}
	});
}
function accept(){
	if (endEditing()){
		var rows=$('#dg').datagrid('getChanges');
		var alretstr ="";
		var cout = 0;
		$('#dg').datagrid('loading');
		for (var i = 0; i < rows.length; i++) {
			var row=rows[i];
			rowisNullClear(row);
			console.log(row);
			pullRequestCommon({
				urlc:"/check/api/zmReturnData",
				type:"PUT",
				jobj:row,
				async:false,
				success:function(data){
					cout = eval(cout+1);
				},
				error:function(data){
					alretstr = alretstr + data;
				}
			});
			
		}
		$('#dg').datagrid('loaded');
		alert("共保存了"+cout+"条     "+alretstr);
	}
}
function IESerch(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		window.open("http://n2cx.yundasys.com:18090/wsd/kjcx/cxend.jsp?wen="+row.courierNumber);
	}else{
		alert("请选择数据");
	}
}

</script>
	<style>
.panel-body {border-color: #E6E6E6; border:none;}
  .datagrid-cell, .datagrid-cell-group, .datagrid-header-rownumber, .datagrid-cell-rownumber {

        padding: 4px;

    }


#mypanel{
border:1px solid lightgray;}
</style>
	<div data-options="region:'north',split:false" style="overflow: hidden">
    <div class="layout-header" style="position: relative">
       
        <div class="logo"></div>
       
        <div class="self_title">
            <a href="">运单状态查询</a>
        </div>
          <div class="my_help"> 
            <a href="../../../view/index.html">关闭|
            </a><a onclick="$('#dlg_help').dialog('open')">帮助</a></div>
    </div>

</div>


	<div data-options="region:'center',split:false" style="padding-left:20px;padding-right:30px;padding-top:1px;padding-bottom:10px">

		<div id="toolsbars">
		 
			<div id="menulist" style="padding-top: 10px;position:raletiver">
			
                <a onclick="$('#fileImport').dialog('open')"><span class="iterm1"></span>导入数据 </a>
                <a onclick="updateObj()"><span class="iterm2"></span>编辑数据</a>
                <a onclick="$('#mbedit').dialog('open')"><span class="iterm3"></span>编辑模板</a>
                <a onclick="accept()"><span class="iterm6"></span>保存数据</a>
<!--                 <a ><span class="iterm6"></span>统计</a> -->
                <a onclick="search_toolbar1()"><span class="iterm5"></span>查询数据</a>
                <a onclick="$('#exportdiv').dialog('open');"><span class="iterm7"></span>导出数据</a>
                <a onclick="IESerch()"><span class="iterm8"></span>&nbsp;快件查询</a>
                <a onclick="$('#fileImport1').dialog('open')" style="display:none;"><span class="iterm1"></span>插发货时间数据 </a>
                  <span class="myself_btn">收缩</span>	
			
			</div>

			<div id="mypanel" class="easyui-panel" style="padding-top:10px;padding-bottom:2px;box-sizing: border-box;margin-top: 5px;width: 100%;margin: 0 auto;margin-top: 5px;" >

                <div class="my_from">
                <form id="search">
                        <!--提交表单栏开始-->
                        <div class="left">
                            <ul>
                                <li> <label>订单编号</label>
                                    <input name ="str5" >
                                </li>
                                <li>  <label>所属大区</label>
                                    <input name ="str8">
                                </li>
                                <li> <label>客户店铺</label>
                                    <input  name ="str6" >
                                </li>
                                <li> <label>签收站点</label>
                                    <input name ="str14">
                                </li>
                                <li> <label>所属分部</label>
                                    <input name ="str10">
                                </li>
                            </ul>
                        </div>
                        <div class="center">
                            <ul>
                                <li>  <label>省份</label>
                                    &nbsp;<input  style="margin-left: 33px"  name ="str13" >
                                </li>

                                <li> <label>地址</label>
                                    &nbsp;<input  style="margin-left: 33px" name ="str15"   ></li>

                                <li><label >客户名称</label>
                                    &nbsp;<input  name ="str12">
                                </li>
                                <li> <label >所属区部</label>
                                    &nbsp;<input  name ="str9" >
                                </li>
                                <li><label >所属分拨点</label>
                                    &nbsp;<input   style="margin-left: -3px" name ="str11">
                                </li>
                              
                            </ul>
                        </div>
                        <div class="right">
                            <ul>
                               <li><label for="">发货日期开始</label>
                                    <input style="height:27px; width:100px;" name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy-MM-dd'})"value="<%=DateTimeHelper.getBeginOfOld().toString3()%>"/> 8:00:00
                                </li>
                                <li><label for="">发货日期结束</label>
                                    <input style="height:27px; width:100px;" name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy-MM-dd'})"value="<%=DateTimeHelper.getEndOfOld().toString3()%>"/> 7:59:59
                                </li>
                                <li> <label >是否超时</label>
                                    &nbsp;<select class="my_select"  name ="int1"  id=""  style="color: #6B6B6B;font-weight: 300;margin-left:29px">
                                    <option value="" style="color: #6B6B6B;font-weight: 300;">--请选择是否超时--</option>
                                    <option value="1" style="color: #6B6B6B;font-weight: 300;">--是--</option>
                                    <option value="0" style="color: #6B6B6B;font-weight: 300;">--否--</option>
                                    </select>
                                </li>
                                  <li> <label >目的地为空</label>
                                    &nbsp;&nbsp;&nbsp;&nbsp;<select class="my_select"  name ="str16"  id=""  style="color: #6B6B6B;font-weight: 300;margin-left:5px">
                                     <option value="0" style="color: #6B6B6B;font-weight: 300;">--否--</option>
                                    <option value="1" style="color: #6B6B6B;font-weight: 300;">--是--</option>
                                    </select>
                                </li>
                                <li><label>修改人</label>
                                    <input  style="margin-left: 43px;width:178px;" name ="str17">
                                </li>
                            </ul>
                        </div>
                        <div class="textarea" >
                            <div><p >客户条码</p>
                                <textarea name ="str4" cols="200" rows="20"></textarea>
                            </div>
                            <div style="margin-left: 30px"><p>快递单号</p>
                                <textarea name="str3" cols="200" rows="20"></textarea>
                            </div>
                            <div class="radio">
                                <input type="checkbox" name ="strn2"  value="配送成功"/><span>配送成功</span>
                                <input type="checkbox" name ="strn2" value="配送失败"/><span>配送失败</span>
                                <input type="checkbox" name ="strn2" value="配送异常"/><span>配送异常</span><br>
                                <input type="checkbox" name ="strn2" value="配送中"/><span>配送中</span>
                                <input type="checkbox" name ="strn2" value="揽件"/><span>揽件</span>
                                <input type="checkbox" name ="strn2" value="退回件"/><span>退回件</span>
                            </div>
                            <input type="hidden" name ="str2" id = "statevalue"/>
							<input type="hidden" name ="str7" id = "exportvalue"/>
                        </div>
                        
                </form>
             </div>
               <!-- <a onclick="search_toolbar1()"  id="my_search" style="top:15px;margin-left:1185px;"><span class="fSearchIcon"></span>查询</a> -->
            
		</div>
		<div style="height: 10px;"></div>
        </div>
        <table id="dg" border="true"
			method="get" toolbar="#toolsbars"
			loadMsg="数据加载中请稍后……"
			striped="true" pagination="true"
			rownumbers="true" fitColumns="false" 
			singleSelect="true" fit="true"
			pageSize="100" pageList="[100,500,1000]"
			data-options="
					rowStyler:function(index,row){
						if (row.noUpdateDeliveryState){
							return 'background-color:#FFCACF;';
						}
					},
					onClickCell: onClickCell
				">
		</table>
		<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
			closed="true" buttons="#dlg-buttons" modal="true">
		<div class="ftitle">数据修改</div>
			<hr>
			<form id="fm" method="post" >
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
		<div id="dlg-buttons">
			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">提交</a>
			<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
		<div id="fileImport" class="easyui-dialog" style="width:350px;height:200px;padding:10px 20px"
				closed="true" modal="true" title="数据源导入">
				<div style="height:25px;line-height:25px;padding:5px 9px">数据导入模板
					<a href="<%=path%>/file/哲盟返回第三方数据模板.xlsx" style="display:block;color:black;font-weight:300px;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;">下载</a>
				</div></br></br></br>
				<form id="fmfile"  enctype="multipart/form-data" method="post">
					<input type="file" name="file"/>
					<input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;"/>
				</form>
		</div>
		<div id="fileImport1" class="easyui-dialog" style="width:350px;height:200px;padding:10px 20px"
				closed="true" modal="true" title="费用时间导入">
				<form id="fmfile1"  enctype="multipart/form-data" method="post">
					<input type="file" name="file"/>
					<input type="button" value="提交" onclick="upload1()" style="width:80px;height:25px;float:right;"/>
				</form>
		</div>
		
		<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:50%;height:100%;padding:10px 20px"
				closed="true" modal="false" collapsible="true" href="<%=path%>/jsp/help/sourceTp.jsp" cache="true" resizable="true">
		</div>
		<div id="exportdiv" class="easyui-dialog" style="width:500px;height:700px;padding:10px 20px"
				closed="true" buttons="#exportdiv-buttons" modal="true" title="导出选项>选择导出的选项">
				请选择你需要导出的列：
					<div><input type="checkbox" name="exportline" />所属大区</div>
					<div><input type="checkbox" name="exportline" />所属区部</div>
					<div><input type="checkbox" name="exportline" />所属分部</div>
					<div><input type="checkbox" name="exportline" />所属分拨点</div>
					<div><input type="checkbox" name="exportline" />客户条码</div>
					<div><input type="checkbox" name="exportline" />客户名称</div>
					<div><input type="checkbox" name="exportline" />快递单号</div>
					<div><input type="checkbox" name="exportline" />发货日期</div>
					<div><input type="checkbox" name="exportline" />是否超时</div>
					<div><input type="checkbox" name="exportline" />异常原因</div>
					<div><input type="checkbox" name="exportline" />省份</div>
					<div><input type="checkbox" name="exportline" />地址</div>
					<div><input type="checkbox" name="exportline" />配送状态</div>
					<div><input type="checkbox" name="exportline" />签收人</div>
					<div><input type="checkbox" name="exportline" />签收时间</div>
					<div><input type="checkbox" name="exportline" />签收站点</div>
					<div><input type="checkbox" name="exportline" />收件人</div>
					<div><input type="checkbox" name="exportline" />订单编号</div>
					<div><input type="checkbox" name="exportline" />客户店铺</div>
					<div><input type="checkbox" name="exportline" />联系方式</div>
					<div><input type="checkbox" name="exportline" />重量</div>
					<div><input type="checkbox" name="exportline" />快递公司</div>
					<div><input type="checkbox" name="exportline" />物品</div>
					<div><input type="checkbox" name="exportline" />物品价值</div>
					<div><input type="checkbox" name="exportline" />费用</div>
					<div><input type="checkbox" name="exportline" />修改人</div>
		</div>                                                      
		<div id="exportdiv-buttons">                                
			<a class="easyui-linkbutton"  onclick="selectAll()">全选/全不选</a>
			<a class="easyui-linkbutton"  onclick="negated()">反 选</a>
			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="excel_export()">导出</a>
			<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
		</div>
		<div id="mbedit"class="easyui-dialog" style="width:650px;height:700px;padding:10px 20px"
				closed="true" buttons="#mbedit-buttons" modal="true" title="模板编辑">
				<form id="moduleform" method="post">
					<h3 style="font-size:28px;color:red;margin-bottom:30px;text-align:center;">顺序从0开始，全不选代表为最原始的状态</h3>
					<table style="margin-left:35px">
						<tr>
							<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>发货日期</td>
							<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>客户条码</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>客户名称</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>快递单号</td>
						</tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>省份</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>地址</td>
						<tr>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>配送状态</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>是否超时</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>签收时间</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>签收站点</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>异常原因</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>订单编号</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>客户店铺</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>收件人</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>联系方式</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>重量</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>快递公司</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>物品</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>物品价值</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>费用</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>所属大区</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>所属区部</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>所属分部</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>所属分拨点</td>
						</tr>
						<tr>
						<td><input style="width:150px;" name ="orderline" type="number" min="1" max="25"/>系统接收时间</td>
						<td><input style="width:150px;margin-left:50px;" name ="orderline" type="number" min="1" max="25"/>修改人</td>
						</tr>
						<tr>
						</tr>
					</table>
				</form>
		</div>
		<div id="mbedit-buttons">
			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="moduleEdit()">提交</a>
			<a class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#mbedit').dialog('close')">取消</a>
		</div>
		
	</div>
</body>
</html>