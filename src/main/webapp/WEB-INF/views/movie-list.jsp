<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List | Awesome App</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	
	<div class = "pt-5 container">
		
		<h1>Movies Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<a class = "btn btn-primary" href="${pageContext.request.contextPath}/movies/empty">Add movie</a>			
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th class="text-center">Cartel</th>
				<th class="text-center">Name</th>
				<th class="text-center">Age</th>
				<th class="text-center">Director</th>
				<th class="text-center">Genre</th>
				<th class="text-center">Actions</th>
			</tr>
			
			<c:forEach items="${movies}" var="movie">
			
				<tr>
					<td class="text-center"> 
						<a href = "${pageContext.request.contextPath}/movies/${movie.id}"> 
							<img class="ted-img rounded img-fluid" alt="Bad boys III" src="${pageContext.request.contextPath}/img/${movie.img}">
						</a>
					</td>
					<td class="text-center">${movie.name}</td>
					<td class="text-center">${movie.age}</td>
					<td class="text-center">
					 <span class="badge badge-light"><a href="${pageContext.request.contextPath}/directors/${movie.director.id}">${movie.director.name}</a></span>
					</td>
					<td class="text-center">${movie.genre}</td>
					<td class="text-center"> 
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/movies/${movie.id}">Edit</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/movies/${movie.id}/delete">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>