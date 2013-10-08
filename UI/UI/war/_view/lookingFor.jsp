<!doctype html>

<html>
	<head>
		<title>Create user</title>
	</head>
	
	<body>
		<p> What are you looking for in a Match?: </p>
		
		<form action="/lookingFor" method="POST">
			<table>
				<tr>
					<td>
						AGE:
					</td>
					<td>
						<input name="age" type="int" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						AGE WEIGHT:
					</td>
					<td>
						<select>
						  <option value="1" name="age_weight" type="int" size="20">1</option>
						  <option value="2" name="age_weight" type="int" size="20">2</option>
						  <option value="3" name="age_weight" type="int" size="20">3</option>
						  <option value="4" name="age_weight" type="int" size="20">4</option>
						  <option value="5" name="age_weight" type="int" size="20">5</option>
						  <option value="6" name="age_weight" type="int" size="20">6</option>
						  <option value="7" name="age_weight" type="int" size="20">7</option>
						  <option value="8" name="age_weight" type="int" size="20">8</option>
						  <option value="9" name="age_weight" type="int" size="20">9</option>
						  <option value="10" name="age_weight" type="int" size="20">10</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						GENDER:
					</td>
					<td>
						<select>
						  <option value="1" name="gender" type="int" size="20">Male</option>
						  <option value="2" name="gender" type="int" size="20">Female</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						RELIGION:
					</td>
					<td>
						<input name="religion" type="text" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						RELIGION WEIGHT:
					</td>
					<td>
						<select>
						  <option value="1" name="religion_weight" type="int" size="20">1</option>
						  <option value="2" name="religion_weight" type="int" size="20">2</option>
						  <option value="3" name="religion_weight" type="int" size="20">3</option>
						  <option value="4" name="religion_weight" type="int" size="20">4</option>
						  <option value="5" name="religion_weight" type="int" size="20">5</option>
						  <option value="6" name="religion_weight" type="int" size="20">6</option>
						  <option value="7" name="religion_weight" type="int" size="20">7</option>
						  <option value="8" name="religion_weight" type="int" size="20">8</option>
						  <option value="9" name="religion_weight" type="int" size="20">9</option>
						  <option value="10" name="religion_weight" type="int" size="20">10</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						SERIOUSNESS:
					</td>
					<td>
						<select>
						  <option value="1" name="seriousness" type="int" size="20">1</option>
						  <option value="2" name="seriousness" type="int" size="20">2</option>
						  <option value="3" name="seriousness" type="int" size="20">3</option>
						  <option value="4" name="seriousness" type="int" size="20">4</option>
						  <option value="5" name="seriousness" type="int" size="20">5</option>
						  <option value="6" name="seriousness" type="int" size="20">6</option>
						  <option value="7" name="seriousness" type="int" size="20">7</option>
						  <option value="8" name="seriousness" type="int" size="20">8</option>
						  <option value="9" name="seriousness" type="int" size="20">9</option>
						  <option value="10" name="seriousness" type="int" size="20">10</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						SERIOUSNESS WEIGHT:
					</td>
					<td>
						<select>
						  <option value="1" name="seriousness_weight" type="int" size="20">1</option>
						  <option value="2" name="seriousness_weight" type="int" size="20">2</option>
						  <option value="3" name="seriousness_weight" type="int" size="20">3</option>
						  <option value="4" name="seriousness_weight" type="int" size="20">4</option>
						  <option value="5" name="seriousness_weight" type="int" size="20">5</option>
						  <option value="6" name="seriousness_weight" type="int" size="20">6</option>
						  <option value="7" name="seriousness_weight" type="int" size="20">7</option>
						  <option value="8" name="seriousness_weight" type="int" size="20">8</option>
						  <option value="9" name="seriousness_weight" type="int" size="20">9</option>
						  <option value="10" name="seriousness_weight" type="int" size="20">10</option>
						</select>
						<input name="seriousness_weight" type="int" size="20" />
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