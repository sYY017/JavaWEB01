<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

欢迎:${sessionScope.user}登录<br/>
当前网站已被访问的次数是:${applicationScope.num}<br>
<a href="<%=application.getContextPath()%>/user?op=reset">注销</a>
<br>
<c:choose>
    <c:when test="${empty requestScope.message}"></c:when>
    <c:when test="${!empty requestScope.message}">警告:${requestScope.message}</c:when>
</c:choose>

<c:choose>
    <c:when test="${empty sessionScope.user}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:when>
</c:choose>

</body>
</html>
