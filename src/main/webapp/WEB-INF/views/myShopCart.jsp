<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/6
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<HEADER>
    <title>我的购物车</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/jquery-1.11.min.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/etao.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/cart.js"></script>
    <link href="${pageContext.servletContext.contextPath}/css/shopCartCSS/cart.css" media="screen" rel="stylesheet" type="text/css" />
    <link href="${pageContext.servletContext.contextPath}/css/shopCartCSS/bootstrap.min.css" media="screen" rel="stylesheet" type="text/css" />
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
    <!-- 导航-->
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
</HEADER>
<script>
    var root='${pageContext.request.contextPath}';
</script>
<body class="container">
<!-- 导航--><jsp:include page="navigation.jsp"/>
<div class="row hidden-print">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="${pageContext.servletContext.contextPath}/index">首页</a></li>
            <li class="active">查看购物车</li>
        </ol>
    </div>
</div>
<form id="form" role="form" action="${pageContext.servletContext.contextPath}/order/addOrder" method="get">
<div class="cart-wrap">
    <table id="cartTable" class="cart table table-condensed">
        <thead>
        <tr>
            <th class="t-checkbox"><label><input class="check-all check" type="checkbox" value="0"/>全选</label></th>
            <th class="t-action text-right"><label></label></th>
            <th class="t-goods text-left"><label>商品详情</label></th>
            <th class="t-selling-price text-right"><label>销售单价</label></th>
            <th class="t-qty text-center"><label>采购数量</label></th>
            <th class="t-subtotal text-right"><label>金额小计</label></th>
            <th class="t-action"><label>操作</label></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="shopCart" items="${myShopCart}">
            <tr>
                <td colspan="2" class="goods">
                    <input type="hidden" id="myShopCart" value="${shopCart.lightId}">
                    <label>
                        <input type="checkbox" class="check-one check" name="checkbox" value="${shopCart.shopCartId}"/><a type="button" class="btn btn-link" href="${pageContext.servletContext.contextPath}/light/lightInfo?lightId=${shopCart.lightId}">${shopCart.lightByLightId.name}</a>
                    </label>
                </td>
                <td><img src="${pageContext.request.contextPath}/${shopCart.lightByLightId.image1}" height="100" width="100"/></td>
                <td class="selling-price number small-bold-red text-right"
                    style="padding-top: 1.1rem;" data-bind="${shopCart.lightByLightId.price*shopCart.lightByLightId.discount}">${shopCart.lightByLightId.price*shopCart.lightByLightId.discount}</td>
                <td>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon minus" style="cursor: pointer">-</span>
                        <input type="text" class="number form-control input-sm" value="${shopCart.quantiy}" />
                        <span class="input-group-addon plus" style="cursor: pointer">+</span>
                    </div>
                </td>
                <td class="subtotal number small-bold-red text-right" style="padding-top: 1.1rem;"></td>
                <td class="action" style="padding-top: 1.1rem;"><span class="delete btn btn-xs btn-warning">删除</span></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12">
            <div class="cart-summary">
                <div style="margin-left: 2rem;" class="pull-right">
                    <button data-toggle="modal" data-target="#newOrder" id="btn_settlement" type="button" class="btn btn-primary" disabled>去结算</button>
                </div>
                <div style="margin-left: 1rem; margin-top: 0.4rem;" class="pull-right total">
                    <label>合计:<span id="priceTotal" class="price-total large-bold-red">0.00</span></label>
                </div>
                <div style="margin-top: 4px;" class="pull-right">
                    <label>您选了<span id="itemCount" class="large-bold-red" style="margin: 0 4px;"></span>款灯饰，共计<span id="qtyCount" class="large-bold-red" style="margin: 0 4px;"></span>件
                    </label>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="newOrder" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    填写订单信息
                </h4>
            </div>
            <div>
                <h5>已选商品：</h5>
                <table id="selected" class="table table-striped">
                </table>
                <input type="hidden" id="totalPrice" name="totalPrice" value="0">
                <input type="hidden" name="postFee" value="10">
                <p id="allMoney"></p><span>快递费10元</span>
            </div>
            <div class="form-group">
                <label for="receiveName">收件人姓名</label>
                <input type="text" class="form-control" id="receiveName" name="receiveName" placeholder="请输入姓名">
            </div>
            <div class="form-group">
                <label for="receivePhone">收件人电话</label>
                <input type="text" class="form-control" id="receivePhone" name="receivePhone" placeholder="请输入电话">
            </div>
            <div class="form-group">
                <label>地址</label>
                <select id="s_province" name="s_province" class="form-control"></select>
                <select id="s_city" name="s_city" class="form-control"></select>
                <select id="s_county" name="s_county" class="form-control"></select>
                <script src="${pageContext.servletContext.contextPath}/js/area.js"></script>

                <script type="text/javascript">_init_area();</script>
            </div>
            <div class="form-group">
                <label for="address">具体街道</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="请输入街道">
            </div>
            <div class="form-group">
                <label for="email">邮箱地址</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱">
            </div>
            <div class="form-group">
                <label for="postalCode">邮政编码</label>
                <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="请输入邮编">
            </div>
            <div class="form-group">
                <label for="postType">快递类型</label>
                <select class="form-control" id="postType" name="postType">
                    <option>顺丰快递</option>
                    <option>申通快递</option>
                    <option>圆通快递</option>
                    <option>EMS快递</option>
                    <option>中通快递</option>
                </select>
            </div>
            <div class="form-group">
                <label for="paymentType">支付方式</label>
                <select class="form-control" id="paymentType" name="paymentType">
                    <option>货到付款--现金支付</option>
                    <option>货到付款--刷卡支付</option>
                    <option>货到付款--网上转账</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="finishOrder" name="finishOrder" class="btn btn-primary">
                    提交订单
                </button>
                <script type="text/javascript">
                    $("#finishOrder").click(function(){
                        $('#form').submit();
                    });
                </script>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>
</body>
</html>
