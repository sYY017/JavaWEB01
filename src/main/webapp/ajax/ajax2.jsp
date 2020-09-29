<%--
  Created by IntelliJ IDEA.
  User: 鑫垚
  Date: 2020/9/25
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    账号:<input type="text" id="username"/>
    <span id="sp" style="color: red"></span>

    <script src="../js/jquery-1.11.1.min.js"></script>
    <script>
        $(function () {
            $("#username").blur(function () {
                $.ajax({
                    url: "<%=application.getContextPath()%>/ajax?op=jiao",
                    type: "post",
                    data: {
                        "username": $("#username").val()
                    },
                    success: function (data) {
                        $("#sp").text(data);
                    }
                });
            });
        });
    </script>
</body>
</html>
