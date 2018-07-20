package com.airline.controlers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Airplane;
import com.airline.models.Flight;
import com.airline.models.FlightDetails;
import com.airline.service.FlightService;

@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightService fs;
       
    public AddFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flight f = new Flight();
		
		String from = request.getParameter("from_destination");
		f.setFlightOrigyn(FlightDetails.valueOf(from));
		
		String to = request.getParameter("to_destination");
		f.setFlightDestination(FlightDetails.valueOf(to));
		
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer dayOfMonth = Integer.parseInt(request.getParameter("day"));
		Integer hour = Integer.parseInt(request.getParameter("hour"));
		Integer minute = Integer.parseInt(request.getParameter("minute"));
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, minute);
		
		Date time = cal.getTime();
		System.out.println(time);
		f.setFlightTime(time);
		
		
		f.setPrice(Integer.parseInt(request.getParameter("price")));
		
		Airplane a = new Airplane();
		
		a.setPlaneMake(request.getParameter("airplane_make"));
		a.setModelName(request.getParameter("airplane_model"));
		a.setSeatsCapacity(Integer.parseInt(request.getParameter("airplane_seating")));
		
		f.setAirplaneDetail(a);
		System.out.println(f);
		System.out.println(a);
		
		fs.addFlight(f, a);
		
		response.sendRedirect("Flights");
	}

}
