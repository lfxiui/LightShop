<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/2
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<nav class="navbar navbar-default  bootsnav">

    <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
    <!-- End Top Search -->

    <div class="container">
        <!-- Start Atribute Navigation -->
        <div class="attr-nav">
            <ul>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" >
                        <i class="fa fa-shopping-bag"></i>
                        <span class="badge">3</span>
                    </a>
                    <ul class="dropdown-menu cart-list">
                        <li>
                            <a href="#" class="photo"><img src="images/thumb/thumb01.jpg" class="cart-thumb" alt="" /></a>
                            <h6><a href="#">Delica omtantur </a></h6>
                            <p>2x - <span class="price">$99.99</span></p>
                        </li>
                        <li>
                            <a href="#" class="photo"><img src="images/thumb/thumb02.jpg" class="cart-thumb" alt="" /></a>
                            <h6><a href="#">Omnes ocurreret</a></h6>
                            <p>1x - <span class="price">$33.33</span></p>
                        </li>
                        <li>
                            <a href="#" class="photo"><img src="images/thumb/thumb03.jpg" class="cart-thumb" alt="" /></a>
                            <h6><a href="#">Agam facilisis</a></h6>
                            <p>2x - <span class="price">$99.99</span></p>
                        </li>
                        <li class="total">
                            <span class="pull-right"><strong>Total</strong>: $0.00</span>
                            <a href="#" class="btn btn-default btn-cart">Cart</a>
                        </li>
                    </ul>
                </li>
                <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                <li class="side-menu"><a href="#"><i class="fa fa-bars"></i></a></li>
            </ul>
        </div>
        <!-- End Atribute Navigation -->

        <!-- Start Header Navigation -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="#brand">
                <img src="images/brand/logo-white.png" class="logo logo-display" alt="">
                <img src="images/brand/logo-black.png" class="logo logo-scrolled" alt="">
            </a>
        </div>
        <!-- End Header Navigation -->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" >品牌</a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${Brands}" var="Brand">
                        <li><a href="${pageContext.request.contextPath}/search/type?name=brandId&id=${Brand.brandId}" class="text-center">${Brand.brandName}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="dropdown megamenu-fw">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">分类</a>
                    <ul class="dropdown-menu megamenu-content" role="menu">
                        <li>
                            <div class="row">
                                <div class="col-menu col-xs-3">
                                    <h6 class="title">适用空间</h6>
                                    <div class="content">
                                        <ul class="menu-col">
                                            <c:forEach items="${Locates}" var="Locate">
                                            <li><a href="${pageContext.request.contextPath}/search/type?name=locateId&id=${Locate.locateId}">${Locate.name}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div><!-- end col-3 -->
                                <div class="col-menu col-xs-3">
                                    <h6 class="title">光源类型</h6>
                                    <div class="content">
                                        <ul class="menu-col">
                                            <c:forEach items="${Catagorys}" var="Catagory">
                                            <li><a href="${pageContext.request.contextPath}/search/type?name=catagoryId&id=${Catagory.catagoryId}">${Catagory.catagoryName}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div><!-- end col-3 -->
                                <div class="col-menu col-xs-3">
                                    <h6 class="title">灯饰风格</h6>
                                    <div class="content">
                                        <ul class="menu-col">
                                            <c:forEach items="${Styles}" var="Style">
                                            <li><a href="${pageContext.request.contextPath}/search/type?name=styleId&id=${Style.styleId}">${Style.styleName}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-menu col-xs-3">
                                    <h6 class="title">材质</h6>
                                    <div class="content">
                                        <ul class="menu-col">
                                            <c:forEach items="${Stuffs}" var="Stuff">
                                                <li><a href="${pageContext.request.contextPath}/search/type?name=stuffId&id=${Stuff.stuffId}">${Stuff.stuffName}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>

                            </div><!-- end row -->
                        </li>
                    </ul>
                </li>
                <li><a href="#">关于我们</a></li>
                <li><a href="#">联系客服</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>

    <!-- Start Side Menu -->
    <div class="side">
        <a href="#" class="close-side"><i class="fa fa-times"></i></a>
        <div class="widget">
            <h6 class="title"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 个人信息</h6>
            <ul class="link">
                <li><a href="#"><span class="fa fa-shopping-basket" aria-hidden="true"></span>订单</a></li>
                <li><a href="#"><span class="fa fa-shopping-bag" aria-hidden="true"></span>购物车</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>收藏夹</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>我的信息</a></li>
            </ul>
        </div>
        <div class="widget">
            <h6 class="title">快捷操作</h6>
            <ul class="link">
                <li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>全站搜索</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-hand-right"aria-hidden="true"></span>灯饰推荐</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>联系客服</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-envelope"aria-hidden="true"></span>关于我们</a></li>
            </ul>
        </div>
    </div>
    <!-- End Side Menu -->
</nav>
</body>
</html>
