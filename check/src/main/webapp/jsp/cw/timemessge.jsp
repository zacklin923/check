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
<title>省份码</title>

</head>
<body>

<jsp:include page="/jsp/part/common.jsp"/>
<jsp:include page="/jsp/part/cw_common.jsp"/>

<style>
    .layout-title{
        position: absolute;
        top:10px;
        left: 30px;
        font-size: 14px;
    }

    .layout-help {
        top: 10px;
        right: 30px;
    }

    .self_form {
        padding-left: 15px;
    }

    button {
        border-radius: 3px;
        background-color: #05A4E3;
        color: white;
        border: 1px solid #05A4E3;
        text-align: center;
    }

    .self_datatime {
        position: relative;
        width: 100%;
    }

    .datatime {
        width: 100%;
        position: absolute;
        top: -1px;
        left: 59px;
    }

    #menulist > a:nth-child(1):hover{
        background-color: lightgray;
    }
    #menulist > a:nth-child(2):hover{
        background-color: lightgray;
    }
    #menulist > a:nth-child(3):hover{
        background-color: lightgray;
    }
    #menulist > a:nth-child(4):hover{
        background-color: lightgray;
    }
    #menulist > a:nth-child(5):hover{
        background-color: lightgray;
    }
    #menulist > a:nth-child(6):hover{
        background-color: lightgray;
    }


    #menulist > a>.iterm1{
        background: url("images/sprice.png") no-repeat center;
        background-position: 1px 1px;
        text-indent: -10px;
    }


    #menulist > a>.iterm2{
        background: url("images/sprice.png") no-repeat left;
        background-position: -96px 1px;
        text-indent: -10px;
    }

    #menulist > a>.iterm3{
        background: url("images/sprice.png") no-repeat left;
        background-position: 1px -96px;
        text-indent: -10px;
    }

    #menulist > a>.iterm4{
        background: url("images/sprice.png") no-repeat left;
        background-position: 1px -127px;
        text-indent: -10px;
    }

    #menulist > a>.iterm5{
        background: url("images/sprice.png") no-repeat left;
        background-position: -288px -63px;
        text-indent: -10px;
    }

    #menulist > a>.iterm6{
        background: url("images/sprice.png") no-repeat left;
        background-position: -256px -63px;
        text-indent: -10px;
    }




    input {
        margin: 3px 10px;
        border-radius: 5px;
        border: 1px solid gray;
        padding-left: 5px;
        border: 1px solid #95B8E7;
        height: 23px;
        width: 180px;
        border: 1px solid #ccc;
        box-shadow: 1px 1px 2px #E6E6E6 inset;
    }


</style>

<div class="layout-wrapper">
    <!--顶部通栏开始-->
    <div class="layout-header" style="position: relative">
        <div class="layout-title">
            <h3><a href="index.html">深圳韵达有限公司</a></h3>
        </div>
        <div class="self_title">
            <a href="">时效控制信息</a>
        </div>
    </div>
    <!--顶部通栏结束-->

    <div id="main" style="height: 781px; overflow: hidden;">

    <!--工具栏开始-->
        <div id="menulist">
            <a href="#"><span class="iterm1"></span>导入数据 </a><a href="#"><span class="iterm2"></span>编辑模板</a><a href="#"><span class="iterm3"></span>编辑数据</a><a href="#"><span class="iterm4"></span>保存</a><a href="#"><span class="iterm5"></span>查询</a><a href="#"><span class="iterm6"></span>统计</a>
        </div>
   <!-- 工具结束 -->


    <!--显示隐藏栏开始-->

        <div class="self-tool-btn">
            <span id="self-btn" class="easyui-linkbutton" data-options="iconCls:'icon-next'"></span>
        </div>
        <script>
            $(function () {
                var index = 0;
                $("#self-btn").on("click", function () {
                    index++;
                    if (index % 2 !== 0) {
                        $("#self_hidden").css({
                            "display": "none"
                        });
                        $(this).css({
                            "transform": "rotate(90deg)"
                        })
                    } else if (index % 2 === 0) {
                        $("#self_hidden").css({
                            "display": "block"
                        });
                        $(this).css({
                            "transform": "rotate(-90deg)"
                        })
                    }
                    console.log(index);
                })
            })
        </script>
     <!--显示隐藏栏结束-->


        <div id="oFilter" class="filter-panel">
            <form action="">
    <!--提交表单栏开始-->
                    <div id="mm">
                        <div data-options="name:'all',iconCls:'icon-ok'"></div>
                        <div data-options="name:'sports'"></div>
                  </div>

                <div id="self_hidden">
                    <div style="margin:5px 0;"></div>
                    &nbsp;&nbsp;
                     <label for="" style="font-size: 12px;">到达省份</label>
                    <input id="searchbox" style="width:180px;height: 26px">&nbsp;&nbsp;<br/>

                    <label for="" style="= font-size: 12px">始发中转站</label>
                    <input style="width:180px;margin-top:10px;height: 26px">&nbsp;&nbsp;
                </div>
            </form>

        </div>

        <!--提交表单栏结束-->
        <!-- 表格部分 -->
        <div id="numberTable" style="width:100%;overflow:scroll;padding-bottom: 15px">
            <table id="dg" class="easyui-datagrid" data-options="scrollbarSize:0" style="width:110%;overflow: scroll">
                <thead>
                <tr>
                    <th data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></th>
                    <th data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></th>
                    <th data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</th>
                    <th data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</th>
                    <th data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</th>
                    <th data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</th>
                    <th data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</th>
                    <th data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</th>
                    <th data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</th>
                    <th data-options="field:'status4',align:'center',resizable:false" width="10%">地址</th>
                    <th data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</th>
                    <th data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</th>
                    <th data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</th>
                    <th data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</th>
                    <th data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</th>
                    <th data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</th>
                    <th data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</th>
                    <th data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</th>
                    <th data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</th>
                    <th data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</th>
                </tr>
                </thead>

            </table>

        </div>
        <!-- 表格部分 -->
        <div  id="pp" class="easyui-panel" style="width: 100%">
            <div class="easyui-pagination" data-options="total:114"></div>
        </div>
        <script>
            $('#pp').pagination({
                displayMsg:"显示1到100,共100记录",
                beforePageText:"第",
                afterPageText:"共一页"

            });
        </script>

    </div>

</body>
</html>