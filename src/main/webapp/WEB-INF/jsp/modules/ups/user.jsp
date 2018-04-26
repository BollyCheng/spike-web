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
                <spring:message code="web.modules.ups.user.title"/>
            </label>
        </div>
        <div class="spike-content-header-search">
            <a id="btnNewDept" href="javascript:void(0)">
                <i class="icon icon-plus"></i>
                <spring:message code="web.modules.ups.user.operation.newDepartment"/>
            </a>
            <a id="btnNewUser" href="javascript:void(0)">
                <i class="icon icon-user-plus"></i>
                <spring:message code="web.modules.ups.user.operation.newUser"/>
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

<div id="dlgNewDept" class="easyui-dialog" title="新建部门" style="display: none; width: 400px;height: auto">
    <form id="formNewDept" method="post">
        <div>
            <label>上级部门:</label>
            <input id="txtDeptParentId" type="text"/>
        </div>
        <div>
            <label>部门名称:</label>
            <input id="txtDeptName" type="text"/>
        </div>
    </form>
</div>

<div id="dlgNewUser" class="easyui-dialog" title="新建用户" style="display: none; width: 400px;height: auto">
    <form id="formNewUser" method="post">
        <div>
            <label>工号：</label>
            <input id="txtUserEmpNo" type="text"/>
        </div>
        <div>
            <label>姓名：</label>
            <input id="txtUserNameCN" type="text"/>
        </div>
        <div>
            <label>昵称：</label>
            <input id="txtUserNickName" type="text"/>
        </div>
        <div>
            <label>邮箱：</label>
            <input id="txtUserEmail" type="text"/>
        </div>
        <div>
            <label>入职日期：</label>
            <input id="txtUserHireDate" type="text" />
        </div>
        <div>
            <label>部门：</label>
            <input id="txtUserDepartment" type="text" />
        </div>
    </form>
</div>

<script type="text/javascript" src="<spring:url value="/resources/js/module/ups/user.js" /> "></script>
