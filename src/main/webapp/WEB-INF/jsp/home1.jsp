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
    <script type="text/javascript" src="<spring:url value="/resources/js/bootstrap.min.js" /> "></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/framework/sidebar.js" /> "></script>

    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/bootstrap.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/framework.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/sidebar.css" />"/>

</head>
<body>

<div class="header">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">菜鸟教程</a>
            </div>
            <div>
                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Java
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">jmeter</a></li>
                            <li><a href="#">EJB</a></li>
                            <li><a href="#">Jasper Report</a></li>
                            <li class="divider"></li>
                            <li><a href="#">分离的链接</a></li>
                            <li class="divider"></li>
                            <li><a href="#">另一个分离的链接</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <button type="submit" class="btn btn-default">
                        向左对齐-提交按钮
                    </button>
                </form>
                <p class="navbar-text navbar-left">向左对齐-文本</p>
                <!--向右对齐-->
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Java <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">jmeter</a></li>
                            <li><a href="#">EJB</a></li>
                            <li><a href="#">Jasper Report</a></li>
                            <li class="divider"></li>
                            <li><a href="#">分离的链接</a></li>
                            <li class="divider"></li>
                            <li><a href="#">另一个分离的链接</a></li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <button type="submit" class="btn btn-default">
                        向右对齐-提交按钮
                    </button>
                </form>
                <p class="navbar-text navbar-right">向右对齐-文本</p>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <div class="sidebar">
        <div class="sidebar-title">
            <ol>
                <li><a href="#">Spike</a></li>
                <li><a href="#">UPS</a></li>
            </ol>
        </div>
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
                            <a href="#">角色&权限管理</a>
                        </li>
                        <li>
                            <a href="#">应用&模块管理</a>
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
                            <a href="#">角色&权限管理</a>
                        </li>
                        <li>
                            <a href="#">应用&模块管理</a>
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
    <div class="content">

    </div>
</div>
<div class="footer">

</div>
</body>
</html>

<script type="text/javascript">
    jQuery("#sidebar-menu").sidebarMenu();
</script>

