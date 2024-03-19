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
AdminBean ab = (AdminBean)session.getAttribute("abean");
BookBean bb = (BookBean)request.getAttribute("bbean");
out.println("page belongs to : "+ab.getfName()+"<br>");
%>
<form action="update" method ="post" style="width: 30rem;">
<input type="hidden" name="bcode" value=<%=bb.getCode() %>>
<table class="table">
	<tr>
		<td>Book Price</td>
		<td><input type="text" name="bprice" value=<%=bb.getPrice() %> class="form-control"></td>
	</tr>
	<tr>
		<td>Book Quantity</td>
		<td><input type="text" name="bqty" value=<%=bb.getQty() %> class="form-control"></td>
	</tr>
</table>

<button class="btn btn-primary">UpdateBookDetails</button>
</form>
</body>
</html>