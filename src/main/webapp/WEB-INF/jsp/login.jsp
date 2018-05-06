<%--
  Created by IntelliJ IDEA.
  User: Bolly
  Date: 2018-05-06
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style type="text/css">
    form p + p {
        margin-top: 10px;
    }

    form p input {
        width: 100%;
        height: 40px;
        line-height: 40px;
    }
</style>

<div class="login-content"
     style="position: absolute; top: 150px; left: 40%; width: 20%; padding: 40px; background: #eee">
    <form id="login-form" action="login" method="post">
        <p>
            <input type="text" name="username" placeholder="请输入用户名"/>
        </p>
        <p>
            <input type="password" name="password" placeholder="请输入密码"/>
        </p>
        <p>
            <input type="submit" value="登录"/>
        </p>
        <%--<p>--%>
        <%--<span><i class="icon icon-user"></i></span>--%>
        <%--<span><i class="icon icon-lock"></i></span>--%>
        <%--</p>--%>
    </form>
</div>

<script>
    $(function () {
        //初始化页面组件信息
        initPageComponent();
        //初始化页面事件
        initPageEvent();
    });

    function initPageComponent() {

    }

    function initPageEvent() {
        $("#login-form").form({
            success: function (strData) {
                var jsonData = $.parseJSON(strData);
                if (jsonData.result === "failed") {
                    console.error(jsonData.message);
                    return;
                } else {
                    document.location = SPIKE_PROJECT_NAME + "/home";
                }
            }
        });
    }

</script>
</html>
