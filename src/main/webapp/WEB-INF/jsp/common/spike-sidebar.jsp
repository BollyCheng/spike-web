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
                    <a href="javascript:void(0)">${userModule.text}</a>
                    <c:if test="${userModule.children != null}">
                        <ul class="sidebar-submenu">
                            <c:forEach items="${userModule.children}" var="subModule">
                                <li>
                                    <a href="javascript:void(0)">${subModule.text}</a>
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
