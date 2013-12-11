<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
		
	<body>
		<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15">Create User</font></p>
		
		<form action="/createUser" method="POST">
			<fieldset>
			<legend> User Registration </legend>
		
			<table>
				<tr>
					<td>
						Username :
					</td>
					<td>
						<input name = "username" type = "text" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						Password : 
					</td>
					<td>
						<input name = "password" type = "password" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						Confirm Password :
					</td>
					<td>
						<input name = "confirm_password" type = "password" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						First Name :
					</td>
					<td>
						<input name = "fname" type = "text" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						Last Name :
					</td>
					<td>
						<input name = "lname" type = "text" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						Birth Date :
					</td>
					<td>
						<input name = "dob" type = "date" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						E-mail : 
					</td>
					<td>
						<input name = "email" type = "text" size = "20" />
					</td>
				</tr>
				<tr>
					<td>
						Security Question : 
					</td>
					<td>
						<select name = "security_question"> 
						<option value="1">What is your mother's madien Name?</option>
						<option value="2">What is your favorite pet's Name?</option>
						<option value="3">What is the street you grew up on?</option>
						<option value="4">What is your favorite crayon color?</option>
						<option value="5">What is your favorite teacher's name</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Security Answer : 
					</td>
					<td>
						<input name = "security_answer" type = "text" size = "20" />
					</td>
				</tr>
				<tr>
					<td></td>
                    <td> <!--  <input name="submit" type="submit" /></td> -->
                    	<input type="submit" value="Submit">	
                    	<!--  <button type="button" onclick="document.location.href='SetUpProfileInfo'">Continue</button> -->
				</tr>
								
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