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

    #numberTable{
        overflow: scroll
    }

    </style>

<div class="layout-wrapper">
    <!--é¡¶é¨éæ å¼å§-->
    <div class="layout-header" style="position: relative">
        <div class="layout-title">
            <h3><a href="index.html">æ·±å³éµè¾¾æéå¬å¸</a></h3>
        </div>
        <div class="self_title">
            <a href="">ææ¬å¯¼å¥æ¶é</a>
        </div>

        <div class="layout-help" style="position: absolute">
            <a href="#" target="_blank">å¸®å©</a>

        </div>
    </div>
    <!--é¡¶é¨éæ ç»æ-->

    <div id="main">

    <!--å·¥å·æ å¼å§-->
        <div id="menulist">
            <a href="#"><span class="iterm1"></span>å¯¼å¥æ°æ® </a><a href="#"><span class="iterm2"></span>ç¼è¾æ¨¡æ¿</a><a href="#"><span class="iterm3"></span>ç¼è¾æ°æ®</a><a href="#"><span class="iterm4"></span>ä¿å­</a><a href="#"><span class="iterm5"></span>æ¥è¯¢</a><a href="#"><span class="iterm6"></span>ç»è®¡</a>
        </div>
   <!-- å·¥å·ç»æ -->


    <!--æ¾ç¤ºéèæ å¼å§-->

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
     <!--æ¾ç¤ºéèæ ç»æ-->


        <div id="oFilter" class="filter-panel">
            <form action="">
    <!--æäº¤è¡¨åæ å¼å§-->
                    <div id="mm">
                        <div data-options="name:'all',iconCls:'icon-ok'"></div>
                        <div data-options="name:'sports'"></div>
                  </div>
                 <div class="self_datatime">

                        <span>å¯¼å¥æ¶é´</span>
                        <ul class="datatime">
                            <li style="cursor: pointer;">ä»å¤©</li>
                            <li style="cursor: pointer;">æ¨å¤©</li>
                            <li style="cursor: pointer;">æ¬å¨</li>
                            <li class="self_show" style="cursor: pointer">æå®æ¶é´</li>
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
                <div id="self_hidden">
                    <div style="margin:5px 0;"></div>

                    <label>è®¢åç¼å·</label>
                    <input type="text">
                    <br>
                    &nbsp;&nbsp;&nbsp;<label>å¯¼å¥äºº</label>
                    <input type="text">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>åå®¶ID</label>
                    <input type="text"><br/>
                    <label style="font-size: 12px">å¿«éåå·</label>
                    <input id="searchbox" style="width:50%;height: 26px">&nbsp;&nbsp;<br/>
                    <label style="= font-size: 12px">å®¢æ·æ¡ç </label>
                    <input style="width:50%;margin-top:10px;height: 26px">&nbsp;&nbsp;
                </div>
            </form>

        </div>

        <!--æäº¤è¡¨åæ ç»æ-->
        <!-- è¡¨æ ¼é¨å -->
        <!--<div id="numberTable" style="width:100%;height:500px;padding-bottom:15px;">-->
        <div style="margin-top: 10px"></div>
            <table id="dg" class="easyui-datagrid"
                   method="get"
                   loadMsg="æ°æ®å è½½ä¸­è¯·ç¨åâ¦â¦"
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
                    <th data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</th>
                    <th data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</th>
                    <th data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</th>
                    <th data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </th>
                    <th data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</th>
                    <th data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </th>
                    <th data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </th>
                    <th data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</th>
                    <th data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</th>
                    <th data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</th>
                    <th data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</th>
                    <th data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</th>
                    <th data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</th>
                    <th data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</th>
                    <th data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</th>
                    <th data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</th>
                    <th data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</th>
                    <th data-options="field:'status15',align:'lelf',resizable:false" width="5%">çä»½</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr>
                    <tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr><tr>
                        <td data-options="field:'itemid8',align:'lelf',resizable:false,checkbox:true" width="5%"></td>
                        <td data-options="field:'itemid',align:'lelf',resizable:false" width="5%">å¯¼å¥äºº</td>
                        <td data-options="field:'productid', align:'lelf',resizable:false" width="5%">åå»ºæ¥æ</td>
                        <td data-options="field:'unitcost',align:'lelf',resizable:false" width="5%">å®¢æ·å</td>
                        <td data-options="field:'attr1', align:'lelf',resizable:false" width="5%">å®¢æ·æ¡ç </td>
                        <td data-options="field:'status1',align:'lelf',resizable:false" width="5%">å¿«éåå·</td>
                        <td data-options="field:'status2',align:'lelf',resizable:false" width="5%">ä¸æ®µç </td>
                        <td data-options="field:'status3',align:'lelf',resizable:false" width="5%">æ¯å¦å·²ä¸ä¼ </td>
                        <td data-options="field:'status4',align:'center',resizable:false" width="10%">å°å</td>
                        <td data-options="field:'status5',align:'lelf',resizable:false" width="5%">è®¢åç¼å·</td>
                        <td data-options="field:'status6',align:'lelf',resizable:false" width="5%">æ¶ä»¶äºº</td>
                        <td data-options="field:'status7',align:'lelf',resizable:false" width="5%">èç³»æ¹å¼</td>
                        <td data-options="field:'status8',align:'lelf',resizable:false" width="5%">åå®¶ID</td>
                        <td data-options="field:'status9',align:'lelf',resizable:false" width="5%">å¿«éå¬å¸</td>
                        <td data-options="field:'status10',align:'lelf',resizable:false" width="5%">ç©åä»·å¼</td>
                        <td data-options="field:'status11',align:'lelf',resizable:false" width="5%">ç©å</td>
                        <td data-options="field:'status12',align:'lelf',resizable:false" width="5%">ç±»å</td>
                        <td data-options="field:'status13',align:'lelf',resizable:false" width="5%">å¯¼å¥æ¶é´</td>
                        <td data-options="field:'status15',align:'lelf',resizable:false" width="50%">çä»½</td>
                    </tr>
                </tbody>


            </table>



            <script type="text/javascript">
                $(function(){
                    var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
                    pager.pagination({
                        displayMsg:"æ¾ç¤º1å°100,å±100è®°å½",
                        beforePageText:"ç¬¬",
                        afterPageText:"å±ä¸é¡µ"

                    });
                })
            </script>
        <!--</div>-->
        <!-- è¡¨æ ¼é¨å -->
    </div>

</body>
</html>