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
<title>哲盟返回第三方数据</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
var url;
function updateObj(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","修改");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${user.licence }");
		url="<%=path%>/api/timeLimit/"+row.orderNumber;
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
function excel_export(){
	$("#search").form("submit",{
		url:"<%=path%>/api/sourceTp/exportExcel",
		method:"get",
		onSubmit: function(){   
	        // do some check   
	        // return false to prevent submit;   
	    },   
	    success:function(data){   
			if(data!=null){
		    	var d = eval('('+data+')');
		    	window.location.href=d.data;
			}
	    } 
	});
}
</script>
<table id="dg" class="easyui-datagrid" border="true" title="快件信息>哲盟返回第三方数据"
		url="<%=path %>/api/sourceTp"
		method="get" toolbar="#toolbar"
		loadMsg="数据加载中请稍后……"
		striped="true" pagination="true"
		rownumbers="true" fitColumns="false" 
		singleSelect="true" fit="true"
		pageSize="25" pageList="[25,40,50,100]">
	<thead>
		<tr>
			<th field="createDate" width="100" sortable="true">创建日期</th>
			<th field="largeArea" width="80" sortable="true">所属大区</th>
			<th field="sliceArea" width="80" sortable="true">所属区部</th>
			<th field="fenbu" width="80" sortable="true">所属分部</th>
			<th field="fbdArea" width="100" sortable="true">所属分拨点</th>
			<th field="ctmBarCode" width="80" sortable="true">客户条码</th>
			<th field="ctmName" width="60" sortable="true">客户名称</th>
			<th field="courierNumber" width="150" sortable="true">快递单号</th>
			<th field="sendTime" width="100" sortable="true">发货日期</th>
			<th field="isTimeOut" width="80" sortable="true">是否超时</th>
			<th field="abnormalCause" width="100" sortable="true">异常原因</th>
			<th field="province" width="100" sortable="true">省份</th>
			<th field="address" width="200" sortable="true">地址</th>
			<th field="deliveryState" width="100" sortable="true">配送状态</th>
			<th field="signatory" width="80" sortable="true">签收人</th>
			<th field="signTime" width="200" sortable="true">签收时间</th>
            <th field="signPort" width="150" sortable="true">签收站点</th>
			<th field="addressee" width="80" sortable="true">收件人</th>
			<th field="orderNumber" width="100" sortable="true">订单编号</th>
			<th field="shopNumber" width="150" sortable="true">客户店铺</th>
			<th field="phone" width="100" sortable="true">联系方式</th>
			<th field="weight" width="80" sortable="true">重量</th>
			<th field="courierCompany" width="80" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(value='11'){
							return '韵达实物';
                      }else if(value='22'){
                      		return '韵达刷单';
                      }else if(value='33'){
                      		return '圆通';
                      }else if(value='44'){
                      		return '顺丰';
                      }else if(value='55'){
                      		return 'EMS';
                      }else if(value='66'){
                      		return '邮政小包';
                      }
               }">快递公司</th>
			<th field="goods" width="100" sortable="true">物品</th>
			<th field="goodsCost" width="80" sortable="true">物品价值</th>
			<th field="fee" width="80" sortable="true">费用</th>
			<th field="returnDate" width="100" sortable="true" data-options="
				formatter:function(value,row,index){
                      if(row.returnDate){
							return getDateByMs(new Date(row.returnDate),'/');
                      }
               }">返回日期</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<div class="btn-separator-none">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#fileImport').dialog('open')">导入数据</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="">编辑数据</a>
	</div>
	<div class="btn-separator">
		<a class="easyui-linkbutton" iconCls="icon-help" plain="true" onclick="$('#dlg_help').dialog('open')">帮助</a>
	</div>
	<br class="clear"/>
	<hr class="hr-geay">
	<form id="search">
		<div class="searchBar-input">
    		<div>
	    		发货日期开始：<input name="date1" id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')}' ,dateFmt:'yyyy/MM/dd'})" />
    		</div>
    		<div>
    			发货日期结束：<input name="date2" id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}' ,dateFmt:'yyyy/MM/dd'})"/>
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		配送状态：
	    		<select name ="str2" style="width: 170px;">
	    			<option value="">--请选择配送状态--</option>
	    			<option value="11">韵达实物</option>
	    			<option value="22">韵达刷单</option>
	    			<option value="33">圆通</option>
	    			<option value="44">顺丰</option>
	    			<option value="55">EMS</option>
	    			<option value="66">邮政小包</option>
	    		</select>
    		</div>
    		<div>
    			快递单号：<input name ="str3" />
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		客户条码：<input name ="str4" />
    		</div>
    		<div>
    			订单编号：<input name ="str5" />
    		</div>
   		</div>
   		<div class="searchBar-input">
    		<div>
	    		客户店铺：<input name ="str6" />
    		</div>
   		</div>
   	</form>
   	<div class="clear"></div>
   	<hr class="hr-geay">
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="search_toolbar()">查询</a>
	<a class="easyui-linkbutton" iconCls="icon-search" disabled="true">统计</a>
	<a class="easyui-linkbutton" iconCls="icon-search" onclick="excel_export()">导出</a>
	<div class="pull-away"></div>
</div>

<div id="dlg" class="easyui-dialog" style="width:600px;height:500px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons" modal="true">
	<div class="ftitle">时效控制信息</div>
	<hr>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence }"/>
		<input type="hidden" name="orderNumber"/>
		<div class="fitem">
			<label>始发中转站:</label>
			<input name="beginProvince" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>到达省份:</label>
			<input name="endProvince" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>小时:</label>
			<input name="hourCost" class="easyui-validatebox" required="true">
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
			<a href="<%=path%>/file/哲盟返回第三方数据模板.xls" style="display:block;float:right;width:80px;height:25px;border:1px solid gray;text-align:center;line-height:25px;">下载</a>
		</div></br></br></br>
		<form id="fmfile"  enctype="multipart/form-data" method="post">
			<input type="file" name="file"/>
			<input type="button" value="提交" onclick="upload()" style="width:80px;height:25px;float:right;"/>
		</form>
</div>
<div id="dlg_help" title="帮助" class="easyui-dialog" iconCls="icon-help" style="width:1000px;height:600px;padding:10px 20px"
		closed="true" modal="true">
	<iframe src="<%=path%>/jsp/help/sourceZm.jsp" frameborder="0" height="100%" width="100%">
	</iframe>
</div>
</body>
</html>