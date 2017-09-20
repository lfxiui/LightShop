<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<HEADER>
    <title>收藏夹</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/jquery-1.11.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/etao.js"></script>
    <link href="${pageContext.servletContext.contextPath}/css/shopCartCSS/cart.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/shopCartCSS/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css" />
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
    <!-- 导航-->
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <script>
        function deleteWishlistById(wishlistId) {
            if(confirm("确定删除此商品？")) {
                window.location.href="${pageContext.servletContext.contextPath}/Wishlist/deleteWishlist?wishlistId="+wishlistId;
            }
        }
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
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
</HEADER>
<body class="container" onload="loadcart()">
<!-- 导航--><jsp:include page="navigation.jsp"/>
<div class="row hidden-print">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="${pageContext.servletContext.contextPath}/index">首页</a></li>
            <li class="active">查看收藏夹</li>
        </ol>
    </div>
</div>
<div class="cart-wrap">
    <table id="cartTable" class="cart table table-condensed">
        <thead>
            <th>产品名称</th>
            <th>产品图片</th>
            <th>收藏日期</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach var="wish" items="${wishlist}">
        <tr>
        <!--点击商品名称跳转相应商品详情页-->
            <td><a href="${pageContext.servletContext.contextPath}/light/lightInfo?lightId=${wish.lightId}">
                    ${wish.lightByLightId.name}
                </a>
            </td>
            <td><img src="${pageContext.request.contextPath}/${wish.lightByLightId.image1}" width="100" height="100"/> </td>
            <td>${wish.storeDate}</td>

            <td><button onclick="deleteWishlistById(${wish.wishListId})">删除</button> </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>