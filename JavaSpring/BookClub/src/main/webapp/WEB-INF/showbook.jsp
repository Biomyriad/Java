<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

		<meta charset="ISO-8859-1">
		<title><c:out value="${book.title}"/></title>
	</head>
<body>

	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h2><c:out value="${book.title}"/></h2>
			<a href="/books/">back to the shelves</a>
		</div>
		
		<p><c:out value="${book.creator.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.authorName}"/>.</p>
		<p>Here are <c:out value="${book.creator.userName}"/>'s thoughts:</p>
		<hr>
		<p> 
			<c:out value="${book.thoughts}"/>
		</p>
		<hr>
		
		<c:set var="userID" value='<%= session.getAttribute("userId") %>'/>
		<c:if test="${userID == book.creator.id}">
			<div class="d-flex justify-content-end">
				<a class="btn btn-primary me-2" href="/books/${book.id}/edit">Edit</a>
				<a class="btn btn-primary" href="/books/${book.id}/delete">Delete</a>
			</div> 
		</c:if>		
	</div>
			
</body>
</html>