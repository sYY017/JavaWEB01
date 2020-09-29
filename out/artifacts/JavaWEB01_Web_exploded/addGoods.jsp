<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="<%=application.getContextPath()%>/good?op=add">
    名称:<input type="text" name="goodsName" placeholder="请输入名称"/><br>
    图片:<input type="file" name="image"/><br>
    价格:<input type="number" name="price"/><br>
    <input type="submit" value="添加"/>
</form>
</body>
</html>
