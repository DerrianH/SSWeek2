/**
 * 
 */
package com.ss.training.utopia.entity;

import java.util.List;

/**
 * @author derrianharris
 *
 */
public class AirplaneType {
	private Integer id;
	private Integer typeId;
	private List<Airplane> airplanes;
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
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * @return the airplanes
	 */
	public List<Airplane> getAirplanes() {
		return airplanes;
	}
	/**
	 * @param airplanes the airplanes to set
	 */
	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}

}
