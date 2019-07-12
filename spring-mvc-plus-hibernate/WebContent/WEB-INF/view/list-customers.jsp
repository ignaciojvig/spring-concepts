<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<title> List Customers </title>
		
		<!-- reference stylesheet -->
		<link 
			type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>

	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2> CRM - Customer Relationship Manager </h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
			
			<!-- button New Customer -->
			<input type="button" 
				class="add-button"
				value="Add Customer"
				onClick="window.location.href='showFormForAdd'; return false;"/>
			
				<table>
					<tr>
						<th> First Name </th>
						<th> Last Name </th>
						<th> Email </th>
						<th> Action </th>
					</tr>
					
					<!-- Loop over data in model -->
					<c:forEach var="tempCustomer" items="${customers}">
					
						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							<td> <a href="${updateLink}"> Update </a>
						</tr>
					
					</c:forEach>
					
				</table>
			</div>
		</div>
		
	</body>

</html>