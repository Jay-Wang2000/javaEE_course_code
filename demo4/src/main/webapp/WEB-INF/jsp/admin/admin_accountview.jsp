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
    <title>欢迎管理员</title>
</head>
<body>
管理员：<%=session.getAttribute("user")%><br/>
<a href="/admin/books">查看库存</a><br/>
<a href="/admin/accounts">查看用户信息</a><br/>
<a href="/admin/actions">查看历史操作</a><br/>
<br/>
<a href="/logout">登出</a>
</body>
</html>
