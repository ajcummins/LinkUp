<!doctype html>

<html>
	<head>
		<title>Edit Profile</title>
	</head>
	
	<body>
		<p> <font  size ="18" >Rate your Date  </font></p>
		
		<form action="/Rating" method="POST">
			<table>
		
			<tr>
					<td>
						Enter the username of your date:
					</td>
					<td>
						<input name="username" type="int" size="20" />
					</td>
				</tr>
			
				
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
				
				
			</table>
				
		</form>
		
	</body>

</html>