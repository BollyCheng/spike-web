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

//扩展对话框的事件，允许扩展对话框的按钮，并增加对应的事件，对应button中的关键字event
$.extend($.fn.dialog.methods, {
    bindButtonEvents: function (jq, param) {
        return jq.each(function () {
            var dialog = $(this);
            dialog.parent().on('click', '.dialog-button a', function (e) {
                var text = $(this).linkbutton('options').event;
                var method = param[text];
                if (method) {
                    method();
                }
            });
        });
    }
});

//对话框的默认参数
$.extend($.fn.dialog.defaults, {
    closable: true, //定义是否显示关闭按钮。
    closed: true,// 窗口默认关闭。（通过事件触发才能显示）
    draggable: true, //定义是否能够拖拽窗口。
    shadow: true, //如果设置为true，在窗体显示的时候显示阴影。
    inline: true, //定义如何布局窗口，如果设置为true，窗口将显示在它的父容器中，否则将显示在所有元素的上面。
    modal: true, //定义是否将窗体显示为模态化窗口。
    border: "true", //定义窗体边框的样式。可用值：true，false，'thin'，'thick'
    constrain: false, //定义是否限制窗体的位置
    buttons: [
        {text: "确认", event: "submit"},
        {
            text: "关闭", event: "close",
            handler: function () {
                // 关闭对话框，按照现在的格式，button会放置在对应的对话框id节点之后
                // 特别注意：扩展close事件时，关闭对话框的事件同样会执行
                $(this).parent().prev().dialog("close");
            }
        }
    ]
});

