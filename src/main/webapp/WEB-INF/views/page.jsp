<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/31
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面管理</title>
</head>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap-3.1.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-table.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-editable.css">
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-editable.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-editable.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.js"></script>

<link href="${pageContext.request.contextPath}/css/fileinput.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/fileinput.js"></script>
<script src="${pageContext.request.contextPath}/js/locales/zh.js"></script>
<script>
    $(function () {
        $("#select").change(function () {
            $('#input-file').fileinput('clear');
            $("#carouselImg1").fileinput('refresh',{uploadExtraData:{'imgNumber':$("#select").val()}})
        })
        $("#carouselImg1").fileinput({
            showCaption: false,
            language:'zh',
            uploadUrl: "${pageContext.request.contextPath}/file/fileUpload1", // server upload action
            uploadAsync: true,
            uploadExtraData:{'imgNumber':$("#select").val()},
            maxFileCount: 1,
            allowedFileExtensions: ["jpg", "png", "gif"]

        });
    })
    function chekclightId(a) {

        if($(a).val()!="")
        $.post('${pageContext.request.contextPath}/page/getLight',{'lightId':$(a).val()},function (result) {
            if(result=="no") {
                $(a).focus();
                $(a).val("");
            }
        })
    }

</script>
<body>
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <div class="panel-primary">
                <div class="panel-heading">首页设置</div>
                <div class="panel-body">
                    <h3>轮播框设置</h3>
                    <div class="form-group">
                    <label for="select">轮播图片</label>
                        <select class="form-control" id="select">
                            <option value="1">图一</option>
                            <option value="2">图二</option>
                            <option value="3">图三</option>
                        </select>
                    <input type="file" id="carouselImg1"  class="file-loading" name="file" accept="image/*">
                    </div>
                    <h3>热销商品</h3>
                    <form class="form-horizontal" role="form" style="width: 400px" action="${pageContext.request.contextPath}/page/submit">
                        <div class="form-group-sm">
                            <label for="hotSale1" class="col-xs-3 control-label">热销商品一</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale1" placeholder="请输入灯饰ID" class="form-control" name="hotSale1" onblur="chekclightId(this)" ></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale2" class="col-xs-3 control-label">热销商品二</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale2" placeholder="" class="form-control" name="hotSale2" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale3" class="col-xs-3 control-label">热销商品三</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale3"  class="form-control" name="hotSale3" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale4" class="col-xs-3 control-label">热销商品四</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale4"  class="form-control" name="hotSale4" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale5" class="col-xs-3 control-label">热销商品五</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale5"  class="form-control" name="hotSale5" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale6" class="col-xs-3 control-label">热销商品六</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale6"  class="form-control" name="hotSale6" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale7" class="col-xs-3 control-label">热销商品七</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale7" class="form-control" name="hotSale7" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale8" class="col-xs-3 control-label">热销商品八</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale8"  class="form-control" name="hotSale8" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <label for="hotSale9" class="col-xs-3 control-label">热销商品九</label>
                            <div class=" col-xs-9">
                                <input type="text" id="hotSale9"  class="form-control" name="hotSale9" onblur="chekclightId(this)"></div>
                        </div>
                        <div class="form-group-sm">
                            <div class="col-xs-offset-3 col-xs-9">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </form>
                    <form class="form-horizontal" role="form" style="width: 400px" action="${pageContext.request.contextPath}/page/submit1">
                        <h3>清仓商品</h3>
                        <div class="form-group-sm">
                            <label class="col-xs-3 control-label" for="endSale1">清仓商品一</label>
                            <div class="col-xs-9">
                                <input class="form-control" id="endSale1" name="endSale1">
                            </div>
                        </div>
                        <div class="form-group-sm">
                            <label class="col-xs-3 control-label" for="endSale2">清仓商品二</label>
                            <div class="col-xs-9">
                                <input class="form-control" id="endSale2" name="endSale2">
                            </div>
                        </div>
                        <div class="form-group-sm">
                            <div class="col-xs-offset-3 col-xs-9">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
