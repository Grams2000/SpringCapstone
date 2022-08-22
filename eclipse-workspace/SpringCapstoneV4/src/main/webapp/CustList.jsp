<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>

<form action="showCustomer">
<c:forEach var="Customers" items="${Customers}">
<tr th:each="Customers : ${Customers}">
<td th:text="${Customers.firstName}"></td>
<td th:text="${Customers.lastName}"></td>
<td th:text="${Customers.email}"></td>
</tr>
</c:forEach>
</form>



</body>
</html>