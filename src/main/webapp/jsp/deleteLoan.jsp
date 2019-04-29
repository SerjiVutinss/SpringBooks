<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Loan</title>
<link href="css/tables.css" rel="stylesheet">
</head>
<body>

	<h1>Delete Loan</h1>

	<form:form modelAttribute="loan">
		<form:select path="lid" items="${loansList}" />

		<input type="submit" value="Delete" />

		<%--
		<table>
			<tr>
				<td>LoanID:</td>
				<td><form:input path="lid"></form:input></td>
				<td><form:errors path="lid"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
		 --%>
	</form:form>

	<jsp:include page="footer-menu.jsp" />

</body>
</html>