/**
 * 
 */
package com.ss.training.utopia.entity;

import java.util.List;

/**
 * @author derrianharris
 *
 */
public class Airplane {

	/**
	 * @param id
	 * @param typeId
	 * @param flights
	 */
	public Airplane(Integer id, AirplaneType typeId, List<Flight> flights) {
		this.id = id;
		this.typeId = typeId;
		this.flights = flights;
	}
	private Integer id;
	private AirplaneType typeId;
	private List<Flight> flights;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the flights
	 */
	public List<Flight> getFlights() {
		return flights;
	}
	/**
	 * @param flights the flights to set
	 */
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	/**
	 * @return the typeId
	 */
	public AirplaneType getTypeId() {
		return this.typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(AirplaneType typeId) {
		this.typeId = typeId;
	}

}
