<%@page import="dao.Category"%>
<%@page import="controller.CategoryController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int id=Integer.valueOf(request.getParameter("id"));
    Category cat=CategoryController.getById(id);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta lang="tr">
<meta charset="UTF-8">
<title><%=cat.getName() %></title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


</head>
<body>
<div class="row">
<div class="col"><a href="/blog/index.jsp">Anasayfa</a></div>
</div>


<div class="container">
<h1><%=cat.getName() %> Makaleleri</h1>

</div>
</body>
</html>