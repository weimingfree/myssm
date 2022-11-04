<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/addBook.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
</head>

<body>
<div id="addAll">
    <div id="nav">
        <p>课程信息管理>更新课程信息</p>
    </div>
    <script type="text/javascript">
        function myclose() {
            window.location="${pageContext.request.contextPath}/courseInfo/split.action";
            //window.close();
        }
    </script>
    <div id="table">
        <form action="${pageContext.request.contextPath}/courseInfo/update.action" enctype="multipart/form-data" method="post" id="myform">
            <table>

                <tr>
                    <td class="one">课程名</td>
                    <td><input type="text" name="cname" class="two" value="${thiscourse.cname}"></td>
                </tr>

                <tr>
                    <td class="one">课程ID</td>
                    <td><input type="text" name="cid" class="two" value="${thiscourse.cid}"></td>
                </tr>

                <tr>
                    <td class="one">教师名</td>
                    <td><input type="text" name="ctname" class="two" value="${thiscourse.ctname}"></td>
                </tr>
                <tr>
                    <td class="one">教师工号</td>
                    <td><input type="text" name="ctid" class="two" value="${thiscourse.ctid}"></td>
                </tr>

                <tr>
                    <td>
                        <input type="submit" value="提交" class="btn btn-success">
                    </td>
                    <td>
                        <input type="reset" value="取消" class="btn btn-default" onclick="myclose()">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>

</html>
