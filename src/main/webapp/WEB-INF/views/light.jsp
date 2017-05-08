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
    <script  src="${pageContext.servletContext.contextPath}/js/bootstrap-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <!-- //js -->
    <!-- for bootstrap working -->
    <!-- //for bootstrap working -->
</head>
<body>
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
            <h3>小仙女闪闪发亮灯饰</h3>
            <!--<span>${light.brandByBrandId.brandName}</span><span>${light.stryleByStyleId.styleName}</span><span>${light.catagoryByCatagoryId.catagoryName}</span> -->
            <div class="description">
                <h5>材质：</h5>
                <p>${light.stuff}</p>
            </div>
            <div class="description">
                <h5>颜色：</h5>
                <p>${light.color}</p>
            </div>
            <div class="description">
                <h5>安放位置：</h5>
                <p>${light.locate}</p>
            </div>
            <div class="color-quality">

                <div class="color-quality-left">
                    <h5>购买数量:</h5>
                    <div class="quantity">
                        <div class="quantity-select">
                            <div class="entry value-minus1">&nbsp;</div>
                            <input type="text" id="quantity" name="quantity" size=2 value=1 />
                            <div class="entry value-plus1 active">&nbsp;</div>
                            <small style="color: #098dff;">(库存：${light.quantity})</small>
                        </div>
                    </div>
                    <!--quantity-->
                    <script>
                        $('.value-plus1').on('click', function(){
                            if(Number($('#quantity').val())<${light.quantity}) $('#quantity').val(Number($('#quantity').val())+1);
                        });

                        $('.value-minus1').on('click', function(){
                            if(Number($('#quantity').val())>1) $('#quantity').val(Number($('#quantity').val())-1);;
                        });
                    </script>
                    <!--quantity-->

                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="simpleCart_shelfItem">
                <p><i class="item_price">￥${light.price}</i></p>
                <form action="#" method="post">
                    <input type="hidden" name="cmd" value="_cart">
                    <input type="hidden" name="add" value="1">
                    <input type="hidden" name="w3ls_item" value="Smart Phone">
                    <input type="hidden" name="amount" value="450.00">
                    <button type="submit" class="w3ls-cart">加入购物车</button>
                </form>
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
                    <h3>小仙女闪闪发亮灯饰</h3>
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

</body>
</html>