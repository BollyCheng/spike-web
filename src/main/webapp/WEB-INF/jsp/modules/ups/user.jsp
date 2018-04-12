<%--
  Author  : Bolly
  CreatAt : 2017/9/23 23:47
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="spike-content">
    <div class="spike-content-header">
        <div class="spike-content-header-breadcrumb">
            <label class="spike-content-header-title">
                <spring:message code="web.modules.ups.user.title" />
            </label>
        </div>
        <div class="spike-content-header-search">
            <a href="javascript:void(0)">
                <i class="icon icon-plus"></i>
                <spring:message code="web.modules.ups.user.operation.newDepartment" />
            </a>
            <a href="javascript:void(0)">
                <i class="icon icon-user-plus"></i>
                <spring:message code="web.modules.ups.user.operation.newUser" />
            </a>
        </div>
    </div>
    <div class="spike-content-main">
        <div class="spike-dept-tree">
            <ul id="groupTree" class="ztree"></ul>
        </div>
        <div class="spike-user-table">
            <div class="spike-user-table-content">
                <table id="userTable"></table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<spring:url value="/resources/js/module/ups/user.js" /> "></script>
