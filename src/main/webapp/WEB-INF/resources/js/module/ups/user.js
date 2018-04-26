/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 21:27:17
 */
$(function () {
    //初始化页面组件信息
    initPageComponent();
    //初始化页面事件
    initPageEvent();
    //加载部门信息
    loadDepartments();
    //加载人员信息
    loadUsers();
});

//初始化页面组件信息
function initPageComponent() {
    $("#txtDeptName").validatebox({
        required: true,
        validType: "length[1, 20]",
        labelPosition: "right",
        missingMessage: "请输入部门名称",
        invalidMessage: "部门名称不能超过20个字符",
        validateOnCreate: false,
        validateOnBlur: true
    });
    $("#txtDeptParentId").combotree({
        url: SPIKE_PROJECT_NAME + "/ups/department/list",
        required: false,
        editable: false,
        id: "id",
        text: "name",
        loadFilter: function (departments) {
            if (departments == null)
                return null;
            var rows = [];
            for (var i = 0; i < departments.length; i++) {
                var dept = departments[i];
                dept._parentId = dept.parent == null ? null : dept.parent.id;
                rows[i] = dept;
            }
            return rows;
        },
        onLoadSuccess: function (node, data) {
        }
    });
}

//初始化页面事件
function initPageEvent() {
    // 绑定新增部门事件
    $("#btnNewDept").unbind("click").bind("click", openNewDeptDialog);
    // 绑定新增用户事件
    $("#btnNewUser").unbind("click").bind("click", openNewUserDialog);
    // 新增部门对话框配置按钮事件
    $("#dlgNewDept").dialog("bindButtonEvents", {
        submit: function () {
            submitNewDepartmentDialog();
        }
    });
    //新增用户对话框配置按钮事件
    $("#dlgNewUser").dialog("bindButtonEvents", {
        submit: function () {
            submitNewUserDialog();
        }
    });
}

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
            {
                field: 'departmentName',
                title: $.i18n.prop('web.modules.ups.user.userTable.columns.department'),
                width: 150
            }
        ]],
        loadFilter: userFilter
    });
}

function reloadUsers() {
    reloadDategridData($('#userTable'));
}

function userFilter(users) {
    var data = {total: 0, rows: []};
    if (users == null || users.length == 0) {
        return data;
    }
    var deptTreeObj = $.fn.zTree.getZTreeObj("groupTree");
    var selectedNodes = deptTreeObj.getSelectedNodes();
    if (selectedNodes == null || selectedNodes.length == 0) {
        data = {total: users.length, rows: users};
        return pagerFilter(data, this);
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
    data = {total: rows.length, rows: rows};
    return pagerFilter(data, this);
}

function openNewDeptDialog() {
    openEasyuiDialog("dlgNewDept");
}

function openNewUserDialog() {
    openEasyuiDialog("dlgNewUser");
}

function submitNewDepartmentDialog() {
    $("#formNewDept").form('submit', {
        url: SPIKE_PROJECT_NAME + "/ups/department/add",
        onSubmit: function () {
            var isValid = $(this).form('validate');
            if (!isValid) {
                console.log("validate failed.");
                return false;
            }
            console.log("form submit.");
        },
        success: function () {
            console.log("form submit success.")
        },
        error: function () {
            console.log("form submit failed.")
        }
    });
}

function submitNewUserDialog() {
    console.log("submit new user dialog");
}