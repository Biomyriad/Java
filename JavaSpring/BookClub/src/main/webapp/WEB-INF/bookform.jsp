<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

		<meta charset="ISO-8859-1">
		<title>
			<c:choose> 
			  <c:when test="${isEdit}">
				Edit Entry
			  </c:when>
			  <c:otherwise>
				New Entry
			  </c:otherwise>
			</c:choose>
		</title>
	</head>
	
	<body>
		<div class="container">
			
			<div class="d-flex justify-content-between align-items-center">
				
				<c:choose> 
				  <c:when test="${isEdit}">
					<h2>Change your Entry</h2>
				  </c:when>
				  <c:otherwise>
					<h2>Add a Book to Your Shelf!</h2>
				  </c:otherwise>
				</c:choose>
				
				<a href="/books/">back to the shelves</a>
			</div>
			
			<form:form action="/books/${isEdit ? bookEntry.id : 'new'}${isEdit ? '/edit' : ''}" method="post" modelAttribute="bookEntry">
				<c:if test="${isEdit}"><input type="hidden" name="_method" value="put"/></c:if>

				<p>
					<form:label path="title">Title</form:label>
					<form:errors class="error-msg" path="title"/>
					<form:input class="form-control" type="text" path="title" />
				</p>
				<p>
					<form:label path="authorName">Author</form:label>
					<form:errors class="error-msg" path="authorName"/>     
					<form:input class="form-control" type="text" path="authorName"/>
				</p>    
				<p>
					<form:label path="thoughts">My Thoughts</form:label>
					<form:errors class="error-msg" path="thoughts"/>     
					<form:textarea path="thoughts" class="form-control" cols="30" rows="10"></form:textarea>
				</p>  

				<div class="d-flex justify-content-end">
					<input class="btn btn-primary" type="submit" value="Submit"/>
				</div>	

			</form:form> 

		</div>
	</body>
</html>