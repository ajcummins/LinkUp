<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Create user</title>
	</head>
	
	<body>
		<p> Create a user account: </p>
		
		<form action="/createUser" method="POST">
			<table>
				<tr>
					<td>
						Username:
					</td>
					<td>
						<input name="username" type="text" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input name="password" type="password" size="20" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input name="submit" type="submit" /></td>
				</tr>
			</table>
			
			<c:if test="${! empty error}">
				<b>Error: ${error}</b>
			</c:if>
			
			<c:if test="${! empty info}">
				<p>${info}</p>
			</c:if> 
				
		</form>
		
	</body>

</html>