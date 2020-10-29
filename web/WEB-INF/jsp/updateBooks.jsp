﻿<%--
  Created by IntelliJ IDEA.
  User: YuanbaoQiang
  Date: 2020/10/25
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
    <%--    bootstrap美化页面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/updateBooks" method="post">
<%--        出现的问题：提交修改的sql请求，但是修改失败--%>
<%--        看一下sql语句，查看是否可以执行成功--%>
<%--    前端传递隐藏域--%>
        <input type="hidden" name="bookId" value="${QBook.bookId}"/>
        <div class="form-group">
            <label>书籍名称：</label>
            <input type="text" name="bookName" class="form-control" value="${QBook.bookName}" required>
        </div>

        <div class="form-group">
            <label>书籍数量：</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBook.bookCounts}" required>
        </div>

        <div class="form-group">
            <label>书籍描述：</label>
            <input type="text" name="detail" class="form-control" value="${QBook.detail}" required>
        </div>

        <div class="form-group">
            <input type="submit" class="form-control" value="提交">
        </div>
    </form>

</div>

</body>
</html>
