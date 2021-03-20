/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.Flight;

/**
 * @author derrianharris
 *
 */
public class FlightDAO extends BaseDAO<Flight> {

	public FlightDAO(Connection conn) {
		super(conn);
	}

	public void addData(Flight flight)
			throws ClassNotFoundException, SQLException {
		executeQuery("insert into flight values (?, ?, ?, ?, ?, ?, ?)",
				new Object[]{flight.getId(), flight.getRouteId(),
						flight.getAirplaneId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice()});
	}

	public void updateData(Flight flight)
			throws ClassNotFoundException, SQLException {
		executeQuery(
				"update flight set route_id = ?,airplane_id = ?,departure_time = ?,reserved_seats = ?,seat_price = ? where id = ?",
				new Object[]{flight.getRouteId(), flight.getAirplaneId(),
						flight.getDepartureTime(), flight.getReservedSeats(),
						flight.getSeatPrice(), flight.getId()});
	}

	public void deleteData(Flight flight)
			throws ClassNotFoundException, SQLException {
		executeQuery("delete from flight where id = ?",
				new Object[]{flight.getId()});
	}

	@Override
	protected List<Flight> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<Flight>();
		System.out.println("extractData");

		while (rs.next()) {
			Integer id = rs.getInt("id");
			Integer routeId = rs.getInt("route_id");
			Integer airplaneId = rs.getInt("airplane_id");
			OffsetDateTime departureTime = OffsetDateTime
					.from(rs.getTimestamp("departure_time").toLocalDateTime());
			Integer reservedSeats = rs.getInt("reserved_seats");
			Float seatPrice = rs.getFloat("seat_price");
			Flight flight = new Flight(id, routeId, airplaneId, departureTime,
					reservedSeats, seatPrice);
			flights.add(flight);
		}
		return flights;
	}
}
