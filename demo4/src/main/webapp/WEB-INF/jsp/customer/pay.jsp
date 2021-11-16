<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/14
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付</title>
</head>
<body>
<h3>
    <h3>请确认订单</h3>
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
                            <td>${book.num}</td>
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
    <%=request.getAttribute("sum")%>
    <h3>请确认账户密码</h3>
    <form name="reg" action="/customer/confirm" method="post">
        账号: <input name="index" type="text"/><br/>
        密&nbsp;&nbsp;码：<input name="password" type="password"/><br/>
        <% session.setAttribute("confirm", 1);%>
        <input type="submit" value="确认"/>
    </form>
    <a href="/customer/cancel_settlement">取消订单</a>
</h3>
</body>
</html>
