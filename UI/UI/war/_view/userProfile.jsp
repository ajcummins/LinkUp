<!DOCTYPE html>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Profile Page</title>
	</head>
	
	<body>		
		<form action="/userProfile" method="GET">
		
		<fieldset>
		
		<h1> ${first_name} ${last_name}  </h1> 
		
		<div style="display: inline;">

		</form>
		<form action="/userMatch" method="POST">
		<button type="button" onclick="document.location.href='userMatch'">Matches!</button> 
	
		&nbsp; <input type="submit" value="Messages">&nbsp; <input type="submit" value="Account Settings">
	
		</form>
		</div>
		<form>
		
		<br><br><table>
				<tr>
					<td>
						Location:
					</td>
					<td>
						${location}
					</td>
					
				</tr>
				<tr>
					<td>
						Age:
					</td>
					<td>
						${age}
					</td>
					
				</tr>
				<tr>
					<td>
						Gender:
					</td>
					<td>
						${gender}
					</td>
					
				</tr>
				<tr>
					<td>
						Looking For:
					</td>
					<td>
						${looking_for}
					</td>
					
				</tr>
				<tr>
					<td>
						Religion:
					</td>
					<td>
						${religion}
					</td>
					
				</tr>
				<tr>
					<td>
						Likes:
					</td>
					<td>
						${likes}
					</td>
					
				</tr>
				<tr>
					<td>
						Dislikes:
					</td>
					<td>
						${dislikes}
					</td>
					
				</tr>
				<tr>
					<td>
						Music:
					</td>
					<td>
						${music}
					</td>
					
				</tr>
				<tr>
					<td>
						Books:
					</td>
					<td>
						${books}
					</td>
					
				</tr>
				<tr>
					<td>
						Movies:
					</td>
					<td>
						${movies}
					</td>
					
				</tr>
				<tr>
					<td>
						Basic Info:
					</td>
					<td>
						${basic_info}
					</td>
					
				</tr>
				
				
			</table>
		
			<br>
			<br>
		
		
			</fieldset>
			
			
			
		</form>
		
	</body>

</html>