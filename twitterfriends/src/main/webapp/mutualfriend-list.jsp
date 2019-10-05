<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<title>Twitter Mutual Friend Finder</title>
<link
type="text/css"
rel="stylesheet"
href="${pageContext.request.contextPath}/css/style.css"
/>
<body>

 <div id="wrapper">
 	<div id="header">
 		<h2>Twitter Mutual Friends </h2>
 	</div>
 </div>
 
 
 <div id="container">
 	<div id="content">
 		<table>
 			<tr>
 				<th>IDs</th>
 				<th>Name</th>
 			</tr>
 			
 			<c:forEach var="friend" items="${mutualfriendlist}">
				
				<tr>
					<td>${friend.id}</td>
					<td>${friend.name}</td>
				</tr>
					
					
				
 			</c:forEach>
 		</table>
  	</div>
 </div>
</body>

</html>