<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers List</title>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Loan Period</th>
		</tr>
		<tr>
			<c:forEach items="${customers}" var="customer">

				<tr>
					<td>${customer.cId}</td>
					<td>${customer.cName}</td>
					<td>${customer.loanPeriod}</td>
				</tr>
			</c:forEach>
		</tr>

	</table>

</body>
</html>