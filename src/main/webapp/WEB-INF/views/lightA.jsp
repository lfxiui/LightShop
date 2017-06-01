<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
<link rel="stylesheet" href="//rawgit.com/wenzhixin/bootstrap-table/master/src/bootstrap-table.css">
<link rel="stylesheet" href="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/css/bootstrap-editable.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="//rawgit.com/vitalets/x-editable/master/dist/bootstrap3-editable/js/bootstrap-editable.js"></script>
<script src="//rawgit.com/wenzhixin/bootstrap-table/master/src/extensions/editable/bootstrap-table-editable.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

<link href="${pageContext.request.contextPath}/css/fileinput.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/fileinput.js"></script>
<script src="${pageContext.request.contextPath}/js/locales/zh.js"></script>
<head>
    <title>Title</title>
</head>
<script>
   $(function() {
       var Brands=[];
       var Styles=[];
       var Catagorys=[];
       var Stuffs=[];
       var Locates=[];
      <c:forEach items="${Brands}" var="brand">
       Brands.push({'value':'${brand.brandId}','text':'${brand.brandName}'});
      </c:forEach>
       <c:forEach items="${Styles}" var="style">
       Styles.push({'value':'${style.styleId}','text':'${style.styleName}'});
       </c:forEach>
       <c:forEach items="${Catagorys}" var="catagory">
       Catagorys.push({'value':'${catagory.catagoryId}','text':'${catagory.catagoryName}'});
       </c:forEach>
       <c:forEach items="${Stuffs}" var="stuff">
       Stuffs.push({'value':'${stuff.stuffId}','text':'${stuff.stuffName}'});
       </c:forEach>
       <c:forEach items="${Locates}" var="locate">
       Locates.push({'value':'${locate.locateId}','text':'${locate.name}'});
       </c:forEach>
        $("#table").bootstrapTable({
            url:'${pageContext.request.contextPath}/light/getLights',
            columns:[
                {
                    field:'lightId',
                    title:'Id',
                    formatter:'footerFormatter'

                },
                {
                    field:'name',
                    title:'名字',
                    editable:{
                        type:'text',
                        title:'修改名字',
                        validate:function (value) {
                            if(!$.trim(value))
                                return '不能为空';
                        }
                    }
                },
                {
                    field:'brandId',
                    title:'品牌',
                    editable:{
                        type:'select',
                        title:"品牌",
                        source:Brands
                    }
                },
                {
                    field:'styleId',
                    title:'风格',
                    editable:{
                        type:'select',
                        title:"风格",
                        source:Styles
                    }
                },
                {
                    field:'stuffId',
                    title:'材质',
                    editable:{
                        type:'select',
                        title:"材质",
                        source:Stuffs
                    }
                },
                {
                    field:'catagoryId',
                    title:'光源类型',  editable:{
                    type:'select',
                    title:"光源类型",
                    source:Catagorys
                }
                },
                {
                    field:'locateId',
                    title:'安放位置',
                    editable:{
                        type:'select',
                        title:"安放位置",
                        source:Locates
                    }
                },
                {
                    field:'description',
                    title:'详情描述',
                    editable:{
                        type:'textarea',
                        title:"详情描述",
                        validate:function (value) {
                            if(!$.trim(value))
                                return '不能为空';
                        }
                    }

                },
                {
                    field:'price',
                    title:'价格',
                    sortable: true,
                    editable:{
                        type:'text',
                        title:"价格",
                        validate:function (value) {
                            if(!$.trim(value))
                                return '不能为空'
                        }
                    }
                },
                {
                    field:'discount',
                    title:'折扣',
                    editable:{
                        type:'text',
                        title:"折扣",
                        validate:function (value) {
                            var reg=/^[0-1]$|^0\.[0-9]+$/;
                            if(!reg.test(value))
                                return '请输入0~1小数';
                            if(!$.trim(value))
                                return '不能为空'
                        }
                    }
                },
                {
                    field:'quantity',
                    title:'库存',
                    editable:{
                        type:'text',
                        title:"库存",
                        validate:function (value) {
                            if(!$.trim(value))
                                return '不能为空'
                        }
                    }
                },
                {
                    field:'sale',
                    title:'销量',
                    sortable: true
                },
                {
                    field:'click',
                    title:'点击量',
                    sortable: true
                },
                {
                    field:'store',
                    title:'收藏量',
                    sortable: true
                },
                {
                    field:'action',
                    title:'操作',
                    formatter:'actionFormatter',
                    events:'actionEvents'
                }
              ],
            onEditableSave:function(field,row,oldValue,$el){
                    $.ajax({
                        type:'post',
                        url:'${pageContext.request.contextPath}/light/update',
                        data:JSON.stringify(row),
                        dataType:'json',
                        contentType:'application/json;charset=UTF-8',
                    })
            }
        });
    }
   )

    function actionFormatter(value, row, index) {
        return [ '<a class="edit ml10" href="javascript:void(0)" title="上传图片">',
            '<i class="glyphicon glyphicon-edit"></i>', '</a>',
            '<a class="remove ml10" href="javascript:void(0)" title="删除">',
            '<i class="glyphicon glyphicon-remove"></i>', '</a>' ].join('');
    }
    function footerFormatter(value,row,index){
        return '<a target="_blank" href="/light/lightInfo?lightId= '+row.lightId+'">'+row.lightId+'</a>';
    }
    window.actionEvents = {
        'click .edit' : function(e, value, row, index) {
            upload(row);
        },
        'click .remove' : function(e, value, row, index) {
            $.post("${pageContext.servletContext.contextPath}/light/delete", {
                "lightId" : row.lightId

            }, function(data, status) {
                if (status == "success")
                    $("#table").bootstrapTable('removeByUniqueId',
                        row.lightId);

            });
        }
    };
