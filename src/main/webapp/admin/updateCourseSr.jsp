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
        <p>选课记录管理>更新选课记录</p>
    </div>
    <script type="text/javascript">
        function myclose() {
            window.location="${pageContext.request.contextPath}/courseSr/split.action";
            //window.close();
        }
    </script>
    <div id="table">
        <form action="${pageContext.request.contextPath}/courseSr/update.action" enctype="multipart/form-data" method="post" id="myform">
            <table>
                <tr>
                    <td><input type="hidden" name="hideid" class="two" value="${thiscourseSr.hideid}"></td>
                </tr>
                <tr>
                    <td class="one">课程名</td>
                    <td><input type="text" name="cname" class="two" value="${thiscourseSr.cname}"></td>
                </tr>

                <tr>
                    <td class="one">课程ID</td>
                    <td><input type="text" name="cid" class="two" value="${thiscourseSr.cid}"></td>
                </tr>

                <tr>
                    <td class="one">教师名</td>
                    <td><input type="text" name="tname" class="two" value="${thiscourseSr.tname}"></td>
                </tr>
                <tr>
                    <td class="one">教师id</td>
                    <td><input type="text" name="tid" class="two" value="${thiscourseSr.tid}"></td>
                </tr>
                <tr>
                    <td class="one">学生姓名</td>
                    <td><input type="text" name="sname" class="two" value="${thiscourseSr.sname}"></td>
                </tr>
                <tr>
                    <td class="one">学生id</td>
                    <td><input type="text" name="sid" class="two" value="${thiscourseSr.sid}"></td>
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

