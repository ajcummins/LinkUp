<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User Match</title>
	</head>
	
	<body>		
		<form action="/userMatch" method="POST">
		
		<fieldset>
		
		<br><br>
		<table>
				<tr>
					<td>
						User ID:
					</td>
					<td>
						<input name="user_id" type="int" size="20" />
					</td>
				</tr>
				<tr>
				<td><input name="submit" value="Find Match" type="submit" /></td> <td>	<button type="button" onclick="document.location.href='userProfile'">Profile</button></td>
				</tr>
				
			</table>
			<br>
			<br>
		
		<legend> Condulations!!!! </legend>
			<input type="hidden" name="userid">
			<table>
				<tr>
					Your Perfect Match: ${match}
				</tr>
				<!--<tr>
					<td></td>
					<td><input name="submit" value="profile" type="submit" /></td>
				</tr>-->
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