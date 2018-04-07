<%--
  Author  : Bolly
  CreatAt : 2017/9/23 23:47
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="spike-content">
    <div class="spike-content-header">
        <div class="spike-content-header-breadcrumb">
            <label class="spike-content-header-title">部门&用户管理</label>
        </div>
        <div class="spike-content-header-search">
            <a href="javascript:void(0)"><i class="icon icon-plus"></i> 新增部门</a>
            <a href="javascript:void(0)"><i class="icon icon-user-plus"></i> 新增员工</a>
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


<script type="text/javascript">

    $(function () {
        //加载部门信息
        loadDepartments();
        //加载人员信息
        loadUsers();
    });

    var deptTreeOption = {
        checkbox: "disabled",
        //加载数据前执行
        beforeAsync: function (treeId, treeNode) {
            showLoadingMask($("#" + treeId).parent());
        },
        //加载失败的事件
        onAsyncError: function (event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
            console.error(treeId + ", " + treeNode + "," + XMLHttpRequest + "," + textStatus + "," + errorThrown);
            hideMask($("#" + treeId).parent());
        },
        //加载成功的事件
        onAsyncSuccess: function (event, treeId, treeNode, msg) {
            hideMask($("#" + treeId).parent());
            var treeObj = $.fn.zTree.getZTreeObj(treeId);
            treeObj.expandAll(true);//展开所有节点
            var nodes = treeObj.getNodes();
            if (nodes.length > 0) {
                treeObj.selectNode(nodes[0]); //选中第一个节点
            }
        },
        //节点点击事件
        onNodeClick: function (event, treeId, treeNode) {
            reloadUsers();
        }
    };

    function loadDepartments() {
        $("#groupTree").showDeptTree(deptTreeOption);
    }

    function loadUsers() {
        $("#userTable").datagrid({
            url: SPIKE_PROJECT_NAME + "/ups/user/list",
            columns: [[
                {field: 'id', hidden: true},
                {field: 'username', title: '工号', width: 100},
                {field: 'name', title: '姓名', width: 100},
                {field: 'nickname', title: '昵称', width: 100},
                {field: 'sex', title: '性别', width: 100},
                {field: 'email', title: '邮箱', width: 200},
                {field: 'hireDate', title: '入职日期', width: 100},
                {field: 'departmentName', title: '部门', width: 150}
            ]],
            loadFilter: userFilter
        });
    }

    function reloadUsers() {
        $('#userTable').datagrid('reload');    // 重新载入当前页面数据
    }

    function userFilter(users) {
        if (users == null || users.length == 0) {
            return {total: 0, rows: []};
        }
        var deptTreeObj = $.fn.zTree.getZTreeObj("groupTree");
        var selectedNodes = deptTreeObj.getSelectedNodes();
        if (selectedNodes == null || selectedNodes.length == 0) {
            return {total: users.length, rows: users};
        }
        if (selectedNodes.length > 1) {
            console.warn("Selected multiple departments. Only show the first department's data.");
        }
        var selectDeptId = selectedNodes[0].id;
        var rows = [];
        for (var i = 0; i < users.length; i++) {
            var user = users[i];
            if (user.department.id == selectDeptId) {
                rows.push(user);
            }
        }
        return {
            total: rows.length,
            rows: rows
        };
    }

</script>

