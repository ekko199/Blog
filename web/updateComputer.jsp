<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/8 0008
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改数据</title>
    <script>
        function  checkBrand(brand) {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkBrand.do",
                data: "brand="+brand+"&location=Boston",
                success: function(msg) {
                    var brandErr=document.getElementById("brandErr");
                    if (msg == 0) {
                        brandErr.innerHTML="用户名重复不可以使用该用户名";
                    } else {
                        brandErr.innerHTML="可以使用该用户名";
                    }
                }
            })
        }
        function cccc() {
            var brandErr=document.getElementById("brandErr").innerHTML;
            if (brandErr=='可以使用该用户名'){
                alert("可以使用该用户名")
            }else {
                alert("用户名重复不可以使用该用户名")
                return false;
            }

        }

    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/updateComputer.do" method="post" method="post" onsubmit="return cccc();">
        <br>
        <input name="id" value="${computer.id}" type="hidden">
        品牌：<input name="brand" value="${computer.brand}" onblur="checkBrand(this.value)" >


        销售额：<input name="sales" value="${computer.sales}">

        价格：<input  name="price" value="${computer.price}">
        <br>
        国家：<input type="radio" name="country" value="中国" <c:if test="${computer.country=='中国'}">checked</c:if>>中国
        <input type="radio" name="country" value="美国" <c:if test="${computer.country=='美国'}">checked</c:if>>美国
        <input type="radio" name="country" value="其他" <c:if test="${computer.country=='其他'}">checked</c:if>>其他
        <br>

             <input type="submit" value="提交">


    </form>


</body>
</html>
