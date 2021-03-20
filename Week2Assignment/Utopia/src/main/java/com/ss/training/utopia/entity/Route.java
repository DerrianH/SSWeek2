/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class Route {
	private Integer id;
	private String originIataId;
	/**
	 * @param id
	 * @param originIataId
	 * @param destinationIataId
	 */
	public Route(Integer id, String originIataId, String destinationIataId) {
		this.id = id;
		this.originIataId = originIataId;
		this.destinationIataId = destinationIataId;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the originIataId
	 */
	public String getOriginIataId() {
		return this.originIataId;
	}
	/**
	 * @param originIataId the originIataId to set
	 */
	public void setOriginIataId(String originIataId) {
		this.originIataId = originIataId;
	}
	/**
	 * @return the destinationIataId
	 */
	public String getDestinationIataId() {
		return this.destinationIataId;
	}
	/**
	 * @param destinationIataId the destinationIataId to set
	 */
	public void setDestinationIataId(String destinationIataId) {
		this.destinationIataId = destinationIataId;
	}
	private String destinationIataId;
}
