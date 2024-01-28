<%@page import="controller.CategoryController"%>
<%@page import="dao.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>




</head>
<body>
<h1>Bloguma Hoş Geldiniz!!!</h1>
<div class="row">
<div class="col"><a href="/blog/categoryadd.jsp">Kategori Ekle</a></div>
</div>
<ul>
<%List<Category> kategoriler=CategoryController.getAllCategory();
for(Category cat:kategoriler){
%>
	<li>
	<a href="/blog/category_detail.jsp?id=<%=cat.getId()%>"><%=cat.getName() %></a></li>
<%}%>
</ul>
</body>
</html>