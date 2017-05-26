<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/24
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
<link rel="stylesheet" href="//rawgit.com/wenzhixin/bootstrap-table/master/src/bootstrap-table.css">
<link rel="stylesheet" href="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="//rawgit.com/wenzhixin/bootstrap-table/master/src/extensions/editable/bootstrap-table-editable.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <h1>在这打代码</h1>
        </div>
    </div>
</div>
</body>
</html>
