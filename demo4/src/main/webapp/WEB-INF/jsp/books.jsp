<%@ page import="com.example.demo.bean.Book" %>
<%@ page import="com.example.demo.repository.BookRepository" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/14
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品</title>
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
                        <th class="text-center">库存</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <c:forEach items="${requestScope.books}" var="book">
                        <tr>
                            <td>${book.index}</td>
                            <td>${book.name}</td>
                            <td>${book.price}</td>
                            <td>${book.repertory}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<a href="/customer/shoppingCart">购物车</a><br/>
<h3>加入购物车</h3>
<form name="reg" action="/customer/addBook" method="post">
    ID: <input name="index" type="text"/>
    数量: <input name="num" type="text"/>
    <input type="submit" value="加入购物车">
</form>
</body>
</html>
