<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/26
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
    <link rel="stylesheet" href="//rawgit.com/wenzhixin/bootstrap-table/master/src/bootstrap-table.css">
    <link rel="stylesheet" href="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <script src="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
    <script src="//rawgit.com/wenzhixin/bootstrap-table/master/src/extensions/editable/bootstrap-table-editable.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(function () {
                $('#table').bootstrapTable({
                    idField: 'ordersId',
                    url: '${pageContext.servletContext.contextPath}/ordersManager/ordersList?randID='+Math.random(),
                    columns: [[{
                        title: '订单编号',
                        field: 'ordersId'
                    },{
                        field: 'userByUserId.userName',
                        title: '用户名'
                    },{
                        field: 'date',
                        title: '下单时间',
                        sortable: true,
                        formatter:'json2TimeStamp'
                    },{
                        field: 'totalPrice',
                        title: '订单总价(元)'
                    },{
                        field: 'orderStateId',
                        title: '订单状态',
                        editable: {
                            type: 'select',
                            title: '订单状态',
                            source: function () {
                                var result = [];
                                $.ajax({
                                    url: '${pageContext.servletContext.contextPath}/ordersManager/orderstatesList?randID='+Math.random(),
                                    async: false,
                                    type: "post",
                                    data: {},
                                    success: function (data, status) {
                                        $.each(data, function (key, value) {
                                            result.push({ value: value.id, text: value.name });
                                        });
                                    }
                                });
                                return result;
                            }
                        }
                    },{
                        field: 'action',
                        title: '操作',
                        formatter: 'actionFormatter',
                        events: 'actionEvents'
                    }]],
                    onEditableSave: function (field, row, oldValue, $el) {
                        var orders = row;
                        $.ajax({
                            type: 'post',
                            url: '${pageContext.servletContext.contextPath}/ordersManager/updateOrders',
                            data: JSON.stringify(orders),
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
        });
        function actionFormatter(value, row, index) {
            return [
                '<a class="option-horizontal ml10" href="javascript:void(0)" title="订单详情">',
                '<i class="glyphicon glyphicon-option-horizontal"></i>',
                '</a>'
            ].join('');
        }

        window.actionEvents = {
            'click .option-horizontal': function (e, value, row, index) {
                var div = $('#div1');
                div.empty();

                div.append('<p>订单号：'+row.ordersId+'&nbsp;&nbsp;&nbsp;&nbsp;下单时间:'+json2TimeStamp(value,row,index)+'</p>');
                div.append('<p><span class="label label-primary">订单状态</span></p>');
                div.append('<p>订单状态：'+row.orderstatesByOrderStateId.name+'</p>');
                div.append('<p><span class="label label-info">收件人信息</span></p>');
                div.append('<p>收件人姓名：'+row.receiveName+'</p><p>收件人电话：'+row.receivePhone+'</p> <p>收件人邮箱：'+row.email+'</p> <p>收件人地址：'+row.address+'</p>');
                div.append('<p><span class="label label-info">支付及配送信息</span></p> <p>支付方式：'+row.paymentType+'</p> <p>快递类型：'+row.postType+'</p> <p>快递费用(元)：'+row.postFee+'</p> <p>邮政编码：'+row.postalCode+'</p>');
                div.append('<p><span class="label label-info">商品信息</span></p>');
                div.append('<p>实际支付(元)：'+row.totalPrice+'</p>');
                var table = $('#modalTable');
                table.empty();
                table.append('<thead> <tr><th>商品</th> <th>单价(元)</th> <th>数量</th> <th>小计（元）</th> </tr> </thead>');
                $.each(row.orderlightsByOrdersId, function (key, value) {
                    table.append('<tbody> <tr> <td><a href="${pageContext.request.contextPath}/light/lightInfo?lightId='+value.lightId+'" target="_blank"><img height="80px" width="80px" src="${pageContext.request.contextPath}/'+value.lightByLightId.image1+'"></a> <a type="button" class="btn btn-link" href="${pageContext.request.contextPath}/light/lightInfo?lightId='+value.lightId+'" target="_blank">'+value.lightByLightId.name+'</a> </td> <td>'+value.lightByLightId.price*value.lightByLightId.discount*1.00+'</td> <td>'+value.quantity+'</td> <td>'+value.lightByLightId.price*value.lightByLightId.discount*value.quantity*1.00+'</td> </tr> </tbody>');
                });

                $('#myModal').modal("show");
            }
        };
        function detailFormatter(index, row) {
            var html = [];
            $.each(row, function (key, value) {
                if (key=="ordersId"){
                    key = "订单编号";
                    html.push('<p><b>' + key + ':</b> ' + value + '</p>');
                }
                if (key=="userByUserId"){
                    key = "用户名";
                    html.push('<p><b>' + key + ':</b> ' + value.userName + '</p>');
                }
                if (key=="date"){
                    key = "下单时间";
                    html.push('<p><b>' + key + ':</b> ' + value + '</p>');
                }
                if (key=="totalPrice"){
                    key = "订单总价(元)";
                    html.push('<p><b>' + key + ':</b> ' + value + '</p>');
                }
                if (key=="orderstatesByOrderStateId"){
                    key = "订单状态";
                    html.push('<p><b>' + key + ':</b> ' + value.name + '</p>');
                }
            });
            return html.join('');
        }
        function json2TimeStamp(value, row, index){
            var datetime = new Date();
            datetime.setTime(row.date);
            var year=datetime.getFullYear();

            //月份重0开始，所以要加1，当小于10月时，为了显示2位的月份，所以补0
            var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
            var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
            var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
            var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
            var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
            return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;

        }
    </script>
</head>
<body>
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">订单管理</div>
                <div class="panel-body">
                    <table data-search="true"
                           data-show-columns="true" data-show-toggle="true" data-show-refresh="true" data-pagination="true" data-detail-view="true"
                           data-toolbar="#toolbar"  data-detail-formatter="detailFormatter" data-cache="false" id="table" data-unique-id="ordersId">
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
                按下 ESC 按钮退出。
            </div>
            <table id="modalTable" class="table table-bordered" style="font-size: small;"></table>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>
