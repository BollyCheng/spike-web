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
        <table>
            <tr>
                <td class="form-name">
                    <label for="txtDeptParentId">上级部门:</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtDeptParentId" name="parent.id" class="department-combo-tree" type="text"/>
                </td>
            </tr>
            <tr>
                <td class="form-name">
                    <label for="txtDeptName">部门名称:</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtDeptName" name="name" type="text"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlgNewUser" class="easyui-dialog" title="新建用户" style="display: none; width: 400px;height: auto">
    <form id="formNewUser" method="post">
        <table>
            <tr>
                <td class="form-name">
                    <label for="txtUserEmpNo">工号：</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtUserEmpNo" type="text"/>
                </td>
            </tr>
            <tr>
                <td class="form-name">
                    <label for="txtUserNameCN">姓名：</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtUserNameCN" type="text"/>
                </td>
            </tr>
            <tr>
                <td class="form-name">
                    <label for="txtUserNickName">昵称：</label></td>
                <td class="form-value" colspan="3">
                    <input id="txtUserNickName" type="text"/>
                </td>
            </tr>
            <tr>
                <td class="form-name">
                    <label for="txtUserEmail">邮箱：</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtUserEmail" type="text"/>
                </td>
            </tr>
            <tr>
                <td class="form-name">
                    <label for="txtUserHireDate">入职日期：</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtUserHireDate" name="hireDate" type="text"/>
                </td>
            </tr>
            <tr>
                <td class="form-name">
                    <label for="txtUserDepartment">部门：</label>
                </td>
                <td class="form-value" colspan="3">
                    <input id="txtUserDepartment" name="department.id" class="department-combo-tree" type="text"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<script type="text/javascript" src="<spring:url value="/resources/js/module/ups/user.js" /> "></script>
