<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>购物车</title>
</head>
<body>
<div class="container">

    <div class="col-md-12">

        <div class="panel-body">
            <!-- table-responsive:响应式表格,在一个表展示所有的数据,当不够显示的时候可以左右滑动浏览-->
            <div class="table table-responsive">
                <!--
                    .table-bordered 类为表格和其中的每个单元格增加边框。
                    .table-hover 类可以让 <tbody> 中的每一行对鼠标悬停状态作出响应。
                -->
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">书名</th>
                        <th class="text-center">价格</th>
                        <th class="text-center">数量</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <c:forEach items="${requestScope.cart}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.name}</td>
                        <td>${book.price}</td>
                        <td>${book.quantity}</td>
                    </tr>
                    </c:forEach>
                    <thead>
                    </thead>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<h3>
    总价:<%=request.getAttribute("sum")%><br/>
    <% session.setAttribute("settlement", 1);%>
    <a href="/customer/settlement">下单</a><br/>
</h3>
<h3><a href="/books">返回继续购物</a><br/>
</h3>
删除项目
<form name="reg" action="/customer/delete" method="post">
    ID: <input name="index" type="text"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
