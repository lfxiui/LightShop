<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/8
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索</title>
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
    <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.jscrollpane.min.js"></script>
    <script>
        $(function () {
            $('.scroll-pane').jScrollPane();
        });
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
<jsp:include page="navigation.jsp"/>
<body onload="loadcart()">
<div class="product-model">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="index.html">搜索条件</a></li>
            <li class="active">
                <c:forEach items="${map}" var="m">
                    <c:if test="${m.key eq 'stuffId'}">
                        <c:forEach items="${Stuffs}" var="stuff">
                            <c:if test="${stuff.stuffId eq m.value}">
                                <a style="border:solid 1px" href="${pageContext.request.contextPath}/search/all?operate=delete&name=${m.key}">${stuff.stuffName}<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${m.key eq 'locateId'}">
                        <c:forEach items="${Locates}" var="Locate">
                            <c:if test="${Locate.locateId eq m.value}">
                <a style="border:solid 1px" href="${pageContext.request.contextPath}/search/all?operate=delete&name=${m.key}">${Locate.name}<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${m.key eq 'catagoryId'}">
                        <c:forEach items="${Catagorys}" var="catagory">
                            <c:if test="${catagory.catagoryId eq m.value}">
                                <a style="border:solid 1px" href="${pageContext.request.contextPath}/search/all?operate=delete&name=${m.key}">${catagory.catagoryName}<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                            </c:if>
                        </c:forEach>
                    </c:if>
                    <c:if test="${m.key eq 'styleId'}">
                        <c:forEach items="${Styles}" var="style">
                            <c:if test="${style.styleId eq m.value}">
                                <a style="border:solid 1px" href="${pageContext.request.contextPath}/search/all?operate=delete&name=${m.key}">${style.styleName}<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach></li>
        </ol>
        <div class="col-md-9 product-model-sec">
            <div class="btn-group pull-left" role="group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false" aria-haspopup="true">
                    价格排序<span class="caret"></span></button>
                <button type="button"  class="btn btn-default"  onclick="location=('${pageContext.request.contextPath}/search/sort?sort=3')" >销量排序</button>
                <button type="button" class="btn btn-default"  onclick="location=('${pageContext.request.contextPath}/search/sort?sort=4')">人气排序</button>
                <ul class="dropdown-menu">
                    <li><a href="${pageContext.request.contextPath}/search/sort?sort=1">由低到高</a></li>
                    <li><a href="${pageContext.request.contextPath}/search/sort?sort=2">由高到低</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
            <c:forEach items="${results}" var="light">
        <div class="product-grid">
            <a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${light.lightId}" target="_blank">
                <div class="more-product"><span> </span></div>
                <div class="product-img b-link-stripe b-animate-go  thickbox">
                    <img src="/${light.image1}"  alt="" height="250" width="190">
                    <div class="b-wrapper">
                        <h4 class="b-animate b-from-left  b-delay03">
                            <button><span class="glyphicon glyphicon-zoom-in" aria-hidden="false"></span>查看详情</button>
                        </h4>
                    </div>
                </div>
            </a>
            <div class="product-info simpleCart_shelfItem">
                <div class="product-info-cust prt_name">
                    <h4>${light.name}</h4>
                    <span class="item_price">${light.price*light.discount}￥</span>
                    <div class="ofr">
                        <p class="pric1"><del>￥${light.price}</del></p>
                        <p class="disc">[${100-light.discount*100}% Off]</p>
                    </div>
                    <input type="text" class="item_quantity" value="1"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
                    <input type="button" class="item_add items" value="加入购物车" name="${light.lightId}">
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
            </c:forEach>

        </div>
        <script>
            $(document).ready(function () {
                $(".item_add.items").click(function () {
                   var quantity=$(this).parents('.product-info-cust.prt_name').find('.item_quantity').val();
                    $.ajax({
                        url: '${pageContext.servletContext.contextPath}/myshopcart/addToCart?lightId= '+$(this).attr('name')+'&quantity='+quantity, //所需要的列表接口地址
                        success : function(data,status) {
                            if (status == "success") {
                                if(data == "success"){
                                    alert("成功加入购物车");
                                    loadcart();
                                }else {
                                    alert("库存不足,加入购物车失败");
                                }
                            }else {
                                alert("商品不存在或已删除")
                            }
                        }
                    });
                })
            })
        </script>

        <div class="rsidebar span_1_of_left">
            <form class="form-inline" action="${pageContext.request.contextPath}/search/submit">
            <section  class="sky-form">

                    <input type="text" class="form-control" placeholder="搜索:${flag}" name="flag">
                    <button class="btn btn-default" type="submit">查找</button>

            </section>
            <section  class="sky-form">
                <div class="product_right">
                    <h4 ><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>分类</h4>
                    <div class="tab1">
                        <ul class="place">
                            <li class="sort">适用空间</li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <c:forEach items="${Locates}" var="Locate">
                            <a href="${pageContext.request.contextPath}/search/all?operate=add&name=locateId&id=${Locate.locateId}"><p>${Locate.name}</p></a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab2">
                        <ul class="place">
                            <li class="sort">光源类型</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <c:forEach items="${Catagorys}" var="catagory">
                                <a href="${pageContext.request.contextPath}/search/all?operate=add&name=catagoryId&id=${catagory.catagoryId}"><p>${catagory.catagoryName}</p></a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab3">
                        <ul class="place">
                            <li class="sort">灯饰风格</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <c:forEach items="${Styles}" var="style">
                                <a href="${pageContext.request.contextPath}/search/all?operate=add&name=styleId&id=${style.styleId}"><p>${style.styleName}</p></a>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab4">
                        <ul class="place">
                            <li class="sort">材质</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <c:forEach items="${Stuffs}" var="stuff">
                            <a href="${pageContext.request.contextPath}/search/all?operate=add&name=stuffId&id=${stuff.stuffId}"><p>${stuff.stuffName}</p></a>
                        </c:forEach>
                        </div>
                    </div>

                    <!--script-->
                    <script>
                        $(document).ready(function(){
                            $(".tab1 .single-bottom").hide();
                            $(".tab2 .single-bottom").hide();
                            $(".tab3 .single-bottom").hide();
                            $(".tab4 .single-bottom").hide();


                            $(".tab1 ul").click(function(){
                                $(".tab1 .single-bottom").slideToggle(300);
                                $(".tab2 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab4 .single-bottom").hide();

                            })
                            $(".tab2 ul").click(function(){
                                $(".tab2 .single-bottom").slideToggle(300);
                                $(".tab1 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab4 .single-bottom").hide();

                            })
                            $(".tab3 ul").click(function(){
                                $(".tab3 .single-bottom").slideToggle(300);
                                $(".tab4 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                            $(".tab4 ul").click(function(){
                                $(".tab4 .single-bottom").slideToggle(300);
                                $(".tab3 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                        });
                    </script>
                    <!-- script -->
                </div>
            </section>
            <section  class="sky-form">
                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>品牌</h4>
                <div class="row row1 scroll-pane">
                    <div class="col col-4">
                        <c:forEach items="${Brands}" var="Brand">
                            <c:if test="${BrandSelect[Brand.brandId] eq 0}">
                                    <label class="checkbox" title="选择品牌后要点查找才生效哦"><input type="checkbox" name="checkbox" value="${Brand.brandId}" ><i></i>${Brand.brandName}</label>
                            </c:if>
                            <c:if test="${BrandSelect[Brand.brandId] eq 1}">
                                <label class="checkbox"><input type="checkbox" name="checkbox" value="${Brand.brandId}" checked=""><i></i>${Brand.brandName}</label>
                            </c:if>
                        </c:forEach>
                    </div>
                    <script>
                        $(document).ready(function () {
                            $(':checkbox').click(function () {
                                if($(this).is(':checked')){
                                   $.ajax({url:"${pageContext.request.contextPath}/search/select",type:"POST",data:{'operate':'add','id':$(this).val()}})
                                }else  $.ajax({url:"${pageContext.request.contextPath}/search/select",type:"POST",data:{'operate':'delete','id':$(this).val()}})
                            })
                        })
                    </script>
                </div>
            </section>
            </form>
            <!---->
        </div>
</div>

</div>
<%--分页--%>
<div style="margin-left: 50%" >
    <c:if test="${pageMessage.totalPage>1}">
        <ul class="pagination">
            <li><a href="${pageContext.request.contextPath}/search/all?operate=&name=&id=&page=${pageMessage.currentPage-1}">&laquo;</a></li>
        <c:forEach  begin="1" var="i" end="${pageMessage.totalPage}">
          <c:choose>
              <c:when test="${i == pageMessage.currentPage}">
                  <li class="active"><a href="${pageContext.request.contextPath}/search/all?operate=&name=&id=&page=${i}">${i}</a></li>
              </c:when>
              <c:otherwise>
                  <li ><a href="${pageContext.request.contextPath}/search/all?operate=&name=&id=&page=${i}">${i}</a></li>
              </c:otherwise>
          </c:choose>

        </c:forEach>
            <li><a href="${pageContext.request.contextPath}/search/all?operate=&name=&id=&page=${pageMessage.currentPage+1}">&raquo;</a></li>
        </ul>
    </c:if>
</div>
</body>
</html>
