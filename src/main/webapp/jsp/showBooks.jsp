<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books List</title>
</head>
<body>

	<table>
		<tr>
			<th>Title</th>
			<th>Author</th>
		</tr>
		<tr>
			<c:forEach items="${books}" var="b">

				<tr>
					<td>${b.title}</td>
					<td>${b.author}</td>
				</tr>
			</c:forEach>
		</tr>

	</table>

</body>
</html>