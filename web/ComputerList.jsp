<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/7 0007
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>电脑列表</title>
</head>
<body>
<form>

</form>

    <table border="1" cellspacing="0" cellpadding="0" width="80%">
        <tr>
            <td>id</td>
            <td>brand</td>
            <td>country</td>
            <td>production</td>
            <td>sales</td>
            <td>price</td>
            <td>操作</td>
            <td>
                <a href="${pageContext.request.contextPath}/addComputer.jsp">添加</a>
            </td>

        </tr>
        <c:forEach  var="computer" items="${computer}">
            <tr>
                <td>${computer.id}</td>
                <td>${computer.brand}</td>
                <td>${computer.country}</td>
                <td>${computer.production}</td>
                <td>${computer.sales}</td>
                <td>${computer.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/deleteComputer?id=${computer.id}">删除</a>
                    <a href="${pageContext.request.contextPath}/ComputerFindById?id=${computer.id}">修改</a>
                </td>

            </tr>
        </c:forEach>

    </table>


</body>
</html>
