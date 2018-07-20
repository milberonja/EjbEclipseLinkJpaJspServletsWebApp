<%@ page import="java.util.*, com.airline.models.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Passenger list</title>
<link rel="stylesheet" href="resources/styles/jspstyle.css">
</head>
<body>
	<h1>The list of flights...</h1>
	<table>
		<tr>
			<td>ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Date of Birth</td>
			<td>Gender</td>
		</tr>
		<%
			List<Passenger> passengerList = (List<Passenger>) request.getAttribute("passenger_list");
			for(Integer i = 0; i < passengerList.size(); i++){
		%>	
		<tr>
			<td><%= passengerList.get(i).getId() %></td>
			<td><%= passengerList.get(i).getFirstName() %></td>
			<td><%= passengerList.get(i).getLastName() %></td>
			<td><%= passengerList.get(i).getDob() %></td>
			<td><%=passengerList.get(i).getGender() %></td>
		</tr>
		<tr>
			<td colspan="5">
			<% List<Flight> flightList = (List<Flight>) passengerList.get(i).getFlights(); 
				if(flightList.size() > 0){
					for(Integer k = 0; k < flightList.size(); k++){
			%>	
					<%= k+1 + ") " + flightList.get(k).getFlightOrigyn() + " - " + flightList.get(k).getFlightDestination() +
						" @ " + flightList.get(k).getFlightTime() %> <br/>
			<% } } else {%> 
			No flight's ticket yet.
			<% } %>
			</td>
		</tr>
		<% 		
			}
		%>
	</table>
</body>
</html>