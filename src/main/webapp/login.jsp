<%@ page import="java.util.UUID" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        session.setAttribute("key", UUID.randomUUID().toString());
    %>
</head>
<body>
<h2>登录页面</h2>
${message}
<form action="<%=application.getContextPath()%>/user?op=login" method="post">
    <input type="hidden" name="token" value="${key}"/>
    用户名: <input type="text" name="username"/><br>
    密&nbsp;&nbsp;&nbsp;码: <input type="password" name="pwd"/><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
