<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JShop商城后台管理登录</title>
    <link rel="stylesheet" href="/css/animate.min.css">
    <link rel="stylesheet" href="/css/bootstrap.min14ed.css">
    <link rel="stylesheet" href="/css/font-awesome.min93e3.css">
    <link rel="stylesheet" href="/css/style.min862f.css">
    <!-- 兼容ie9-->
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>
<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">S+</h1>

        </div>
        <h3>欢迎使用 JShop管理平台</h3>

        <form class="m-t" role="form" action="http://www.zi-han.net/theme/hplus/index.html">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center">
                <a href="login.html#">
                    <small>忘记密码了？</small>
                </a>
                <%--| <a href="register.html">注册一个新账号</a>--%>
            </p>

        </form>
    </div>
</div>
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<%--<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>--%>
<script type="text/javascript">
    $("#login").click(function () {
        var username = $("[name=username]").val();
        var password = $("[name=password]").val();

        if (username != "admin" || password != "admin") {
            $.messager.alert('错误', "用户名密码不正确！");
            return;
        }
        window.location.href = "/rest/page/index";
    });
</script>
</body>


</body>
</html>