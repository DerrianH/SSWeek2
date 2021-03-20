/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.Booking;

/**
 * @author derrianharris
 *
 */
public class BookingDAO extends BaseDAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
	}

	public void addData(Booking booking) throws ClassNotFoundException, SQLException {
		executeQuery("insert into booking values (?, ?)", new Object[] { booking.isActive(), booking.getConfirmationCode()});
	}

	public void updateData(Booking booking) throws ClassNotFoundException, SQLException {
		executeQuery("update booking set is_active = ?, confirmation_code = ? where id = ?", new Object[] {booking.isActive(),booking.getConfirmationCode()});
	}

	public void deleteData(Booking booking) throws ClassNotFoundException, SQLException {
		executeQuery("delete from booking where id = ?", new Object[] {booking.getId()});
	}
	
	@Override
	protected List<Booking> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<Booking>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer id = rs.getInt("id");
			Boolean isActive = rs.getBoolean("is_active");
			String confirmationCode = rs.getString("confirmation_code");
			Booking booking = new Booking(id,isActive,confirmationCode);
			
			bookings.add(booking);
		}
		return bookings;
	}
}
