<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
String msg = (String)request.getAttribute("msg");
out.println("Page belongs to : "+ab.getfName()+"<br>");
out.println(msg);
%>
<a href="Book.html">AddBook</a>
<a href="view1">ViewAllBooks</a>
<a href="logout">Logout</a>
</body>
</html>