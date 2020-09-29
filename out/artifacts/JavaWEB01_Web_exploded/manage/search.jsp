<%@ page import="java.util.List" %>
<%@ page import="com.tjetc.domain.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/index.css">
<%--    <%--%>
<%--        List<Emp> list = (List<Emp>) request.getAttribute("list");--%>
<%--        String u = (String) session.getAttribute("user");--%>
<%--        if (u == null) {--%>
<%--            request.setAttribute("message", "对不起请先登录!");--%>
<%--            request.getRequestDispatcher("login.jsp").forward(request, response);--%>
<%--        }--%>
<%--    %>--%>
    <%
        List<Emp> list = (List<Emp>) request.getAttribute("list");
    %>
</head>
<body>
<div class="container">
    <div class="main">
        <table>
            <thead>
            <tr>
                <th class="t2">
                    <h1>雇员查询系统</h1>
                </th>
            </tr>
            </thead>
            <tbody>
            <form action="../emp?op=find" method="post">
                <tr class="t3">
                    <td>
                        <label for="name1" style="margin-left: 20px"><strong>雇员姓名:</strong></label>
                        <input type="text" id="name1" name="empname" class="t4"/>
                    </td>
                </tr>
                <tr class="t3">
                    <td>
                        <label for="post1" style="margin-left: 20px"><strong>公司职位:</strong></label>
                        <select id="post1" name="post" class="t4">
                            <%
                                for (Emp emp : list) {
                            %>
                            <option value="<%=emp.getPostType()%>">
                                <%
                                    int num = emp.getPostType();
                                    String str2 = Integer.toString(emp.getPostType());
                                    if (num == 1) {
                                        String str = "行政助理";
                                        str2 = str;
                                    } else if (num == 2) {
                                        String str = "业务经理";
                                        str2 = str;
                                    } else if (num == 3) {
                                        String str = "总经理";
                                        str2 = str;
                                    }
                                %>
                                <%=str2%>
                            </option>
                            <%
                                }
                            %>

                        </select>
                    </td>
                </tr>
                <tr class="t6">
                    <td>
                        <input type="submit" name="btn" value="查询" class="t5"/>
                    </td>
                </tr>
            </form>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>
