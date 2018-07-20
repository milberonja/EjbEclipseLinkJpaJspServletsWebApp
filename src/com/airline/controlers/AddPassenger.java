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

import com.airline.models.FlightClass;
import com.airline.models.Gender;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;


@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PassengerService ps;
       
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Passenger p = new Passenger();
		
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String dob_row = request.getParameter("dob");
		String gender = request.getParameter("gender");
		
		p.setFirstName(fName);
		p.setLastName(lName);
		
		Calendar cal = Calendar.getInstance();
		String[] dob_array = dob_row.split("\\/");
		cal.set(Calendar.YEAR, Integer.parseInt(dob_array[2]));
		cal.set(Calendar.MONTH, Integer.parseInt(dob_array[0]));
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dob_array[1]));
		
		Date dob = cal.getTime();
		p.setDob(dob);
		
		p.setGender(Gender.valueOf(gender));
		
		System.out.println(p);
		
		ps.addPassenger(p);	
		
		response.sendRedirect("Passengers");
	}

}
