<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Loan</title>
</head>
<body>

	<form:form modelAttribute="loanModel">
		<table>
			<tr>
				<td>CustID:</td>
				<td><form:input path="customerId"></form:input></td>
				<td><form:errors path="customerId"></form:errors></td>
			</tr>
			<tr>
				<td>BookID:</td>
				<td><form:input path="bookId"></form:input></td>
				<td><form:errors path="bookId"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>