/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.BookingUser;

/**
 * @author derrianharris
 *
 */
public class BookingUserDAO extends BaseDAO<BookingUser> {

	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	public void addData(BookingUser user) throws ClassNotFoundException, SQLException {
		executeQuery("insert into booking_user values (?, ?)", new Object[] { user.getBookingId(), user.getUserId()});
	}

	public void updateData(BookingUser user) throws ClassNotFoundException, SQLException {
		executeQuery("update booking_user set user_id = ? where booking_id = ?", new Object[] {user.getUserId(), user.getBookingId()});
	}

	public void deleteData(BookingUser user) throws ClassNotFoundException, SQLException {
		executeQuery("delete from booking_user where booking_id = ?", new Object[] {user.getBookingId()});
	}
	
	@Override
	protected List<BookingUser> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<BookingUser> bookingsUsers = new ArrayList<BookingUser>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer bookingId = rs.getInt("booking_id");
			Integer userId = rs.getInt("user_id");
			BookingUser bookingUser = new BookingUser(bookingId,userId);
			
			bookingsUsers.add(bookingUser);
		}
		return bookingsUsers;
	}
}
