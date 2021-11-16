<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/5
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证管理员验证码</title>
</head>
<body>
<form name="reg" action="/sign_in" method="post">
    管理员注册验证码: <input name="veri_code" type="text"/><br/>
    <input name="veri" type="text" value="1" style="display: none">
    <input type="submit" value="提交"></input>
</form>
</body>
</html>
