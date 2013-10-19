<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User Match</title>
	</head>
	
	<body>		
		<form action="/userMatch" method="POST">
		<fieldset>
		<legend> Condulations!!!! </legend>
			<table>
				<tr>
					Your Perfect Match: Everyone! <input name="soulMate" size="20" />
				</tr>
				<tr>
					<td></td>
					<td><input name="submit" value="profile" type="submit" /></td>
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