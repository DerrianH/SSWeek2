/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class BookingUser extends BookingBaseUser {


	private Integer userId;


	/**
	 * @param bookingId
	 * @param userId
	 */
	public BookingUser(Integer bookingId, Integer userId) {
		super(bookingId);
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
