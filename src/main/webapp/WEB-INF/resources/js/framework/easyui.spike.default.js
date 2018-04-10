/**
 * 继承easyui框架，将一些全局的设置放到本模块中
 * Author   : Bolly
 * CreateAt : 2018/04/06 08:09:13
 */
$.extend($.fn.datagrid.defaults, {
    fit: true,
    rownumbers: true,
    dataType: "json",
    singleSelect: true,
    pagination: true,
    pageSize: 20,
    pageList: [10, 20, 50, 100]
});

$.extend($.fn.tabs.defaults, {
    fit: true,
    plain: true,
    pill: true,
    border: false
});

$.extend($.fn.treegrid.defaults, {
    fit: true,
    rownumbers: true,
    idField: "id",
    treeField: "name",
    dataType: "json",
    singleSelect: true
});