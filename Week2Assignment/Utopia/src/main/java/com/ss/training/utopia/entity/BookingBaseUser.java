/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class BookingBaseUser {
	private Integer bookingId;

	/**
	 * @param bookingId
	 */
	public BookingBaseUser(Integer bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return this.bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
}
