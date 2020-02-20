var examination;
var question;

$(function () {
    //初始化页面组件信息
    initPageComponent();
    //初始化页面事件
    initPageEvent();
});

function initPageComponent() {
    refreshQuestion();
}

function initPageEvent() {
    $("#btnStartExam, #btnRestartExam").unbind("click").bind("click", startExam);

    $("#options > a").unbind("click").bind("click", answerQuestion);
}

function showStartExamPanel() {
    $("#panelStartExam, #panelQuestion, #panelExamScore").css("display", "none");
    $("#panelStartExam").show();
}

function showQuestionPanel() {
    $("#panelStartExam, #panelQuestion, #panelExamScore").css("display", "none");
    $("#options > a").removeClass("active");
    $("#panelQuestion").show();
}

function showExamScorePanel() {
    $("#panelStartExam, #panelQuestion, #panelExamScore").css("display", "none");
    $("#panelExamScore").show();
}

function refreshQuestion() {
    if (!question) {
        $("#labTitle").text("数学测试");
        return;
    }
    $("#options > a").removeClass("active");
    $("#labTitle").text("第" + question.index + "/" + examination.totalCount + "题 (" + question.score + " 分)");
    $("#subject").text(question.subject);
    var optionList = question.options.split(";");
    for (var i = 0; i < 4; i++) {
        $("#options > a")[i].text = optionList[i];
    }
    // 结果
    $("#resultSuccess, #resultFailed").css("display", "none");
}

function startExam() {
    $.ajax({
        url: SPIKE_PROJECT_NAME + "/math/startExam",
        method: "post",
        dataType: "json",
        success: function (data) {
            if (data == null) {
                return;
            }
            examination = data.data.examination;
            question = data.data.question;
            refreshQuestion();
            showQuestionPanel();
        }
    });
}

function answerQuestion() {
    $("#options > a").removeClass("active");
    $(this).addClass("active");

    question.answer = this.text;
    $.ajax({
        url: SPIKE_PROJECT_NAME + "/math/answerQuestion",
        method: "post",
        dataType: "json",
        data: question,
        success: function (data) {
            question = data.data;
            $("#resultSuccess, #resultFailed").css("display", "none");
            if (question.actualScore > 0) {
                $("#resultSuccess").show();
            } else {
                $("#resultFailed").show();
            }
            // 启动延时(答对了，停留2秒，答错了，停留5秒)
            restSec = question.actualScore > 0 ? 2 : 10;
            refreshNextQuestionButton();
            clearInterval(intervalNextQuestion);
            intervalNextQuestion = setInterval(refreshRestTime, 100);
        }
    });
}

var intervalNextQuestion;
var restSec = -1;

function refreshNextQuestionButton() {
    if (restSec > 0) {
        $("#timeWait").text("(" + restSec.toFixed(1) + ")");
    } else {
        $("#timeWait").text("");
    }
}

function refreshRestTime() {
    restSec = restSec - 0.1;
    refreshNextQuestionButton();

    if (restSec <= 0) {
        if (question.index === examination.totalCount) {
            submitExam();
        } else {
            nextQuestion();
        }
    }
}

function nextQuestion() {
    if (!question.answer) {
        alert("请先选择答案.");
        return;
    }
    restSec = -1;
    clearInterval(intervalNextQuestion);
    $.ajax({
        url: SPIKE_PROJECT_NAME + "/math/findQuestionByExamIndex",
        method: "post",
        dataType: "json",
        data: {examId: examination.id, index: question.index + 1},
        success: function (data) {
            question = data.data;
            if (!question) {
                submitExam();
                return;
            }
            refreshQuestion();
        }
    });
}

function submitExam() {
    if (!question.answer) {
        alert("请先选择答案.");
        return;
    }
    $.ajax({
        url: SPIKE_PROJECT_NAME + "/math/submitExam",
        method: "post",
        dataType: "json",
        data: examination,
        success: function (data) {
            examination = data.data;
            showExamScore();
        }
    });
}

function showExamScore() {
    $("#labTitle").text(examination.title + " (满分:" + examination.totalScore + " 分)");
    $("#labScore").text(examination.actualScore);
    showExamScorePanel();
}

