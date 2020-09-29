<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script>
        $(function () {
            $("#myform").submit(function () {
                var data = $("#myform").serializeArray();
                var s=JSON.stringify(data);
                $("#myDiv").empty().text(s);
                $.each(data,function (i,obj) {
                    $("#myDiv").append("<p>"+obj.name+"-------------"+obj.value+"</p>");
                });
                return false;
            });
        });
    </script>
</head>
<body>

<form id="myform" method="post">
    账号:<input type="text" name="username"/><br/>
    密码:<input type="password" name="pwd"/><br/>
    性别:<input type="radio" name="sex" value="男"/>男
    <input type="radio" name="sex" value="女"/>女<br/>
    <input type="submit" name="sub"/>
</form>

<div id="myDiv"></div>

</body>
</html>
