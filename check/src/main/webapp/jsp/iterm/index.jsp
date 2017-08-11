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
<title>首页</title>

</head>
<body style="overflow: hidden;">

<script type="text/javascript" src="<%=path%>/framework/jquery-easyui/jquery.min.js"></script>
<link rel="stylesheet" href="<%= path%>/jsp/iterm/css/base.css">
<link rel="stylesheet" href="<%= path%>/jsp/iterm/css/index.css">
<link href="<%= path%>/jsp/iterm/favicon.ico" rel="shortcut icon" type="image/x-icon"/>
<script type="text/javascript" src="<%=path%>/jsp/iterm/js/base.js"></script>
<div>
    <span id="self-btn" class="easyui-linkbutton" data-options="iconCls:'icon-next'"></span>
</div>
<div class="layout-wrapper" style="position: relative">
    <div class="layout-header">
        <div class="layout-logo" style="width: 200px;position:absolute">
            <a href="#" id="systerm" style="background: url('<%=path%>/jsp/iterm/images/mylogo2.gif');display:block;width: 200px;height: 60px;position: absolute;left:0px;margin-left:0px; "></a>
        </div>
        <div class="layout-title"style="position: absolute;top: 30px;left: 220px">

            <p style="font-size: 14px;padding-left: 0px;line-height: 21px;color:#fcfcfc;font-weight:600;"  title="查看账号信息" target="_blank">深圳韵达有限公司欢迎你!</a></p>
        </div>
        <div class="layout-help" style="position: absolute;top: 30px ;right:30px">
            <a href="<%=path%>/jsp/iterm/login.jsp" style="line-height: 1px;">退出登录</a>
        </div>
    </div>

    <div id="wrapper">
        <div id="sidebar" style="height: 110%;overflow: hidden;background-image: url('<%=path%>/jsp/iterm/images/22.png')">
            <h3>
                我的标签
            <span id="ctl_38576754" class="dropdownlink" style="float:right;">

			</span>
            </h3>
            <ul id="tag" data-listidx="0">
                <li href="#desktop" ref="200000021782"><span>公司主页</span>
                </li>
            </ul>
            <h3 id="mymuen">我的菜单</h3>
            <ul id="group_list" class="myself-menu">

                <li><span>
		       		 <img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px;vertical-align: top;" src="<%=path%>/jsp/iterm/images/brick.png">大客户查件</span>
                </li>
                <li><span>
		       	 	 <img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px; vertical-align: top;" src="<%=path%>/jsp/iterm/images/credit.png">电子看板</span>
                </li>
                <li><span>
		       			<img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px;vertical-align: top;" src="<%=path%>/jsp/iterm/images/soil_layers.png">网点信息管理</span>
                </li>
                <li><span>
		       		<img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px; vertical-align: top;" src="<%=path%>/jsp/iterm/images/world.png">关键性指标</span>
                </li>
                <li><span>
		       		<img class="floatleft" style="width: 20px; height: 20px;margin:3px 3px 0px 0px; vertical-align: top;" src="<%=path%>/jsp/iterm/images/phone_Android.png">帮助</span>
                </li>
            </ul>


            <h3>扩展系统</h3>
            <ul>
                <li id="li_sysapp" style="cursor:pointer">
                <span>
                    <img style="width: 16px; height: 16px;" src="<%=path%>/jsp/iterm/images/gear_in.png">
                    集成系统
                </span>
                </li>
            </ul>

        </div>



        <!-- 左侧工具栏结束 -->

        <!-- 右侧详情栏开始 -->
        <div id="main" style="height: 781px; overflow: auto;">

            <div id="menuiterm" style="display: block;">
                <!-- tab栏切换开始 -->

                <ul class="menutab" id="menugroup">
                    <li  class="menutabactive">
                        <span>全部</span>
                    </li>
                    <li>
                        <span>快件信息</span>
                    </li>
                    <li>
                        <span>报表</span></li>
                    <li>
                        <span>系统管理</span>
                    </li>
                    <li>
                        <span>基础维护</span>
                    </li>
                    <li>
                        <span>帮助</span>
                    </li>
                </ul>
                <div class="clear">
                </div>


                <div id="myapps">
                    <ul>
                        <li class="iterm1"><a href="<%=path%>/jsp/iterm/dateinput.jsp" title="收货" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/package_go.png"><span>导入数据</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm1"><a href="<%=path%>/jsp/iterm/error.jsp" title="调货" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/measure_crop.png"><span>错误数据</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm1"><a href="<%=path%>/jsp/iterm/message.jsp" title="退货" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/lorry_go.png"><span>运单信息查询</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm1"><a href="<%=path%>/jsp/iterm/statues.jsp" title="盘点" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/server_components.png"><span>运单状态查询</span>
                        </a>

                            <p>快件操作</p>
                        </li>
                        <li class="iterm2"><a  href="<%=path%>/jsp/iterm/day.jsp" title="收银" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/credit.png"><span>日报表</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="<%=path%>/jsp/iterm/mounth.jsp" title="基础档案" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/legend.png"><span>月报表</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="<%=path%>/jsp/iterm/gather.jsp" title="销售报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/chart_bar.png"><span>成本导入收集</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm2"><a href="<%=path%>/jsp/iterm/collect.jsp" title="库存调整" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/brick_delete.png"><span>成本导入汇总</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                       
                        <li class="iterm2"><a href="<%=path%>/jsp/iterm/colllectw.jsp" title="销售指标报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/chart_line.png"><span>成本按导入人汇总</span>
                        </a>

                            <p>零售、报表信息</p>
                        </li>
                        <li class="iterm2"><a href="<%=path%>/jsp/iterm/signin.jsp" title="库存类报表(X3)" target="_blank"><img src="<%=path%>/jsp/iterm/images/chart_pie_alternative.png">
                            <span>签收报表(X3)</span>
                        </a>

                            <p>报表信息</p>
                        </li>
                        <li class="iterm3"><a href="<%=path%>/jsp/iterm/username.jsp" title="销售扩展报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/server_components.png"> <span>用户管理</span>
                        </a>

                            <p>系统管理</p>
                        </li>
                        <li class="iterm3"><a href="<%=path%>/jsp/iterm/usernameg.jsp" title="零售补录" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/user.png"><span>角色管理</span>
                        </a>

                            <p>系统管理</p>
                        </li>
                        <li class="iterm3"><a href="<%=path%>/jsp/iterm/permission.jsp" title="EP报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/server_components.png"><span>权限管理</span>
                        </a>

                            <p>系统管理</p></li>
                        <li class="iterm3"><a href="<%=path%>/jsp/iterm/log.jsp" title="EP报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/document_inspector.png"><span>查看日志</span>
                        </a><p>系统管理</p></li>

                        <li class="iterm4"><a href="<%=path%>/jsp/iterm/biguser.jsp" title="EP报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/flag_red.png"><span>大客户信息</span>
                            </a><p>基础信息维护</p>
                        </li>
                        <li class="iterm4"><a href="<%=path%>/jsp/iterm/timemessge.jsp" title="EP报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/chart_bar.png"><span>时效控制信息</span>
                             </a><p>基础信息维护</p>
                        </li>
                        <li class="iterm4"><a href="<%=path %>/jsp/iterm/province.jsp" title="EP报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/brick_delete.png"><span>一段码省份对照表</span>
                            </a><p>基础信息维护</p>
                        </li>

                        <li class="iterm5"><a href="<%=path%>/jsp/iterm/help.jsp" title="EP报表" target="_blank">
                            <img src="<%=path%>/jsp/iterm/images/server_components.png"><span>帮助</span>
                            </a><p>基础信息维护</p></li>

                    </ul>
                    <!-- 右侧详情栏结束 -->

                </div>

            </div>

        </div>
         <div style="width: 200px;height: 30px;margin: 0 auto;color: #0f0f0f">
            <a href="http://www.yundaex.com/" style="color:black">---韵达速递---</a>
        </div>
    </div>

    </div>

</body>
</html>