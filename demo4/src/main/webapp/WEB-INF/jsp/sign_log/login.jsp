<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/5
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<form name="reg" action="/account" method="post">
    账号: <input name="index" type="text"/><br/>
    密&nbsp;&nbsp;码：<input name="password" type="password"/><br/>
    <input name="login" type="text" value="1" style="display: none"/><br/>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
