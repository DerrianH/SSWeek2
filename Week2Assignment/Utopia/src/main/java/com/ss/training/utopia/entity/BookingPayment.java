/**
 * 
 */
package com.ss.training.utopia.entity;

/**
 * @author derrianharris
 *
 */
public class BookingPayment {
	private Integer bookingId;
	private String stripeId;
	private boolean refunded;
	/**
	 * @param bookingId
	 * @param stripeId
	 * @param refunded
	 */
	public BookingPayment(Integer bookingId, String stripeId,
			boolean refunded) {
		this.bookingId = bookingId;
		this.stripeId = stripeId;
		this.refunded = refunded;
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
	/**
	 * @return the stripeId
	 */
	public String getStripeId() {
		return this.stripeId;
	}
	/**
	 * @param stripeId the stripeId to set
	 */
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	/**
	 * @return the refunded
	 */
	public boolean isRefunded() {
		return this.refunded;
	}
	/**
	 * @param refunded the refunded to set
	 */
	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}
}
