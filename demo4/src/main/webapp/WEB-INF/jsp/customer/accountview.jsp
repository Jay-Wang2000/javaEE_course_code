<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎客户</title>
</head>
<body>
用户名：<%=session.getAttribute("user")%>
余额 ：<%=request.getAttribute("balance")%><br/>
<a href="/customer/shoppingCart">购物车</a>
<a href="/books">购买书籍</a><br/>
<br/>
<a href="/logout">登出</a>
</body>
</html>
