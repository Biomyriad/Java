<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="/css/styles.css"/>
		<link rel="stylesheet" href="/css/resets.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container" style="width: 600px;">
			<h1 class="heading">Send an Omikuji!</h1>
			
			<form action="/submitted" method="post">
				<div class="border border-dark rounded p-3">
					<label class="fw-bold">Pick any number from 5 to 25</label>
					<select class="form-select mb-2" name="number">
						<option selected>Choose...</option>
						<% for(int i = 5; i <= 25; i++) { %>
				    		<option><%= i %></option>
				    	<% } %>
				    </select>
					
					<label class="fw-bold">Enter the name of any city.</label>
					<input class="form-control mb-2" type="text" name="city">
					
					<label class="fw-bold">Enter the name of any real person.</label>
					<input class="form-control mb-2" type="text" name="person">
					
					<label class="fw-bold">Enter professional endeavor or hobby.</label>
					<input class="form-control mb-2" type="text" name="endeavor">
					
					<label class="fw-bold">Enter any type of living thing.</label>
					<input class="form-control mb-2" type="text" name="thing">
					
					<label class="fw-bold">Say something nice to someone.</label>
					<textarea class="form-control mb-3" rows="5" cols="20" name="message"></textarea>
					
					<div class="d-flex justify-content-end">
						<p class="align-self-end fw-bold mb-2 me-2">Send and show a friend</p>				
						<input class="btn btn-primary" type="submit" value="Send"/>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>