/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class BookingGuest extends BookingBaseUser{
	private String email;
	private String phone;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}