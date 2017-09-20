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
<script>
    function loadcart(){
        $.ajax({
            url:"${pageContext.request.contextPath}/myshopcart/getCartList",
            success:function (data) {
                var cart=$(".cart-list");
                $(".badge").text(data.length);
                var total=0;
                cart.empty();
                for(var i=0;i<data.length;i++){
                    cart.append('<li>'+
                        '<a href="${pageContext.request.contextPath}/light/lightInfo?lightId='+data[i].lightId+'" class="photo"><img src="/'+data[i].lightByLightId.image1+'" class="cart-thumb" alt="" /></a>'+
                        '<h6><a href="${pageContext.request.contextPath}/light/lightInfo?lightId='+data[i].lightId+'">'+data[i].lightByLightId.name +'</a></h6>'+
                        '<p>'+data[i].quantiy+'X<span class="price">￥'+data[i].lightByLightId.price+'</span></p>'+
                        '</li>');
                    total=total+data[i].lightByLightId.price*data[i].quantiy;
                }
                cart.append('<li class="total">'+
                    ' <span class="pull-right"><strong>总价</strong>: ￥'+total+'</span>'+
                    '<a href="${pageContext.request.contextPath}/myshopcart/showMyShopCart" class="btn btn-default btn-cart">购物车</a>'+
                    '</li>')

            }
        })
    }
</script>
<body onload="loadcart()">
<!-- 导航--><jsp:include page="navigation.jsp"/>
<div class="jumbotron">
    <div class="container">
        <h1>已完成订单！</h1>
        <p>亲，请耐心等待发货，发货后我们会邮件通知您！感谢您的消费，祝生活愉快。</p>

    </div>
</div>
</body>
</html>
