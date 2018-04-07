<%--
  Created by IntelliJ IDEA.
  User: Bolly
  Date: 2018-04-07
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="spike-content">
    <div class="spike-content-header">
        <div class="spike-content-header-breadcrumb">
            <label class="spike-content-header-title">应用&模块管理</label>
        </div>
        <div class="spike-content-header-search">
            <a href="javascript:void(0)"><i class="icon icon-plus"></i> 新增应用</a>
            <a href="javascript:void(0)"><i class="icon icon-user-plus"></i> 新增模块</a>
        </div>
    </div>
    <div class="spike-content-main">
        <div class="spike-application-list">
            <ul id="applicationList" class="easyui-tree"></ul>
        </div>
        <div class="spike-module-table">
            <div class="spike-module-table-content">
                <table id="moduleTable"></table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<spring:url value="/resources/js/module/ups/module.js" /> "></script>