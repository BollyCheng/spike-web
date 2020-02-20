<%--
  Author  : Bolly
  CreatAt : 2017/9/23 23:47
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="spike-content">
    <div class="spike-content-header">
        <div class="spike-content-header-breadcrumb">
            <label class="spike-content-header-title">
                <span id="labTitle"></span>
            </label>
        </div>
        <div class="spike-content-header-search"></div>
    </div>
    <div class="spike-content-main">
        <div id="panelStartExam" style="display:block;text-align: center">
            <a id="btnStartExam" type="btn" href="javascript:void(0);">开始考试</a>
        </div>
        <div id="panelQuestion" style="display: none;">
            <table style="width: 100%">
                <tr>
                    <td>
                        <div style="display: block;text-align: center;">
                            <span id="subject" class="number">12 + ? = 21</span>
                        </div>
                        <div id="result">
                            <span id="resultSuccess" style="color:green;">恭喜你，回答正确</span>
                            <span id="resultFailed" style="color: red;">很遗憾，回答错误</span>
                            <span id="timeWait"></span>
                        </div>
                    </td>
                    <td style="width: 380px">
                        <div id="options">
                            <a href="javascript:void(0);" class="btn active">A.23</a>
                            <a href="javascript:void(0);" class="btn">B.32</a>
                            <a href="javascript:void(0);" class="btn">C.33</a>
                            <a href="javascript:void(0);" class="btn">D.43</a>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div id="panelExamScore" style="display: none; text-align: center">
            <div style="font-size: 100px">
                <span>总分：</span><span id="labScore">100</span><span> 分</span>
            </div>
            <div>
                <a id="btnRestartExam" type="btn" href="javascript:void(0);">再来一次</a>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<spring:url value="/resources/js/module/math/math.js" /> "></script>
<style type="text/css">
    .spike-content-main, table {
        text-align: center;
        vertical-align: middle;
    }

    #btnStartExam, #btnRestartExam {
        border: 2px solid;
        border-color: #8c8c8c;
        border-radius: 5px;
        height: 100px;
        padding: 0 20px;
        line-height: 80px;
        font-size: 80px;
    }

    #subject {
        display: inline-block;
        height: 100px;
        line-height: 100px;
        font-size: 100px;
    }

    #options {
        height: 160px;
        margin-top: 20px;
    }

    #options > a {
        display: inline-block;
        width: 160px;
        font-size: 60px;
        height: 60px;
        line-height: 60px;
        margin: 10px;
    }

    #options > a.btn {
        color: black;
        border: 2px solid;
        border-color: #8c8c8c;
        border-radius: 5px;
        padding: 0 10px;
    }

    #options > a.active {
        border-color: blue;
    }

    #result {
        margin-top: 20px;
        height: 30px;
        line-height: 30px;
        font-size: 30px;
    }

</style>