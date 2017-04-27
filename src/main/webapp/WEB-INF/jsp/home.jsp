<%--
  Author  : Bolly
  CreatAt : 2017/4/21 21:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Spike</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <script type="text/javascript" src="<spring:url value='/resources/js/jquery.min.js' />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/framework/sidebar.js" /> "></script>

    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/icon.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/framework.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/header.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/sidebar.css" />"/>

</head>
<body>

<div class="spike-header">
    <div class="spike-header-container">
        <div class="spike-brands">
            <a href="#">
                <div class="icon icon-leaf" style="font-size: 35px;">
                    <span>Spike</span>
                </div>
            </a>
        </div>
        <div class="spike-user">
            <a href="#">成响林</a>
            <a href="#"> <i class="icon icon-user" style="font-size: 30px;"></i></a>
        </div>
        <div class="spike-applications">

        </div>
    </div>
</div>
<div class="spike-container">
    <div class="spike-sidebar">
        <div class="sidebar-content">
            <ul id="sidebar-menu" class="sidebar-menu">
                <li>
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#">基础资料</a>
                    <ul class="sidebar-submenu">
                        <li>
                            <a href="#">部门&用户管理</a>
                        </li>
                        <li>
                            <a href="#">应用&模块管理</a>
                        </li>
                        <li>
                            <a href="#">角色&权限管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">基础资料</a>
                    <ul class="sidebar-submenu">
                        <li>
                            <a href="#">部门&用户管理</a>
                        </li>
                        <li>
                            <a href="#">应用&模块管理</a>
                        </li>
                        <li>
                            <a href="#">角色&权限管理</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="sidebar-foot">
            <ol>
                <li><span>才能</span></li>
            </ol>
        </div>
    </div>
    <div class="spike-content">

    </div>
</div>
<div class="spike-footer">

</div>
</body>
</html>

<script type="text/javascript">
    jQuery("#sidebar-menu").sidebarMenu();
</script>

