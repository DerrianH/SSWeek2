/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class Booking {
	
	private Integer id;
	private Boolean isActive;
	private String confirmationCode;
	/**
	 * @param id
	 * @param isActive
	 * @param confirmationCode
	 */
	public Booking(Integer id, boolean isActive, String confirmationCode) {
		this.id = id;
		this.isActive = isActive;
		this.confirmationCode = confirmationCode;
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
	 * @return the isActive
	 */
	public boolean isActive() {
		return this.isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the confirmationCode
	 */
	public String getConfirmationCode() {
		return this.confirmationCode;
	}
	/**
	 * @param confirmationCode the confirmationCode to set
	 */
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}
}
