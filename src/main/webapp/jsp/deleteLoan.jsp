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

	<form:form modelAttribute="loan">
		<table>
			<tr>
				<td>LoanID:</td>
				<td><form:input path="lid"></form:input></td>
				<td><form:errors path="lid"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>