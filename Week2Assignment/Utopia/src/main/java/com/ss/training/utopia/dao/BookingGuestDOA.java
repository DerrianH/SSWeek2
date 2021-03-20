/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.BookingGuest;

/**
 * @author derrianharris
 *
 */
public class BookingGuestDOA extends BaseDAO<BookingGuest> {

	public BookingGuestDOA(Connection conn) {
		super(conn);
	}

	public void addData(BookingGuest guest) throws ClassNotFoundException, SQLException {
		executeQuery("insert into booking_guest values (?, ?, ?)", new Object[] { guest.getBookingId(), guest.getEmail(), guest.getPhone()});
	}

	public void updateData(BookingGuest guest) throws ClassNotFoundException, SQLException {
		executeQuery("update booking_guest set contact_email = ?, contact_phone = ? where booking_id = ?", new Object[] {guest.getEmail(), guest.getPhone(),guest.getBookingId(),});
	}

	public void deleteData(BookingGuest guest) throws ClassNotFoundException, SQLException {
		executeQuery("delete from booking_guest where booking_id = ?", new Object[] {guest.getBookingId()});
	}
	
	@Override
	protected List<BookingGuest> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuests = new ArrayList<BookingGuest>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer bookingId = rs.getInt("booking_id");
			String email = rs.getString("contact_email");
			String phone = rs.getString("contact_phone");
			BookingGuest bookingGuest = new BookingGuest(bookingId, email, phone);
			
			bookingGuests.add(bookingGuest);
		}
		return bookingGuests;
	}
}
