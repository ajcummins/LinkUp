<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Looking For</title>
	</head>
	<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15">Looking For Information</font></p>
	<body>
		<p> What are you looking for in a Match? </p>
		
		<form action="/lookingFor" method="POST">
		<fieldset>
		<legend> Let's Find A Match </legend>
			<table>
				<tr>
					<!--<td>
						User ID:
					</td>
					<td>
						<input name="user_id" type="int" size="20" />
					</td>-->
				</tr>
				<tr>
					<td>
						Age Range:
					</td>
					<td>
						<input name="age_low" type="int" size="20" /> - <input name="age_high" type="int" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						Gender:
					</td>
					<td>
						${gender2}
					</td>
				</tr>
				<tr>
					<td>
						Location:
					</td>
					<td>
						${location2}
					</td>
				</tr>
				<tr>
					<td>
						Religion:
					</td>
					<td>
						${religion2}
					</td>
				</tr>
				<tr>
					<td>
						Religion Importance:
					</td>
					<td>
						${rWeight}
					</td>
				</tr>
				<tr>
					<td>
						Seriousness:
					</td>
					<td>
						${lookingfor2}
					</td>
				</tr>
				<tr>
					<td>
						Seriousness Importance:
					</td>
					<td>
						${sWeight}
					</td>
				</tr>
				<tr>
					<td></td>
					<td> <input name="submit" type="submit" />
					<button type="button" onclick="document.location.href='userProfile'">Continue!</button></td> 
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