<%@ page import="java.util.*, com.airline.models.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Flight list</title>
<link rel="stylesheet" href="resources/styles/jspstyle.css">
</head>
<body>
	<h1>The list of flights...</h1>
	<table>
		<tr><td>ID</td>
			<td>From</td>
			<td>To</td>
			<td>Time</td>
			<td>Price</td>
			<td>Airplane</td>
			<td>Seating places</td>
			<td>Number of Pilots</td>
			<td>Pilot names</td>
		</tr>
		<%
			List<Flight> flightList = (List<Flight>) request.getAttribute("flight_list");
			for(Integer i = 0; i < flightList.size(); i++){
		%>	
		<tr>
			<td><%= flightList.get(i).getId() %></td>
			<td><%= flightList.get(i).getFlightOrigyn() %></td>
			<td><%= flightList.get(i).getFlightDestination() %></td>
			<td><%= flightList.get(i).getFlightTime() %></td>
			<td><%= flightList.get(i).getPrice() %></td>
			<td><%= flightList.get(i).getAirplaneDetail().getPlaneMake() + " " + flightList.get(i).getAirplaneDetail().getModelName() %></td>
			<td><%= flightList.get(i).getAirplaneDetail().getSeatsCapacity() %></td>
			<% if(flightList.get(i).getPilots().size() != 0){ %>
				<td><%=flightList.get(i).getPilots().size() %></td>
			<% } else { %>
				<td>0 flights</td>
			<%}%>
			<% if(flightList.get(i).getPilots().size() != 0){ %>
				<td>
					<% for(int j = 0; j < flightList.get(i).getPilots().size(); j++){ 
						List<Pilot> pilotList = (List<Pilot>)flightList.get(i).getPilots();
					%>
						<%=pilotList.get(j).getFirstName() + " " + pilotList.get(j).getLastName() + " - " + pilotList.get(j).getPilotRank() %> <br>
		
					<% } %>
				</td>
			<% } else { %>
				<td>There is no Pilots on this Flight</td>
			<%}%>
		</tr>
		<tr>
			<td colspan="9">
			<% if(flightList.get(i).getPassengers().size() > 0){
					List<Passenger> passengerList = (List<Passenger>)flightList.get(i).getPassengers();
					
					for(int k = 0; k < passengerList.size(); k++){
			%>			
					
				<%= k+1 + ") " + passengerList.get(k).getFirstName() + " " + passengerList.get(k).getLastName()%> <br/>
			
			<% } } else { %> 
				No passengers on this flight, yet.
			<%} %>
			</td>
		</tr>
		<% 		
			}
		%>
	</table>
</body>
</html>