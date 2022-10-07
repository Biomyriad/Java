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
		<title>New Product</title>
	</head>
	
	<body>
		<div class="container">
			
			<h1 class="mx-auto" style="width:fit-content">New Product</h1>

			<a class="d-block" href="/">Home</a>

			<hr>

            <form:form action="/products/new" method="post" modelAttribute="newProduct">

                <table class="new-form" style="width: 600px;">
                    <tbody>
                        <tr>
                            <td>
                                <form:label path="name" class="ps-1" style="font-size: 20px;">Name:</form:label>
                                <form:errors path="name" class="error" />
                            </td>
                            <td>
                                <form:input path="name" class="form-control" type="text"  />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="description" class="ps-1" style="font-size: 20px;">Description:</form:label>
                                <form:errors path="description" class="error" />
                            </td>
                            <td>
                                <form:input path="description" class="form-control" type="text"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="price" class="ps-1"  style="font-size: 20px;">Price:</form:label>
                                <form:errors path="price" class="error" />
                            </td>
                            <td>
                                <form:input path="price" class="form-control" type="text"  />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" class="p-1">
                                <input class="btn-sm btn-primary w-100" type="submit" value="Submit"/>
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form:form>
		</div>
	</body>
</html>