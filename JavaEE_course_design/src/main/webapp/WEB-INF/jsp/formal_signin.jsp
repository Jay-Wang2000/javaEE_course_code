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
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("identity",0);
    %>
    <form name="reg" action="/shopping/addAccount" method="post">
    用户名: <input name="user" type="text" /><br/>
    密&nbsp;&nbsp;码：<input name="password" type="password" /><br/>
    再次输入密码：<input name="password'" type="password" /><br/>
    <input type="submit" value="注册" id="bt" />
    </form>
<p>
    <a href=sign_in.jsp>
        管理员注册
    </a>
</p>
</body>
</html>
