/**
 * 框架相关的js操作
 * Author   : Bolly
 * CreateAt : 2018/04/05 11:49:16
 */

/**
 * 显示加载中的模态框
 * @param dim
 */
function showLoadingMask(dim) {
    if (dim == null) {
        dim = $("#spike-body");
    }
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
    dim.css("position","relative");
    dim.append(divMask).append(divMaskAnimation).append(divMaskMsg);
}

/**
 * 隐藏模态框
 * @param dim
 */
function hideMask(dim) {
    if (dim == null) {
        dim = $("#spike-body");
    }
    dim.find(".spike-mask").remove();
    dim.find(".spike-mask-animation").remove();
    dim.find(".spike-mask-msg").remove();
}