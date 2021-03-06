/**
 * 框架相关的js操作
 * Author   : Bolly
 * CreateAt : 2018/04/05 11:49:16
 */
$(function () {
    jQuery.i18n.properties({
        name: "message",//资源文件名称
        path: SPIKE_PROJECT_NAME + "/resources/i18n/", //资源文件路径
        mode: 'map', //用Map的方式使用资源文件中的值
        language: LOCALE_LANGUAGE,
        cache: true, //指定浏览器是否对资源文件进行缓存,默认false
        encoding: 'UTF-8', //加载资源文件时使用的编码。默认为 UTF-8。
        callback: function () {//加载成功后设置显示内容
            //以下是将要国际化的文字内容
            $(".dialog-button a[group='submit']>span>span").html($.i18n.prop('web.dialog.submit'));
            $(".dialog-button a[group='cancel']>span>span").html($.i18n.prop('web.dialog.cancel'));
            $(".dialog-button a[group='close']>span>span").html($.i18n.prop('web.dialog.close'));
        }
    });

    if ($(".department-combo-tree").length > 0) {
        $(".department-combo-tree").combotree({
            url: SPIKE_PROJECT_NAME + "/ups/department/combotree"
        });
    }
});

//使用占位符来格式化字符串
//var str = "js实现用{two}自符串替换占位符{two} {three}  {one} ".format({one: "I",two: "LOVE",three: "YOU"});
//var str2 = "js实现用{1}自符串替换占位符{1} {2}  {0} ".format("I","LOVE","YOU");
String.prototype.format = function () {
    if (arguments.length === 0)
        return this;
    var param = arguments[0];
    var s = this;
    if (typeof(param) === 'object') {
        for (var key in param)
            s = s.replace(new RegExp("\\{" + key + "\\}", "g"), param[key]);
        return s;
    } else {
        for (var i = 0; i < arguments.length; i++)
            s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
        return s;
    }
};

/**
 * 显示加载中的模态框
 * @param dim
 */
function showLoadingMask(dim) {
    if (dim === null) {
        dim = $("#spike-body");
    }
    hideMask(dim);//对于同一个组件，同一时间只允许有一个模态框
    $("<div>").addClass("spike-mask");
    var divMask = $("<div>").addClass("spike-mask");
    var divMaskAnimation = $("<div>").addClass("spike-mask-animation");
    var divMaskMsg = $("<div>").addClass("spike-mask-msg").html("Loading...");
    var divWaveWrapper = $("<div>").addClass("wave-wrapper");
    divMaskAnimation.append(divWaveWrapper);
    for (var i = 1; i <= 5; i++) {
        var divRect = $("<div>").addClass("w-rect").addClass("rect" + i);
        divWaveWrapper.append(divRect);
    }
    dim.css("position", "relative");
    dim.append(divMask).append(divMaskAnimation).append(divMaskMsg);
}

/**
 * 隐藏模态框
 * @param dim
 */
function hideMask(dim) {
    if (dim === null) {
        dim = $("#spike-body");
    }
    dim.find(".spike-mask").remove();
    dim.find(".spike-mask-animation").remove();
    dim.find(".spike-mask-msg").remove();
}

function openEasyuiDialog(dlgId) {
    $("#" + dlgId).dialog("open");
}

function closeEasyuiDialog(dlgId) {
    $("#" + dlgId).dialog("close");
}
