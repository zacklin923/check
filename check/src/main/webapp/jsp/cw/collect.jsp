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
    #menulist > a>.iterm1{
        background: url("images/sprice.png") no-repeat left;
        background-position: -288px -63px;
        text-indent: -10px;
    }

    #menulist > a>.iterm2{
        background: url("images/sprice.png") no-repeat left;
        background-position: -256px -63px;
        text-indent: -10px;
    }
    }
    #menulist > a:nth-child(1):hover{
        background-color: lightgray;
    }
    #menulist > a:nth-child(2):hover{
        background-color: lightgray;
    }



    .layout-help>a:nth-child(1) {
        background: url("images/help.png") no-repeat left;
        padding-left: 20px;
    }
    #numberTable{
        overflow: scroll
    }

    </style>

<div class="layout-wrapper">
    <!--顶部通栏开始-->
    <div class="layout-header" style="position: relative">
        <div class="layout-title">
            <h3><a href="index.html">深圳韵达有限公司</a></h3>
        </div>
        <div class="self_title">
            <a href="">数据导入</a>
        </div>

        <div class="layout-help" style="position: absolute">
            <a href="#" target="_blank">帮助</a>

        </div>
    </div>
    <!--顶部通栏结束-->

    <div id="main">

    <!--工具栏开始-->
        <div id="menulist">
            <a href="#"><span class="iterm1"></span>查询</a><a href="#"><span class="iterm2"></span>统计</a>
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
                 <div class="self_datatime">

                        <span>导入时间</span>
                        <ul class="datatime">
                            <li style="cursor: pointer;">今天</li>
                            <li style="cursor: pointer;">昨天</li>
                            <li style="cursor: pointer;">本周</li>
                            <li class="self_show" style="cursor: pointer">指定时间</li>
                            <li class="datatime_iterm" style="display: none"><input class="easyui-datebox" style="width:100px"></li>
                            <li class="datatime_iterm" style="display: none"><input class="easyui-datebox" style="width:100px"></li>
                        </ul>
                        <script>
                            $(function () {
                                var index=0;
                                $(".self_show").click(function () {
                                    index++;
                                    if(index%2!==0){
                                        $(".datatime>li").css({
                                            "display": "block"
                                        })
                                    }else if(index%2===0){
                                        $(".datatime>.datatime_iterm").css({
                                            "display": "none"
                                        })
                                    }

                                });
                                $(".datatime>li").click(function () {
                                    $(this).css({
                                       "backgroundColor": "#05A4E3",
                                        "color":"white"
                                }).siblings().css({
                                        "backgroundColor": "white",
                                        "color":"#333"
                                })

                                })
                            })
                        </script>
                  </div>
            </form>

        </div>

        <!--提交表单栏结束-->
        <!-- 表格部分 -->
        <!--<div id="numberTable" style="width:100%;height:500px;padding-bottom:15px;">-->
        <div style="margin-top: 10px"></div>
            <table id="dg" class="easyui-datagrid"
                   method="get"
                   loadMsg="数据加载中请稍后……"
                   striped="true" pagination="true"
                   rownumbers="true" fitColumns="true"
                   singleSelect="true" fit="true"
                   pageSize="25" pageList="[25,40,50,100]"
                   selectOnCheck="true"
                   striped="true"
                   checkOnSelect="true">
                <thead>
                <tr>
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
                <tbody>
                    <tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr>
                    <tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">导入人</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">创建日期</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">客户名</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">客户条码</td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">快递单号</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">一段码</td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">是否已上传</td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">地址</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">订单编号</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">收件人</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">联系方式</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">商家ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">快递公司</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">物品价值</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">物品</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">类型</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">导入时间</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">省份</td>
                    </tr>
                </tbody>


            </table>



            <script type="text/javascript">
                $(function(){
                    var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
                    pager.pagination({
                        displayMsg:"显示1到100,共100记录",
                        beforePageText:"第",
                        afterPageText:"共一页"

                    });
                })
            </script>
        <!--</div>-->
        <!-- 表格部分 -->
    </div>

</body>
</html>