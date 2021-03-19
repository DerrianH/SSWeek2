/**
 * 
 */
package com.ss.training.utopia.entity;

import java.util.List;

/**
 * @author derrianharris
 *
 */
public class Airport {
	private String iataId;
	private String city;
	private List<Route> routes;
	/**
	 * @return the iataId
	 */
	public String getIataId() {
		return iataId;
	}
	/**
	 * @param iataId the iataId to set
	 */
	public void setIataId(String iataId) {
		this.iataId = iataId;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the routes
	 */
	public List<Route> getRoutes() {
		return routes;
	}
	/**
	 * @param routes the routes to set
	 */
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
}
