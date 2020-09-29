<%--
  Created by IntelliJ IDEA.
  User: 鑫垚
  Date: 2020/9/28
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" cellpadding="20px">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>图片</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${list}" var="g">
        <tr>
            <td>${g.id}</td>
            <td>${g.name}</td>
            <td><img src="<%=application.getContextPath()%>/${g.image}" width="200px"/></td>
            <td>${g.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
