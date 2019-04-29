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

	<c:forEach items="${customers}" var="customer">
		<h2>${customer.cId} - ${customer.cName}</h2>
		<p>Loan Period = ${customer.loanPeriod} days</p>
		<h3>${customer.cName}'sLoans</h3>

		<table>
			<tr>
				<th>Loan ID</th>
				<th>Book ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Due Date</th>
			</tr>

			<c:forEach items="${customer.loans}" var="loan">
				<tr>
					<td>${loan.lid}</td>
					<td>${loan.book.bid}</td>
					<td>${loan.book.title}</td>
					<td>${loan.book.author}</td>
					<td>${loan.dueDate}</td>
				</tr>
			</c:forEach>
		</table>

	</c:forEach>

	<a href="<c:url value="/logout" />">Logout</a>

</body>
</html>