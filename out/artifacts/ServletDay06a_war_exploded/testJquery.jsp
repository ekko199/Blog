<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/13 0013
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script>
    $(function () {
        alert("测试是否可以使用")
    })
</script>
<script>
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/checkBrand.do",
        data: "brand="+brand+"&location=Boston",
        success: function(msg){
            var brandErr=document.getElementById("brandErr");
            if (msg==0){
                brandErr.innerHTML="用户名已经注册不能再注册";
            }else {
                brandErr.innerHTML="用户名可以使用";
            }
        }
    });
</script>

</body>
</html>
