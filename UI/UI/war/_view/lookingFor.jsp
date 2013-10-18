<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Looking For</title>
	</head>
	
	<body>
		<p> What are you looking for in a Match? </p>
		
		<form action="/lookingFor" method="POST">
		<fieldset>
		<legend> Let's Find A Match </legend>
			<table>
				<tr>
					<td>
						User ID:
					</td>
					<td>
						<input name="user_id" type="int" size="20" />
					</td>
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
						<select>
						  <option gender="1" value = "1" size="20">Male</option>
						  <option gender="2" value = "2" size="20">Female</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Religion:
					</td>
					<td>
						<input name="religion" type="text" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						Religion Importance:
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
						Seriousness:
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
						Seriousness Importance:
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
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input name="submit" type="submit" /></td>
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