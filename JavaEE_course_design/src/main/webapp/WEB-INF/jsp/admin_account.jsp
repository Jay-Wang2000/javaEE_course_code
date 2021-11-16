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
    if(session.getAttribute("user")== null){
%>
        <h1>请先登录！</h1>
        <jsp:forward page="../login.jsp"></jsp:forward> <h3>请先登录！</h3>
<%
    }else{
%>
</body>
</html>
