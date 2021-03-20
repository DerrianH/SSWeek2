/**
 * 
 */
package com.ss.training.utopia.entity;

import java.time.OffsetDateTime;

/**
 * @author derrianharris
 *
 */
public class Flight {
	private Integer id;
	private Integer routeId;
	private Integer airplaneId;
	private OffsetDateTime departureTime;
	private Integer reservedSeats;
	private Float seatPrice;
	/**
	 * @param id
	 * @param routeId
	 * @param airplaneId
	 * @param departureTime
	 * @param reservedSeats
	 * @param seatPrice
	 */
	public Flight(Integer id, Integer routeId, Integer airplaneId,
			OffsetDateTime departureTime, Integer reservedSeats,
			Float seatPrice) {
		this.id = id;
		this.routeId = routeId;
		this.airplaneId = airplaneId;
		this.departureTime = departureTime;
		this.reservedSeats = reservedSeats;
		this.seatPrice = seatPrice;
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
	 * @return the routeId
	 */
	public Integer getRouteId() {
		return this.routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the airplaneId
	 */
	public Integer getAirplaneId() {
		return this.airplaneId;
	}
	/**
	 * @param airplaneId the airplaneId to set
	 */
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	/**
	 * @return the departureTime
	 */
	public OffsetDateTime getDepartureTime() {
		return this.departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(OffsetDateTime departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the reservedSeats
	 */
	public Integer getReservedSeats() {
		return this.reservedSeats;
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
	public Float getSeatPrice() {
		return this.seatPrice;
	}
	/**
	 * @param seatPrice the seatPrice to set
	 */
	public void setSeatPrice(Float seatPrice) {
		this.seatPrice = seatPrice;
	}
	
}
