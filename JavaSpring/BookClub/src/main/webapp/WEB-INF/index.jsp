<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> -->
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

		<meta charset="ISO-8859-1">
		<title>Welcome</title>
	</head>
	
	<body>
		<div class="container">
		
			<div class="d-flex justify-content-between" style="margin-left: 0px;">
				<div>
					<h2 style="color: rgb(223, 0, 223)">Welcome, <c:out value="${user.userName}"></c:out>!</h2>
					<p>Books from everyone's shelves:</p>			
				</div>
				
				<div class="d-flex flex-column align-items-end" >
					<a class="d-block mt-3" href="/logout">logout</a>
					<a class="d-block mt-2" href="/books/new">+ Add a book to my shelf!</a>
				</div>
			</div>
			
			<table class="table table-striped expense-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
					</tr>				
				</thead>
				<tbody>
				
					<c:forEach var="item" items="${bookEntries}">
					<tr>
						<td><c:out value="${item.id}"></c:out></td>
						<td><a href="/books/${item.id}"><c:out value="${item.title}"/></a></td>
						<td><c:out value="${item.authorName}"></c:out></td>
						<td><c:out value="${item.creator.userName}"></c:out></td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
		</div>
	</body>
</html>