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
		<title>Project Manager Dashboard</title>
	</head>
	
	<body>
		<div class="container">
			
			<div class="d-flex justify-content-between " style="margin-left: 0px;">
				<div>
					<h2 class="mb-4">Welcome, <c:out value="${user.firstName}"></c:out>!</h2>
					<p class="fw-bold">All Projects</p>			
				</div>
				
				<div class="d-flex flex-column align-items-end" >
					<a class="d-block mt-3" href="/logout">logout</a>
					<a class="d-block mt-2 btn btn-primary" href="/projects/new">+ New Project</a>
				</div>
			</div>
			
			<table class="table table-striped dashboard-table">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>				
				</thead>
				<tbody>
				
 					<c:forEach var="project" items="${notAssignedProjects}">
						<tr>
							<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
							<td><c:out value="${project.creator.firstName}"></c:out></td>
							<td><fmt:formatDate type="date" dateStyle="medium" pattern="MMM d" value ="${project.dueDate}"/></td>
							<td><a href="/projects/${project.id}/join">Join Team</a></td>
						</tr>
					</c:forEach> 
					
				</tbody>
			</table>

			<p class="fw-bold mt-5">Your Projects</p>	

			<table class="table table-striped dashboard-table">
				<thead>
					<tr>
						<th>Project</th>
						<th>Team Lead</th>
						<th>Due Date</th>
						<th>Actions</th>
					</tr>				
				</thead>
				<tbody>

 					<c:forEach var="project" items="${AssignedProjects}">
						<tr>
							<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
							<td><c:out value="${project.creator.firstName}"></c:out></td>
							<td><fmt:formatDate type="date" dateStyle="medium" pattern="MMM d" value ="${project.dueDate}"/></td>
							<td>
								<c:set var="userId" value='<%= session.getAttribute("userId") %>'/>
								
								<c:choose> 
								  <c:when test="${userId == project.creator.id}">
								    <a href="/projects/${project.id}/edit">Edit</a>
								  </c:when>
								  <c:otherwise>
								    <a href="/projects/${project.id}/leave">Leave Team</a>
								  </c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>

		</div>
	</body>
</html>