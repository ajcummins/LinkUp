<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
		<title>Looking For</title>
	</head>
	<p><font color="pink" face="Comic Sans MS" size="15">LinkUp:</font> <font color="blue" face="Comic Sans MS" size="15">Looking For Information</font></p>
	<body>
		<p> What are you looking for in a Match? </p>
		
		<form action="/lookingFor" method="POST">
		<fieldset>
		<legend> Let's Find A Match </legend>
			<table>
				<tr>
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
						${gender2}
					</td>
				</tr>
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
						Are you okay with someone with a different religion:
					</td>
					<td>
						<!--${rWeight}-->
						<select name="religion_weight">
							<option name="religion_weight" value = "1"' size='20'>Yes</option>
							<option name="religion_weight" value = "2" size='20'>No</option>
						</select>
							
					</td>
				</tr>
				<tr>
					<td>
						Seriousness:
					</td>
					<td>
						${lookingfor2}
					</td>
				</tr>
				<tr>
					<td>
						How important is Seriousness:
					</td>
					<td>
						<!--${sWeight}-->
						  <div data-role="content">
						      <div data-role="fieldcontain">
						        <input type="range" name="seriousness_weight" id="seriousness_weight" value="5" min="1" max="10">
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
						Are you okay with someone out of state:
					</td>
					<td>
						<!--${location2}-->
						<select name="location">
							<option name="location" value = "1"' size='20'>Yes</option>
							<option name="location" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Are you okay with someone who has children:
					</td>
					<td>
						<select name="children">
							<option name="children" value = "1"' size='20'>Yes</option>
							<option name="children" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Are you okay with someone who has be previously married:
					</td>
					<td>
						<select name="married">
							<option name="married" value = "1"' size='20'>Yes</option>
							<option name="married" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Are you okay with someone who has pets:
					</td>
					<td>
						<select name="pets">
							<option name="pets" value = "1"' size='20'>Yes</option>
							<option name="pets" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Are you okay with someone from a different race:
					</td>
					<td>
						<select name="race">
							<option name="race" value = "1"' size='20'>Yes</option>
							<option name="race" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						How important is Income:
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
					<td>
						How important is it they have that income:
					</td>
					<td>
						<!--${sWeight}-->
						  <div data-role="content">
						      <div data-role="fieldcontain">
						        <input type="range" name="income_weight" id="income_weight" value="5" min="1" max="10">
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
					<td> I do not care</td>
					</tr>
					<tr>
					<td>5</td>
					<td> I would like them to</td>
					</tr>
					<tr>
					<td>10</td>
					<td> They must have it!</td>
					</tr>
					</table>
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td> <input name="submit" type="submit" />
					<!--  <button type="button" onclick="document.location.href='userProfile'">Continue!</button></td>  -->
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