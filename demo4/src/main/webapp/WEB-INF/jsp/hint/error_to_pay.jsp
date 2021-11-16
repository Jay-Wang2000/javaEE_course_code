<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/14
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有订单！</title>
</head>
<body>
<%if((int)request.getAttribute("noGoodinCart")==1){%>
    购物车为空
<%}else{%>
没有订单可以支付！<br/>
<%}%>
<a href="/customer/shoppingCart">购物车</a>
</body>
</html>
