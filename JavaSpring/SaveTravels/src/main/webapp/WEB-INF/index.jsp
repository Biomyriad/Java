<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form ((See Model & Validation OneNote Tab)) -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- for rendering errors on PUT routes ((See Model & Validation OneNote Tab)) -->
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

<!-- 		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> -->
<!-- 		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script> -->
		
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<div class="container">
		
			<h1 style="color: rgb(0, 0, 196)">Save Travels</h1>
			
			<div>
				<table class="table table-striped expense-table">
					<thead>
						<tr>
							<th>Expense</th>
							<th>Vender</th>
							<th>Vender</th>
							<th>Description</th>
						</tr>				
					</thead>
					<tbody>
					
						<c:forEach var="item" items="${expense}">
						<tr>
							<td><c:out value="${item.getExpense()}"></c:out></td>
							<td><a href="/book/${item.getVendor()}"><c:out value="${item.getVendor()}"></c:out></a></td>
							<td><c:out value="${item.getAmount()}"></c:out></td>
							<td><c:out value="${item.getDescription()}"></c:out></td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>	
			<div>
				<h3 style="color: rgb(0, 0, 196)">Add an expense:</h3>

				<form:form class="expence-form" action="/create" method="post" modelAttribute="newExpense">
					<form:label path="expense" for="">Expense Name: </form:label>
					<form:errors class="error" path="expense"/>  
					<form:input path="expense" class="form-control" type="text" name="" id=""/>

					<form:label path="vendor" for="">Vendor:</form:label>
					<form:errors class="error" path="vendor"/>  
					<form:input path="vendor" class="form-control" type="text" name="" id=""/>

					<form:label path="amount" for="">Amount:</form:label>
					<form:errors class="error" path="amount"/>  
					<form:input path="amount" class="form-control" type="text" name="" id=""/>

					<form:label path="description" for="">Description:</form:label>
					<form:errors class="error" path="description"/>  
					<form:textarea path="description" class="form-control" name="" id="" cols="30" rows="10"></form:textarea>

					<div class="d-flex justify-content-end mt-3">
						<input class="btn btn-sm btn-primary" type="Submit" value="Submit"/>
					</div>
				</form:form>
			</div>					
		</div>
	</body>
</html>