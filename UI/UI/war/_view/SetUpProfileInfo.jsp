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
						${location2}
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
						${religion2}
					</td>
				</tr>
				<tr>
					<td>
						Books:
					</td>
					<td>
						<textarea rows="5" cols="31" name="music" type="text" size="20" maxlength="250"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Movies:
					</td>
					<td>
						<textarea rows="5" cols="31" name="movies" type="text" size="20" maxlength="250"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Music:
					</td>
					<td>
						<textarea rows="5" cols="31" name="books" type="text" size="20" maxlength="250"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Basic Info:
					</td>
					<td>
						<textarea rows="5" cols="31" name="basic_info" type="text" size="20" maxlength="250"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Likes:
					</td>
					<td>
						<textarea rows="5" cols="31" name="likes" type="text" size="20" maxlength="250"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Dislikes:
					</td>
					<td>
						<textarea rows="5" cols="31" name="dislikes" type="text" size="20" maxlength="250"></textarea>
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