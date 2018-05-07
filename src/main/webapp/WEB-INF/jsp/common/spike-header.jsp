<%--
  Author  : Bolly
  CreatAt : 2017/9/24 13:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="spike-header">
    <div class="spike-header-container">
        <div class="spike-brands">
            <a href="#">
                <i class="icon icon-leaf"></i>
                <span>Spike</span>
            </a>
        </div>
        <div class="spike-user">
            Language:
            <a href="?lang=zh_CN"><spring:message code="language.cn"/></a>
            <a href="?lang=en_US"><spring:message code="language.en"/></a>
            <a href="#"><c:out value="${loginUser.name}" /></a>
            <a href="#" class="btn-group">
                <i class="icon icon-user"></i>
                <i class="icon icon-play3"></i>
            </a>
        </div>
        <div class="spike-applications">
            <ol>
                <c:forEach items="${userApplications}" var="userApplication">
                    <li>
                        <a href="javascript:void(0)" <c:if test="${userApplication.name == 'UPS'}">class="active" </c:if>>
                            <i class="icon icon-home"></i>
                            <span>${userApplication.name}</span>
                        </a>
                    </li>
                </c:forEach>
            </ol>
        </div>
    </div>
</div>