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
        <p>教师信息管理>更新教师信息</p>
    </div>
    <script type="text/javascript">
        function myclose() {
            window.location="${pageContext.request.contextPath}/admin/managermain";
            //window.close();
        }
    </script>
    <div id="table">
        <form action="${pageContext.request.contextPath}/teacherInfo/update.action" enctype="multipart/form-data" method="post" id="myform">
            <table>

                <tr>
                    <td class="one">教师姓名</td>
                    <td><input type="text" name="tname" class="two" value="${thisteacher.tname}"></td>
                </tr>

                <tr>
                    <td class="one">教师ID</td>
                    <td><input type="text" name="tid" class="two" value="${thisteacher.tid}"></td>
                </tr>

                <tr>
                    <td class="one">教师密码</td>
                    <td><input type="text" name="tpw" class="two" value="${tpw.tpw}"></td>
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
