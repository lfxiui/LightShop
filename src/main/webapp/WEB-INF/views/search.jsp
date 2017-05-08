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
    </script>
</head>
<jsp:include page="navigation.jsp"/>
<body>
<div class="product-model">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Products</li>
        </ol>
        <h2>Our Products</h2>
        <div class="rsidebar span_1_of_left">
            <form class="form-inline">
            <section  class="sky-form">

                    <input type="text" class="form-control" placeholder="搜索">
                    <button class="btn btn-default">查找</button>

                <h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>价格区间</h4>
                <ul class="dropdown-menu1">
                    <li><a href="">
                        <div id="slider-range"></div>
                        <input type="text" id="amount" style="border: 0; font-weight: NORMAL;   font-family: 'Dosis-Regular';" />
                    </a></li>
                </ul>
            </section>
            <!---->
            <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.css">
            <script type='text/javascript'>//<![CDATA[
            $(window).load(function(){
                $( "#slider-range" ).slider({
                    range: true,
                    min: 0,
                    max: 100000,
                    values: [ 0, 100000 ],
                    slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
                    }
                });
                $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

            });//]]>
            </script>
            <section  class="sky-form">
                <div class="product_right">
                    <h4 ><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>分类</h4>
                    <div class="tab1">
                        <ul class="place">
                            <li class="sort">Home Decorates</li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <a href="#"><p>Lanterns</p></a>
                            <a href="#"><p>Wall Lamps</p></a>
                            <a href="#"><p>Table Lamps</p></a>
                            <a href="#"><p>Selling Lamps</p></a>
                        </div>
                    </div>
                    <div class="tab2">
                        <ul class="place">
                            <li class="sort">Festive Needs</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <a href="#"><p>Lanterns</p></a>
                            <a href="#"><p>Disco Lights</p></a>
                        </div>
                    </div>
                    <div class="tab3">
                        <ul class="place">
                            <li class="sort">Kitchen & Dining</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <a href="#"><p>Lights & Lamps</p></a>
                        </div>
                    </div>
                    <div class="tab4">
                        <ul class="place">
                            <li class="sort">Books</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <a href="#"><p>Standing Lamps</p></a>
                            <a href="#"><p>Lamps</p></a>
                            <a href="#"><p>Led Lamps</p></a>
                        </div>
                    </div>
                    <div class="tab5">
                        <ul class="place">
                            <li class="sort">Automotive</li>
                            <li class="by"><img src="images/do.png" alt=""></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <div class="single-bottom">
                            <a href="#"><p>Car Lights</p></a>
                            <a href="#"><p>Stick Lights</p></a>
                            <a href="#"><p>Thread Lights</p></a>
                        </div>
                    </div>

                    <!--script-->
                    <script>
                        $(document).ready(function(){
                            $(".tab1 .single-bottom").hide();
                            $(".tab2 .single-bottom").hide();
                            $(".tab3 .single-bottom").hide();
                            $(".tab4 .single-bottom").hide();
                            $(".tab5 .single-bottom").hide();

                            $(".tab1 ul").click(function(){
                                $(".tab1 .single-bottom").slideToggle(300);
                                $(".tab2 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab4 .single-bottom").hide();
                                $(".tab5 .single-bottom").hide();
                            })
                            $(".tab2 ul").click(function(){
                                $(".tab2 .single-bottom").slideToggle(300);
                                $(".tab1 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab4 .single-bottom").hide();
                                $(".tab5 .single-bottom").hide();
                            })
                            $(".tab3 ul").click(function(){
                                $(".tab3 .single-bottom").slideToggle(300);
                                $(".tab4 .single-bottom").hide();
                                $(".tab5 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                            $(".tab4 ul").click(function(){
                                $(".tab4 .single-bottom").slideToggle(300);
                                $(".tab5 .single-bottom").hide();
                                $(".tab3 .single-bottom").hide();
                                $(".tab2 .single-bottom").hide();
                                $(".tab1 .single-bottom").hide();
                            })
                            $(".tab5 ul").click(function(){
                                $(".tab5 .single-bottom").slideToggle(300);
                                $(".tab4 .single-bottom").hide();
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
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Everyday</label>
                    </div>
                    <div class="col col-4">
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Anchor</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Philips</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Wipro</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Havells</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox" ><i></i>Ferolex</label>
                        <label class="checkbox"><input type="checkbox" name="checkbox"><i></i>Gold Medal</label>
                    </div>
                </div>
            </section>
            </form>
            <!---->
        </div>
</div>
</div>
</body>
</html>
