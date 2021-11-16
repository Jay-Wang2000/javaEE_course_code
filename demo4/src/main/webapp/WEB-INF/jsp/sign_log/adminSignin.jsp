<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/8
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>
</head>
<body>
<%
    if (session.getAttribute("admin").equals(0)) {
%>
<p>请先返回输入管理员验证码</p>
<jsp:forward page="sign_in.jsp"></jsp:forward>
<%
} else {
%>
<form name="reg" action="/addAccount" method="post">
    用户名: <input name="name" type="text"/><br/>
    密&nbsp;&nbsp;码：<input name="password" type="password"/><br/>
    再次输入密码：<input name="password'" type="password"/><br/>
    <input name="id" type="number" value="1" style="display: none">
    <input name="balance" type="number" value="0" style="display: none">
    <input type="submit" value="注册" id="bt"/>
</form>
<%
    }
%>
</body>
</html>
