<!doctype html>

<html>
	<head>
		<title>Create user</title>
	</head>
	
	<body>
		<p> Create a user account: </p>
		
		<form action="/createUser" method="POST">
			<table>
				<tr>
					<td>
						Username:
					</td>
					<td>
						<input name="username" type="text" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						Password:
					</td>
					<td>
						<input name="password" type="password" size="20" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input name="submit" type="submit" /></td>
				</tr>
			</table>
				
		</form>
		
	</body>

</html>