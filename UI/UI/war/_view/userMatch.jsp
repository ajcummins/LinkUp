<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User Match</title>
	</head>
	
	<body>		
		<form action="/userMatch" method="POST">
		
		<fieldset>
		
		<legend> Congratulations!!!! </legend>
			<input type="hidden" name="userid">
			<table>
				<tr>
					Your Matches are:<br> ${match}
				</tr>
				<tr>
				<td><input name="submit" value="Profile" type="submit" /></td>
				</tr>
			</table>
			</fieldset>
			
			<c:if test="${! empty error}">
				<b>Error: ${error}</b>
			</c:if>
			
			<c:if test="${! empty info}">
				<p>${info}</p>
			</c:if> 
			
		</form>
		
	</body>

</html>