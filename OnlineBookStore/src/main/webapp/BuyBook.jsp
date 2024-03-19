<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../node_modules/bootstrap-icons/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/bootstrap.css">
<style>
	td{
		font-weight:bold;
	}
</style>
</head>
<body class="container-fluid">
<%
CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
BookBean bb = (BookBean)request.getAttribute("bbean");
out.println("Page belongs to : "+cb.getfName()+"<br>");
%>
<form action="order" method="post" style="width:30rem;">
<table class="table">
	<tr>
		<td>Book Code</td>
		<td><input type="text" name="bcode" value=<%=bb.getCode() %>></td>
	</tr>
	<tr>
		<td>Book Name</td>
		<td><input type="text" name="bname" value=<%=bb.getName() %>></td>
	</tr>
	<tr>
		<td>Book Author</td>
		<td><input type="text" name="bauthor" value=<%=bb.getAuthor() %>></td>
	</tr>
	<tr>
		<td>Book Price</td>
		<td><input type="text" name="bprice" value=<%=bb.getPrice() %>></td>
	</tr>
	<tr>
		<td>Book Quantity</td>
		<td><input type="text" name="bqty" value=<%=bb.getQty() %>></td>
	</tr>
	<tr>
		<td>Required Books</td>
		<td><input type="text" name="rqty"></td>
	</tr>
</table>

<button class="btn btn-primary">Buy Books</button>
</form>
</body>
</html>