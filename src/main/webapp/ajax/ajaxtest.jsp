<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script>
        $(function () {
            $("#sub").click(function () {
                $.ajax({
                    url: "<%=application.getContextPath()%>/ajax",
                    type: "post",
                    data: {
                        "username": $("#username").val(),
                        "password": $("#pwd").val()
                    },
                    success: function (data) {
                         alert("你好登录成功");
                    },
                    error:function (data) {
                        alert("登录失败");
                    }
                });
            });
        });
    </script>
</head>
<body>
<form method="post" id="myform">
    <input type="text" id="username"/><br>
    <span id="sp"></span>
    <input type="password" id="pwd"/><br>
    <input type="submit" value="登录" id="sub"/>
</form>
</body>
</html>
