<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Reply Match Messages</title>
	</head>
	
	<body>		
		<form action="/replyMessage" method="POST">
		
		<fieldset>
		
		<legend> Send ${sendid} a Messages</legend>
			<br>
			<table border='1'>
				<tr>
				<textarea rows="5" cols="31" name="message" type="text" size="20"></textarea>
				</tr>
				<tr>
					<td><input name="submit" type="submit" value="Send"/></td>
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