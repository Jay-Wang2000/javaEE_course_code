<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/11
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功！</title>
</head>
<body>
注册成功！您的账号是：<%=request.getAttribute("index")%>，请牢记<br/>
<a href="/login">
    返回登录
</a>
</body>
</html>
