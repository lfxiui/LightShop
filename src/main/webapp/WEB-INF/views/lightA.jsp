<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/26
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<head>
    <title>Title</title>
</head>
<script>
    $(document).ready(function(){
        $("#table").bootstrapTable('refresh',{url:"${pageContext.request.contextPath}/light/getLights"});
    })
    function actionFormatter(value, row, index) {
        return [ '<a class="edit ml10" href="javascript:void(0)" title="编辑">',
            '<i class="glyphicon glyphicon-edit"></i>', '</a>',
            '<a class="remove ml10" href="javascript:void(0)" title="删除">',
            '<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
    }
    function footerFormatter(value,row,index){
        return '<a target="_blank" href="/light/lightInfo?lightId= '+row.lightId+'">'+row.name+'</a>';
    }
    window.actionEvents = {
        'click .edit' : function(e, value, row, index) {
            $("#form1")
                .append(
                    "<input type='hidden' name='employeeId' value="+row.employeeId+">");
            $("#update").modal('show');

        },
        'click .remove' : function(e, value, row, index) {
            $.post("${pageContext.servletContext.contextPath}/Staff/delete", {
                id : row.employeeId

            }, function(data, status) {
                if (status == "success")
                    $("#table").bootstrapTable('removeByUniqueId',
                        row.employeeId);

            });
        }
    };
</script>
<body>
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <h3>商品管理</h3>
            <div id="toolbar" class="btn-group">
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="">添加商品</button>
            </div>
            <table data-toggle="table" data-search="true" data-show-columns="true"
                   data-pagination="true"
                    data-toolbar="#toolbar"
                    data-cache="false"
                   id="table" data-unique-id="lightId">
                <thead>
                <tr>
                    <th data-field="lightId">ID</th>
                    <th data-field="name"  	data-formatter="footerFormatter">名字</th>
                    <th data-field="price" data-sortable="true">价格</th>
                    <th data-field="discount">折扣</th>
                    <th data-field="quantity">库存</th>
                    <th data-field="brandByBrandId.brandName">品牌</th>
                    <th data-field="catagoryByCatagoryId.catagoryName">光源类型</th>
                    <th data-field="styleByStyleId.styleName">分格</th>
                    <th data-field="stuffByStuffId.stuffName">材质</th>
                    <th data-field="locateByLocateId.name">位置</th>
                    <th data-field="sale">销量</th>
                    <th data-field="click">点击</th>
                    <th data-field="store">收藏</th>
                    <th data-field="description">详情描述</th>
                    <th data-field="action" data-formatter="actionFormatter"
                        data-events="actionEvents">操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
</body>
</html>
