<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>Looking For</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>
		<script>
			$(document).ready(function(){
			  $("#seriousness").click(function(){
			  	var s = document.getElementById("seriousness");
			    $("#test1").text(s.value);
			  });
			  $("#seriousness_weight").click(function(){
			 	 var sw = document.getElementById("seriousness_weight");
			    $("#test2").text(sw.value);
			  });
			  $("#income").click(function(){
			 	 var i = document.getElementById("income");
			    $("#test3").text(i.value);
			  });
			  $("#income_weight").click(function(){
			 	 var iw = document.getElementById("income_weight");
			    $("#test4").text(iw.value);
			  });
			});
		</script>
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
						<input name="age_low" type="int" size="20" style="width:50px"/> - <input name="age_high" type="int" size="20" style="width:50px"/>
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
						<select name="religion_weight" style="width:110px">
							<option name="religion_weight" value = "1"' size='20'>Yes</option>
							<option name="religion_weight" value = "2" size='20'>No</option>
						</select>
							
					</td>
				</tr>
				<tr>
					<td>
						Seriousness of a Relationship: <p id="test1">5</p>
					</td>
					<td>
						<div data-role="content">
						      <div data-role="fieldcontain">
						        <input type="range" name="seriousness" id="seriousness" value="5" min="1" max="10">
						  </div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						How important is the Seriousness of Your Relationship: <p id="test2">5</p>
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
						<select name="location" style="width:110px">
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
						<select name="children" style="width:110px">
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
						<select name="married" style="width:110px">
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
						<select name="pets" style="width:110px">
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
						<select name="race" style="width:110px">
							<option name="race" value = "1"' size='20'>Yes</option>
							<option name="race" value = "2" size='20'>No</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						How important is Income: <p id="test3">5</p>
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
						How important is it they have that income: <p id="test4">5</p>
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