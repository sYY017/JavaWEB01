<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
               $.get("<%=application.getContextPath()%>/ajax?op=gettest",function (data) {
                    alert(data);
               });
            });
        })
    </script>
</head>
<body>
<button id="btn">点击以下</button>
</body>
</html>
