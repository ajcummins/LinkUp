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
						Seriousness: <p id="test1"></p>
					</td>
					<td>
						<div data-role="content">
						      <div data-role="fieldcontain">
						        <input type="range" name="seriousness" id="seriousness" value="5" min="1" max="10">
						  </div>
						</div>
					</td>
					
					<td>
					<table border="1">
					<tr>
					<td>Number</td>
					<td>Definition</td>
					</tr>
					<tr>
					<td>1</td>
					<td>Someone to hang out with</td>
					</tr>
					<tr>
					<td>5</td>
					<td>Relationship, someday something more</td>
					</tr>
					<tr>
					<td>10</td>
					<td>Settle down, hoping to get married</td>
					</tr>
					</table>
					</td>
				</tr>
				
				
				
				<tr>
					<td>
						Do you have children:
					</td>
					<td>
						<select name="children" style="width:110px">
							<option name="children" value = "1"' size='20'>Yes</option>
							<option name="children" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Have you been previously married:
					</td>
					<td>
						<select name="married" style="width:110px">
							<option name="married" value = "1"' size='20'>Yes</option>
							<option name="married" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Do you have pets:
					</td>
					<td>
						<select name="pets" style="width:110px">
							<option name="pets" value = "1"' size='20'>Yes</option>
							<option name="pets" value = "2" size='20'>No</option>
						</select>
					</td>
				
				<tr>
					<td>
						Race: 
					</td>
					<td>
						${race2}
					</td>
				
				
					<tr>
					<td>
						Income: <p id="test3"></p>
					</td>
					<td>
						<!--${sWeight}-->
						  <div data-role="content">
						      <div data-role="fieldcontain">
						        <input type="range" name="income" id="income" value="5" min="1" max="10">
						  </div>
						</div>
					</td>
					<td>
					<table border="1">
					<tr>
					<td>Number</td>
					<td>Definition</td>
					</tr>
					<tr>
					<td>1</td>
					<td> < $10,000 per year</td>
					</tr>
					<tr>
					<td>5</td>
					<td> $100,000 per year</td>
					</tr>
					<tr>
					<td>10</td>
					<td> > $200,000 per year</td>
					</tr>
					</table>
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