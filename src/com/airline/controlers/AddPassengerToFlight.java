package com.airline.controlers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightService;


@WebServlet("/AddPassengerToFlight")
public class AddPassengerToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FlightService fs;
       
    
    public AddPassengerToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String fid = request.getParameter("fid");
		
		fs.addPassengerToFlight(pid, fid);
		
		response.sendRedirect("Flights");
	}

}
