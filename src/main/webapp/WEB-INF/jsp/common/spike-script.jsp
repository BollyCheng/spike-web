<%--
  Author  : Bolly
  CreatAt : 2017/9/24 13:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/icon.css" />"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/framework.css" />"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/header.css" />"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/framework/sidebar.css" />"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/easyui/easyui.css" />"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/content.css" />"/>
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/metroStyle.css" />">

<script type="text/javascript" src="<spring:url value='/resources/js/jquery.js' />"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/framework/sidebar.js" /> "></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery.ztree.core.js" />"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery.ztree.excheck.js" />"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/easyui/jquery.easyui.min.js" /> "></script>
<script type="text/javascript" src="<spring:url value="/resources/js/framework/const.js" />"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/framework/framework.js" />"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/framework/grouptree.js" /> "></script>

<script type="text/javascript">

    $(function () {
        $("#sidebar-menu").sidebarMenu();
    });

</script>

