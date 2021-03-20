/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.Passenger;

/**
 * @author derrianharris
 *
 */
public class PassengerDOA extends BaseDAO<Passenger> {

	public PassengerDOA(Connection conn) {
		super(conn);
	}

	public void addData(Passenger passenger)
			throws ClassNotFoundException, SQLException {
		executeQuery("insert into passenger values (?, ?, ?, ?, ?, ?)",
				new Object[]{passenger.getBookingId(), passenger.getFirstName(),
						passenger.getLastName(), passenger.getDob(),
						passenger.getGender(), passenger.getAddress()});
	}

	public void updateData(Passenger passenger)
			throws ClassNotFoundException, SQLException {
		executeQuery(
				"update passenger set booking_id = ?,given_name = ?,family_name = ?,dob = ?,gender = ?,address = ? where id = ?",
				new Object[]{passenger.getBookingId(), passenger.getFirstName(),
						passenger.getLastName(), passenger.getDob(),
						passenger.getGender(), passenger.getAddress(),
						passenger.getId()});
	}

	public void deleteData(Passenger passenger)
			throws ClassNotFoundException, SQLException {
		executeQuery("delete from passenger where id = ?",
				new Object[]{passenger.getId()});
	}

	@Override
	protected List<Passenger> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<Passenger>();
		System.out.println("extractData");

		while (rs.next()) {
			Integer id = rs.getInt("id");
			Integer bookingId = rs.getInt("booking_id");
			String firstName = rs.getString("given_name");
			String lastName = rs.getString("family_name");
			LocalDate dob = rs.getDate("dob").toLocalDate();
			String gender = rs.getString("gender");
			String address = rs.getString("address");
			Passenger passenger = new Passenger(id, bookingId, firstName, lastName, dob, gender, address);
			passengers.add(passenger);
		}
		return passengers;
	}
}
