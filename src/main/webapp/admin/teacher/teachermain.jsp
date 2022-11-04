<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title></title>
    <%--<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >--%>
    <style type="text/css">

    </style>
</head>
<body>
<!--整体部分-->
<div id="all">

    <!--上部分-->
    <div id="top">

        <div id="top1">
            <span>选课系统</span>
        </div>

        <div id="top2"></div>

        <div id="top3">
            <span>欢迎您，${admin.tid}</span>
        </div>
    </div>

    <!--下部分-->
    <div id="bottom">
        <!--下部分左边-->
        <div id="bleft">
            <div id="ltop">
                <div id="lts">
                    <img src="${pageContext.request.contextPath}/myImage/logo.jpg" /><br />
                    <%--p:段落标签 text-align：设置元素中文本的对齐方式--%>
                    <p style="text-align: center;">${admin.tid}</p>
                </div>
            </div>
            <div id="lbottom">
                <ul><%--target 属性规定在何处打开链接文档--%>
                    <a href="${pageContext.request.contextPath}/grantedCourse/split.action?tid=${admin.tid}" target="myright" >
                        <%--&nbsp：一个空格 --%>
                        <li class="one"><span class="glyphicon glyphicon-adjust" style="color: white;"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看已授课程&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-play" style="color: white;"></span> </li>
                        <%--li标签定义列表项目。标签(全称为list item)是HTML语言中的一个元素标签。属于列表标签--%>
                    </a>
                    <a href="${pageContext.request.contextPath}/teachCourse/split.action?tid=${admin.tid}" target="myright">
                        <li class="one"><span class="glyphicon glyphicon-sort" style="color: white;"></span>&nbsp;&nbsp;&nbsp;&nbsp;授课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-play" style="color: white;"></span> </li>
                    </a>
                    <a href="${pageContext.request.contextPath}/admin/myLogin.jsp" >
                        <li class="one"><span class="glyphicon glyphicon-bullhorn" style="color: white"></span>&nbsp;&nbsp;&nbsp;&nbsp;登出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-play" style="color: white;"></span> </li>
                    </a>
                </ul>
            </div>
        </div>
        <!--下部分右边-->
        <div id="bright">
            <iframe frameborder="0" scrolling="yes" name="myright" width="1235px" height="700px" ></iframe>
        </div>
    </div>
</div>
</body>

</html>

