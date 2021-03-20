/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class AirplaneType {
	private Integer id;
	private Integer maxCapacity;
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
	 * @return the maxCapacity
	 */
	public Integer getMaxCapacity() {
		return this.maxCapacity;
	}
	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	/**
	 * @param id
	 * @param maxCapacity
	 */
	public AirplaneType(Integer id, Integer maxCapacity) {
		this.id = id;
		this.maxCapacity = maxCapacity;
	}
}
