<%--
  Created by IntelliJ IDEA.
  User: Fuxi
  Date: 2017/5/31
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>品牌管理</title>
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
                    idField: 'brandId',
                    url: '${pageContext.servletContext.contextPath}/brand/brandList?randID='+Math.random(),
                    columns: [{
                        field: 'brandId',
                        title: 'ID'
                    }, {
                        field: 'brandName',
                        title: '品牌名称',
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
                        var brand = row;
                        $.ajax({
                            type: 'post',
                            url: '${pageContext.servletContext.contextPath}/brand/updateBrand',
                            data: JSON.stringify(brand),
                            contentType: 'application/json',
                            success: function(data) {
                                if(data == "success"){
                                    alert("修改成功");
                                }else {
                                    alert("修改失败");
                                }
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
                var brand = row;
                $.ajax({
                    type: 'post',
                    url: '${pageContext.servletContext.contextPath}/brand/deleteBrand',
                    data: JSON.stringify(brand),
                    contentType: 'application/json',
                    success: function(data) {
                        if(data == "success"){
                            alert('删除成功');
                            $("#table").bootstrapTable('removeByUniqueId',row.brandId);
                        }else {
                            alert("删除失败");
                        }

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
                if (key=="brandId")
                    key = "ID";
                if (key=="brandName")
                    key = "品牌名称";
                html.push('<p><b>' + key + ':</b> ' + value + '</p>');
            });
            return html.join('');
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
                <div class="panel-heading">品牌管理</div>
                <div class="panel-body">
                    <div id="toolbar" class="btn-group">
                        <button type="button" class="btn  btn-info" data-toggle="modal" data-target="#myModal">添加品牌</button>
                    </div>
                    <table data-search="true"
                           data-show-columns="true" data-show-toggle="true" data-show-refresh="true" data-pagination="true" data-detail-view="true"
                           data-toolbar="#toolbar"  data-detail-formatter="detailFormatter" data-cache="false" id="table" data-unique-id="brandId">
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
                    填写品牌信息
                </h4>
            </div>
            <div class="modal-body" id="div1">
                <form class="form-horizontal" role="form" id="form" action="${pageContext.servletContext.contextPath}/brand/addBrand" method="post">
                    <div class="form-group">
                        <label for="name">品牌名称</label>
                        <input type="text" class="form-control" id="name" name="brandName" placeholder="请输入品牌名称">
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
