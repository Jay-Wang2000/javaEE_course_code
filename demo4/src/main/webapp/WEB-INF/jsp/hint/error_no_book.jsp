<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/12
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>没有此书！</title>
</head>
<body>
<%if(session.getAttribute("id").equals(1)){%>
<p>没有此书，请<a href="/admin/books">返回</a>重新输入！</p>
<%}else{%>
<p>没有此书，请<a href="/books">返回</a>重新输入！</p>
<%}%>
</body>
</html>
