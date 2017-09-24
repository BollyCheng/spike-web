<%--
  Author  : Bolly
  CreatAt : 2017/4/21 21:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Spike</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/icon.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/framework.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/header.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/sidebar.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/content.css" />"/>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/metroStyle.css" />">

    <script type="text/javascript" src="<spring:url value='/resources/js/jquery.js' />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/framework/sidebar.js" /> "></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/jquery.ztree.core.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/jquery.ztree.excheck.js" />"></script>
    <script type="text/javascript" src="<spring:url value="/resources/js/framework/grouptree.js" /> "></script>

</head>
<body>

<div class="spike-header">
    <div class="spike-header-container">
        <div class="spike-brands">
            <a href="#">
                <i class="icon icon-leaf"></i>
                <span>Spike</span>
            </a>
        </div>
        <div class="spike-user">
            <a href="#">成响林</a>
            <a href="#" class="btn-group">
                <i class="icon icon-user"></i>
                <i class="icon icon-play3"></i>
            </a>
        </div>
        <div class="spike-applications">
            <ol>
                <li>
                    <a href="#" class="active">
                        <i class="icon icon-home"></i>
                        <span>UPS</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="icon icon-infinite"></i>
                        <span>ITS</span>
                    </a>
                </li>
            </ol>
        </div>
    </div>
</div>
<div class="spike-container">
    <div class="spike-sidebar">
        <div class="sidebar-content">
            <ul id="sidebar-menu" class="sidebar-menu">
                <li>
                    <a href="#" class="active">首页</a>
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
        <div class="spike-content-header">
            <div class="spike-content-header-breadcrumb">
                <label class="spike-content-header-title">部门&用户管理</label>
            </div>
            <div class="spike-content-header-search">
                <div>
                    <label class="radio">
                        <input type="radio" name="category" checked="checked"/>
                        <span>致命</span>
                    </label>
                    <label class="radio">
                        <input type="radio" name="category"/>
                        <span>严重</span>
                    </label>
                    <label class="radio">
                        <input type="radio" name="category"/>
                        <span>一般</span>
                    </label>
                    <label class="radio">
                        <input type="radio" name="category"/>
                        <span>提示</span>
                    </label>
                </div>
            </div>
            <div class="spike-content-header-main">
                <ol>
                    <li><a href="javascript:void(0)">你好</a></li>
                    <li><a href="javascript:void(0)">我好</a></li>
                    <li><a href="javascript:void(0)">大家好</a></li>
                </ol>
            </div>
        </div>
        <div class="spike-content-main">
            <ul id="groupTree" class="ztree"></ul>
        </div>
    </div>
</div>
<div class="spike-footer">
    <div class="fl">
        <p>版权所有2017 Bolly Inc. 保留所有权利。</p>
    </div>
    <div class="fr">
        <a class="contact-me" href="javascript:void(0)"><i class="icon icon-bubble"></i> 请联系我</a>
        <a class="user-book" href="javascript:void(0)"><i class="icon icon-book"></i> 使用手册</a>
    </div>
</div>

<div class="spike-mask"></div>
<div class="spike-mask-msg">
    <div class="wave-wrapper">
        <div class="w-rect rect1"></div>
        <div class="w-rect rect2"></div>
        <div class="w-rect rect3"></div>
        <div class="w-rect rect4"></div>
        <div class="w-rect rect5"></div>
    </div>
</div>

</body>
</html>

<script type="text/javascript">

    $("#sidebar-menu").sidebarMenu();

    $("#groupTree").showDeptTree(null);

</script>

