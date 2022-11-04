<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <script type="text/javascript">
        if ("${msg}" != "") {
            alert("${msg}");
        }
    </script>
    <c:remove var="msg"></c:remove>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bright.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <title></title>
</head>

<body>
<div id="brall">
    <div id="nav">
        <p>课程管理>已选课程列表</p>
    </div>
    <%--查询--%>
    <div id="condition" style="text-align: center">
        <form id="myform2">
            教师姓名：<input name="selecttname" id="selecttname">
            <input type="button" value="查询" onclick="conditionByTname()">
        </form>
        <form id="myform3">
            课程名：<input name="selectcname" id="selectcname">
            <input type="button" value="查询" onclick="conditionByCname()">
        </form>
    </div>

    <%--换行标签--%>
    <br>

    <div id="table">
        <c:choose>
            <c:when test="${info.list.size()!=0}">
                <%-- <div id="top">
                         &lt;%&ndash;新增&ndash;%&gt;
                     <a href="${pageContext.request.contextPath}/admin/addCourseSr.jsp">
                         <input type="button" class="btn btn-warning" id="btn2"
                                value="新增选课记录">
                     </a>
                 </div>--%>

                <div id="middle">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>课程号</th>
                            <th>课程名</th>
                            <th>教师名</th>
                            <th>教师号</th>
                            <th>学生名</th>
                            <th>学生号</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${info.list}" var="csr"><%--这里原来是info.list，但视频中的代码是list--%>
                            <tr>
                                <td>${csr.cid}</td>
                                <td>${csr.cname}</td>
                                <td>${csr.tname}</td>
                                <td>${csr.tid}</td>
                                <td>${csr.sname}</td>
                                <td>${csr.sid}</td>
                                    <%--<td><a href="${pageContext.request.contextPath}/admin/product?flag=delete&pid=${p.pId}" onclick="return confirm('确定删除吗？')">删除</a>--%>
                                    <%--&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/product?flag=one&pid=${p.pId}">修改</a></td>--%>
                                <td>
                                    <button type="button" class="btn btn-warning" id="mydel"
                                            onclick="del(${csr.hideid})">退选
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <!--分页栏-->
                    <div id="bottom">
                        <div>
                                <%--nav标签只是用来表示该区域是导航链接，默认并没有什么显示效果。--%>
                            <nav aria-label="..." style="text-align:center;">
                                <ul class="pagination">
                                    <li>
                                            <%--aria-label 不会在视觉上呈现效果，只是方便设备读取备注--%>
                                        <a href="javascript:ajaxsplit(${info.prePage})" aria-label="Previous">
                                            <span aria-hidden="true">«</span></a>
                                    </li>
                                    <c:forEach begin="1" end="${info.pages}" var="i">
                                        <%-- <li>${i}</li>--%>
                                        <c:if test="${info.pageNum==i}">
                                            <li>
                                                    <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}" style="background-color: grey">${i}</a>--%>
                                                <a href="javascript:ajaxsplit(${i})"
                                                   style="background-color: grey">${i}</a>
                                            </li>
                                        </c:if>
                                        <c:if test="${info.pageNum !=i}">
                                            <li>
                                                    <%--                                                <a href="${pageContext.request.contextPath}/prod/split.action?page=${i}">${i}</a>--%>
                                                <a href="javascript:ajaxsplit(${i})">${i}</a>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                    <li>
                                            <%--  <a href="${pageContext.request.contextPath}/prod/split.action?page=1" aria-label="Next">--%>
                                        <a href="javascript:ajaxsplit(${info.nextPage})" aria-label="Next">
                                            <span aria-hidden="true">»</span></a>
                                    </li>
                                    <li style=" margin-left:150px;color: #0e90d2;height: 35px; line-height: 35px;">总共&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">${info.pages}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <c:if test="${info.pageNum!=0}">
                                            当前&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">${info.pageNum}</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </c:if>
                                        <c:if test="${info.pageNum==0}">
                                            当前&nbsp;&nbsp;&nbsp;<font
                                            style="color:orange;">1</font>&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        </c:if>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <h2 style="width:1200px; text-align: center;color: orangered;margin-top: 100px">暂时没有符合条件的课程！</h2>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>

<script type="text/javascript">


    //单个删除
    function del(cid) {
        //弹框提示
        if (confirm("确定删除吗")) {
            //发出ajax的请求，向服务器提交请求完成删除
            $.ajax({
                url:"${pageContext.request.contextPath}/courseSr/delete.action",
                data:{"hideid":cid},
                type:"post",
                dataType:"text",
                success:function (msg){
                    alert(msg);
                    $("#table").load("http://localhost:8080/admin/lookCourseInfo.jsp #table");
                }
            });
        }
    }
    //编辑
    function one(cid) {
        //向服务器提交请求，传递商品id
        var str ="?hideid="+cid;
        location.href = "${pageContext.request.contextPath}/courseSr/one.action" + str ;
    }
</script>
<!--分页的AJAX实现-->
<script type="text/javascript">
    function ajaxsplit(page) {
        //异步ajax分页请求
        //向服务器发出ajax请求，请求page页中的所有数据，在当前页面上局部刷新显示
        $.ajax({
            url:"${pageContext.request.contextPath}/courseSr/ajaxSplit.action",
            data:{"spage":page},
            type:"post",
            success:function () {
                //重新加载显示分页数据的容器
                //location.href---->http://localhost:8080/admin/login.action
                $("#table").load("http://localhost:8080/admin/studnet/lookCourseInfo.jsp #table");
            }
        });
    }
    //查询
    function conditionByCname(){
        //取出查询的条件
        var cname = $("#selectcname").val();
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/courseSr/conditionByCname.action",
            data:{"cname":cname},
            success:function (){
                //刷新显示数据的容器
                $("#table").load("http://localhost:8080/admin/studnet/lookCourseInfo.jsp #table")
            }
        })
    }
    function conditionByTname(){
        //取出查询的条件
        var tname = $("#selecttname").val();
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/courseSr/conditionByTname.action",
            data:{"tname":tname},
            success:function (){
                //刷新显示数据的容器
                $("#table").load("http://localhost:8080/admin/student/lookCourseInfo.jsp #table")
            }
        })
    }
</script>

</html>

