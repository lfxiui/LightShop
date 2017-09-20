<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/2
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/htmleaf-demo.css">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
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
<body id="home" onload="loadcart()">
<!-- Start Navigation -->
<jsp:include page="navigation.jsp"/>
<!-- End Navigation -->
<%--轮播--%>
<div class="row" >
    <div class="col-lg-12">
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators" >
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner"  role="listbox">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/${page.carouselImg1}" alt="First slide" height="100%" width="100%">
            <div class="carousel-caption">标题 1</div>
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/${page.carouselImg2}" alt="Second slide" height="100%" width="100%">
            <div class="carousel-caption">标题 2</div>
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/${page.carouselImg3}" alt="Third slide" height="100%" width="100%">
            <div class="carousel-caption">标题 3</div>
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;
    </a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;
    </a>
</div>
</div>
</div>
<%--Top sale--%>
<div class="items">
    <h3>热&nbsp;销</h3>
<div class="container">
    <div class="items-sec">
        <c:forEach items="${lights}" var="light">
            <div class="col-md-3 feature-grid">
                <a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${light.lightId}" target="_blank">
                    <img src="${pageContext.request.contextPath}/${light.image1}" alt="">
                    <div class="arrival-info">
                        <h4>${light.name}</h4>
                        <p>￥${light.price*light.discount}</p>
                        <span class="item_price"></span>
                        <span class="disc">[${100-light.discount*100}% off]</span>
                    </div>
                    <div class="viw">
                        <a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${light.lightId}" target="_blank"><span class="glyphicon glyphicon-eye-open" aria-hidden="true">view</span></a>
                    </div>
                </a>
            </div>
        </c:forEach>
        <div class="clearfix"></div>
    </div>
</div>
</div>
<%--清仓--%>
<div class="offers">
    <div class="container">
        <h3>清&nbsp;仓</h3>
        <div class="offer-grids">
            <div class="col-md-6 grid-left">
                <a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${elights[0].lightId}" target="_blank">
                    <div class="offer-grid1">
                        <div class="ofr-pic">
                            <img src="${pageContext.request.contextPath}/images/ofr2.jpeg" class="img-responsive" alt="">
                        </div>
                        <div>
                            <h4>${elights[0].name}</h4>
                            <span>${100-elights[0].discount*100}% OFF</span>
                            <p>浏览</p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
            <div class="col-md-6 grid-right">
               <a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${elights[1].lightId}" target="_blank"><div class="offer-grid2">
                <div class="ofr-pic-info2">
                    <h4>清仓大促</h4>
                    <span>${100-elights[1].discount*100}% OFF</span>
                    <h5>${elights[1].name}</h5>
                    <p>Shop Now</p>
                </div>
                <div class="ofr-pic2">
                    <img src="${pageContext.request.contextPath}/images/ofr2.jpeg" class="img-responsive" alt=""/>
                </div>
                <div class="clearfix"></div>
            </div></a>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <div class="container">
        <div class="footer-grids">
            <div class="col-md-3 about-us">
                <h3>About Us</h3>
                <p>Maecenas nec auctor sem. Vivamus porttitor tincidunt elementum nisi a, euismod rhoncus urna. Curabitur scelerisque vulputate arcu eu pulvinar. Fusce vel neque diam</p>
            </div>
            <div class="col-md-3 ftr-grid">
                <h3>Information</h3>
                <ul class="nav-bottom">
                    <li><a href="#">Track Order</a></li>
                    <li><a href="#">New Products</a></li>
                    <li><a href="#">Location</a></li>
                    <li><a href="#">Our Stores</a></li>
                    <li><a href="#">Best Sellers</a></li>
                </ul>
            </div>
            <div class="col-md-3 ftr-grid">
                <h3>More Info</h3>
                <ul class="nav-bottom">
                    <li><a href="login.html">Login</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="contact.html">Contact</a></li>
                    <li><a href="#">Shipping</a></li>
                    <li><a href="#">Membership</a></li>
                </ul>
            </div>
            <div class="col-md-3 ftr-grid">
                <h3>Categories</h3>
                <ul class="nav-bottom">
                    <li><a href="#">Car Lights</a></li>
                    <li><a href="#">LED Lights</a></li>
                    <li><a href="#">Decorates</a></li>
                    <li><a href="#">Wall Lights</a></li>
                    <li><a href="#">Protectors</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
</body>
</html>
