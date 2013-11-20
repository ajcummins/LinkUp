<!doctype html>



<html>
	<head>
		<title>Edit Profile</title>
	</head>
	
	<body>
		<p> <font face = "Impact" size ="18" >Edit Profile info  </font></p>
		
		<form action="/SetUpProfileInfo" method="POST">
			<table>
			<tr>
					<!--<td>
						User ID:
					</td>
					<td>
						<input name="user_id" type="text" size="20" style="width: 100px; "/>
					</td>-->
				</tr>
				<tr>
				<tr>
					<!--<td>
						Username:
					</td>
					<td>
						<input name="username" type="text" size="20" style="width: 100px; "/>
					</td>-->
				</tr>
				<tr>
			
				<tr>
					<td>
						Upload a Picture:
					</td>
					
					<!--  <td>
						<form action="" method="post" enctype="multipart/form-data">
    					<fieldset>
      						<input name ="picture" type="file" name="Image" />
      						<br/>
     						 
   						 </fieldset>
 						 </form>
 
   
   
    
					</td>-->
				</tr>
				
			
			
			
				<tr>
					<td>
						Location:
					</td>
					<td>
						<select name="location">
						  <option value="1" name="location" type="int" size="20">PA</option>
						  <option value="2" name="location" type="int" size="20">DE</option>
						  <option value="3" name="location" type="int" size="20">MD</option>
						  <option value="4" name="location" type="int" size="20">NJ</option>
						  <option value="5" name="location" type="int" size="20">WI</option>
						  <option value="6" name="location" type="int" size="20">CA</option>
						  <option value="7" name="location" type="int" size="20">MA</option>
						  <option value="8" name="location" type="int" size="20">RI</option>
						  <option value="9" name="location" type="int" size="20">OH</option>
						  <option value="10" name="location" type="int" size="20">SC</option>
						  <option value="11" name="location" type="int" size="20">NC</option>
						  <option value="12" name="location" type="int" size="20">VA</option>
						  <option value="13" name="location" type="int" size="20">TX</option>
						  
						  
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
				<!--  <tr>
					<td>
						Age:
					</td>
					<td>
						<input name="age" type="text" size="20" style="width: 59px; "/>
					</td>
				</tr>-->
				<tr>
					<td>
						Religion:
					</td>
					<td>
						<select name = "religion">
						  <option value="1" name="gender" type="int" size="20">Non-Religious</option>
						  <option value="2" name="gender" type="int" size="20">Atheist</option>
						  <option value="3" name="gender" type="int" size="20">Buddhism</option>
						  <option value="4" name="gender" type="int" size="20">Christian</option>
						  <option value="5" name="gender" type="int" size="20">Hinduism</option>
						  <option value="6" name="gender" type="int" size="20">Islam</option>
						  <option value="7" name="gender" type="int" size="20">Jewish</option>
						  <option value="8" name="gender" type="int" size="20">Sikhism</option>
						  <option value="9" name="gender" type="int" size="20">Other</option>
						  
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Books:
					</td>
					<td>
					
						<textarea rows="5" cols="31" name="music" type="text" size="20" maxlength="250" >${books}</textarea>
					</td>
				</tr>
				<tr>
					<td>
						Movies:
					</td>
					<td>
						<textarea rows="5" cols="31" name="movies" type="text" size="20" maxlength="250" >${movies}</textarea>
					</td>
				</tr>
				<tr>
					<td>
						Music:
					</td>
					<td>
						<textarea rows="5" cols="31" name="books" type="text" size="20" maxlength="250" >${music}</textarea>
					</td>
				</tr>
				<tr>
					<td>
						Basic Info:
					</td>
					<td>
						<textarea rows="5" cols="31" name="basic_info" type="text" size="20" maxlength="250" >${basic_info}</textarea>
					</td>
				</tr>
				<tr>
					<td>
						Likes:
					</td>
					<td>
						<textarea rows="5" cols="31" name="likes" type="text" size="20" maxlength="250" >${likes}</textarea>
					</td>
				</tr>
				<tr>
					<td>
						Dislikes:
					</td>
					<td>
						<textarea rows="5" cols="31" name="dislikes" type="text" size="20" maxlength="250" >${dislikes}</textarea>
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
						  <option value="5" name="looking_for" type="int" size="20">Long Term</option>
						  <option value="6" name="looking_for" type="int" size="20">Short Term</option>
						  <option value="7" name="looking_for" type="int" size="20">Fun</option>
						  
						</select>
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