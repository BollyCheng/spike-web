/**
 * 全局常量
 * Author   : Bolly
 * CreateAt : 2018/04/05 10:27:16
 */
//当前网址，如： http://localhost:8088/spike/home.jsp
var SPIKE_CURRENT_PATH = window.document.location.href;
//主机地址之后的目录，如： spike/home.jsp
var SPIKE_PATH_NAME = window.document.location.pathname;
//主机地址，如： http://localhost:8088
var SPIKE_LOCALHOST_PATH = SPIKE_CURRENT_PATH.substring(0, SPIKE_CURRENT_PATH.indexOf(SPIKE_PATH_NAME));
//项目名(含"/")，如：/spike
var SPIKE_PROJECT_NAME = SPIKE_PATH_NAME.substring(0, SPIKE_PATH_NAME.substr(1).indexOf('/') + 1);
//项目根目录，如：http://localhost:8088/spike
var SPIKE_ROOT_PATH = SPIKE_LOCALHOST_PATH + SPIKE_PROJECT_NAME;

