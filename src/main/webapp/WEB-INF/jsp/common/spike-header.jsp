<%--
  Author  : Bolly
  CreatAt : 2017/9/24 13:52
--%>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="org.apache.shiro.session.Session" %>
<%@ page import="com.bolly.spike.model.entity.ups.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
Session spikeSession = SecurityUtils.getSubject().getSession();
User loginUser = (User)spikeSession.getAttribute("loginUser");
%>
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
            <a href="#"><%= loginUser.getName() %></a>
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