<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>User Messages</title>
	</head>
	
	<body>		
		<form action="/matchMessages" method="POST">
		<td><input name="submit" value="Profile" type="submit" /></td><td><input name="submit" value="Matches!" type="submit" /></td>
		<fieldset>
		
		<legend> ${username} Recieved Messages</legend>
			<input type="hidden" name="userid">
			<br>
			<table border='1'>
				<tr><td>From: </td><td>Message</td><td>Click to Reply</td></tr>
				${table}
				<br>
				
				</tr>
			</table>
			</fieldset>
			
		<fieldset>
		
		<legend> ${username} Sent Messages</legend>
			<input type="hidden" name="userid">
			<br>
			<table border='1'>
				<tr><td>From: </td><td>Message</td></tr>
				${sentTable}
				<br>
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