<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
	
	<head>
		
		<title>
			Spring Security Demo
		</title>
		
	</head>
	
	<body>
		
		<h2> Spring Security Demo Home Page </h2>
		
		<hr/>
		
		<!--  Display user name and role -->
		<p>
			User: <security:authentication property="principal.username" />
			<br /> <br />
			
			Role (s): <security:authentication property="principal.authorities" />
		</p>
		
		
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