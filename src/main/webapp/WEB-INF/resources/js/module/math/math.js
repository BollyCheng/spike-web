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
            if (!question) {
                setTimeout(showExamScore, 300);
                return;
            }
            refreshQuestion();
        }
    });
}

function showExamScore() {
    $("#labTitle").text(examination.title + " (满分:" + examination.totalScore + " 分)");
    $("#labScore").text(examination.actualScore);
    showExamScorePanel();
}

