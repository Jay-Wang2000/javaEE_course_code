<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/12
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>账户</title></head>
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
                        <th class="text-center">账号</th>
                        <th class="text-center">用户名</th>
                        <th class="text-center">密码</th>
                        <th class="text-center">余额</th>
                        <th class="text-center">身份(0为普通用户，1为管理员)</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <c:forEach items="${requestScope.accounts}" var="user">
                        <tr>
                            <td>${user.index}</td>
                            <td>${user.name}</td>
                            <td>${user.password}</td>
                            <td>${user.balance}</td>
                            <td>${user.id}</td>
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
<form name="reg" action="/admin/addAccount" method="post">
    用户名 ：<input name="name" type="text"/>
    密 码 ：<input name="password" type="text"/>
    余额 ：<input name="balance" type="text"/>
    <input type="submit" value="提交">
</form>
<h3>修改账户密码</h3>
<form name="reg" action="/admin/password" method="post">
    账号: <input name="index" type="text"/>
    密码: <input name="password" type="text"/>
    <input type="submit" value="提交">
</form>
<h3>修改余额</h3>
<form name="reg" action="/admin/balance" method="post">
    账号: <input name="index" type="text"/>
    余额: <input name="balance" type="text"/>
    <input type="submit" value="提交">
</form>
<h3>删除项目</h3>
<form name="reg" action="/admin/deleteAccount" method="post">
    账号: <input name="index" type="text"/>
    <input type="submit" value="提交"><br/>
</form>
</form>
</form>
<a href="/account">返回账户界面</a>
</body>
</html>
