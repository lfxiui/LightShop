<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/20
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>我的订单</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/jquery-1.11.min.js"></script>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
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
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">我的订单<small>MyOrders</small></h3>
    </div>
    <ul class="nav nav-pills" style="width: 80%;margin:10 auto;">
        <input type="hidden" name="" id="state" value="${state}">
        <li id="li1"><a href="${pageContext.request.contextPath}/order/getMyOrders?state=0">所有订单</a></li>
        <li id="li2"><a href="${pageContext.request.contextPath}/order/getMyOrders?state=1">未发货订单</a></li>
        <li id="li3"><a href="${pageContext.request.contextPath}/order/getMyOrders?state=2">已发货订单</a></li>
    </ul>
        <div class="panel panel-primary" style="width: 80%;margin:10 auto;">
            <div class="panel-heading">订单号：${myOrder.ordersId}&nbsp;&nbsp;&nbsp;&nbsp;下单时间:${myOrder.date}</div>
            <div class="panel-body">
            <p><span class="label label-primary">订单状态</span></p>
            <p>订单状态：${myOrder.orderstatesByOrderStateId.name}</p>
            <p><span class="label label-info">收件人信息</span></p>
            <p>收件人姓名：${myOrder.receiveName}</p>
            <p>收件人电话：${myOrder.receivePhone}</p>
            <p>收件人邮箱：${myOrder.email}</p>
            <p>收件人地址：${myOrder.address}</p>
            <p><span class="label label-info">支付及配送信息</span></p>
            <p>支付方式：${myOrder.paymentType}</p>
            <p>快递类型：${myOrder.postType}</p>
            <p>快递费用(元)：${myOrder.postFee}</p>
            <p>邮政编码：${myOrder.postalCode}</p>
            <p><span class="label label-info">商品信息</span></p>
            <table class="table table-bordered" style="font-size: small;">
                <thead>
                <tr>
                    <th>商品</th>
                    <th>单价(元)</th>
                    <th>数量</th>
                    <th>小计（元）</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ol" items="${myOrder.orderlightsByOrdersId}">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${ol.lightId}"><img height="80px" width="80px" src="${pageContext.request.contextPath}/${ol.lightByLightId.image1}"></a>
                            <a type="button" class="btn btn-link" href="${pageContext.request.contextPath}/light/lightInfo?lightId=${ol.lightId}">${ol.lightByLightId.name}</a>
                        </td>
                        <td>${ol.lightByLightId.price*ol.lightByLightId.discount*1.00}</td>
                        <td>${ol.quantity}</td>
                        <td>${ol.lightByLightId.price*ol.lightByLightId.discount*ol.quantity*1.00}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <p>实际支付(元)：${myOrder.totalPrice}</p>
            </div>
        </div>
</div>
</body>
</html>
