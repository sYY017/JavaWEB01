<%--
  Created by IntelliJ IDEA.
  User: 鑫垚
  Date: 2020/9/25
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script>
        $(function () {
            $("#sub").click(function () {
                $.ajax({
                    url: "../ajax?op=like",
                    type: "post",
                    data: {
                        "keywords": $("#k").val(),
                    },
                    success: function (data) {
                        //data是一个json格式字符串 需要转换成json格式对象
                        //因为你要转换的数据本来就是object，这个方法是把一个字符串解析出json对象，你再转换就会报错;
                        //var arr = JSON.parse(data);
                        //console.log(data);
                        //获取table中的第一行tr进行保留
                        var tr = $("#mt").find("tr").first();
                        //清空table
                        $("#mt").empty();
                        //再把第一行内容加入进去
                        $("#mt").append(tr);
                        $.each(data, function (i, obj) {
                            $("#mt").append("<tr><td>" + obj.id + "</td><td>" + obj.postType + "</td><td>" + obj.empName +
                                "</td><td>" + obj.empSex + "</td><td>" + obj.empAge + "</td><td>" +
                                obj.empDepart + "</td><td>" + obj.empYear + "</td></tr>");
                        })
                    },
                    error: function () {
                        alert("数据获取失败");
                    },
                    dataType: 'json'
                });
            });
        });
    </script>
</head>
<body>
<input type="text" id="k"/>
<input type="submit" id="sub" value="查询"/>
<table border="1px" id="mt">
    <tr>
        <th>编号</th>
        <th>职位</th>
        <th>员工姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>部门名称</th>
        <th>工龄</th>
    </tr>
</table>
</body>
</html>
