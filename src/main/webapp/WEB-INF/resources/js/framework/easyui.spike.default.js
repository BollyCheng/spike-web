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
    pageList: [10, 20, 50, 100],
    loadFilter: pagerFilter
});

function pagerFilter(data, datagrid) {
    if (typeof data.length === 'number' && typeof data.splice === 'function') {    // 判断数据是否是数组
        data = {
            total: data.length,
            rows: data
        }
    }
    var dg = datagrid === null ? $(this) : $(datagrid);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
        onSelectPage: function (pageNum, pageSize) {
            opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh', {
                pageNumber: pageNum,
                pageSize: pageSize
            });
            dg.datagrid('reload');
        }
    });
    if (!data.originalRows) {
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}

/**
 * 重新加载表格数据（前端）
 * @param datagrid 表格对象（注意通过$('#id')的方式传递参数）
 */
function reloadDategridData(datagrid) {
    //每次重新加载数据都恢复到第一页
    var opts = $(datagrid).datagrid('options');
    var pager = $(datagrid).datagrid('getPager');
    opts.pageNumber = 1;
    pager.pagination('refresh', {
        pageNumber: opts.pageNumber
    });
    $(datagrid).datagrid('reload');    // 重新载入当前页面数据
}

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
            dialog.parent().on('click', '.dialog-button a', function () {
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
        // text为显示的文本，因为需要国际化，这里只给定一个默认值
        // event，表示事件，通过bindButtonEvents绑定事件
        // group，用于国际化，因为没有找到合适的属性赋值到按钮上
        {text: 'Submit', event: "submit", group: "submit"},
        {
            text: 'Close', event: "close", group: "close",
            handler: function () {
                // 关闭对话框，按照现在的格式，button会放置在对应的对话框id节点之后
                // 特别注意：扩展close事件时，关闭对话框的事件同样会执行
                $(this).parent().prev().dialog("close");
            }
        }
    ]
});

$.extend($.fn.form.defaults, {
    novalidate: false,
    onSubmit: function () {
        // 表单验证不通过，不向后台提交请求
        var isValid = $(this).form('validate');
        if (!isValid) {
            return false;
        }
    },
    success: function (data) {
        var json = $.parseJSON(data);
        if (json.result === 'success') {
            console.warn("Success on process form data. but do nothing.");
        } else {
            console.error("Error on process form data. error message is %s", json.message);
        }
    }
});

/**
 * 扩展easy ui的validate box
 *
 * @requires jQuery, EasyUI
 */
$.extend($.fn.validatebox.defaults.rules, {
    eqPwd: {
        validator: function (value, param) {
            return value === $(param[0]).val();
        },
        message: '密码不一致！'
    },
    idcard: {// 验证身份证
        validator: function (value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message: '身份证号码格式不正确'
    },
    minLength: {
        validator: function (value, param) {
            return value.length >= param[0];
        },
        message: '请输入至少（2）个字符.'
    },
    length: {
        validator: function (value, param) {
            var len = $.trim(value).length;
            return len >= param[0] && len <= param[1];
        },
        message: "输入内容长度必须介于{0}和{1}之间."
    },
    phone: {// 验证电话号码
        validator: function (value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '格式不正确,请使用下面格式:010-88888888'
    },
    mobile: {// 验证手机号码
        validator: function (value) {
            return /^(13|15|18)\d{9}$/i.test(value);
        },
        message: '手机号码格式不正确'
    },
    intOrFloat: {// 验证整数或小数
        validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '请输入数字，并确保格式正确'
    },
    currency: {// 验证货币
        validator: function (value) {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message: '货币格式不正确'
    },
    qq: {// 验证QQ,从10000开始
        validator: function (value) {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message: 'QQ号码格式不正确'
    },
    integer: {// 验证整数
        validator: function (value) {
            return /^[+]?[1-9]+\d*$/i.test(value);
        },
        message: '请输入整数'
    },
    age: {// 验证年龄
        validator: function (value) {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
        },
        message: '年龄必须是0到120之间的整数'
    },
    chinese: {// 验证中文
        validator: function (value) {
            return /^[\Α-\￥]+$/i.test(value);
        },
        message: '请输入中文'
    },
    english: {// 验证英语
        validator: function (value) {
            return /^[A-Za-z]+$/i.test(value);
        },
        message: '请输入英文'
    },
    unnormal: {// 验证是否包含空格和非法字符
        validator: function (value) {
            return /.+/i.test(value);
        },
        message: '输入值不能为空和包含其他非法字符'
    },
    username: {// 验证用户名
        validator: function (value) {
            return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i.test(value);
        },
        message: '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
    },
    faxno: {// 验证传真
        validator: function (value) {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message: '传真号码不正确'
    },
    zip: {// 验证邮政编码
        validator: function (value) {
            return /^[0-9]\d{5}$/i.test(value);
        },
        message: '邮政编码格式不正确'
    },
    ip: {// 验证IP地址
        validator: function (value) {
            return /d+.d+.d+.d+/i.test(value);
        },
        message: 'IP地址格式不正确'
    },
    name: {// 验证姓名，可以是中文或英文
        validator: function (value) {
            return /^[\Α-\￥]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);
        },
        message: '请输入姓名'
    },
    msn: {
        validator: function (value) {
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
        },
        message: '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
    }
});
