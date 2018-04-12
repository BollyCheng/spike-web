/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 21:27:17
 */
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
            {field: 'username', title: $.i18n.prop('web.modules.ups.user.userTable.columns.username'), width: 100},
            {field: 'name', title: $.i18n.prop('web.modules.ups.user.userTable.columns.name'), width: 100},
            {field: 'nickname', title: $.i18n.prop('web.modules.ups.user.userTable.columns.nickname'), width: 100},
            {field: 'sex', title: $.i18n.prop('web.modules.ups.user.userTable.columns.sex'), width: 100},
            {field: 'email', title: $.i18n.prop('web.modules.ups.user.userTable.columns.email'), width: 200},
            {field: 'hireDate', title: $.i18n.prop('web.modules.ups.user.userTable.columns.hireDate'), width: 100},
            {field: 'departmentName', title: $.i18n.prop('web.modules.ups.user.userTable.columns.department'), width: 150}
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