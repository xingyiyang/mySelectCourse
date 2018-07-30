<%@ page import="lib.Dao.StudentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

  <div class="container">
    <h5><b>当前位置</b>：公告</h5>
    <hr>
    <% StudentDao studentDAO = new StudentDao();%>
    <%=studentDAO.getNotes()%>
  </div>

</body>
</html>
