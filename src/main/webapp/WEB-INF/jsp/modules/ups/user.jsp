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
        var option = {
            checkbox: "disabled",
            //加载数据前执行
            beforeAsync: function (treeId, treeNode) {
                showLoadingMask($("#" + treeId).parent());
            },
            //加载失败的事件
            onAsyncError: function (event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
                console.log(treeId + ", " + treeNode + "," + XMLHttpRequest + "," + textStatus + "," + errorThrown);
                hideMask($("#" + treeId).parent());
            },
            //加载成功的事件
            onAsyncSuccess: function (event, treeId, treeNode, msg) {
                console.log("Load " + treeId + " success.");
                hideMask($("#" + treeId).parent());
                var treeObj = $.fn.zTree.getZTreeObj(treeId);
                treeObj.expandAll(true);//展开所有节点
                var nodes = treeObj.getNodes();
                if (nodes.length > 0) {
                    treeObj.selectNode(nodes[0]); //选中第一个节点
                    treeObj.setting.callback.onClick(null, treeId, nodes[0]); //模拟点击事件
                }
            },
            //节点选中事件
            onNodeClick: function (event, treeId, treeNode) {
                console.log(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
                loadUsersByDepartment(treeNode.id);
            }
        };
        $("#groupTree").showDeptTree(option);
    });

    function loadUsersByDepartment(departmentId) {
        $("#userTable").datagrid({
            width: "100%",
            height: "100%",
            rownumbers: true,
            url: SPIKE_PROJECT_NAME + "/ups/user/list",
            columns: [[
                {field: 'username', title: '工号', width: 100},
                {field: 'name', title: '姓名', width: 100},
                {field: 'nickname', title: '昵称', width: 100},
                {field: 'sex', title: '性别', width: 100},
                {field: 'email', title: '邮箱', width: 200},
                {field: 'hireDate', title: '入职日期', width: 100},
                {field: 'departmentName', title: '部门', width: 150}
            ]],
            pagination: true
        });
//        $.ajax({
//            url: SPIKE_PROJECT_NAME + "/ups/user/list",
//            type: "post",
//            contentType: "application/x-www-form-urlencoded",
//            data: {departmentId: departmentId},
//            dataType: "json",
//            beforeSend: function () {
//                showLoadingMask($("#userTable").parent());
//            },
//            dataFilter: function (data) {
//                return data;
//            },
//            complete: function () {
//                hideMask($("#userTable").parent());
//            },
//            success: function (data, textStatus) {
//                console.log("Load users success.");
//            },
//            error: function (XMLHttpRequest, textStatus, errorThrown) {
//                console.log("Load users failed.");
//            }
//        });
    }

</script>

