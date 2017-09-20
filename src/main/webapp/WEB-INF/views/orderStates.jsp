<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/28
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单状态管理</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-editable.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-editable.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-table-editable.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript">

        $(function(){
            $(function () {
                $('#table').bootstrapTable({
                    idField: 'id',
                    url: '${pageContext.servletContext.contextPath}/ordersManager/orderstatesList?randID='+Math.random(),
                    columns: [{
                        field: 'id',
                        title: 'ID'
                    }, {
                        field: 'name',
                        title: '名称',
                        editable: {
                            type: 'text',
                            title: '名称',
                            validate: function (v) {
                                if (!v) return '名称不能为空';
                            }
                        }
                    }, {
                        field: 'action',
                        title: '操作',
                        formatter: 'actionFormatter',
                        events: 'actionEvents'
                    }],
                    onEditableSave: function (field, row, oldValue, $el) {
                        var orderStates = row;
                        $.ajax({
                            type: 'post',
                            url: '${pageContext.servletContext.contextPath}/ordersManager/updateOrderStates',
                            data: JSON.stringify(orderStates),
                            contentType: 'application/json',
                            success: function(data) {
                                alert('修改成功');
                            },
                            error: function () {
                                alert('修改失败');
                            },
                            complete: function () {

                            }

                        });
                    }
                });
            });
            $("#bt").click(function(){
                $('#form').submit();

            });
        });
        function actionFormatter(value, row, index) {
            return [
                '<a class="remove ml10" href="javascript:void(0)" title="删除">',
                '<i class="glyphicon glyphicon-remove"></i>',
                '</a>'
            ].join('');
        }

        window.actionEvents = {
            'click .remove': function (e, value, row, index) {
                var orderStates = row;
                $.ajax({
                    type: 'post',
                    url: '${pageContext.servletContext.contextPath}/ordersManager/deleteOrderStates',
                    data: JSON.stringify(orderStates),
                    contentType: 'application/json',
                    success: function(data) {
                        alert('删除成功');
                        $("#table").bootstrapTable('removeByUniqueId',row.id);
                    },
                    error: function () {
                        alert('删除失败');
                    },
                    complete: function () {

                    }

                });
            }
        };
        function detailFormatter(index, row) {
            var html = [];
            $.each(row, function (key, value) {
                if (key=="id")
                    key = "ID";
                if (key=="name")
                    key = "名称";
                html.push('<p><b>' + key + ':</b> ' + value + '</p>');
            });
            return html.join('');
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
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">订单状态管理</div>
                <div class="panel-body">
                    <div id="toolbar" class="btn-group">
                        <button type="button" class="btn  btn-info" data-toggle="modal" data-target="#myModal">添加状态</button>
                    </div>
                    <table data-search="true"
                           data-show-columns="true" data-show-toggle="true" data-show-refresh="true" data-pagination="true" data-detail-view="true"
                           data-toolbar="#toolbar"  data-detail-formatter="detailFormatter" data-cache="false" id="table" data-unique-id="id">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    订单详情
                </h4>
            </div>
            <div class="modal-body" id="div1">
                <form class="form-horizontal" role="form" id="form" action="${pageContext.servletContext.contextPath}/ordersManager/addOrderStates" method="post">
                    <div class="form-group">
                        <label for="name">名称</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入名称">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
                <button type="button" id="bt" class="btn btn-primary">
                    提交添加
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
