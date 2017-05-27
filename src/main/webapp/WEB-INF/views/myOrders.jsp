<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>我的订单</title>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/shopCartJS/jquery-1.11.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
    <!-- 导航-->
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
</head>
<script type="text/javascript">
    window.onload =function() {
        var sate = parseInt($("#state").val());
        if (sate == 0) {
            $("#li1").addClass("active");
        }
        if (sate == 1) {
            $("#li2").addClass("active");
        }
        if (sate == 2) {
            $("#li3").addClass("active");
        }
    }
</script>
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
    <c:forEach var="o" items="${myOrders}">
        <div class="panel panel-primary" style="width: 80%;margin:10 auto;">
            <div class="panel-heading">订单号：${o.ordersId}&nbsp;&nbsp;&nbsp;&nbsp;下单时间:${o.date}</div>
            <table class="table" style="font-size: small;">
                <thead>
                <th>商品信息</th><th>实付款(元)</th><th>订单状态</th><th>操作</th>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <table class="table table-striped" style="font-size: small;">
                            <thead>
                            <th>商品图片</th><th>商品名称</th><th>单价(元)</th><th>数量</th><th></th>
                            </thead>
                            <tbody>
                            <c:forEach var="ol" items="${o.orderlightsByOrdersId}">
                                <tr>
                                    <td><a href="${pageContext.request.contextPath}/light/lightInfo?lightId=${ol.lightId}"><img height="80px" width="80px" src="${pageContext.request.contextPath}/${ol.lightByLightId.image1}"></a></td>
                                    <td><a type="button" class="btn btn-link" href="${pageContext.request.contextPath}/light/lightInfo?lightId=${ol.lightId}">${ol.lightByLightId.name}</a></td>
                                    <td>${ol.lightByLightId.price*ol.lightByLightId.discount/1.00}</td>
                                    <td>${ol.quantity}</td>
                                    <td><button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#comment" onclick="getLightId(${ol.lightId})">评价</button></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </td>
                    <td>${o.totalPrice/1.00}<p>未包含运费(10.0元)</p></td>
                    <td>${o.orderstatesByOrderStateId.name}</td>
                    <td><a type="button" class="btn btn-link" href="${pageContext.request.contextPath}/order/showMyOrder?orderId=${o.ordersId}">查看订单</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>
<script type="text/javascript">
    function getLightId(lightId) {
        $("#getLightId").val(lightId);
    }
</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="comment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加商品评价
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="comments">请输入评价</label>
                    <input type="hidden" id="getLightId" name="getLightId" value="">
                    <textarea class="form-control" rows="3" id="comments" name="comments"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" id="send" name="send">
                    提交评价
                </button>
                <script type="text/javascript">
                    $("#send").click(function () {
                        var comments = $("#comments").val();
                        var lightId = $("#getLightId").val();
                        if(comments == null||comments == ""||comments.length < 5){
                            alert("评价不能为空且不能少于5字！");
                        }else {
                            $.post("${pageContext.request.contextPath}/comments/addComment?rand="+Math.random(),
                                {
                                    lightId:lightId,
                                    comments:comments
                                },
                                function(data,status){
                                    if(status == "success"){
                                        alert("评价成功");
                                        $("#comment").modal("hide");
                                        $("#comments").val("");
                                    }
                                });

                        }
                    });
                </script>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
