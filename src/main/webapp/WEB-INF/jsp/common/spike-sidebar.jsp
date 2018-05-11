<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Author  : Bolly
  CreatAt : 2017/9/24 13:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="spike-sidebar">
    <div class="sidebar-content">
        <ul id="sidebar-menu" class="sidebar-menu">
            <c:forEach items="${userModules}" var="userModule">
                <li>
                    <a href="<spring:url value='${userModule.data.url}' />">${userModule.text}</a>
                    <c:if test="${userModule.children != null}">
                        <ul class="sidebar-submenu">
                            <c:forEach items="${userModule.children}" var="subModule">
                                <li <c:if test="${subModule.text=='部门&用户管理'}"> class="active" current=true </c:if>>
                                    <a href="<spring:url value='${subModule.data.url}' />">${subModule.text}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="sidebar-foot">
        <ol>
            <li><span>预留空间</span></li>
        </ol>
    </div>
</div>
