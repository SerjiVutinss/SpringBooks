<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>

	<form:form modelAttribute="book">
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title"></form:input></td>
				<td><form:errors path="title"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author"></form:input></td>
				<td><form:errors path="author"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>