</script>
<body >
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <h3>商品管理</h3>
            <div id="toolbar" class="btn-group">
                <button type="button" class="btn btn-info" data-toggle="modal" href="#addLight">添加商品</button>
            </div>
            <table id="table"
                   data-search="true"
                   data-toolbar="#toolbar"
                   data-cache="false"
                   data-pagination="true"
                   data-show-columns="true"
                   data-unique-id="lightId">
            </table>
        </div>
    </div>
</div>
<div class="modal fade " id="updatePhoto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    上传图片
                </h4>
            </div>
            <div class="modal-body">
                <h3 class="text-danger text-center">最多上传3张照片</h3>
            <input id="input-file" type="file" multiple class="file-loading" name="file" accept="image/*">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
    <script>
        $('#updatePhoto').on('hide.bs.modal', function () {
            $('#input-file').fileinput('clear');
        })
        function upload(row){
            $("#input-file").fileinput({
                language:'zh',
                uploadUrl: "/file/fileUpload", // server upload action
                uploadAsync: true,
                uploadExtraData:{'lightId':row.lightId},
                maxFileCount: 3,
                allowedFileExtensions: ["jpg", "png", "gif"]

        });
            $("#updatePhoto").modal('show');}
    </script>
</div>
<div class="modal fade" id="addLight" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    <div class="modal-dialog" style="width: 800px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel1">
                    增加商品
                </h4>
            </div>
            <div class="modal-body">
               <form class="form-horizontal" action="${pageContext.request.contextPath}/light/addLight">
                   <div class="form-group">
                       <label class="col-sm-2 control-label">名字</label>
                       <div class="col-sm-10">
                           <input class="form-control" name="name" required>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">品牌</label>
                       <div class="col-sm-10">
                           <select class="form-control" name="brandId" required>
                               <c:forEach items="${Brands}" var="brand">
                                   <option value="${brand.brandId}">${brand.brandName}</option>
                               </c:forEach>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">风格</label>
                       <div class="col-sm-10">
                           <select class="form-control" name="styleId" required>
                               <c:forEach items="${Styles}" var="style">
                                   <option value="${style.styleId}">${style.styleName}</option>
                               </c:forEach>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">材质</label>
                       <div class="col-sm-10">
                           <select class="form-control" name="stuffId" required>
                               <c:forEach items="${Stuffs}" var="stuff">
                                   <option value="${stuff.stuffId}">${stuff.stuffName}</option>
                               </c:forEach>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">光源类型</label>
                       <div class="col-sm-10">
                           <select class="form-control" name="catagoryId" required>
                               <c:forEach items="${Catagorys}" var="catagory">
                                   <option value="${catagory.catagoryId}">${catagory.catagoryName}</option>
                               </c:forEach>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">安放位置</label>
                       <div class="col-sm-10">
                           <select class="form-control" name="locateId" required>
                               <c:forEach items="${Locates}" var="locate">
                                   <option value="${locate.locateId}">${locate.name}</option>
                               </c:forEach>
                           </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">库存</label>
                       <div class="col-sm-10">
                           <input type="text" name="quantity" class="form-control">
                       </div>
                   </div>
                   <div class="form-group">
                   <label class="col-sm-2 control-label">价格</label>
                   <div class="col-sm-10">
                       <input type="text" required name="price" class="form-control">
                   </div>
               </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">折扣</label>
                       <div class="col-sm-10">
                           <input type="text" required name="discount" value="1" class="form-control">
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-sm-2 control-label">详情描述</label>
                       <div class="col-sm-10">
                           <textarea name="description" class="form-control"></textarea>
                       </div>
                   </div>
                   <div class="modal-footer">
                   <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                   <button type="submit" class="btn btn-primary" >提交更改</button>
                   </div>
               </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
