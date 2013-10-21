<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
	
		<h1>LinkUp!</h1>
		
		<form action="/index" method="POST">
		
		<fieldset>
			<legend> Login </legend>
		
			<table>
				<tr>
					<td>
						Username :
					</td>
					<td>
						<input name = "inUser" type = "text" size = "20" />
					</td>
				</tr>
				
				<tr>
					<td>
						Password :
					</td>
					<td>
						<input name = "inPass" type = "password" size = "20" />
					</td>
				</tr>
				
				<tr>
					<td>
					</td>
					<td>
						<!--  <input name="submit" type="submit" /> -->
						<button type="button" onclick="document.location.href='userProfile'">Log in</button> 		
					</td>
				</tr>
			</table>
			
			<!--  <a href="localhost:8080/createUser" target="_blank" >Not a Member? Sign Up Now!</a>			-->
			<button type="button" onclick="document.location.href='createUser'">Not a Member? Sign up now!!!!</button> 			
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