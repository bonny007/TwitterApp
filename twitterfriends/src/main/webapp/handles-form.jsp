<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

	<head>
		<title>Form</title>		
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/css/add-customer-style.css"/>
	<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/css/style.css"/>
	
	</head>

	<body>
		<div id ="wrapper">
			<div id ="header">
				<h2>Mutual Friend Finder</h2>
			</div>
		</div>
		<div id="container">
			<h3>Find common friends!!!</h3>
			<form:form action="list" modelAttribute="handles" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>1.TwitterHandle</label></td>
							<td><form:input  path="user1handle" />
								<form:errors path="user1handle" cssClass="error"/>
							</td>
						</tr>		
						<tr>
							<td><label>2.TwitterHandle</label></td>
							<td><form:input path="user2handle" />
								<form:errors path="user2handle" cssClass="error"/>
							</td>
						</tr>
					</tbody>
				</table>
				
				<input type="submit" value="Find" class="save">
				
			</form:form>
		</div>
	</body>

</html>