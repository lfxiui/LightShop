<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/24
  Time: 17:08
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
<script src="/js/Chart.js"></script>
<head>
    <title>Title</title>
</head>
<script>
    $(function () {
        $("#search").click(function () {
           $.post('/statistic/getLight',{'lightId':$("#lightId").val()},function (result) {
               if($.isEmptyObject(result)) {
                  $("#lightId").focus().val("").attr("placeholder","该ID不存在");
               }else radarChart(result)
           })
        })
        $("#search1").click(function () {
            $.post('${pageContext.request.contextPath}/statistic/getType',{'type':$("#select").val()},function (result) {
                pieChart(result)
            })
        })
    })
    function radarChart(result) {
        var ctx = document.getElementById("myChart").getContext("2d");
        var data = {
            labels : ["销量","价格","点击","收藏"],
            datasets : [
                {
                    fillColor : "rgba(220,220,220,0.5)",
                    strokeColor : "rgba(220,220,220,1)",
                    pointColor : "rgba(220,220,220,1)",
                    pointStrokeColor : "#fff",
                    data : [result.sale,result.price,result.click,result.store]
                }

            ]
        }
        new Chart(ctx).Radar(data)
        $("#msg").html("["+result.name+"]&nbsp;价格，收藏，销量，点击量的雷达图")
    }
    function pieChart(result){
        $("#myChart1").remove();
        $("#myChart1Parent").append('<canvas id="myChart1" width="400" height="400"></canvas>');
        var ctx = document.getElementById("myChart1").getContext("2d");
        new Chart(ctx).Pie(result);
    }
</script>
<body>
<jsp:include page="top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2 main">
            <div class="panel panel-primary">
                <div class="panel-heading">灯饰数据分析</div>
                <div class="panel-body">
                    <div class="form-inline">
                        <input type="text" placeholder="请输入灯饰ID" class="form-control" id="lightId">
                        <button class="btn btn-primary" type="button" id="search">查找</button>
                    </div>
                    <h4 class="text-danger" id="msg">该灯饰价格，收藏，销量，点击量的雷达图</h4>
                    <div class="col-md-offset-3">
                    <canvas id="myChart" width="400" height="400"></canvas>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">销量分布</div>
                <div class="panel-body">
                    <div class="form-inline">
                        <label class="control-label">选择要展示的销量分布类别</label>
                        <select class="form-control" id="select">
                            <option value="brand">品牌</option>
                            <option value="style">风格</option>
                            <option value="stuff">材质</option>
                            <option value="locate">安装位置</option>
                            <option value="catagory">光源类型</option>
                        </select>
                        <button class="btn btn-primary" id="search1">查找</button>
                    </div>
                    <h4 class="text-danger" id="msg1">该分类销量分布雷达图</h4>
                    <div  class="col-md-offset-3" id="myChart1Parent">
                        <canvas id="myChart1" width="400" height="400"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
