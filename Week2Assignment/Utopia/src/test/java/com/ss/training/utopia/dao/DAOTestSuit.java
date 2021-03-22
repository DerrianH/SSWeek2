/**
 * 
 */
package com.ss.training.utopia.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ss.training.utopia.entity.AirplaneType;
import com.ss.training.utopia.entity.Airport;

/**
 * @author derrianharris
 *
 */
@RunWith(Suite.class)
@SuiteClasses({AirplaneDAOTest.class, AirplaneTypeDAOTest.class, AirportDAOTest.class,
		BookingAgentDAOTest.class, BookingDAOTest.class,
		BookingGuestDAOTest.class, BookingPaymentDAOTest.class,
		BookingUserDAOTest.class, FlightBookingDAOTest.class,
		FlightDAOTest.class, PassengerDAOTest.class, QueryBuilderTest.class,
		RouteDAOTest.class, UserDAOTest.class, UserRoleDAOTest.class})
public class DAOTestSuit {

	/**
	 * 
	 */

}
