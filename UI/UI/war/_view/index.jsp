<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<body>
	
		<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15"> Sign In or Sign Up</font></p>
		
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
						<input type="submit" value="Submit">	
						<!--<button type="button" onclick="document.location.href='userProfile'">Go to Profile</button>-->
					</td>
					
				</tr>
			</table>
			
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