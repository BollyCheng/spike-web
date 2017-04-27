
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>三级下拉菜单导航栏</title>
    <style type="text/css">
        *{
            padding: 0;
            margin: 0;
        }
        ul{
            list-style-type:none;
        }
        .triangle{

            font-size: 1em;
            color: white;
        }
        a{
            text-decoration:none;
            text-align: center;
            font-weight: bold;

        }
        /*一级导航*/
        ul.nav{
            float: left;
            border:1px solid gray;
            margin-left: 10%;
            margin-top:10px;
            border-radius: 4px;
            position: fixed;
        }
        ul.nav li{
            float: left;
            width: 9em;
            background-color:yellowgreen;
        }
        ul.nav a{
            display: block;
            color: white;
            line-height: 1.5em;
            border-right: 1px solid white;
            border-left: 1px solid white;
            padding: 5px;
        }

        ul.nav a:hover,
        ul.nav a:focus{
            color: black;
            background-color: #98FB98;
            opacity: 0.5;
        }
        ul.nav li:first-child a{
            border-left: 0;
            border-bottom: 0;
        }
        ul.nav li:last-child a{
            border-right: 0;
            border-bottom: 0;
        }
        /*二级导航*/
        ul.nav li ul{
            width: 10em;
            position: absolute;
            left: -1000em;
        }

        ul.nav li:hover ul{
            width: 10em;
            left:auto;
        }

        ul.nav li ul a{
            border-top: 1px solid white;
            border-bottom: 1px solid white;
            border-left: 0;
            border-right: 0;

        }
        /*三级导航*/
        ul.nav li:hover ul li ul{
            width: 10em;
            position: absolute;
            left: -1000em;

        }

        ul.nav li:hover ul li:hover ul{
            left: auto;
            margin-left: 9.1em;
            margin-top: -2.1em;
        }
        ul.nav li:hover ul li:hover ul.nav1{
            left: auto;
            margin-left: -9.1em;
            margin-top: -2.1em;
        }
    </style>
</head>
<body bgcolor="aliceblue">
<ul class="nav">
    <li>
        <a href="" target="_blank">
            手机数码<span class="triangle">▼</span></a>
        <ul>
            <li><a href="http://baidu.com" target="_blank">
                手机 <span class="triangle">▶</span>
            </a>
                <ul>
                    <li><a href="">小米</a></li>
                    <li><a href="">华为</a></li>
                    <li><a href="">魅族</a></li>
                </ul>
            </li>
            <li><a href="">
                电脑 <span class="triangle">▶</span>
            </a>
                <ul>
                    <li><a href="">平板</a></li>
                    <li><a href="">笔记本</a></li>
                    <li><a href="">台式</a></li>
                </ul>
            </li>
            <li><a href="">相机</a></li>
        </ul>
    </li>
    <li><a href="">男装女装<span class="triangle">▼</span></a>
        <ul>
            <li><a href="">
                上衣 <span class="triangle">▶</span></a>
                <ul>
                    <li><a href="">衬衫</a></li>
                    <li><a href="">T恤</a></li>
                </ul>
            </li>
            <li><a href="">
                裤子 <span class="triangle">▶</span></a>
                <ul>
                    <li><a href="">牛仔裤</a></li>
                    <li><a href="">休闲裤</a></li>
                </ul>
            </li>
        </ul>
    </li>
    <li><a href="">运动户外<span class="triangle">▼</span></a>
        <ul>
            <li><a href="">运动鞋</a></li>
            <li><a href="">运动服</a></li>
            <li><a href="">运动设备</a></li>
        </ul>
    </li>
    <li>
        <a href="">时尚百货</a>
    </li>
    <li><a href="">生活服务<span class="triangle">▼</span></a>
        <ul>
            <li><a href="">万能缴费</a></li>
            <ul>
                <li><a href="">水费</a></li>
                <li><a href="">电费</a></li>
            </ul>
            <li><a href="">教育培训</a></li>
            <li><a href="">话费充值</a></li>
        </ul>
    </li>
    <li>
        <a href="">   汇吃美食</a>
    </li>
    <li>
        <a href="">   家居家纺<span class="triangle">▼</span></a>
        <ul>
            <li><a href="">
                <span class="triangle">◀</span> 床上用品</a>
                <ul class="nav1">
                    <li><a href="">被子</a></li>
                    <li><a href="">枕头</a></li>
                </ul>
            </li>
            <li>
                <a href=""><span class="triangle">◀</span> 客厅家具</a>
                <ul class="nav1">
                    <li><a href="">茶具</a></li>
                    <li><a href="">沙发</a></li>
                    <li><a href="">椅子</a></li>
                </ul>
            </li>
        </ul>
    </li>
</ul>
</body>
</html>