<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

		<meta charset="ISO-8859-1">
		<title>Tasks Page</title>
	</head>
	
	<body>
		<div class="container">
			
            <div class="d-flex justify-content-between align-items-center">
				<h2>Project: <c:out value="${projectModel.title}"/></h2>
				<a href="/">Back to Dashboard</a>
			</div>
			<p class="fw-bold">Project Lead: <c:out value="${projectModel.creator.firstName} ${projectModel.creator.lastName}"/></p>
			
			<form:form action="/projects/${projectModel.id}/tasks" method="post" modelAttribute="newTask">
                <p>
                    <form:label path="taskDetails">Add a task ticket for this team:</form:label>
                    <form:errors path="taskDetails" class="error"/>     
                    <form:textarea path="taskDetails" class="form-control" cols="30" rows="4"></form:textarea>
                </p>  

                <div class="d-flex justify-content-end">
                  <input class="btn btn-primary" type="submit" value="Submit"/>
                </div>  
             </form:form> 

			  <c:forEach var="task" items="${taskList}">
				<p class="fw-bold mb-0">Added by <c:out value="${task.creator.firstName}"/> at <fmt:formatDate type="date" dateStyle="medium" pattern="h:mm a MMM d" value ="${task.createdAt}"/> :</p>
				<p><c:out value="${task.taskDetails}"/></p>
			  </c:forEach>

		</div>
	</body>
</html>