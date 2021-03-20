/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.FlightBooking;

/**
 * @author derrianharris
 *
 */
public class FlightBookingDOA extends BaseDAO<FlightBooking> {

	public FlightBookingDOA(Connection conn) {
		super(conn);
	}

	public void addData(FlightBooking flightBooking) throws ClassNotFoundException, SQLException {
		executeQuery("insert into flight_bookings values (?, ?)", new Object[] { flightBooking.getFlightId(), flightBooking.getBookingId()});
	}

	public void updateData(FlightBooking flightBooking) throws ClassNotFoundException, SQLException {
		executeQuery("update flight_bookings set booking_id = ? where flight_id = ?", new Object[] {flightBooking.getBookingId(),flightBooking.getFlightId()});
	}

	public void deleteData(FlightBooking flightBooking) throws ClassNotFoundException, SQLException {
		executeQuery("delete from flight_bookings where flight_id = ?", new Object[] {flightBooking.getFlightId()});
	}
	
	@Override
	protected List<FlightBooking> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<FlightBooking> flightBookings = new ArrayList<FlightBooking>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer flightId = rs.getInt("flight_id");
			Integer bookingId = rs.getInt("booking_id");
			FlightBooking flightBooking = new FlightBooking(flightId,bookingId);
			
			flightBookings.add(flightBooking);
		}
		return flightBookings;
	}
}
