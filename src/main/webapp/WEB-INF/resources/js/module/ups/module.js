/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 22:35:16
 */

var applications = null; // 缓存应用信息
var currentTabIndex = 0; // 当前选中的tab序号

$(function () {
    $("#applicationTabs").tabs({
        onSelect: function (title,index) {
            currentTabIndex = index;
            reloadModules(index);
        }
    });
    //加载应用信息
    loadApplications();
    //加载模块信息
    loadModules();
});

function loadApplications() {
    $.ajax({
        url: SPIKE_PROJECT_NAME + "/ups/application/list",
        method: "post",
        dataType: "json",
        success: function (data) {
            if (data == null) {
                return;
            }
            applications = data;
            for (var i = 0; i < data.length; i++) {
                var application = data[i];
                var selected = (i == currentTabIndex); // 默认选中第一个
                $("#applicationTabs").tabs('add', {
                    id: application.id,
                    title: application.name + " <i class='icon icon-home'></i>",
                    selected: selected
                });
            }
        }
    });
}

function loadModules() {
    $("#moduleTreeTable").treegrid({
        url: SPIKE_PROJECT_NAME + "/ups/module/list",
        columns: [[
            {field: 'name', title: '名称', width: 200}
        ]],
        loadFilter: moduleFilter
    });
}

function reloadModules(index) {
    // 找到tab对应的容器
    var tabContent = $("#applicationTabs>.tabs-panels>.panel>.panel-body")[index];
    // 找到数据内容的表格
    var treeGrid = $('#moduleTreeTable').parent().parent().parent();
    // 将数据内容放到tab容器中
    $(tabContent).append(treeGrid);
    // 刷新数据
    $('#moduleTreeTable').treegrid('reload');    // 重新载入当前页面数据
}

function moduleFilter(modules) {
    if (modules == null) {
        return null;
    }
    var application = applications[currentTabIndex];
    //刷新树形结构
    var rows = [];
    var count = 0;
    for (var i = 0; i < modules.length; i++) {
        if (modules[i].application.id != application.id) {
            continue;
        }
        var module = modules[i];
        module._parentId = modules[i].parent == null ? null : modules[i].parent.id;
        rows[count++] = module;
    }
    return {
        total: rows.length,
        rows: rows
    };
}