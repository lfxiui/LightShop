<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/24
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">灯饰后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><img  class="img-responsive" alt="Cinque Terre" src="${pageContext.servletContext.contextPath}${user.photo}" height="20px" width="30px"></li>
                <li><a href="#">${user.employeeName}</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/out">退出登录</a></li>
            </ul>
        </div>
    </div>

</nav>
</body>
</html>
