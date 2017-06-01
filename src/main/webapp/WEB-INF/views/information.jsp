<%--
  Created by IntelliJ IDEA.
  User: AgZou
  Date: 2017/5/13
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <!--导航栏+bootstrap-->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/fonts/FontAwesome/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootsnav.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/overwrite.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/skins/color.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootsnav.js"></script>
    <!--导航栏目+bootstrap-->
    <!--x-editable-->
    <link href="${pageContext.request.contextPath}/css/bootstrap-editable.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/bootstrap-editable.js"></script>
</head>
<script>
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
<body onload="loadcart()">
<jsp:include page="navigation.jsp"/>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">个人信息<small>&nbsp;&nbsp;点击内容修改</small></h3>
        </div>
        <table class="table table-bordered">
            <tbody>
            <tr>
                <td>登陆账号</td>
                <td>${user.loginId}</td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><a href="#" data-type="text" data-title="用户名" id="userName" >${user.userName}</a></td>
            </tr>
            <tr>
                <td>手机</td>
                <td><a href="#" data-type="text" data-title="'手机号码" id="phone">${user.phone}</a></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><a href="#" data-type="text" data-title="地址" id="address">${user.address}</a></td>
            </tr>
            <tr>
                <td>邮编</td>
                <td><a href="#" data-type="text" data-title="邮编" id="postalCode">${user.postalCode}</a></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><a href="#" data-type="select" data-title="性别" id="gender">${user.gender}</a></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><a href="#" data-type="text" data-title="邮箱" id="email">${user.email}</a></td>
            </tr>
            <tr>
                <td>最近登陆时间</td>
                <td>${user.lastLoginTime}</td>
            </tr>
            <tr>
                <td>密码</td>
                <td><button class="btn btn-default" data-toggle="modal" data-target="#myModal">修改</button></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%--修改密码模态框--%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/updatepwd">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
                <div class="modal-body">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">旧密码</label>
                            <div class="col-sm-10"><input type="password" class="form-control" name="opwd" id="opwd" required onblur="checkOpasswords()">
                            <span id="msg" class="text-danger"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">新密码</label>
                            <div class="col-sm-10"><input type="password" class="form-control" name="npwd" id="npwd" required onchange="checkPasswords()"></div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">重复密码</label>
                            <div class="col-sm-10"><input type="password" class="form-control" name="rnpwd" id="rnpwd" required onchange="checkPasswords()"></div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary" id="subform">提交更改</button>
                </div>
            </div>
            </form></div>
    </div>
</div>
<script>
  $.fn.editable.defaults.modal='inline';
  $(document).ready(function () {
      $("#userName").editable({
          url:"${pageContext.request.contextPath}/user/update",
          pk:1,
          name:'userName',
          params:function (params) {
              var data={};
              data['flag']=params.name;
              data['v']=params.value;
              return data;
          }
      });
      $("#phone").editable({
          url:"${pageContext.request.contextPath}/user/update",
          pk:1,
          name:'phone',
          params:function (params) {
              var data={};
              data['flag']=params.name;
              data['v']=params.value;
              return data;
          },
          validate:function (value) {
              var ret = /^[\d]{5,20}$/;
              if(!ret.test(value))
                  return '请输入正确的手机号码';
          }
      })
      $("#address").editable({
          url:"${pageContext.request.contextPath}/user/update",
          pk:1,
          name:'address',
          params:function (params) {
              var data={};
              data['flag']=params.name;
              data['v']=params.value;
              return data;
          }
      })
      $("#postalCode").editable({
          url:"${pageContext.request.contextPath}/user/update",
          pk:1,
          name:'postalCode',
          params:function (params) {
              var data={};
              data['flag']=params.name;
              data['v']=params.value;
              return data;
          }
      })
      $("#gender").editable({
          url:"${pageContext.request.contextPath}/user/update",
          source:[{value:'男',text:'男'},{value:'女',text:'女'}],
          pk:1,
          name:'gender',
          params:function (params) {
              var data={};
              data['flag']=params.name;
              data['v']=params.value;
              return data;
          }
      })
      $("#email").editable({
          url:"${pageContext.request.contextPath}/user/update",
          pk:1,
          name:'email',
          params:function (params) {
              var data={};
              data['flag']=params.name;
              data['v']=params.value;
              return data;
          },
          validate:function(value){
              var ret=/^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
              if(!ret.test(value))
                  return '请输入正确邮箱地址';
          }
      })
  });
  function checkPasswords() {
      var pass1 = document.getElementById("npwd");
      var pass2 = document.getElementById("rnpwd");

      if (pass1.value != pass2.value)
          pass1.setCustomValidity("两次输入的密码不匹配");
      else
          pass1.setCustomValidity("");
  }
  function checkOpasswords(){
      $.ajax({
          cache:false,
          url:"${pageContext.request.contextPath}/user/checkopwd",
          data:{'opwd':$("#opwd").val()},
          success:function(data){
                 if(data=="no"){
                     $("#opwd").focus().val('');
                     $("#msg").html("密码错误");
                 }else $("#msg").html("");


          }
      })
  }


</script>
</body>
</html>
