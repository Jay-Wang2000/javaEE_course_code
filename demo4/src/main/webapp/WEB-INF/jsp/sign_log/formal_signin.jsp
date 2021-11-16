<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/5
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form name="reg" action="/addAccount" method="post">
    用户名: <input name="name" type="text"/><br/>
    密&nbsp;&nbsp;码：<input name="password" type="password"/><br/>
    再次输入密码：<input name="password'" type="password"/><br/>
    <input name="id" type="text" value="0" style="display: none">
    <input name="balance" type="text" value="1000" style="display: none">
    <input type="submit" value="注册"/>
</form>
<p>
    <a href="/si">
        管理员注册
    </a>
</p>
</body>
</html>
