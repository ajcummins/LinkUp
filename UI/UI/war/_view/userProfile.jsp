<!DOCTYPE html>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Profile Page</title>
	</head>
	<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15"> Your Profile</font></p>
	<body>		
		<form action="/userProfile" method="GET"></form>
		
		<fieldset>
		
		<h1> ${first_name} ${last_name}  </h1> 
		
		<div style="display: inline;">

		</form>
		<form action="/userProfile" method="POST">
		<fieldset>
		<table>
	 	<tr><td><input name ="submit" type="submit" value="Matches!"></td><td><input name ="submit" type="submit" value="Messages"><td><input name="submit" type="submit" value="Update Looking For"></td><td><input name ="submit" type="submit" value="Edit Profile Info"></td></td><td><input name="submit" type="submit" value="Logout"></td>
		</tr>
		</table>
	</fieldset>
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
						Birthday:
					</td>
					<td>
						${month} ${day}, ${year}
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