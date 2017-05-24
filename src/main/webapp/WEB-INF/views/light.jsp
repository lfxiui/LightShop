<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>商品详情</title>
    <!-- 商品详情 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <!-- 商品详情 -->
    <!-- Custom Theme files -->
    <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style1.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
    <!-- js -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <!-- //js -->
    <!-- for bootstrap working -->
    <!-- //for bootstrap working -->
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
                            '<a href="/light/lightInfo?lightId='+data[i].lightId+'" class="photo"><img src="/'+data[i].lightByLightId.image1+'" class="cart-thumb" alt="" /></a>'+
                            '<h6><a href="/light/lightInfo?lightId='+data[i].lightId+'">'+data[i].lightByLightId.name +'</a></h6>'+
                            '<p>'+data[i].quantiy+'X<span class="price">￥'+data[i].lightByLightId.price+'</span></p>'+
                            '</li>');
                        total=total+data[i].lightByLightId.price*data[i].quantiy;
                    }
                    cart.append('<li class="total">'+
                        ' <span class="pull-right"><strong>总价</strong>: ￥'+total+'</span>'+
                        '<a href="/myshopcart/showMyShopCart" class="btn btn-default btn-cart">购物车</a>'+
                        '</li>')

                }
            })
        }
    </script>
</head>
<body onload="loadcart()">
<!-- single -->
<jsp:include page="navigation.jsp"/>
<div class="single">
    <div class="container">
        <div class="col-md-4 single-left">
            <div class="flexslider">
                <ul class="slides">
                    <li data-thumb="${pageContext.request.contextPath}/${light.image1}">
                        <div class="thumb-image"> <img src="${pageContext.request.contextPath}/${light.image1}" data-imagezoom="true" class="img-responsive" alt=""> </div>
                    </li>
                    <li data-thumb="${pageContext.request.contextPath}/${light.image2}">
                        <div class="thumb-image"> <img src="${pageContext.request.contextPath}/${light.image2}" data-imagezoom="true" class="img-responsive" alt=""> </div>
                    </li>
                    <li data-thumb="${pageContext.request.contextPath}/${light.image3}">
                        <div class="thumb-image"> <img src="${pageContext.request.contextPath}/${light.image3}" data-imagezoom="true" class="img-responsive" alt=""> </div>
                    </li>
                </ul>
            </div>
            <!-- flexslider -->
            <script defer src="${pageContext.servletContext.contextPath}/js/jquery.flexslider.js"></script>
            <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/flexslider.css" type="text/css" media="screen" />
            <script>
                // Can also be used with $(document).ready()
                $(window).load(function() {
                    $('.flexslider').flexslider({
                        animation: "slide",
                        controlNav: "thumbnails"
                    });
                });
            </script>
            <!-- flexslider -->
            <!-- zooming-effect -->
            <script src="${pageContext.servletContext.contextPath}/js/imagezoom.js"></script>
            <!-- //zooming-effect -->
        </div>
        <div class="col-md-8 single-right">
            <h3>${light.name}</h3>
            <div class="description">
                <h5>材质：<span>${light.stuffByStuffId.stuffName}</span></h5>
            </div>
            <div class="description">
                <h5>品牌：<span>${light.brandByBrandId.brandName}</span></h5>

            </div>
            <div class="description">
                <h5>种类：<span>${light.catagoryByCatagoryId.catagoryName}</span></h5>

            </div>
            <div class="description">
                <h5>安放位置：<span>${light.locateByLocateId.name}</span></h5>

            </div>
            <div class="color-quality">

                <div class="color-quality-left">
                    <h5>购买数量:</h5>
                    <div class="quantity">
                        <div class="quantity-select">
                            <div class="entry value-minus1">&nbsp;</div>
                            <input type="text" id="quantity" name="quantity" style="height: 40px;width: 40px;" value="1" />
                            <div class="entry value-plus1 active">&nbsp;</div>
                            <small style="color: #098dff;" id="qu">(库存：${light.quantity})</small>
                        </div>
                    </div>
                    <!--quantity-->
                    <script>
                        $('#quantity').keyup(function () {
                            var quantity = $(this);
                            var num = quantity.val();
                            var val = parseInt(quantity.val());
                            if (isNaN(num) || (val < 1)) { quantity.val("1"); }
                            $.ajax({
                                url: '${pageContext.servletContext.contextPath}/myshopcart/getQuantity?lightId='+'${light.lightId}'+'&id='+<%=Math.random()%>, //所需要的列表接口地址
                                success : function(data,status) {
                                    if (status == "success") {
                                        var quantity2 = parseInt(data);
                                        if (val > quantity2) {
                                            alert("库存不足："+val+"！当前最大库存为："+quantity2)
                                            quantity.val(quantity2);
                                            $("#qu").text("(库存:"+quantity2+")");
                                        }
                                    }else {
                                        alert("商品不存在或已删除")
                                    }
                                }
                            });
                        });
                        
                        $('.value-plus1').on('click', function(){
                            var quantity = $('#quantity');
                            var num = quantity.val();
                            var val = parseInt(quantity.val());
                            if (isNaN(num) || (val < 1)) { quantity.val("1"); }
                            $.ajax({
                                url: '${pageContext.servletContext.contextPath}/myshopcart/getQuantity?lightId='+'${light.lightId}'+'&id='+<%=Math.random()%>, //所需要的列表接口地址
                                success : function(data,status) {
                                    if (status == "success") {
                                        var quantity2 = parseInt(data);
                                        if (val < quantity2) val++;
                                        else {
                                            alert("库存不足："+val+"！当前最大库存为："+quantity2)
                                            quantity.val(quantity2);
                                            $("#qu").text("(库存:"+quantity2+")");
                                        }
                                        quantity.val(val);
                                        if (val > quantity2) {
                                            alert("库存不足："+val+"！当前最大库存为："+quantity2)
                                            quantity.val(quantity2);
                                            $("#qu").text("(库存:"+quantity2+")");
                                        }
                                    }else {
                                        alert("商品不存在或已删除")
                                    }
                                }
                            });
                            //if(($('#quantity').val())<${light.quantity}) $('#quantity').val(Number($('#quantity').val())+1);
                        });

                        $('.value-minus1').on('click', function(){
                            var quantity = $('#quantity');
                            var num = quantity.val();
                            var val = parseInt(quantity.val());
                            if (isNaN(num) || (val < 1)) { quantity.val("1"); }
                            $.ajax({
                                url: '${pageContext.servletContext.contextPath}/myshopcart/getQuantity?lightId='+'${light.lightId}'+'&id='+<%=Math.random()%>, //所需要的列表接口地址
                                success : function(data,status) {
                                    if (status == "success") {
                                        var quantity2 = parseInt(data);
                                        if (val > 1) val--;
                                        quantity.val(val);
                                        if (val > quantity2) {
                                            alert("库存不足："+val+"！当前最大库存为："+quantity2)
                                            quantity.val(quantity2);
                                            $("#qu").text("(库存:"+quantity2+")");
                                        }
                                    }else {
                                        alert("商品不存在或已删除")
                                    }
                                }
                            });
                            //if(Number($('#quantity').val())>1) $('#quantity').val(Number($('#quantity').val())-1);;
                        });
                    </script>
                    <!--quantity-->

                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="description">
                <h5>单价：</h5>
            </div>
            <div class="simpleCart_shelfItem">
                <p><span>￥${light.price}</span><i class="item_price">￥${light.price*light.discount}</i></p>
                <form action="#" method="post">
                    <button type="button" class="w3ls-cart">加入购物车</button>
                    <button type="button" class="w3ls-wishlist">加入收藏夹</button>
                    <button type="button" class="w3ls-count">去结算</button>
                </form>
                <!--加入购物车add to myshopcart-->
                <script>
                    $('.w3ls-cart').on('click', function() {
                        $.ajax({
                            url: '${pageContext.servletContext.contextPath}/myshopcart/addToCart?lightId='+'${light.lightId}'+'&quantity='+parseInt($('#quantity').val()), //所需要的列表接口地址
                            success : function(data,status) {
                                if (status == "success") {
                                    if(data == "success"){
                                        alert("成功加入购物车");
                                        loadcart();
                                    }else {
                                        $('#quantity').val(parseInt(data));
                                        $("#qu").text("(库存:"+data+")");
                                        alert("库存不足,加入购物车失败");
                                    }
                                }else {
                                    alert("商品不存在或已删除")
                                }
                            }
                        });
                    })

                    $('.w3ls-count').on('click', function() {
                        window.location.href = "${pageContext.servletContext.contextPath}/myshopcart/showMyShopCart";
                    })
                </script>
                <!--加入购物车add to myshopcart-->
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<div class="additional_info">
    <div class="container">
        <div class="sap_tabs">
            <div id="horizontalTab1" style="display: block; width: 100%; margin: 0px;">
                <ul>
                    <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>商品详情</span></li>
                    <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>买家评价</span></li>
                </ul>
                <div class="tab-1 resp-tab-content additional_info_grid" aria-labelledby="tab_item-0">
                    <h3>${light.name}</h3>
                    <p>${light.description}</p>
                </div>

                <div class="tab-2 resp-tab-content additional_info_grid" aria-labelledby="tab_item-1">
                    <h4>共${comments.size()}个评价</h4>
                    <c:forEach var = "p" items="${comments}">
                        <div class="additional_info_sub_grids">
                            <div class="col-xs-2 additional_info_sub_grid_left">
                                <img src="${pageContext.servletContext.contextPath}/images/simple3.jpg" height="80" width="80" alt=" " class="img-responsive" />
                            </div>
                            <div class="col-xs-10 additional_info_sub_grid_right">
                                <div class="additional_info_sub_grid_rightl">
                                    <a href="#">${p.userByUserId.userName}</a>
                                    <h5>${p.date}</h5>
                                    <p>${p.comments}</p>
                                </div>
                                <div class="additional_info_sub_grid_rightr">
                                    <div class="rating">

                                        <div class="clearfix"> </div>
                                    </div>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <script src="${pageContext.servletContext.contextPath}/js/easyResponsiveTabs.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#horizontalTab1').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion
                    width: 'auto', //auto or any width like 600px
                    fit: true   // 100% fit in a container
                });
            });
        </script>
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
</body>
</html>