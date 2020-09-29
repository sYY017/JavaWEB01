<%--
  Created by IntelliJ IDEA.
  User: 鑫垚
  Date: 2020/9/25
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script>
        var user = {"id": 1, "username": "张三", "password": "123"};
        var country = ["中", "美", "俄"];
        var users = [
            {"id": 1, "username": "张三", "password": "123"},
            {"id": 2, "username": "李四", "password": "123"},
            {"id": 3, "username": "王五", "password": "123"}
        ];

        $(function () {
            $("#i").text(user.id);
            $("#username").text(user.username);
            $("#pwd").text(user.password);

            $.each(country, function (i, a) {
                $("#con").append("<li>" + a + "</li>");
                $("#se").append("<option value='" + i + "'>" + a + "</option>");
            });

            $.each(users, function (j, b) {
                $("#mt").append("<tr><td>"+b.id+"</td><td>"+b.username+"</td><td>"+b.password+"</td></tr>")
            });
        })
    </script>
</head>
<body>
<h3>用户信息展示</h3>
编号:<span id="i"></span><br>
用户名:<span id="username"></span><br>
密码:<span id="pwd"></span><br>

<h3>国家</h3>
<ul id="con">

</ul>

<select id="se">

</select>

<h3>用户表格</h3>
<table id="mt" border="1px">
    <tr>
        <th>编号</th>
        <th>用户名</th>
        <th>密码</th>
    </tr>

</table>
</body>
</html>
