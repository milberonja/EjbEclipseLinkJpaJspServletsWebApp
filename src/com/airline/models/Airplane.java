package com.airline.models;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Airplane implements Serializable {

	private static final long serialVersionUID = 1L;

	public Airplane() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String planeMake;
	
	private String modelName;
	
	private Integer seatsCapacity;
	
	@OneToOne(mappedBy = "airplaneDetail")
	private Flight fligt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaneMake() {
		return planeMake;
	}

	public void setPlaneMake(String planeMake) {
		this.planeMake = planeMake;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Integer getSeatsCapacity() {
		return seatsCapacity;
	}

	public void setSeatsCapacity(Integer seatsCapacity) {
		this.seatsCapacity = seatsCapacity;
	}

	public Flight getFligt() {
		return fligt;
	}

	public void setFligt(Flight fligt) {
		this.fligt = fligt;
	}

	@Override
	public String toString() {
		return "Airplane [id=" + id + ", planeMake=" + planeMake + ", modelName=" + modelName + ", seatsCapacity="
				+ seatsCapacity + "]";
	}
	
	
	
	
   
}
