<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Edit Profile</title>
	</head>
	
	<body>
		<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15">Rate Your Date</font></p>
		
		<form action="/Rating" method="POST">
			<table>
		
			
				
				<tr>
					<td>
						Comment on your date experience:
					</td>
					<td>
						<textarea rows="5" cols="31" name="comment" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input name="submit" type="submit" value="Submit"/></td>
				
				</tr>
				<tr>
					<td>			<c:if test="${! empty error}">
									<b>Error: ${error}</b>
				
									</c:if>
					</td>
					
				
				</tr>
				
				
			</table>
				
		</form>
		
	</body>

</html>