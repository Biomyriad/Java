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
			
			<div class="panel p-3">
				<div class="p-3 mb-2" style="border: 5px solid #3a53ba; border-radius: 5px; background-color: #2b48bd;">				
					<p class="fw-bold text-white">
						<c:out value="${fortune}"/>
					</p>
				</div>
				
				<a class="" href="/">Go Back</a>
			</div>
		</div>	
	</body>
</html>