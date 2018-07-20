package com.airline.controlers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;


@WebServlet("/CreateNewPilotAndAddToFlight")
public class CreateNewPilotAndAddToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private PilotService ps;
 
    public CreateNewPilotAndAddToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String license = request.getParameter("license");
		String pilot_rank = request.getParameter("pilot_rank"); 
		String fid = request.getParameter("fid");
		
		Pilot p = new Pilot();
		p.setFirstName(fName);
		p.setLastName(lName);
		p.setPilotLicence(Integer.parseInt(license));
		p.setPilotRank(PilotRank.valueOf(pilot_rank));
		
		ps.addNewPilotToFlight(p, fid);
		
		response.sendRedirect("Flights");
	}

}
