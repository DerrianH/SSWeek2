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

/**
 * @author derrianharris
 *
 */
public class BookingAgentDAO extends BaseDAO<BookingAgent> {

	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	public void addData(BookingAgent agent) throws ClassNotFoundException, SQLException {
		executeQuery("insert into booking_agent values (?, ?)", new Object[] { agent.getBookingId(), agent.getUserId()});
	}

	public void updateData(BookingAgent agent) throws ClassNotFoundException, SQLException {
		executeQuery("update booking_agent set agent_id = ? where booking_id = ?", new Object[] {agent.getUserId(), agent.getBookingId()});
	}

	public void deleteData(BookingAgent agent) throws ClassNotFoundException, SQLException {
		executeQuery("delete from booking_agent where booking_id = ?", new Object[] {agent.getBookingId()});
	}
	
	@Override
	protected List<BookingAgent> extractData(ResultSet rs)
			throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgents = new ArrayList<BookingAgent>();
		System.out.println("extractData");
		
		while(rs.next()) {
			Integer bookingId = rs.getInt("booking_id");
			Integer agentId = rs.getInt("agent_id");
			BookingAgent bookingAgent = new BookingAgent(bookingId,agentId);
			
			bookingAgents.add(bookingAgent);
		}
		return bookingAgents;
	}
}
