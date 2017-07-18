<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>深圳韵达有限公司</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/look.css">
    <link rel="stylesheet" href="css/commen.css"/>
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="lib/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="lib/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="lib/demo/demo.css">
    <script type="text/javascript" src="lib/jquery.min.js"></script>
    <script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/base.js"></script>
</head>
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


    #menulist > a>.iterm1 {
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
    /*table>thead {*/
        /*border: 1px solid #DFDFDF;*/
    /*}*/
    #numberTable>table>thead th{
        border-bottom: 1px solid #DFDFDF;
        border-right: 1px solid #DFDFDF;
        color: #6B6B6B;
        font-weight:600;}
    .datagrid-header td{
        color: black;
        font-weight: 900;
        font-size: 14px;
    }

</style>

<body>
<div class="layout-wrapper">
    <!--顶部通栏开始-->
    <div class="layout-header" style="position: relative">
        <div class="layout-title">
            <h3><a href="index.html">深圳韵达有限公司</a></h3>
        </div>
        <div class="self_title">
            <a href="">错误数据</a>
        </div>

        <div class="layout-help" style="position: absolute">
            <a href="#" target="_blank">帮助</a>

        </div>
    </div>
    <!--顶部通栏结束-->

    <div id="main" style="height: 781px; overflow: hidden;">

    <!--工具栏开始-->
        <div id="menulist">
            <a href="#"> <span class="iterm1"></span>批量删除 </a><a href="#"><span class="iterm2"></span>删除所有</a><a href="#"><span class="iterm3"></span>查询</a><a href="#"><span class="iterm4"></span>导出</a>
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

                        <span style="font-weight:300;font-size:12px;color: #6B6B6B">导入时间</span>
                        <ul class="datatime">
                            <li style="cursor: pointer;">今天</li>
                            <li style="cursor: pointer;">昨天</li>
                            <li style="cursor: pointer;">本周</li>
                            <li class="self_show" style="cursor: pointer">指定时间</li>
                            <li class="datatime_iterm" style="display: none"><input class="easyui-datebox" style="width:100px"></input></li>
                            <li class="datatime_iterm" style="display: none"><input class="easyui-datebox" style="width:100px"></input></li>
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
                <div id="self_hidden">
                    <div style="margin:5px 0;"></div>

                    &nbsp;&nbsp;&nbsp;<label for="">导入人</label>
                    <input type="text">
                    <br>
                    <label for="">失败类型</label>
                    <select  style="margin:8px 10px;border-radius: 5px; border: 1px solid gray;  padding-left: 5px;border: 1px solid #95B8E7;height: 23px;width: 190px;text-indent: 25px">
                        <option value="">--请选择--</option>
                        <option value="">--重复快递单号--</option>
                        <option value="">--数据必填项为空--</option>
                        <option value="">--数据类型转换错误--</option>
                        <option value="">--客户条码不存在--</option>
                    </select>



                </div>
            </form>

        </div>

        <!--提交表单栏结束-->
        <!-- 表格部分 -->
        <div id="numberTable" style="width:100%;overflow:scroll;padding-bottom: 15px">
            <table id="dg" class="easyui-datagrid" data-options="scrollbarSize:0,
            " style="width:110%;overflow: scroll">
                <thead >
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
                <tbody>
                <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr> <tr>
                    <td data-options="field:'itemid7',align:'lelf',resizable:false" width="2%"></td>
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
                    <td data-options="field:'status15',align:'lelf',resizable:false" width="5%">省份</td>
                </tr>
                </tbody>

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