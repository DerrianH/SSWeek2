/**
 * 
 */
package com.ss.training.utopia.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author derrianharris
 *
 */
public class Flight {
	private Integer id;
	private Route route;
	private Airplane airplane;
	private LocalDateTime departureTime;
	private Integer reservedSeats;
	private Integer seatPrice;
	private List<FlightBooking> flightBookings;
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
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}
	/**
	 * @return the airplane
	 */
	public Airplane getAirplane() {
		return airplane;
	}
	/**
	 * @param airplane the airplane to set
	 */
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	/**
	 * @return the departureTime
	 */
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the reservedSeats
	 */
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	/**
	 * @param reservedSeats the reservedSeats to set
	 */
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	/**
	 * @return the seatPrice
	 */
	public Integer getSeatPrice() {
		return seatPrice;
	}
	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}
	/**
	 * @return the flightBookings
	 */
	public List<FlightBooking> getFlightBookings() {
		return flightBookings;
	}
	/**
	 * @param flightBookings the flightBookings to set
	 */
	public void setFlightBookings(List<FlightBooking> flightBookings) {
		this.flightBookings = flightBookings;
	}
}
