/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class Airplane {
	private Integer id;
	private Integer typeId;
	/**
	 * @param id
	 * @param typeId
	 */
	public Airplane(Integer id, Integer typeId) {
		this.id = id;
		this.typeId = typeId;
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
	 * @return the typeId
	 */
	public Integer getTypeId() {
		return this.typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
