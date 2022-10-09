<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>

		<meta charset="ISO-8859-1">
		<title>Project Details</title>
	</head>
	
	<body>
		<div class="container">
			
            <div class="d-flex justify-content-between align-items-center">
				<h1>Project Details</h1>
				<a href="/dashboard">Back to Dashboard</a>
			</div>
			
			<table class="show-table">
				<tr>
					<td>Project:</td>
					<td><c:out value="${projectModel.title}"/></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><c:out value="${projectModel.description}"/></td>
				</tr>
				<tr>
					<td>Due Date</td>
					<td><fmt:formatDate type="date" dateStyle="medium" pattern="MM/dd/yyyy" value ="${projectModel.dueDate}"/></td>
				</tr>
			</table>

            <div class="d-flex justify-content-between align-items-center">
				<a href="/projects/${projectModel.id}/tasks">See tasks!</a>
				<form action="/projects/${projectModel.id}/delete" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input class="btn btn-danger" type="submit" value="Delete Project">
                </form>
			</div>
            
		</div>
	</body>
</html>