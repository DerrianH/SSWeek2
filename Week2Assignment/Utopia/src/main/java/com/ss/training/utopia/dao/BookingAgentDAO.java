/**
 * 
 */
package com.ss.training.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.training.utopia.entity.BookingAgent;
import com.ss.training.utopia.entity.BookingUser;
import com.ss.training.utopia.entity.User;

/**
 * @author derrianharris
 *
 */
public class BookingAgentDAO extends BookingUserDAO {

	public BookingAgentDAO(Connection conn, String tableName) {
		super(conn, tableName);
		idName = "agent_id";
	}

	@Override
	protected List<BookingUser> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<BookingUser> bookingAgents = new ArrayList<BookingUser>();
		while (rs.next()) {
			Integer bookingId = rs.getInt("booking_id");
			Integer agentId = rs.getInt("agent_id");
			BookingAgent bookingAgent = new BookingAgent(bookingId, agentId);

			bookingAgents.add(bookingAgent);
		}
		return bookingAgents;
	}
	@Override
	public List<BookingUser> getAllBookingUserFromUser(User user)
			throws ClassNotFoundException, SQLException {
		Object[] value = new Object[]{user.getId()};
		return readDataQuery(
				QueryBuilder.selectQueryCond(tableName, "*", idName), value);
	}
}
