<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer</title>
<link href="css/tables.css" rel="stylesheet">
</head>
<body>

	<h1>Add New Customer</h1>

	<form:form modelAttribute="customer">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="cName"></form:input></td>
				<td><form:errors path="cName"></form:errors></td>

			</tr>
			<tr>
				<td>Loan Period:</td>
				<td><form:input path="loanPeriod"></form:input></td>
				<td><form:errors path="loanPeriod"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

	<jsp:include page="footer-menu.jsp" />

</body>
</html>