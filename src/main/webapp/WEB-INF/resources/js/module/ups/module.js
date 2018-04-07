/**
 * Author   : Bolly
 * CreateAt : 2018/04/07 22:35:16
 */
$(function () {
    //加载应用信息
    loadApplications();
    //加载模块信息
    loadModules();
});


function loadApplications() {
    $('#applicationList').tree({
        url: SPIKE_PROJECT_NAME + "/ups/application/list",
        onLoadSuccess: function (node, data) {
            console.log("Load application success.");
            console.log(node + "," + data);
        }
    });
}

function loadModules() {
    $("#moduleTable").datagrid({
        url: SPIKE_PROJECT_NAME + "/ups/module/list",
        columns: [[
            {field: 'id', hidden: true},
            {field: 'name', title: '名称', width: 100},
            {field: 'applicationName', title: '应用', width: 100},
            {field: 'parentModuleName', title: '父模块', width: 100}
        ]],
        onLoadSuccess: function (data) {
            console.log(data);
        }
    });
}