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
        #menupanel{
            border-bottom:1px solid #228BD4;}
        #menulist>ul>li{
            border-bottom: none;
        }

    </style>


<div class="loading-mask" style="top: 360.4px; display: none;">loading...</div>
<div>
    <span id="self-btn" class="easyui-linkbutton" data-options="iconCls:'icon-next'"></span>
</div>
<div class="layout-wrapper" style="position: relative">
    <div class="layout-header">
        <div class="layout-logo" style="border-right: 1px solid #6CBBF0;width: 200px;height: 60px;">
            <a href="#" id="systerm">大客户查件系统</a>
        </div>
        <div class="layout-title"style="position: absolute;top: 30px;left: 220px">

            <p style="font-size: 18px;padding-left: 0px" href="/Account" title="查看账号信息" target="_blank">深圳韵达有限公司欢迎你!</a></p>
        </div>
        <div class="layout-help" style="position: absolute;top: 30px ;right:30px">
            <a href="Login.html">退出登录</a>
        </div>
    </div>

    <div id="wrapper">
        <div id="sidebar" style="height: 841px;">
            <h3>
                我的标签
            <span id="ctl_38576754" class="dropdownlink" style="float:right;">

			</span>
            </h3>
            <ul id="tag" data-listidx="0">
                <li href="#desktop" ref="200000021782" class="active"><span>主页</span>
                <img src="images/transform_move.png" class="move"></li>
            </ul>
            <h3 id="mymuen">我的菜单</h3>
            <ul id="group_list" class="myself-menu">

                <li href="#ndex.html"><span>
		       		 <img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px" src="images/brick.png">  快件信息</span>
                </li>
                <li href="#menu|id=7"><span>
		       	 	 <img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px" src="images/credit.png"> 报表</span>
                </li>
                <li href="#menu|id=9"><span>
		       			<img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px" src="images/soil_layers.png"> 系统管理</span>
                </li>
                <li href="#menu|id=10"><span>
		       		<img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px" src="images/world.png"> 基础信息维护</span>
                </li>
                <li href="#menu|id=11"><span>
		       		<img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px" src="images/phone_Android.png"> 帮助</span>
                </li>
            </ul>


            <h3>扩展系统</h3>
            <ul>
                <li id="li_sysapp" style="cursor:pointer">
                <span>
                    <img style="width: 16px; height: 16px;" src="images/gear_in.png">
                    集成系统
                </span>
                </li>
            </ul>

        </div>



        <!-- 左侧工具栏结束 -->

        <!-- 右侧详情栏开始 -->
        <div id="main" style="height: 781px; overflow: auto;">

            <div id="menulist" style="display: block;">
                <!-- tab栏切换开始 -->

                <ul class="menutab" id="menugroup">
                    <li href="#menugroup|name=ALL&amp;text=A0048" ref="name=ALL&amp;text=A0048&amp;id=3" class="menutabactive">
                        <span>全部</span>
                    </li>
                    <li href="#menugroup|name=Report&amp;text=A05CF" ref="name=Report&amp;text=A05CF&amp;id=3">
                        <span>决策分析</span>
                    </li>
                    <li href="#menugroup|name=Business&amp;text=A05CO" ref="name=Business&amp;text=A05CO&amp;id=3">
                        <span>主营业务</span></li>
                    <li href="#menugroup|name=AnalysisManagement&amp;text=A0BP1" ref="name=AnalysisManagement&amp;text=A0BP1&amp;id=3">
                        <span>分析管理</span>
                    </li>
                    <li href="#menugroup|name=Archive&amp;text=A05CP" ref="name=Archive&amp;text=A05CP&amp;id=3">
                        <span>基础资料</span>
                    </li>
                    <li href="#menugroup|name=TerminalManagement&amp;text=A0BOZ" ref="name=TerminalManagement&amp;text=A0BOZ&amp;id=3">
                        <span>终端管理</span>
                    </li>
                    <li href="#menugroup|name=PolicyManagement&amp;text=A0BOY" ref="name=PolicyManagement&amp;text=A0BOY&amp;id=3">
                        <span>政策管理</span>
                    </li>
                </ul>
                <!-- tab栏切换结束-->


                <!-- 工具栏开始 -->
                <div id="menupanel">
                    <div class="panel-header floatright">
                    </div>
                    <div class="clear">
                    </div>
                    <div class="menuline">
                    </div>
                </div>

                <!-- 工具栏开始 -->


                <!-- 右侧列表栏开始 -->
                <div class="clear">
                </div>


                <div id="myapps">
                    <ul>
                        <li class="iterm1"><a href="look.html" title="收货" target="_blank">
                            <img src="images/package_go.png"><span>导入数据</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm1"><a href="erro.html" title="调货" target="_blank">
                            <img src="images/measure_crop.png"><span>错误数据</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm1"><a href="messge.html" title="退货" target="_blank">
                            <img src="images/lorry_go.png"><span>运单信息查询</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm1"><a href="statues.html" title="盘点" target="_blank">
                            <img src="images/server_components.png"><span>运单状态查询</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm2"><a href="day.html" title="收银" target="_blank">
                            <img src="images/credit.png"><span>日报表</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="mouth.html" title="基础档案" target="_blank">
                            <img src="images/legend.png"><span>月报表</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="gather.html" title="销售报表" target="_blank">
                            <img src="images/chart_bar.png"><span>成本导入收集</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="collect.html" title="库存调整" target="_blank">
                            <img src="images/brick_delete.png"><span>成本导入汇总</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="collectwo.html" title="销售指标报表" target="_blank">
                            <img src="images/chart_line.png"><span>成本收集汇总</span>
                        </a>

                            <p>零售、报表信息</p>
                        </li>
                        <li class="iterm2"><a href="collectree.html" title="销售指标报表" target="_blank">
                            <img src="images/chart_line.png"><span>成本按导入人汇总</span>
                        </a>

                            <p>零售、报表信息</p>
                        </li>
                        <li class="iterm2"><a href="signin.html" title="库存类报表(X3)" target="_blank"><img src="images/chart_pie_alternative.png">
                            <span>签收报表(X3)</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm3"><a href="username.html" title="销售扩展报表" target="_blank">
                            <img src="images/server_components.png"> <span>用户管理</span>
                        </a>

                            <p>系统管理</p>
                        </li>
                        <li class="iterm3"><a href="username2.html" title="零售补录" target="_blank">
                            <img src="images/user.png"><span>角色管理</span>
                        </a>

                            <p>系统管理</p>
                        </li>
                        <li class="iterm3"><a href="username3.html" title="EP报表" target="_blank">
                            <img src="images/server_components.png"><span>权限管理</span>
                        </a>

                            <p>系统管理</p></li>
                        <li class="iterm3"><a href="log.html" title="EP报表" target="_blank">
                            <img src="images/document_inspector.png"><span>查看日志</span>
                        </a><p>系统管理</p></li>

                        <li class="iterm4"><a href="biguser.html" title="EP报表" target="_blank">
                            <img src="images/flag_red.png"><span>大客户信息</span>
                            </a><p>基础信息维护</p>
                        </li>
                        <li class="iterm4"><a href="timemessge.html" title="EP报表" target="_blank">
                            <img src="images/chart_bar.png"><span>时效控制信息</span>
                             </a><p>基础信息维护</p>
                        </li>
                        <li class="iterm4"><a href="province.html   " title="EP报表" target="_blank">
                            <img src="images/brick_delete.png"><span>一段码省份对照表</span>
                            </a><p>基础信息维护</p>
                        </li>

                        <li class="iterm5"><a href="help.html" title="EP报表" target="_blank">
                            <img src="images/server_components.png"><span>帮助</span>
                            </a><p>基础信息维护</p></li>

                    </ul>
                    <!-- 右侧详情栏结束 -->

                </div>

            </div>

        </div>
        <div style="width: 200px;height: 30px;margin: 0 auto;">
            <a href="http://www.yundaex.com/">---韵达速递---</a>
        </div>
    </div>

    </div>

</body>
</html>