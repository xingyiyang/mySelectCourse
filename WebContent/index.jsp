<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录|学生选课信息管理系统</title>
    <link rel="SHORTCUT ICON" href="static/image/logo.ico">
  　　<link rel="BOOKMARK" href="static/image/logo.ico">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/signin.css" rel="stylesheet">
</head>

<body>

   <h2>选课管理信息系统登陆</h2>

    <div class="container">

    <div id="error" class="row">${error}</div>
        <form class="form-signin" action="signin" method="post">
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required="" autofocus="">
            <br/>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required="">
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> 记住密码
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>

    </div> <!-- /container -->
</body>
</html>