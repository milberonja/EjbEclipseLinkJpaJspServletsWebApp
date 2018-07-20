package com.airline.models;

import java.io.Serializable;
import javax.persistence.*;

@NamedQuery(name="Pilot.findById", query="SELECT p FROM Pilot p WHERE p.id = :id")
@Entity
public class Pilot implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pilot() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private Integer pilotLicence;
	
	@Enumerated(EnumType.STRING)
	private PilotRank pilotRank;
	
	@ManyToOne
	@JoinColumn(name = "flight_fk")
	private Flight flightForPilots;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPilotLicence() {
		return pilotLicence;
	}

	public void setPilotLicence(Integer pilotLicence) {
		this.pilotLicence = pilotLicence;
	}

	public PilotRank getPilotRank() {
		return pilotRank;
	}

	public void setPilotRank(PilotRank pilotRank) {
		this.pilotRank = pilotRank;
	}

	public Flight getFlightForPilots() {
		return flightForPilots;
	}

	public void setFlightForPilots(Flight flightForPilots) {
		this.flightForPilots = flightForPilots;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pilotLicence="
				+ pilotLicence + ", pilotRank=" + pilotRank + ", flightForPilots=" + flightForPilots + "]";
	}
	
	
   
}
