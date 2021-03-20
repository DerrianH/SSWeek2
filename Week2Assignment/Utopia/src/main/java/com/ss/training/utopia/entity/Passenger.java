/**
 * 
 */
package com.ss.training.utopia.entity;

import java.time.LocalDate;

/**
 * @author derrianharris
 *
 */
public class Passenger {

	private Integer id;
	private String firstName;
	private String LastName;
	private LocalDate dob;
	private String gender;
	private String address;
	private Integer bookingId;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param dob
	 * @param gender
	 * @param address
	 * @param bookingId
	 */
	public Passenger(Integer id, Integer bookingId, String firstName,
			String lastName, LocalDate dob, String gender, String address) {
		this.id = id;
		this.firstName = firstName;
		this.LastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.bookingId = bookingId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}
	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.LastName;
	}
	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return this.dob;
	}
	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return this.gender;
	}
	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}
	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return this.bookingId;
	}
	/**
	 * @param bookingId
	 *            the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
}
