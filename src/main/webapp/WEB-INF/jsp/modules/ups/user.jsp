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
            <table id="userTable" class="table">
                <thead>
                <tr>
                    <th width="10%">工号</th>
                    <th width="10%">姓名</th>
                    <th width="20%">部门</th>
                    <th width="10%">创建人</th>
                    <th width="20%">创建时间</th>
                    <th width="10%">更新人</th>
                    <th width="20%">更新时间</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="7">没有数据</td>
                </tr>
                </tbody>
                <tfoot>
                <tr>
                    <td rowspan="7">分页</td>
                </tr>
                </tfoot>
            </table>
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
            }
        };
        $("#groupTree").showDeptTree(option);
    });

</script>

