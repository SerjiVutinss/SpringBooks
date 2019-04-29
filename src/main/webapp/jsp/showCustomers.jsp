<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers List</title>
<link href="css/tables.css" rel="stylesheet">
</head>
<body>

	<h1>List of Customers</h1>

	<c:forEach items="${customers}" var="c">
		<h2>${c.cId} - ${c.cName}</h2>
		<p>Loan Period = ${c.loanPeriod} days</p>
		<h3>${c.cName}'sLoans</h3>

		<table class="data-table">
			<tr>
				<th>Loan ID</th>
				<th>Book ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Due Date</th>
			</tr>

			<c:forEach items="${c.loans}" var="l">
				<tr>
					<td>${l.lid}</td>
					<td>${l.book.bid}</td>
					<td>${l.book.title}</td>
					<td>${l.book.author}</td>
					<td>${l.dueDate}</td>
				</tr>
			</c:forEach>

		</table>

	</c:forEach>

	<jsp:include page="footer-menu.jsp" />

</body>
</html>