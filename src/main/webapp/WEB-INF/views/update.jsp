<%--
  Created by IntelliJ IDEA.
  User: hainv
  Date: 11/11/2023
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>FORM EDIT STUDENT</h3>
<form action="/students/update" method="post">
    <input type="text" name="id" placeholder="Nhập id" value="${student.id}">
    <input type="text" name="name" placeholder="Nhập tên" value="${student.name}">
    <button type="submit">Submit</button>
</form>

</body>
</html>
