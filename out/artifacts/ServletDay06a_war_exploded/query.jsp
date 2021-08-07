<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/7 0007
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
     <form action="${pageContext.request.contextPath}/query.aa">

          品牌：<input  type="text" name="brandQuery"/>
          <br>
          ID：<input type="text" name="idQuery"/>
          <br>
          <input type="submit" value="查询"/>

     </form>



</body>
</html>
