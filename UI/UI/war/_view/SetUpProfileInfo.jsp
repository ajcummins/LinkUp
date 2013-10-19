<!doctype html>

<html>
	<head>
		<title>Edit Profile</title>
	</head>
	
	<body>
		<p> <font face = "Impact" size ="18" >Set up your Profile!  </font></p>
		
		<form action="/SetUpProfileInfo" method="POST">
			<table>
				<tr>
					<td>
						Location:
					</td>
					<td>
						<select name="location">
						  <option value="1" name="location" type="int" size="20">PA</option>
						  <option value="2" name="location" type="int" size="20">DE</option>
						  <option value="2" name="location" type="int" size="20">MD</option>
						  <option value="2" name="location" type="int" size="20">NJ</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Gender:
					</td>
					<td>
						<select name = "gender">
						  <option value="1" name="gender" type="int" size="20">Male</option>
						  <option value="2" name="gender" type="int" size="20">Female</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Age:
					</td>
					<td>
						<input name="age" type="text" size="20" style="width: 59px; "/>
					</td>
				</tr>
				<tr>
					<td>
						Religion:
					</td>
					<td>
						<input name="religion" type="text" size="20" style="width: 245px; "/>
					</td>
				</tr>
				<tr>
					<td>
						Books:
					</td>
					<td>
						<textarea rows="5" cols="31" name="music" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Movies:
					</td>
					<td>
						<textarea rows="5" cols="31" name="movies" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Music:
					</td>
					<td>
						<textarea rows="5" cols="31" name="books" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Basic Info:
					</td>
					<td>
						<textarea rows="5" cols="31" name="basic_info" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Likes:
					</td>
					<td>
						<textarea rows="5" cols="31" name="likes" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Dislikes:
					</td>
					<td>
						<textarea rows="5" cols="31" name="dislikes" type="text" size="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						What are you looking for?
					</td>
					<td>
						<select name = "looking_for">
						  <option value="1" name="looking_for" type="int" size="20">Relationship</option>
						  <option value="2" name="looking_for" type="int" size="20">Friendship</option>
						  <option value="3" name="looking_for" type="int" size="20">Cuddle Buddy</option>
						  <option value="4" name="looking_for" type="int" size="20">Nothing Serious</option>
						</select>
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