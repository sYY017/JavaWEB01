<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.domain.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>系统后台模板</title>
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="../dashboard.css" rel="stylesheet" type="text/css">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">员工信息展示</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">员工信息 <span
                        class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>员工编号</th>
                        <th>职位名称</th>
                        <th>员工姓名</th>
                        <th>员工性别</th>
                        <th>员工年龄</th>
                        <th>部门名称</th>
                        <th>在职时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        Emp emp = (Emp) request.getAttribute("emp2");
                    %>
                    <th><%=emp.getId()%>
                    </th>
                    <th>
                        <%
                            int num = emp.getPostType();
                            String str2 = Integer.toString(emp.getPostType());
                            if (num == 1) {
                                String str = "行政助理";
                                str2 = str;
                            } else if (num == 2) {
                                String str = "业务经理";
                                str2 = str;
                            } else if (num == 3) {
                                String str = "总经理";
                                str2 = str;
                            }
                        %>
                        <%=str2%>
                    </th>
                    <th><%=emp.getEmpName()%>
                    </th>
                    <th>
                        <%
                            int num1 = emp.getEmpSex();
                            String str = null;
                            if (num1 == 1) {
                                str = "男";
                            } else if (num1 == 2) {
                                str = "女";
                            }
                        %>
                        <%=str%>
                    </th>
                    <th><%=emp.getEmpAge()%>岁
                    </th>
                    <th><%=emp.getEmpDepart()%>
                    </th>
                    <th><%=emp.getEmpYear()%>年
                    </th>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>
<script>window.jQuery || document.write('<script src="../js/jquery-1.11.1.min.js"><\/script>')</script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/holder.min.js"></script>

<%--<script>--%>
<%--    $(function () {--%>
<%--        $(".delBtn").click(function (event) {--%>
<%--            event.preventDefault();--%>
<%--            if (confirm("您确定要删除此部门信息吗?")) {--%>
<%--                window.location.href = $(this).attr("href");--%>
<%--            } else {--%>
<%--                alert("您已取消删除");--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>
