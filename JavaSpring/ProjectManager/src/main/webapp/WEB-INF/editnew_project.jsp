<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                Edit My Project
                </c:when>
                <c:otherwise>
                Create a Project
                </c:otherwise>
            </c:choose>
        </title>
	</head>
	
	<body>
		<div class="container">
			
            <c:choose> 
                <c:when test="${isEdit}">
                <h2>Edit project</h2>
                </c:when>
                <c:otherwise>
                <h2>Create a Project</h2>
                </c:otherwise>
            </c:choose>
              
              <form:form action="/projects/${isEdit ? projectModel.id : 'new'}${isEdit ? '/edit' : ''}" method="post" modelAttribute="projectModel">
                <c:if test="${isEdit}"><input type="hidden" name="_method" value="put"/></c:if>
                <p>
                  <form:label path="title">Project Title:</form:label>
                  <form:errors path="title" class="error"/>
                  <form:input path="title" class="form-control" type="text"/>
                </p>
                <p>
                    <form:label path="description">Project Description:</form:label>
                    <form:errors path="description" class="error"/>     
                    <form:textarea path="description" class="form-control" cols="30" rows="10"></form:textarea>
                </p>  
                <p>
                  <form:label path="dueDate">Due Date:</form:label>
                  <form:errors path="dueDate" class="error"/>     
                  <form:input path="dueDate" class="form-control" type="date"/>
                </p>    
                <div class="d-flex justify-content-end">
                  <a class="btn btn-primary me-3" href="/dashboard">Cancel</a>
                  <input class="btn btn-primary" type="submit" value="Submit"/>
                </div>  
              </form:form> 

		</div>
	</body>
</html>