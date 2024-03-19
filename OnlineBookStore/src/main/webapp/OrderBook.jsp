<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
String msg = (String)request.getAttribute("amt");
out.println("Page belongs to : "+cb.getfName()+"<br>");
out.println(msg);
%>
<a href="view2">ViewAllBooks</a>
<a href="logout">Logout</a>
</body>
</html>