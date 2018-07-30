<%@ page import="lib.Dao.TeacherDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>

  <div class="container">
    <h5><b>当前位置</b>：信息管理 > 学生选课管理</h5>
    <hr>
    <div>
      <% TeacherDao teacherDAO = new TeacherDao();%>
      <%=teacherDAO.getScource()%>
    </div>
  </div>


</body>
</html>
