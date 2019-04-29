<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books List</title>
<link href="css/tables.css" rel="stylesheet">
</head>
<body>

	<h1>List of Books</h1>

	<table class="data-table">
		<tr>
			<th>Book ID</th>
			<th>Title</th>
			<th>Author</th>
		</tr>

		<c:forEach items="${books}" var="b">
			<tr>
				<td>${b.bid}</td>
				<td>${b.title}</td>
				<td>${b.author}</td>
			</tr>
		</c:forEach>

	</table>

	<jsp:include page="footer-menu.jsp" />

</body>
</html>