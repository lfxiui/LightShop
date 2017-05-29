<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/24
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li><a href="">销售分析</a></li>
        <li ><a href="${pageContext.request.contextPath}/light/lightA">商品管理</a></li>
        <li><a href="#demo" aria-expanded="false"  aria-controls="demo" data-toggle="collapse"  >类目管理<span class="pull-right glyphicon glyphicon-chevron-down"></span></a>
            <ul class="list-group collapse" id="demo" style="margin-left: 30px">
                <li class="list-group-item"><a href="" >风格</a></li>
                <li class="list-group-item"><a href="" >材质</a></li>
                <li class="list-group-item"><a href="" >品牌</a></li>
                <li class="list-group-item"><a href="" >适用空间</a></li>
                <li class="list-group-item"><a href="" >光源类型</a></li>
            </ul>
        </li>
        <li><a href="#demo2" aria-expanded="false"  aria-controls="demo" data-toggle="collapse"  >订单管理<span class="pull-right glyphicon glyphicon-chevron-down"></span></a>
            <ul class="list-group collapse" id="demo2" style="margin-left: 30px">
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/ordersManager/show" >查看订单</a></li>
                <li class="list-group-item"><a href="${pageContext.request.contextPath}/ordersManager/orderStates" >订单状态管理</a></li>
            </ul>
        </li>
        <li><a href="" >用户管理</a></li>

    </ul>
</div>
</body>
</html>
