<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User Match</title>
	</head>
	<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15"> Matches</font></p>
	<body>		
		<form action="/userMatch" method="POST">
		<fieldset>
		<table>
		<td><td><input name="submit" value="Profile" type="submit"data-icon="home"/></td><td></td><td></td>
		</tr>
		</table>
		</fieldset>
		<fieldset>
		
		<legend> Congratulations!!!! </legend>
			<input type="hidden" name="userid">
			<table>
				<tr>
					Your Matches are:<br> 
					<tr>${match}
					</tr>
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