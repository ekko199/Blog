<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/7 0007
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加数据</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<%--      <script>--%>
<%--            $(function () {--%>
<%--                  alert("测试是否可以使用")--%>
<%--            })--%>
<%--      </script>--%>

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
      请输入添加的数据
      <form action="${pageContext.request.contextPath}/computerAdd" method="post" onsubmit="return cccc();">
            ID:  <input type="text" name="id"/>
            <br>
            品牌：<input type="text" name="brand" onblur="checkBrand(this.value)"/>
            <font id="brandErr"></font>
            <br>
            国家：<input type="text" name="country"/>
            <br>
            日期：<input type="text" name="production"/>
            <br>
            销售额：<input type="text" name="sales"/>
            <br>
            价格：<input type="text" name="price"/>
            <br>
            <input type="submit" value="添加">
            <br>
      </form>

</body>
</html>
