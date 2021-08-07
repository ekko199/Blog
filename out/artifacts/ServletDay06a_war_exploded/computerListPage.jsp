<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/12 0012
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>分页查询</title>
</head>
<body>
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
            <c:forEach  var="list" items="${list}">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.brand}</td>
                    <td>${list.country}</td>
                    <td>${list.production}</td>
                    <td>${list.sales}</td>
                    <td>${list.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/deleteComputer?id=${list.id}">删除</a>
                        <a href="${pageContext.request.contextPath}/ComputerFindById?id=${list.id}">修改</a>
                    </td>

                </tr>
            </c:forEach>

        </table>
        <table>
            <tr>
                <td>
                    总共&nbsp;&nbsp; ${info.totalPageCount}  &nbsp; &nbsp; &nbsp;  页
                    当前&nbsp;&nbsp;${info.pageNo}  &nbsp;&nbsp; 页
                    总共&nbsp;&nbsp; ${info.totalCount}        &nbsp;&nbsp; 条数据
                    <c:if test="${info.pageNo>1}">
                        <a href="${pageContext.request.contextPath}/computerPage.do?pageNo=1">首页</a>
                        <a href="${pageContext.request.contextPath}/computerPage.do?pageNo=${info.pageNo-1}">上一页</a>
                    </c:if>
                    <c:if test="${info.pageNo<info.totalPageCount}">
                        <a href="${pageContext.request.contextPath}/computerPage.do?pageNo=${info.pageNo+1}">下一页</a>
                        <a href="${pageContext.request.contextPath}/computerPage.do?pageNo=${info.totalPageCount}">末页</a>
                    </c:if>

                </td>
            </tr>
        </table>


</body>
</html>
