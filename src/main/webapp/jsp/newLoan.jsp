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
	<h1>New Loan</h1>
	<form:form modelAttribute="loanModel">

		<form:select path="customerId" items="${customerList}" />
		<form:select path="bookId" items="${bookList}" />

		<input type="submit" value="Add" />

		<%--
		 <table>
			<tr>
				<td>CustID:</td>
				<td><form:input path="customerId"></form:input></td>
				<td><form:errors path="customerId"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td>BookID:</td>
				<td><form:input path="bookId"></form:input></td>
				<td><form:errors path="bookId"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
		--%>

	</form:form>

</body>
</html>