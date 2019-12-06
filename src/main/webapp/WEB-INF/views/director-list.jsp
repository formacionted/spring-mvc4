<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Director List | Awesome App</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	
	<div class = "pt-5 container">
		
		<h1>Director list</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<a class = "btn btn-primary" href="${pageContext.request.contextPath}/directors/empty">Add director</a>			
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Name</th>
				<th>Active Years</th>
				<th>Age</th>
				<th>Movies</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${directors}" var="director">
			
				<tr>
					<td>${director.name}</td>
					<td>${director.activeYears}</td>
					<td>${director.age}</td>
					<td>
						<c:forEach items="${director.movies}" var="movie">
						 <span class="badge badge-info"><a href="${pageContext.request.contextPath}/movies/${movie.id}">${movie.name}</a></span>
						 </c:forEach>
					</td>
					<td> 
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/directors/${director.id}">Edit</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/directors/${director.id}/delete">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>