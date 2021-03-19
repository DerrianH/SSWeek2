/**
 * 
 */
package com.ss.training.utopia.entity;

import java.util.List;

/**
 * @author derrianharris
 *
 */
public class Route {
	private Integer id;
	private Airport origin;
	private Airport destination;
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
	 * @return the origin
	 */
	public Airport getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(Airport origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public Airport getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Airport destination) {
		this.destination = destination;
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
}
