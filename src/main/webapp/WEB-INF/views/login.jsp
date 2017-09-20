<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/31
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.servletContext.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.js"></script>
<link href="${pageContext.servletContext.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.servletContext.contextPath}/css/signin.css" rel="stylesheet">
<head>
    <title>登陆</title>
</head>
<body>
<div class="container">
    <form class="form-signin" action="${pageContext.servletContext.contextPath}/login/submit">
        <h2 class="form-signin-heading">请登录</h2>
        <h2 class="text-danger">${msg}</h2>
        <label for="inputLoginId" class="sr-only">邮箱地址</label>
        <input type="text" id="inputLoginId" class="form-control" placeholder="账号" name="loginId" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码"name="password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </form>
</div>
</body>
</html>
