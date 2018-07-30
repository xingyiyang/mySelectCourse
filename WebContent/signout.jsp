<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="static/css/signout.css" rel="stylesheet">
</head>
<body>
<br>
  <%
    session.invalidate();
  %>

  <p>
    ：）您已成功注销，正在跳转至登陆页面！</br></br>
    ......
  </p>

  <%
    response.setHeader("refresh","1;url=index.jsp");
  %>
  <img alt="注销" src="static/image/zhuxiao.png" style="margin: auto,auto; padding-left: 400px; ">

</body>
</html>
