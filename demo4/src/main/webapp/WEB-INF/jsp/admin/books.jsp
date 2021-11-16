<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 汪杰--%>
<%--  Date: 2021/11/5--%>
<%--  Time: 10:43--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>库存</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="panel panel-primary">--%>
<%--    <!-- .panel-heading 面板头信息。 -->--%>
<%--    <div class="panel-heading">--%>
<%--        <!-- .panel-title 面板标题。 -->--%>
<%--        <h3 class="panel-title">Spring Boot添加JSP示例</h3>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="container">--%>

<%--    <div class="col-md-12">--%>

<%--        <div class="panel-body">--%>
<%--            <!-- table-responsive:响应式表格,在一个表展示所有的数据,当不够显示的时候可以左右滑动浏览-->--%>
<%--            <div class="table table-responsive">--%>
<%--                <table class="table table-bordered table-hover">--%>
<%--                    <thead>--%>
<%--                        <tr>--%>
<%--                            <th class="text-center">书名</th>--%>
<%--                            <th class="text-center">价格</th>--%>
<%--                            <th class="text-center">库存</th>--%>
<%--                        </tr>--%>
<%--                    </thead>--%>
<%--                    <tbody class="text-center">--%>
<%--                        <c:forEach var="book" items="${requestScope.books}">--%>
<%--                            <tr>--%>
<%--                                <td>${books.name}<td/>--%>
<%--                                <td>${books.price}<td/>--%>
<%--                                <td>${books.repertory}<td/>--%>
<%--                            <tr/>--%>
<%--                        </c:forEach>--%>
<%--                    </tbody>--%>
<%--                </table>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>库存</title></head>
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
</div>

<h3>增加项目</h3>
<form name="reg" action="/admin/addBook" method="post">
    书名: <input name="name" type="text"/>
    价格：<input name="price" type="text"/>
    库存：<input name="repertory" type="text"/>
    <input type="submit" value="提交">
</form>
<h3>更改库存</h3>
<form name="reg" action="/admin/repertory" method="post">
    ID: <input name="index" type="text"/>
    库存：<input name="repertory" type="text"/>
    <input type="submit" value="提交">
</form>
<h3>更改价格</h3>
<form name="reg" action="/admin/price" method="post">
    ID: <input name="index" type="text"/>
    库存：<input name="price" type="text"/>
    <input type="submit" value="提交">
</form>
<h3>删除项目</h3>
<form name="reg" action="/admin/deleteBook" method="post">
    ID: <input name="index" type="text"/>
    <input type="submit" value="提交">
</form>
<a href="/account">返回账户界面</a>
</form>
</body>
</html>