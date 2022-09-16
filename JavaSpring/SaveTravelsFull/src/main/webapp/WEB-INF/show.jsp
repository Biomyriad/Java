<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>
	
	
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container mx-auto">
			<div class="d-flex justify-content-between align-items-center">
				<h1 style="color: rgb(0, 0, 196)">Expense Details</h1>
				<a href="/">Go Back</a>
			</div>
			
			<table class="show-expense">
				<tr>
					<td>Expense Name</td>
					<td><c:out value="${expense.expense}"/></td>
				</tr>
				<tr>
					<td>Expense Description</td>
					<td><c:out value="${expense.description}"/></td>
				</tr>
				<tr>
					<td>Vender</td>
					<td><c:out value="${expense.vendor}"/></td>
				</tr>
				<tr>
					<td>Amount</td>
					<td><c:out value="${expense.amount}"/></td>
				</tr>
			</table>
				
		</div>
	</body>
</html>