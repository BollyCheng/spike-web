<%--
  Author  : Bolly
  CreatAt : 2017/9/24 13:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title>Spike</title>
    <tiles:insertAttribute name="meta"/>
    <title><tiles:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="script"/>
</head>
<body>

<tiles:insertAttribute name="header"/>
<div class="spike-container">
    <tiles:insertAttribute name="sidebar"/>
    <tiles:insertAttribute name="content"/>
</div>
<tiles:insertAttribute name="footer"/>

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

