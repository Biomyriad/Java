<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- form:form ((See Model & Validation OneNote Tab)) -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- for rendering errors on PUT routes ((See Model & Validation OneNote Tab)) -->
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="/js/bs_popover_tooltip_init.js" defer></script>

		<link rel="stylesheet" href="/css/resets.css"/>
		<link rel="stylesheet" href="/css/styles.css"/>
		
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<div class="container">
		
			<div style="margin-left: 75px;">
				<h2 style="color: rgb(223, 0, 223)">Book Club</h2>
				<p>A place for friends to store thoughts on books.</p>
			</div>
			
			<div class="d-flex flex-column mt-3"> 
		        <!-- Login -->
		        <div class="panel rounded p-3 mx-auto flex-grow-1 login-register collapse show" style="height: min-content; min-width: 450px;">
		            <h4 class="text-center mt-1 mx-auto">Login</h4>
		
					<form:form action="/login" method="post" modelAttribute="newLogin">
						<label for="">Email: </label>
						<form:errors path="email" class="text-danger"/>
						<form:input class="form-control" type="text" path="email"/>

						<label for="">Password:</label>
						<form:errors path="password" class="text-danger"/>
						<form:input class="form-control" type="text" path="password"/>
		
		                <!-- links -->
		                <div class="d-flex justify-content-between mt-3">
		                    <div>
		                        <a class="text-decoration-none" href=".login-register" data-bs-toggle="collapse" role="button">Register</a>
		                        <a>|</a>
		                        <a class="text-decoration-none" 
		                            tabindex="0" data-bs-toggle="popover" data-bs-trigger="focus" 
		                            title="Notice" data-bs-content="This feature is not available at this time. Try again later.">
		                            Forgot Password
		                        </a>
		                    </div>
			                    
							<div class="d-flex justify-content-end">
								<input class="btn btn-sm btn-primary" type="submit" value="Submit"/>
							</div>
						</div>
					</form:form>
		        </div>
		
		        <!-- Register -->
		        <div class="panel rounded p-3 mx-auto flex-grow-1 login-register collapse no-show" style="height: min-content; min-width: 450px;">
		            <h4 class="text-center mt-1 mx-auto">Register</h4>
		
		            <form:form action="/register" method="post" modelAttribute="newUser">
		
						<label for="">User Name: </label>
						<form:errors path="userName" class="text-danger"/>
						<form:input class="form-control" type="text" path="userName"/>

						<label for="">Email:</label>
						<form:errors path="email" class="text-danger"/>
						<form:input class="form-control" type="text" path="email"/>

						<label for="">Password:</label>
						<form:errors path="password" class="text-danger"/>
						<form:input class="form-control" type="text" path="password"/>

						<label for="">Confirm Password:</label>
						<form:errors path="confirm" class="text-danger"/>
						<form:input class="form-control" type="text" path="confirm"/>
		
		                <!-- submit -->
		                <div class="d-flex justify-content-end mt-3">
		                    <button type="reset" class="btn-sm btn-primary me-2" data-bs-toggle="collapse" data-bs-target=".login-register">Cancel</button> 
		                    <input class="btn btn-sm btn-primary" type="submit" value="Register"/>
		                </div>
		            </form:form>
		        </div>
		        
		    </div>
		    
		</div>
		
	</body>
</html>