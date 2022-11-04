<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <%--是一个做网页的框架（目前最流行的WEB前端框架），就是说你只需要写HTML标签调用它的类你就可以很快速的做一个高大上的网页，
    你不用担心兼容问题，提供了很多样式供你选择！比如你需要做一个网站的导航对吧，你自己写的话你需要写很多代码，
    但是如果你使用bootstrap框架来写的话，只需要写好HTML标签然后调用类名就可以了！
    作用：用它提供的样式和组件快速写网站
    你只需要引用一些定义好的类，也就是class名字，就可以创建出已经有非常漂亮的样式的网页，而且支持自适应，是一个很不错的框架。--%>
    <link rel="stylesheet" href="../css/bootstrap.css" />
    <link rel="stylesheet" href="../css/login.css" />
    <%--jQuery 是一个 JavaScript 函数库。jQuery 库包含以下特性：HTML 元素选取 HTML 元素操作 CSS 操作 HTML 事件函数 JavaScript 特效和动画
    HTML DOM 遍历和修改 AJAX Utilities--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title></title>
</head>

<body>
<div id="login">
    <div id="top">
        <img src="${pageContext.request.contextPath}/myImage/cloud.jpg" /><span>LOGIN</span>
    </div>
    <div id="bottom">
        <%--表单标签--%>
        <%--action：将表单中的数据发向action中，method:发送的方式:post:from表单里所填的值，附加在HTML Headers上。--%>
        <form  action="${pageContext.request.contextPath}/ast/login.action" method="post">
            <%--表格 border：边框的宽度是0就是无边框--%>
            <table border="0px" id="table">
                <%--tr定义行--%>
                <tr>
                    <%--td表示头部--%>
                    <td class="td1">账号名：</td>
                    <%--此placeholder属性可以在input没有任何输入或value的属性为空的情况下，
                    来提示用户在input中该输入什么样的内容，达到一个提示的作用。--%>
                    <td><input type="text" value="admin" placeholder="Username" class="td2" name="name"></td>
                </tr>


                <%--<tr>
                    <td></td>
                    &lt;%&ndash;span标签是使用来组合文档中的行内元素，以便使用样式来对它们进行格式化。
                    span标签本身并没有什么格式表现（比如：换行等），需要对它应用样式才会有视觉上的变化&ndash;%&gt;
                    <td><span id="nameerr"></span></td>
                </tr>--%>


                <tr>
                    <td class="td1">密码：</td>
                    <td><input type="password"  value="123456" placeholder="Password" class="td2" name="pwd"></td>
                </tr>


                <%--<tr>
                    <td></td>
                    <td><span id="pwderr"></span></td>
                </tr>--%>
                <tr>
                    <select name="type" id="type">
                        <option value="-1">请选择</option>
                        <%--不清楚这里为何这里不显示，其他两个都可以 <option>1</option>--%>
                        <option value="1">admin</option>
                        <option value="3">教师</option>
                        <option value="2">学生</option>
                    </select>
                </tr>

                <tr>
                    <td></td>
                    <%--提交按钮会把表单数据发送到服务器。--%>
                    <td><input type="submit" value="登录" class="td2">
                        <%--使用a标签来实现超链接。--%>
                        <%--href:是你想要跳转到那个页面的路径(也就是地址)，可以是下相对路径，也可以是绝对路径--%>

                    </td>
                </tr>


            </table>
        </form>
        ${errmsg}
    </div>

</div>
</body>

</html>