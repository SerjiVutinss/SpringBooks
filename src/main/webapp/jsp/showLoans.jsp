<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Loans</title>
</head>
<body>

	<table>
		<tr>
			<th>LoanID</th>
		</tr>
		<tr>
			<c:forEach items="${loans}" var="l">

				<tr>
					<td>${l.lid}</td>
					<td>${l.cust.cName}</td>
					<td>${l.book.title}</td>
					<td>${l.dueDate}</td>
				</tr>
			</c:forEach>
		</tr>

	</table>

</body>
</html>