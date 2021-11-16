<%--
  Created by IntelliJ IDEA.
  User: 汪杰
  Date: 2021/11/13
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>操作历史</title></head>
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
                        <th class="text-center">时间</th>
                        <th class="text-center">管理员名</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    <c:forEach items="${requestScope.actions}" var="action">
                        <tr>
                            <td>${action.time}</td>
                            <td>${action.name}</td>
                            <td>${action.action}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<a href="/account">返回账户界面</a>
</body>
</html>

