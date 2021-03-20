/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class FlightBooking {
	private Integer flightId;
	private Integer bookingId;
	/**
	 * @param flightId
	 * @param bookingId
	 */
	public FlightBooking(Integer flightId, Integer bookingId) {
		this.flightId = flightId;
		this.bookingId = bookingId;
	}
	/**
	 * @return the flightId
	 */
	public Integer getFlightId() {
		return this.flightId;
	}
	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
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
