/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class Airport {
	private String iataId;
	private String city;
	/**
	 * @return the iataId
	 */
	public String getIataId() {
		return this.iataId;
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
		return this.city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param iataId
	 * @param city
	 */
	public Airport(String iataId, String city) {
		this.iataId = iataId;
		this.city = city;
	}
}
