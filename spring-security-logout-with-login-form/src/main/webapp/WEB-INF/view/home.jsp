<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	
	<head>
		
		<title>
			Spring Security Demo
		</title>
		
	</head>
	
	<body>
		
		<h2> Spring Security Demo Home Page </h2>
		
		<hr/>
		
		<p> Welcome to the Spring Security Demo Home Page </p>
		
		<!-- Add a logout button -->
		<form:form 
			action="${pageContext.request.contextPath}/logout" 
			method="POST">
		
			<input type="submit" value="Logout" />
		
		</form:form>
	
	</body>


</html>