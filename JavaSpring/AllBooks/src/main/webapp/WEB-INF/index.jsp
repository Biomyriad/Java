<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/styles.css"/>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<div class="container">
		
			<h1 style="color: pink">All Books</h1>
			
			<div class="p-2" style="background-color: pink; width: 435px;">
				<table class="table m-2" style="background-color: white; width: 400px; border-color: pink;">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Language</th>
							<th># Pages</th>
						</tr>				
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
						<tr>
							<td><c:out value="${book.getId()}"></c:out></td>
							<td><a href="/book/${book.getId()}"><c:out value="${book.getTitle()}"></c:out></a></td>
							<td><c:out value="${book.getDescription()}"></c:out></td>
							<td><c:out value="${book.getNumberOfPages()}"></c:out></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>						
		</div>
	</body>
</html>