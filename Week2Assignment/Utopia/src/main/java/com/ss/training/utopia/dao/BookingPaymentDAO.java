/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.BookingPayment;

/**
 * @author derrianharris
 *
 */
public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	public void addData(BookingPayment payment) throws ClassNotFoundException, SQLException {
		executeQuery("insert into booking_payment values (?, ?, ?)", new Object[] { payment.getBookingId(), payment.getStripeId(), payment.isRefunded()});
	}

	public void updateData(BookingPayment payment) throws ClassNotFoundException, SQLException {
		executeQuery("update booking_payment set stripe_id = ?, is_refunded = ? where booking_id = ?", new Object[] {payment.getStripeId(), payment.isRefunded(),payment.getBookingId()});
	}

	public void deleteData(BookingPayment payment) throws ClassNotFoundException, SQLException {
		executeQuery("delete from booking_payment where booking_id = ?", new Object[] {payment.getBookingId()});
	}
	
	@Override
	protected List<BookingPayment> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingsUsers = new ArrayList<BookingPayment>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer bookingId = rs.getInt("booking_id");
			String stripeId = rs.getString("stripe_id");
			Boolean isRefunded = rs.getBoolean("is_refunded");
			BookingPayment bookingUser = new BookingPayment(bookingId,stripeId,isRefunded);
			
			bookingsUsers.add(bookingUser);
		}
		return bookingsUsers;
	}
}
