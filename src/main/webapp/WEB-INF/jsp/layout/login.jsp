<%--
  Created by IntelliJ IDEA.
  User: Bolly
  Date: 2018-05-06
  Time: 18:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <tiles:insertAttribute name="meta"/>
    <title><tiles:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="script"/>
</head>
<body>
<div class="spike-container">
    <tiles:insertAttribute name="content"/>
</div>
<tiles:insertAttribute name="footer"/>

</body>
</html>

