/**
 * Author   : Bolly
 * CreateAt : 2017/07/08 22:06:21
 */
(function ($) {

    var setting = {
        async: {
            enable: true,
            url: "./department/list",
            type: "post",
            dataType: "json",
            contentType: "application/json"
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId"
            },
            key: {
                checked: "checked", //保存 check 状态的属性名称
                children: "children", //保存子节点数据的属性名称
                name: "name",//保存节点名称的属性名称
                title: ""
            }
        },
        view: {
            nameIsHTML: false,// name 属性是否支持 HTML 脚本
            showIcon: true,//是否显示节点的图标
            showLine: true,//是否显示节点之间的连线
            showTitle: false,//是否显示节点的 title 提示信息
            txtSelectedEnable: false,//是否允许可以选择 zTree DOM 内的文本
            selectedMulti: false,//是否允许同时选中多个节点。
            autoCancelSelected: true, //点击节点时，按下 Ctrl 或 Cmd 键是否允许取消选择操作。
            dblClickExpand: true,//双击节点时，是否自动展开父节点的标识
            expandSpeed: "fast",//节点展开、折叠时的动画速度
            fontCss: {},//个性化文字样式，只针对 zTree 在节点上显示的<A>对象
            addDiyDom: addDiyDom, //在节点上固定显示用户自定义控件
            addHoverDom: addHoverDom,//当鼠标移动到节点上时，显示用户自定义控件
            removeHoverDom: removeHoverDom//用于当鼠标移出节点时，隐藏用户自定义控件
        },
        check: {
            enable: true,//设置 zTree 的节点上是否显示 checkbox / radio
            chkStyle: "checkbox", //勾选框类型(checkbox 或 radio）
            //勾选 checkbox 对于父子节点的关联关系。
            //Y 属性定义 checkbox 被勾选后的情况；
            //N 属性定义 checkbox 取消勾选后的情况；
            // p:表示操作会影响父级节点,
            // s:表示操作会影响子级节点。
            chkboxType: {"Y": "", "N": ""} //如：{"Y": "ps", "N": "ps}
        },
        callback: {
            onAsyncError: null,//异步加载出现异常错误的事件回调函数
            onAsyncSuccess: null,//异步加载正常结束的事件回调函数
            onCheck: treeNodeChecked //捕获 checkbox被勾选 或 取消勾选的事件回调函数
        }
    };

    //选中事件
    function treeNodeChecked(event, treeId, treeNode) {
        console.log(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
    }

    //用户自定义控件
    function addDiyDom(treeId, treeNode) {
        console.log(treeNode);
        var aObj = $("#" + treeNode.tId + "_a");
        aObj.children().remove();
        //aObj.find("span[treenode_ico]").remove(); //移除图标


        var ul = $("<ul>")
            .addClass("more");
        for (var i = 0; i < 5; i++) {
            ul.append("<li><a href='#' target='_blank'>1234</a></li>")
        }

        //添加状态位
        var stateDiv = $("<div>").html("state")
            .attr("id", treeId + "_" + treeNode.id + "_state")
            .addClass("node-state")
            .addClass("state-true")
            .append(ul);

        var tipDiv = $("<div>").html("12")
            .attr("id", treeId + "_" + treeNode.id + "_sup")
            .addClass("node-sup");

        var nameDiv = $("<div>").html(treeNode.name)
            .attr("id", treeId + "_" + treeNode.id + "_name")
            .addClass("node-name");

        var selectDiv = $("<select>")
            .attr("id", treeId + "_" + treeNode.id + "_dev")
            .addClass("node-dev")
            .append("<option>请选择1</option>");

        aObj.append(stateDiv)
            .append(tipDiv)
            .append(nameDiv)
            .append(selectDiv);

    };
    //
    function addHoverDom(treeId, treeNode) {
        var aObj = $("#" + treeNode.tId + "_a");
        if ($("#diyBtn_" + treeNode.id).length > 0) return;
        var editStr = "<span id='diyBtn_space_" + treeNode.id + "' > </span>"
            + "<button type='button' class='diyBtn1' id='diyBtn_" + treeNode.id
            + "' title='" + treeNode.name + "' onfocus='this.blur();'></button>";
        aObj.append(editStr);
        var btn = $("#diyBtn_" + treeNode.id);
        if (btn) btn.bind("click", function () {
            alert("diy Button for " + treeNode.name);
        });
    };
    //
    function removeHoverDom(treeId, treeNode) {
        $("#diyBtn_" + treeNode.id).unbind().remove();
        $("#diyBtn_space_" + treeNode.id).unbind().remove();
    };

    $.fn.showDeptTree = function (option) {

        $.fn.zTree.init(this, setting);
        return this;
    };

}(jQuery));