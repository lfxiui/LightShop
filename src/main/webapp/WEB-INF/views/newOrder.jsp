<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/13
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写订单</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/jquery-1.11.min.js"></script>
    <link href="${pageContext.servletContext.contextPath}/css/shopCartCSS/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css" />
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
    <!-- 导航-->
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
</head>
<body>
<!-- 导航--><jsp:include page="navigation.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h1>已完成订单！</h1>
        <p>亲，请耐心等待发货，发货后我们会邮件通知您！感谢您的消费，祝生活愉快。</p>

    </div>
</div>
</body>
</html>
